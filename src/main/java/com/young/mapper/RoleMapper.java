package com.young.mapper;


import com.young.pojo.Role;

import java.util.List;

/**
* @author 15455
* @description 针对表【role(角色表)】的数据库操作Mapper
* @createDate 2023-08-20 15:35:26
* @Entity com.young.pojo.Role
*/
public interface RoleMapper {
    //查询状态正常的所有角色的方法
    public List<Role> findAllRole();

    //根据用户id查询用户已分配的角色
    public List<Role> findRolesByUserId(Integer userId);


}




