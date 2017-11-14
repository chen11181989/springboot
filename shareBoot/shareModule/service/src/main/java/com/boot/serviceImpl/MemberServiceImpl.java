package com.boot.serviceImpl;

import com.boot.mapper.MemberMapper;
import com.boot.module.Member;
import com.boot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public int insert(Member record) {
        return memberMapper.insert(record);
    }
}
