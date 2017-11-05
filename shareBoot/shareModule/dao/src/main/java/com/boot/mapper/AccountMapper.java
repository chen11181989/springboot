package com.boot.mapper;

import com.boot.module.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    Account findAccountById(@Param("id") Integer id);
}
