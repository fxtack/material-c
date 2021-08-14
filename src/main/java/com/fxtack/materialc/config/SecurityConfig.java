package com.fxtack.materialc.config;

import com.fxtack.materialc.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * spring security 配置类
 *
 * @author fxtack
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.headers().frameOptions().disable();

        // 拦截设置
        http.authorizeRequests()
                .antMatchers("/*").hasAnyRole("admin", "staff")
                .antMatchers("/main/**").hasAnyRole("admin", "staff")
//                .antMatchers("/*").hasRole("admin")
//                .antMatchers("/main/**").hasRole("admin")
//                .antMatchers("/*").hasRole("staff")
//                .antMatchers("/main/**").hasRole("staff")
        ;

        //登入设置
        http.formLogin()
                .loginPage("/user/login")                // 登录跳转url
                .passwordParameter("password")
                .usernameParameter("username")
//                .loginProcessingUrl("/login")   // 处理表单登录url
//                .and()
//                .authorizeRequests()            // 授权配置
//                .antMatchers("/login.html").permitAll()  // 无需认证
//                .anyRequest()                   // 所有请求
//                .authenticated()                // 都需要认证
//                .and().csrf().disable()
        ;

        http
                .rememberMe()
                .rememberMeParameter("remember")
                // 设置记住我持续秒数
                .tokenValiditySeconds(86400)
        ;

        // 关闭 csrf 攻击防护
        http
                .csrf().disable()
        ;

        // 登出设置
        http
                .logout()
                .logoutSuccessUrl("/")
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("Achar").password(new BCryptPasswordEncoder().encode("123456")).roles("admin");
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
