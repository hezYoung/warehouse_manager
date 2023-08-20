package com.young.controller;

import com.young.dto.AssignRoleDto;
import com.young.page.Page;
import com.young.pojo.CurrentUser;
import com.young.pojo.Role;
import com.young.pojo.User;
import com.young.service.RoleService;
import com.young.service.UserRoleService;
import com.young.service.UserService;
import com.young.utils.TokenUtils;
import com.young.vo.Result;
import com.young.vo.WarehouseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService loginService;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private RoleService roleService;

    //注入redis模板
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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

    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user, @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token) {
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        int userId = currentUser.getUserId();
        user.setCreateBy(userId);

        Result result = loginService.saveallUser(user);
        return result;
    }

    @RequestMapping("/updateState")
    public Result updateUserState(@RequestBody User user,
                                  @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String token) {
        //获取当前登录的用户
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        //获取当前登录的用户id,即修改用户的用户id
        int updateBy = currentUser.getUserId();

        //设置修改用户的用户id和修改时间
        user.setUpdateBy(updateBy);
        user.setUpdateTime(new Date());

        //执行业务
        Result result = loginService.setStateto(user);

        //响应
        return result;
    }

    /**
     * 查询用户已分配的角色的url接口/user/user-role-list/{userId}
     */
    @RequestMapping("/user-role-list/{userId}")
    public Result userRoleList(@PathVariable Integer userId) {
        //执行业务
        List<Role> roleList = roleService.queryRolesByUserId(userId);
        //响应
        return Result.ok(roleList);
    }

    @RequestMapping("/assignRole")
    public Result assignRole(@RequestBody AssignRoleDto assignRoleDto) {
        loginService.assignRole(assignRoleDto);
        return Result.ok("角色修改成功");
    }

    /**
     * 删除用户的url接口/user/deleteUser/{userId}
     */
    @RequestMapping("/deleteUser/{userId}")
    public Result deleteuser(@PathVariable Integer userId) {
        loginService.setUserDelete(userId);
        return Result.ok("删除成功");
    }

    /**
     * 登出的url接口/logout
     *
     * @RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME) String clientToken
     * 将请求头Token的值即前端归还的token,赋值给请求处理方法的参数String clientToken
     */
    @DeleteMapping("/logout")
    public Result logout(@RequestHeader(WarehouseConstants.HEADER_TOKEN_NAME)
                         String clientToken) {
        //从redis移除token
        stringRedisTemplate.delete(clientToken);
        return Result.ok();
    }


}
