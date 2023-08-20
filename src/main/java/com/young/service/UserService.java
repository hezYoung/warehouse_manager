package com.young.service;

import com.young.page.Page;
import com.young.pojo.User;

public interface UserService {
    public User findUserByCode(String userCode);
    //分页查询用户的业务方法
    Page findUserPage(Page page, User user);
}
