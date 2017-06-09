package com.itcrowds.guapibooks.config;


import com.itcrowds.guapibooks.auth.CustomAuthenticationProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public AuthenticationProvider authenticationProvider(){
        AuthenticationProvider authenticationProvider=new CustomAuthenticationProvider();
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 防止csrf 攻击
        http.csrf().disable();

        http.authorizeRequests()
                // 不需要验证的页面
                .antMatchers("/","/books/**", "/login/**", "/login/auth")
                .permitAll()

                // 需要进行验证的页面
                .antMatchers("/reader/**")
                .authenticated()

                // 角色控制
                // .hasRole("ROLE_ADMIN")
                // 记住密码有效期

                .and().rememberMe().tokenValiditySeconds(60 * 60)
                // 设置cookies的私密钥
                .key("EumJi025")

                // 登录页面不需要密码  并在成功后自动跳转到指定页面
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/reader/readerspace")
                .failureUrl("/login?err=1001")  // 登陆失败页面
                // .failureHandler(new AuthenticationFailureHandler() {
                //     @Override
                //     public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                //         // httpServletResponse.getStatus();
                //     }
                // })
                .permitAll()

                // 登出页面不需要验证
                .and().logout().logoutUrl("/reader/logout")
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 放行资源请求
        web.ignoring().antMatchers("/**/*.*");
        // web.ignoring().antMatchers("/**/*.js","/**/*.css","/**/*.htm","*.jpg","/image/**","/vendor/**","/**/*.gif");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}

