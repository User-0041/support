package com.support.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter  {
    @Autowired
    private UserDetailsService UserDetailsService;

    
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    AuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider provider  = new DaoAuthenticationProvider(); 
        provider.setUserDetailsService(UserDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/webjars/**").permitAll()
        .antMatchers("/Support/OpenSupport").hasAnyAuthority("Admin","Resever","User")
        .antMatchers("/Support/CloseSupport").hasAnyAuthority("Admin","Resever")
        .antMatchers("/Support/TakeSupport/{id}").hasAnyAuthority("Admin","Resever")
        .antMatchers("/Support/ListSupport").hasAnyAuthority("Admin","Resever","User")
        .antMatchers("/static/**").permitAll()

        .and()
        .formLogin()
        .defaultSuccessUrl("/Support/ListSupport")
        ;

    }

    
}