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
import com.lgg.nticxs.web.DAO.AlumnoDAO;
import com.lgg.nticxs.web.model.Alumno;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		AlumnoDAO alumdao = new AlumnoDAO();

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		Alumno user = new Alumno();
		user = alumdao.retrieveByName(name);
		try {
			if (name.equals(user.getName()) && password.equals(EncryptorPassword.decrypt(user.getPassword())) && user != null) {
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority(user.getRole()));
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
