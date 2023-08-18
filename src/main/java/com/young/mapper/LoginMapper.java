package com.young.mapper;

import com.young.pojo.User;

public interface LoginMapper {
    User findbyuser(String userCode);
}
