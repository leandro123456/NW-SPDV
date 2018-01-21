package com.lgg.nticxs.web.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.lgg.nticxs.web.DAO.RolesDAO;
import com.lgg.nticxs.web.model.Role;

/**
 * Created by movasim on 08/09/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//Cargo mi provedor de autenticaciones modificado
	@Autowired
	private CustomAuthenticationProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authProvider);
	}

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	RolesDAO roledao = new RolesDAO();
    	List<Role> listRole = roledao.retrieveAll();
    	String access = "";
    	
    	for (Role role : listRole) {
    		access = access + "hasAuthority('" + role.getNameRole() + "') or ";
    	}
        http.authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers("/signup").permitAll()
	        .antMatchers("/randompassword").permitAll()
	        .antMatchers("/twoauthentication").access(access.substring(0, (access.length() - 4)) + " or hasAuthority('PRE-AUTHENTICATION')")
	        .antMatchers("/home/").access(access.substring(0, (access.length() - 4)) + " or hasAuthority ('VISITOR') or hasAuthority ('SUPERADMIN')")
	        .antMatchers("/home/**").access(access.substring(0, (access.length() - 4))  + " or hasAuthority ('SUPERADMIN')")
	        .and().formLogin().defaultSuccessUrl("/twoauthentication").loginPage("/login")
	        .usernameParameter("user").passwordParameter("password")
	        .and().exceptionHandling().accessDeniedPage ("/logoutsession")
	        .and().csrf().disable();
    }
}
