package com.boot.controller;
import com.boot.module.Account;
import com.boot.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@RestController
public class AccountController {

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);


    @Autowired
    private MessageSource messageSource;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/index")
    public  String getIndex(){

        return "index";
    }

    @RequestMapping(value = "/list")
    public Account  getAccounts() {
        logger.debug("debug 日志");
        logger.info("info 日志");
        logger.error("error日志");
        return accountService.findAccountById(1);
    }


    @RequestMapping("/validtor")
    public String validator(@Valid Account account, BindingResult result) {
       String meg =  this.validtorUtil(account,result);
       if (StringUtils.isEmpty(meg))
        return  "验证通过";
       else
           return  meg;
    }


    public String validtorUtil(Object obj,BindingResult result){
        if (result.hasErrors()) {
            StringBuffer msg = new StringBuffer();
            //获取错误字段集合
            List<FieldError> fieldErrors = result.getFieldErrors();
            //获取本地的local
            Locale currentLocal = LocaleContextHolder.getLocale();
            for (FieldError fieldError : fieldErrors) {
                //获取错误信息
                String errormessage = messageSource.getMessage(fieldError, currentLocal);
                // 添加到错误消息集合内
                msg.append(fieldError.getField() + ":" + errormessage);
            }
            return  msg.toString();
        }
        return  null;
    }


}
