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
	
	private static WSLoggerPreLogin logger = new WSLoggerPreLogin();
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UserDAO userdao = new UserDAO();
		
		//Tomo los nombres de la autenticacion que se carga al loguearse
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		//Busco en la DB el usuario que coincida con el nombre que ingrese
		//si no se encuentra devuelve un null
		User user = new User();
		user = userdao.retrieveByName(name);
		
		//Se usa try por el decrypt de la password
		try {
			//Busco si coinciden todos los datos con el usuario que se encontro y pido que se encuentre un usuario
			if (name.equals(user.getName()) && password.equals(EncryptorPassword.decrypt(user.getPassword())) && user != null) {
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				
				//Es necesario que la autoridad del usuario simpre sea la que se especifica a continuacion
				//debido a que sino hay incongruencias con la autenticacion de dos pasos
				authorities.add(new SimpleGrantedAuthority("PRE-AUTHENTICATION"));
				
				//Devuelvo una autenticacion completa al SecurityCongiguration
				logger.logger("DEBUG", "SM-WEB", "Login", "Login successfull (parcial)", "", "", "", "", "", "User name = " + user.getName() + " Role: PRE-AUTHENTICATION");
				return new UsernamePasswordAuthenticationToken(user.getName(), EncryptorPassword.decrypt(user.getPassword()), authorities);
			} else {
				logger.logger("ERROR", "SM-WEB", "Login", "Login failed", "", "", "", "", "", "Invalid date. User name = " + user.getName());
			}
		} catch (Exception e) {
			
			logger.logger("ERROR", "SM-WEB", "Login", "", "", "authenticate()", "", "", "", "Error to decrypt the password");
			
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
