package com.cloud.eurekaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    /**
     * 开启secutiry.basic.enable=true 保证url认证登录，必须使用httpBasic
     */
    @Override
    protected void configure(HttpSecurity http)
        throws Exception {
        //http.sessionManagement()
        //    .sessionCreationPolicy(SessionCreationPolicy.NEVER);
        //禁用csrf，保证在加密的情况下  分片能够相互注册
        //permitAll是不需要登录可以访问的 anyRequest是其他的资源 authenticated是需要登录访问的
        //fromLogin允许表单登录  httpBasic允许url登录
        http.authorizeRequests()
            .antMatchers("/actuator/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
        http.csrf().disable();
    }
}
