package com.lgg.nticxs.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.lgg.nticxs.utils.EncryptorPassword;
import com.lgg.nticxs.utils.WSLoggerPreLogin;
import com.lgg.nticxs.web.DAO.UserDAO;
import com.lgg.nticxs.web.model.User;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UserDAO userdao = new UserDAO();

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println("valores ingresados: "+ name +" "+password);
		User user = new User();
		user = userdao.retrieveByName(name);
		System.out.println("usuario en la base de datos. "+ user);
		try {
			if (name.equals(user.getName()) && password.equals(EncryptorPassword.decrypt(user.getPassword())) && user != null) {
				System.out.println("los valores se corresponden ");
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(user.getRole()));
				System.out.println("autoridades: "+ authorities.size());
				System.out.println("autoridades: "+authorities.get(0).getAuthority());
				System.out.println("Login successfull"+ "User name = " + user.getName() +" rol: "+user.getRole());
				System.out.println("retorna esto: "+ user.getName()+" "+ EncryptorPassword.decrypt(user.getPassword())+" "+ authorities);
				return new UsernamePasswordAuthenticationToken(user.getName(), EncryptorPassword.decrypt(user.getPassword()), authorities);
			} else {
				System.out.println("Login failed"+ "Invalid date. User name = " + user.getName());
			}
		} catch (Exception e) {
			System.out.println(" Error authenticate()"+ "Error to decrypt the password");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
}
