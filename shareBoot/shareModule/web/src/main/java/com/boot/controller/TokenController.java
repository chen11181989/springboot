package com.boot.controller;

import com.boot.module.TokenInfo;
import com.boot.module.TokenResult;
import com.boot.module.UserInfo;
import com.boot.service.TokenService;
import com.boot.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class TokenController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @RequestMapping("/token")
    public TokenResult getToken(@RequestParam String appId, @RequestParam String secret) {
        TokenResult result = new TokenResult();
        UserInfo info = null;
        TokenInfo token = null;
        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(secret)) {
            result.setMessage("参数错误");
        } else {
            info = userService.getUser(appId);
        }
        if (info == null) {
            result.setMessage("appId is not found");
        } else {
            token = tokenService.getToken(appId);
            String tokenStr =null;
            //验证是否存在token ，不存在则创建，存在的话验证是否失效
            if (token == null) {
                tokenStr = createToken(appId);
                token = new TokenInfo();
                token.setAppId(info.getAppId());
                token.setCreateTime(String.valueOf(System.currentTimeMillis()));
                token.setToken(tokenStr.getBytes());
                tokenService.insertToken(token);

            }else {
              long createTime =  Long.valueOf(token.getCreateTime());
              long currentTime = System.currentTimeMillis();
             long second=   TimeUnit.MILLISECONDS.toSeconds(currentTime-createTime);
              if(second>0&&second<3600){
                  tokenStr =new String(token.getToken());
              }else {
                  //...........
                  result.setMessage("token 失效");
              }
            }
         result.setToken(tokenStr);
        }

        return  result;
    }

    public String createToken(String appId) {
        Date now = new Date(System.currentTimeMillis());
        //设置过期时间
        Date expiration = new Date(now.getTime() + 3600000);
        return Jwts.builder().setSubject(appId).setIssuedAt(now).setIssuer("Test")
                .setExpiration(expiration).signWith(SignatureAlgorithm.HS256,"test").compact();
    }
}
