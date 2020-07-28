package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
    DataSource dataSource;

	// jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
	
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/resources/**");
	    }
	 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		 	.antMatchers("/").permitAll()
		 	.antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
		 	.antMatchers("/findall").hasAnyRole("USER", "ADMIN")
		 	.antMatchers("/findbyid").hasAnyRole("USER", "ADMIN")
		 	.antMatchers("/findbyname").hasAnyRole("USER", "ADMIN")
		 	.antMatchers("/register").hasAnyRole("ADMIN")
		 	.antMatchers("/delete").hasAnyRole("ADMIN")
		 	.antMatchers("/update").hasAnyRole("ADMIN")
		 	.anyRequest().authenticated().and().formLogin().loginPage("/login")
		 	.permitAll().and().logout().permitAll();
		 
     http.csrf().disable();

	}

}
