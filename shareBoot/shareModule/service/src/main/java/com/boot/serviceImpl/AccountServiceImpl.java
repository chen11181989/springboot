package com.boot.serviceImpl;
import com.boot.mapper.AccountMapper;
import com.boot.module.Account;
import com.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@CacheConfig(cacheNames = "account")
public class AccountServiceImpl  implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findAccountById(Integer id) {
        return accountMapper.findAccountById(id);
    }

   /* @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }
    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }
    public int delete(int id) {
        return accountMapper.delete(id);
    }

    //的作用 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存(缓存的是方法的返回结果
    //value 必须至少指定一个 ，keyGenerator 最好指定一下，不然容易报错
    @Cacheable(value = "account", keyGenerator="wiselyKeyGenerator")
    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }
    @Cacheable(value = "allCount",keyGenerator="wiselyKeyGenerator")
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }*/

}
