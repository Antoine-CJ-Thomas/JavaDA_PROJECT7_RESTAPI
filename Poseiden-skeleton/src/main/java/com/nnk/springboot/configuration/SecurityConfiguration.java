package com.nnk.springboot.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.nnk.springboot.service.LoginService;

/**
 * This class allows to configure Spring Security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private LoginService loginService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
        
	        .formLogin()
	        	.defaultSuccessUrl("/bidList/list", true)
	        
	        .and()
	        .logout()
	            .logoutUrl("/app-logout")
	            .logoutSuccessUrl("/")
	            .invalidateHttpSession(true)

            .and()
        	.authorizeRequests()
		        .antMatchers("/").permitAll()
		        .antMatchers("/login").permitAll()
		        .antMatchers("/user/**").permitAll()
		        .antMatchers("/**").authenticated()
				.antMatchers("/resources/**").permitAll();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	
    	web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
