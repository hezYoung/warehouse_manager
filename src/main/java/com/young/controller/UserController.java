package com.young.controller;

import com.young.page.Page;
import com.young.pojo.User;
import com.young.service.UserService;
import com.young.utils.TokenUtils;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService loginService;
    @Autowired
    private TokenUtils tokenUtils;

    /**
     * 分页查询用户的url接口/user/user-list
     * <p>
     * 参数Page对象用于接收请求参数页码pageNum、每页行数pageSize;
     * 参数User对象用于接收请求参数用户名userCode、用户类型userType、用户状态userState;
     * <p>
     * 返回值Result对象向客户端响应组装了所有分页信息的Page对象;
     */

    @GetMapping("/user-list")
    public Result userlist(Page page, User user) {
        Page userPage = loginService.findUserPage(page, user);
        return Result.ok(userPage);
    }

}
