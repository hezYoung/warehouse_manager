package com.young.controller;

import com.young.pojo.Role;
import com.young.service.RoleService;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/role")
@RestController
public class RoleController {

    //注入RoleService
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色的url接口role/role-list
     */
    @RequestMapping("/role-list")
    public Result queryAllRole(){
        //执行业务
        List<Role> roleList = roleService.getAllRole();
        //响应
        return Result.ok(roleList);
    }
}
