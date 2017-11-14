package com.boot.serviceImpl;

import com.boot.mapper.TokenInfoMapper;
import com.boot.module.TokenInfo;
import com.boot.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService{
    @Autowired
    private TokenInfoMapper infoMapper;
    @Override
    public TokenInfo getToken(String appId) {
        return infoMapper.selectByPrimaryKey(appId);
    }

    @Override
    public int insertToken(TokenInfo info) {
        return  infoMapper.insert(info);
    }
}
