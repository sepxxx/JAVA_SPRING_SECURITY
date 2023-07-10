package com.spring.security.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ComboPooledDataSource comboPooledDataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication().
//                withUser(userBuilder.username("kali").password("kali").roles("EMPLOYEE")).
//                withUser(userBuilder.username("dell").password("dell").roles("HR")).
//                withUser(userBuilder.username("boomer").password("boomer").roles("HR","MANAGER"));
        auth.jdbcAuthentication().dataSource(comboPooledDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/").hasAnyRole("HR","MANAGER","EMPLOYEE").
                antMatchers("/hr_info").hasRole("HR").
                antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }
}
