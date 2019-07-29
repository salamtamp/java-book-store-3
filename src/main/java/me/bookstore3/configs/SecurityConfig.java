package me.bookstore3.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
       
    }
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/books").hasRole("USER")
			.antMatchers(HttpMethod.DELETE, "/books/**").hasRole("USER")
			.antMatchers(HttpMethod.GET, "/users/**").hasRole("USER")
			.antMatchers(HttpMethod.POST, "/users").hasRole("USER")
			.antMatchers(HttpMethod.DELETE, "/users/**").hasRole("USER")
			.and()
			.csrf().disable()
			.formLogin().disable();
    }
}
