package com.rawg.rawgspringbackend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/api/games/**").permitAll()// allowed by anyone
                .antMatchers(HttpMethod.GET, "/api/user/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.GET, "/api/wishlist/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.POST, "/api/wishlist/**").authenticated() // allowed only when signed in
                .antMatchers(HttpMethod.DELETE, "/vehicles/**").hasRole("ADMIN") // allowed if signed in with ADMIN role
                .anyRequest().denyAll(); // anything else is denied
    }
}
