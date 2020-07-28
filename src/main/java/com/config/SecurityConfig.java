package com.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

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
    
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() throws Exception {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(dataSource);
		
		return jdbcUserDetailsManager;
	}
	
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/resources/**");
	    }
	 
	// Setting Permissions
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
