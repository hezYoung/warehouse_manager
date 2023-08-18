package com.young.service.impl;

import com.young.mapper.LoginMapper;
import com.young.pojo.User;
import com.young.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    //注入UserMapper
    @Autowired
    private LoginMapper loginMapper;
    //根据用户名查找用户的业务方法
    @Override
    public User findUserByCode(String userCode) {

        User findbyuser = loginMapper.findbyuser(userCode);
        return findbyuser;
    }
}
