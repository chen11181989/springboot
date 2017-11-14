package com.boot.controller;

import com.boot.module.Member;
import com.boot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @RequestMapping(value = "/insert")
    public  String  insert(){
        Member member = new Member();
        member.setEmplyeeId("333344");
        member.setGender(1);
        member.setUid(100);
      Integer id =  memberService.insert(member);
    return  "id3334"+id;
    }
}
