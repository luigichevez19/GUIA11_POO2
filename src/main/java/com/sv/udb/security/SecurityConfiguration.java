package com.sv.udb.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity


public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
  DataSource dataSource;
	
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
    	auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select acce_usua,cont_usua,esta from usuarios where acce_usua=?")
		.authoritiesByUsernameQuery("select  u.acce_usua,p.nomb_perm from usuarios u inner join permisos_usuarios pu on u.codi_usua=pu.codi_usua inner join permisos p on p.codi_perm = pu.codi_perm where u.acce_usua =?");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
      http.authorizeRequests()
        .antMatchers("/", "/home/").permitAll()
        .antMatchers("/tipos/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/libros/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/db/**").access("hasRole('ROLE_ADMIN')")
        .and().formLogin().loginPage("/home/login")
        .usernameParameter("acce_usua").passwordParameter("cont_usua")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/home/denegado");
    }
}

