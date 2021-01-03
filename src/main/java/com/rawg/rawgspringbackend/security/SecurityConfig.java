package com.rawg.rawgspringbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    public SecurityConfig(JwtTokenServices jwtTokenServices) {
        this.jwtTokenServices = jwtTokenServices;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/logout").permitAll()
                .antMatchers("/api/games/**").permitAll()
                .antMatchers("/api/game/**").permitAll()
                .antMatchers("/picture/**").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
                        "/swagger-resources", "/swagger-resources/configuration/security",
                        "/swagger-ui.html/**", "/webjars/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/user/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/me").authenticated()
                .antMatchers(HttpMethod.GET, "/api/wishlist/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/wishlist/add").authenticated()
                .antMatchers(HttpMethod.POST, "/api/wishlist/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/list/users/**").hasRole("ADMIN")
                .anyRequest().denyAll()
                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenServices),
                        UsernamePasswordAuthenticationFilter.class); // anything else is denied
    }
}
