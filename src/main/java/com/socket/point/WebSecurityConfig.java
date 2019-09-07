package com.socket.point;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @author liulei
 * @Description web请求控制
 * @create 2017/7/30 21:26
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    /**
     * @Title: configure
     * @Description: 配置访问拦截路径及登录成功页
     * @param: http
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/login").permitAll().anyRequest().authenticated().and().formLogin
                ().loginPage("/login").defaultSuccessUrl("/chat").permitAll().and().logout().permitAll();
    }

    @Override
    /**
     * @Title: configure
     * @Description: 认证用户信息
     * @param: auth
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("liu").password("123").roles("USER").and().withUser("lei").password
                ("123").roles("USER");
    }

    @Override
    /**
     * @Title: configure
     * @Description: 配置不拦截的静态页面访问路径
     * @param: web
     */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resource/static/**");
    }
}
