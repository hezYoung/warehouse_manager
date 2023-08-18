package com.young.service;

import com.young.pojo.User;

public interface LoginService {
    public User findUserByCode(String userCode);
}
