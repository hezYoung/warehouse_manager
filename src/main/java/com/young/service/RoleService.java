package com.young.service;

import com.young.pojo.Role;

import java.util.List;


/**
* @author 15455
* @description 针对表【role(角色表)】的数据库操作Service
* @createDate 2023-08-20 15:35:26
*/
public interface RoleService {
    List<Role> getAllRole();
    //查询用户已分配的角色的业务方法
    public List<Role> queryRolesByUserId(Integer userId);

}