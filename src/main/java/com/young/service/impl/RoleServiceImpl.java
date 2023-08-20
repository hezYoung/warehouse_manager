package com.young.service.impl;

import com.young.pojo.Role;
import com.young.service.RoleService;
import com.young.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 15455
* @description 针对表【role(角色表)】的数据库操作Service实现
* @createDate 2023-08-20 15:35:26
*/
@Service
@CacheConfig(cacheNames = "com/young/service/impl/RoleServiceImpl")
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Cacheable("'all:role")
    @Override
    public List<Role> getAllRole() {
        List<Role> allRole = roleMapper.findAllRole();
        return allRole;
    }

    @Override
    public List<Role> queryRolesByUserId(Integer userId) {
        return roleMapper.findRolesByUserId(userId);
    }
}




