package com.example.share1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    @RequestMapping(value = "/hello")
    public String hello(){

        return  "Hello Springboot";
    }

    @RequestMapping(value = "/index")
    public String index(){

        return "index";
    }
}
