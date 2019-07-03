package org.nix.home.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 设置访问权限相关的配置信息
     * @param http http安全对象
     * @throws Exception 处理异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    /**
     * 认证信息管理
     * 踩坑：当前版本的安全框架必须需要一个密码加密器
     * 踩坑记录解决方案：https://blog.csdn.net/canon_in_d_major/article/details/79675033
     * @param auth 权限对象
     * @throws Exception 异常处理
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangpei")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("admin");
    }
}
