package com.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liulei
 * @Description MVC配置文件
 * @create 2017/7/30 19:55
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    /**
     * @Title: addViewControllers
     * @Description: 配置直接的页面跳转路径映射
     * @param: registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("/ws");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/chat").setViewName("/chat");
    }
}
