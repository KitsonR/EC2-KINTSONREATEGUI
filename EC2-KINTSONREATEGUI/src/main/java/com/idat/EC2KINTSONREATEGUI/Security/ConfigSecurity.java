package com.idat.EC2KINTSONREATEGUI.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.idat.EC2KINTSONREATEGUI.Security.EntryPoint;
import com.idat.EC2KINTSONREATEGUI.Security.TokenFilter;
import com.idat.EC2KINTSONREATEGUI.Security.UserDetailService;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailService service;

    @Autowired
    private TokenFilter filter;

    @Autowired
    private EntryPoint entrypoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("profesor").password(encriptado().encode("123") ).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("estudiante").password(encriptado().encode("123")).roles("ESTUDIANTE");

        auth.userDetailsService(service).passwordEncoder(encriptado());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests()
//			.antMatchers("/producto/v1/**").access("hasRole('ADMIN')")
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/crearToken").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(entrypoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();

    }

    @Bean
    public PasswordEncoder encriptado() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        // TODO Auto-generated method stub
        return super.authenticationManager();
    }


}
