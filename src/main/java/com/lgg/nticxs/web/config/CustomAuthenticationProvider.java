package com.lgg.nticxs.web.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.lgg.nticxs.utils.EncryptorPassword;
import com.lgg.nticxs.web.DAO.AdminDAO;
import com.lgg.nticxs.web.DAO.AdministrativoDAO;
import com.lgg.nticxs.web.DAO.AlumnoDAO;
import com.lgg.nticxs.web.DAO.DocenteDAO;
import com.lgg.nticxs.web.DAO.PadreDAO;
import com.lgg.nticxs.web.model.Admin;
import com.lgg.nticxs.web.model.Administrativo;
import com.lgg.nticxs.web.model.Alumno;
import com.lgg.nticxs.web.model.Docente;
import com.lgg.nticxs.web.model.Padre;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		AlumnoDAO alumdao = new AlumnoDAO();
		PadreDAO padredao = new PadreDAO();
		AdminDAO admindao = new AdminDAO();
		AdministrativoDAO administrativodao = new AdministrativoDAO();
		DocenteDAO docentedao = new DocenteDAO();

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		System.out.println("valor autenticacion credenciales: "+ authentication.getCredentials());
		System.out.println("valor autenticacion tamaño: "+ authentication.getAuthorities().size());
		System.out.println("valor autenticacion detalles: "+ authentication.getDetails());
		System.out.println("valor autenticacion principal: "+ authentication.getPrincipal());
		Collection<GrantedAuthority> authorities1 = (Collection<GrantedAuthority>) authentication.getAuthorities();
	    String role="";
		for (GrantedAuthority grantedAuthority : authorities1) {
	    	role=grantedAuthority.getAuthority();	
	    	System.out.println("rol: "+role);
	    }		
		
		
		Alumno alumno = alumdao.retrieveByName(name);
		if(alumno != null)
			System.out.println("es alumno");
		Padre padre = padredao.retrieveByName(name);
		if(padre != null)
			System.out.println("es padre");
		Admin admin = admindao.retrieveByName(name);
		if(admin != null)
			System.out.println("es admin");
		Administrativo administrativo = administrativodao.retrieveByName(name);
		if (administrativo != null)
			System.out.println("es administrativo");
		Docente docente = docentedao.retrieveByName(name);
		if (docente != null)
			System.out.println("es docente");
		
		
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
