package com.lgg.nticxs.web.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.lgg.nticxs.utils.Utils;
import com.lgg.nticxs.web.DAO.RolesDAO;
import com.lgg.nticxs.web.DAO.UserDAO;
import com.lgg.nticxs.web.model.Role;
import com.lgg.nticxs.web.model.User;

/**
 * Created by leandro Guzman 22/01/2018.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private CustomAuthenticationProvider authProvider;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) {
//		auth.authenticationProvider(authProvider);
//	}
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//    	RolesDAO roledao = new RolesDAO();
//    	List<Role> listRole = roledao.retrieveAll();
//    	String access = "";
//    	
//    	for (Role role : listRole) {
//    		access = access + "hasAuthority('" + role.getNameRole() + "') or ";
//    	}
//        http.authorizeRequests()
//	        .antMatchers("/").permitAll()
//	        .antMatchers("/signup").permitAll()
////	        .antMatchers("/randompassword").permitAll()
////	        .antMatchers("/twoauthentication").access(access.substring(0, (access.length() - 4)) + " or hasAuthority('PRE-AUTHENTICATION')")
//	        .antMatchers("/home/").access(access.substring(0, (access.length() - 4)) + " or hasAuthority ('VISITOR') or hasAuthority ('SUPERADMIN')")
//	        .antMatchers("/home/**").access(access.substring(0, (access.length() - 4))  + " or hasAuthority ('SUPERADMIN')")
//	        .and().formLogin().defaultSuccessUrl("/home/").loginPage("/login")
//            .usernameParameter("user").passwordParameter("password")
//	        .and().exceptionHandling().accessDeniedPage ("/logoutsession")
//	        .and().csrf().disable();
//    }
	
	  @Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	    	UserDAO userDao= new UserDAO();
	    	List<User> users= userDao.retrieveAll();
	    	for(User user: users){
	    		auth.inMemoryAuthentication().withUser("lean").password("lean").roles("ADMIN");
	    		System.out.println("usuario: "+user.getName()+" pass: "+Utils.toUnformattedHexArray(user.getPassword())+" rol: "+user.getRole());
	    		auth.inMemoryAuthentication().withUser(user.getName()).password(user.getPassword().toString()).roles(user.getRole());
	    	}

	    }


	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	    	RolesDAO roledao = new RolesDAO();
	    	List<Role> listRole = roledao.retrieveAll();
	    	String access = "";
	    	
	    	for (Role role : listRole) {
	    		access = access + "hasAuthority('" + role.getNameRole() + "') or ";
	    	}
	    	System.out.println("roles-guz: " + access);
	        http.authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers("/signup").permitAll()
//	        .antMatchers("/randompassword").permitAll()
//	        .antMatchers("/twoauthentication").access(access.substring(0, (access.length() - 4)) + " or hasAuthority('PRE-AUTHENTICATION')")
	        .antMatchers("/home/").access("hasRole('ADMIN') or hasRole('VISITOR') or hasRole('SUPERADMIN') or hasRole('DOCENTE') or hasRole('ALUMNO') or hasRole('ADMINISTRATIVO')")
//	        .antMatchers("/home/**").access("hasRole('ADMIN') or hasRole('VISITOR') or hasRole('SUPERADMIN') or hasRole('DOCENTE') or hasRole('ALUMNO') or hasRole('ADMINISTRATIVO')")
	        .and().formLogin().defaultSuccessUrl("/home/").loginPage("/login")
            .usernameParameter("user").passwordParameter("password")
	        .and().exceptionHandling().accessDeniedPage ("/logoutsession")
	        .and().csrf().disable();
   }
	
	
	
	
}
