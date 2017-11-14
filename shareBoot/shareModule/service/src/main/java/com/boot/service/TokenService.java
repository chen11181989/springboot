package com.boot.service;

import com.boot.module.TokenInfo;

public interface TokenService {

    public TokenInfo getToken(String appId);

    public  int insertToken(TokenInfo info);
}
