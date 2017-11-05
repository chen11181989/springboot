package com.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
*静态资源过滤配置
* */
@Configuration
public class StaticConfiguration extends WebMvcConfigurerAdapter {

    //自定义静态资源文件路径 ,我们配置了静态资源的路径为/static/resource，那么只要访问地址前缀是/static/resource，就会被自动转到项目根目录下的static文件夹内。

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/resource/**").addResourceLocations("classPath:/static/");

    }

}
