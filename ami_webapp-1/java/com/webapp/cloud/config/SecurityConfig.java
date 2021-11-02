package com.webapp.cloud.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.webapp.cloud.api.UserService;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	    @Autowired
	    private UserService userService;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	 auth.userDetailsService(userService).passwordEncoder(encoder());
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();

	        http.httpBasic().and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//	        http.authorizeRequests()
//	                .antMatchers("/cloud/services/api/users/**").fullyAuthenticated()
//	                .anyRequest().permitAll();
	    }
	
	    @Bean
	    public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	    @Bean
	    public BasicAuthenticationEntryPoint authenticationEntryPoint() {
	        return new BasicAuthenticationEntryPoint() {
	            @Override
	            public void afterPropertiesSet() {
	                setRealmName("webapp");
	                super.afterPropertiesSet();
	            }

	            @Override
	            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
	                response.addHeader("WWW-Authenticate", "Basic realm = "+getRealmName());
	                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	                response.getWriter().println("401 - UNAUTHORIZED");
	            }
	        };
	    }

}
