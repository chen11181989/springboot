package com.boot.controller;

import com.boot.module.ApiResult;
import com.boot.utils.ApiResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常信息处理 ControllerAdvice注解可以有参数，定义拦截某个包下的控制器等等
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandler {

    // 全局异常处理返回的是一个json 所以 在控制器方法内一定得返回的也是json ,不得是视图
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExeptionHandler(Exception e){
        return ApiResultGenerator.errorResult(e.getMessage(),e);

    }
}
