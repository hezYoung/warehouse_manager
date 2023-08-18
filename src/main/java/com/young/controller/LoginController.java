package com.young.controller;

import com.google.code.kaptcha.Producer;
import com.young.pojo.CurrentUser;
import com.young.pojo.LoginUser;
import com.young.pojo.User;
import com.young.service.LoginService;
import com.young.utils.DigestUtil;
import com.young.utils.TokenUtils;
import com.young.vo.Result;
import com.young.vo.WarehouseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {
    @Resource(name = "captchaProducer")
    private Producer producer;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private LoginService loginService;
    @Autowired
    private TokenUtils tokenUtils;
    @GetMapping("/captcha/captchaImage")
    public void captchaImage(HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        //生成文本
        String text = producer.createText();
        //生成图片
        BufferedImage image = producer.createImage(text);
        //存入redis
        redisTemplate.opsForValue().set(text, "", 60 * 5, TimeUnit.SECONDS);
        //传入前端
        //响应正文为jpg图片即验证码图片
        response.setContentType("image/jpeg");
        out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        out.flush();

    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginUser loginUser) {

//        校验验证码：

        if(!redisTemplate.hasKey(loginUser.getVerificationCode())){
            return Result.err(Result.CODE_ERR_BUSINESS, "验证码不正确！");
        }

        User userByCode = loginService.findUserByCode(loginUser.getUserCode());
        if (userByCode != null) {
            if (userByCode.getUserState().equals(WarehouseConstants.USER_STATE_PASS)) {//查到的用户状态是已审核
                String password  = DigestUtil.hmacSign(loginUser.getUserPwd());
                if (password.equals(userByCode.getUserPwd())) {
                    //密码相匹配
                    CurrentUser currentUser = new CurrentUser(userByCode.getUserId(), userByCode.getUserCode(), userByCode.getUserName());
                    String token = tokenUtils.loginSign(currentUser, userByCode.getUserPwd());
                    return Result.ok("登录成功", token);
                }
                else {
                    return Result.ok("密码错误");
                }
            }else {
                return Result.ok("用户没有审核");
            }
        }
            return Result.ok("用户不存在");

    }
}
