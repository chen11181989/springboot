package com.boot.serviceImpl;

import com.boot.mapper.UserInfoMapper;
import com.boot.module.UserInfo;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserviceImpl implements UserService{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo getUser(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }
}
