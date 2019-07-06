package org.nix.home.security;

import org.nix.home.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserService userService;

    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private AccessDeniedHandlerImpl accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 设置访问权限相关的配置信息
     *
     * @param http http安全对象
     * @throws Exception 处理异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(SecurityConstant.LOGIN_PROCESSING_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .loginProcessingUrl(SecurityConstant.LOGIN_PROCESSING_URL)
                .and()
                .rememberMe()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and()
                .csrf().disable();
    }

    /**
     * 认证信息管理
     * 踩坑：当前版本的安全框架必须需要一个密码加密器
     * 踩坑记录解决方案：https://blog.csdn.net/canon_in_d_major/article/details/79675033
     *
     * @param auth 权限对象
     * @throws Exception 异常处理
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
