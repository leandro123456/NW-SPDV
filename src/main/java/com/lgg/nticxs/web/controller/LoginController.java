package com.lgg.nticxs.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

import nl.flotsam.xeger.Xeger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController{
	private AdminDAO admindao = new AdminDAO();
	private AdministrativoDAO adminstrativodao = new AdministrativoDAO();
	private DocenteDAO docentedao  = new DocenteDAO();
	private AlumnoDAO alumnodao  = new AlumnoDAO();
	private PadreDAO padredao = new PadreDAO();

    @GetMapping("/")
    public String redirect(Model model) {
        return "redirect:login";
    }


    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @GetMapping("/signup")
    public String signup(Model model) {
    	loadSingUp(model);
        return "signup";
    }
    
    private void loadSingUp(Model model) {
    	List<Alumno> allAlumnos = alumnodao.retrieveAll();
    	List<String> alumnos =new ArrayList<>();
    	for(Alumno alum: allAlumnos){
    		if(!alum.getCuenta_iniciada())
    			alumnos.add(alum.getName());
    	}
    	model.addAttribute("alumnos",alumnos);
		
	}


	@PostMapping("/signup")
    public String addNewUser(Model model,
    		@RequestParam("action") String action,
    		@RequestParam(name="insertname", required=false) String insertName,
    		@RequestParam(name="selectName", required=false) String selectName,
    		@RequestParam(name="role", required=false) String role,
    		@RequestParam(name="newPass", required=false) String pass, 
    		@RequestParam(name="newPass2", required=false) String pass2,
    		@RequestParam(name="relacion", required=false) String relacion) throws Exception{
    	String returnValue = null;
    	if (action.compareTo("save") == 0) {   		
    		if(nameExist(insertName, selectName)) {
    			model.addAttribute("msg1", "Error ... el nombre ya existe, genere otro diferente");
    			loadSingUp(model);
    			return "signup";
        	}
        	switch (role) {
    		case "ALUMNO":
    			returnValue = createAlumno(model, selectName, role,pass, pass2);
    			break;
    		case "PADRE":
    			returnValue = createPadre(model, insertName, role,pass, pass2, relacion);
    			break;

    		default:
    			break;
    		}
        	return returnValue;
    	} 
    	return "login";
    	
    }
    
    
    private boolean nameExist(String insertName, String selectName) {
		if(insertName == null){
			Alumno alumno = alumnodao.retrieveByName(selectName);
			Docente docente = docentedao.retrieveByName(selectName);
			Padre padre = padredao.retrieveByName(selectName);
			Admin admin = admindao.retrieveByName(selectName);
			Administrativo admina = adminstrativodao.retrieveByName(selectName);
			if(alumno == null && docente == null && padre == null 
					&& admin == null && admina == null)
				return true;
			else
				return false;
		}else{
			Alumno alumno = alumnodao.retrieveByName(insertName);
			Docente docente = docentedao.retrieveByName(insertName);
			Padre padre = padredao.retrieveByName(insertName);
			Admin admin = admindao.retrieveByName(insertName);
			Administrativo admina = adminstrativodao.retrieveByName(insertName);
			if(alumno == null && docente == null && padre == null 
					&& admin == null && admina == null)
				return true;
			else
				return false;
		}
	}


	@GetMapping("/signupPass")
    public String signupPass(Model model) {
        return "signup2";
    }
    
    @PostMapping("/signupPass")
    public String signupPass(Model model,
    		@RequestParam(name="pass", required=true) String pass) throws Exception{
    		if(pass.equals("KFsck32/dF$5sd8"))
    				return "signup2";
    		else{
    			model.addAttribute("msg1", "Error ... contraseña incorrecta");
    			return "signup2";
    		}
    }
    
    
    @GetMapping("/signupPass2")
    public String signupPass2(Model model) {
        return "signup2";
    }
    
    @PostMapping("/signupPass2")
    public String signupPass2(Model model,
    		@RequestParam("action") String action,
    		@RequestParam(name="newName", required=false) String name,
    		@RequestParam(name="role", required=false) String role,
    		@RequestParam(name="newPass", required=false) String pass, 
    		@RequestParam(name="newPass2", required=false) String pass2) throws Exception{
    	String returnValue = null;
    	if (action.compareTo("save") == 0) {
    		if(name.isEmpty()) {
    			model.addAttribute("msg1", "Error ... incorrect name, is empty");
    			return "signup";
        	}
    		
        	switch (role) {
    		case "ADMIN":
    			returnValue = createAdmin(model, name, role,pass, pass2);
    			break;
    		case "ADMINISTRATIVO":
    			returnValue = createAdministrativo(model, name, role,pass, pass2);
    			break;
    		case "DOCENTE":
    			returnValue = createDocente(model, name, role,pass, pass2);
    			break;
    		default:
    			break;
    		}
    	} 
    
    	return returnValue;
    }



	private String createPadre(Model model, String name, String role,String pass, String pass2, String alumnoRelacionado) {
		if(!existName(name,role)) {
			if(pass.equals(pass2)){
				if (pass.matches("^(?!.*([A-Za-z0-9])\\1{1})(?=.*[A-Z].*[A-Z].*[A-Z])(?=.*[!@#$&;.,*].*[!@#$&;.,*].*[!@#$&;.,*])(?=.*[0-9].*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{15}$")) {
					Padre admin = new Padre();
	    			admin.setName(name);
	    			try {
	    				byte[] password = EncryptorPassword.encrypt(pass);
						admin.setPassword(password);
						List<byte[]> list = new ArrayList<byte[]>();
						list.add(password);
						admin.setHistoryPassword(list);
					} catch (Exception e) {
						System.out.println("error en la generacion del pass");
						e.printStackTrace();
					}
					admin.setRole(role);
					admin.setDelete(false);
					admin.setAlumno(new ArrayList<String>());
					admin.getAlumno().add(alumnoRelacionado);
					padredao.create(admin);
					model.addAttribute("msg2", "User update successfully completed");
			    	return "login";
				} else {
					model.addAttribute("msg1", "Error ... Password must meet security requirements");
					return "signup";
				}
			} else {
				model.addAttribute("msg1", "Error ... password do not match");
				return "signup";
			}
		}else {
			model.addAttribute("msg1", "Error ... incorrect name, already exists");
			return "signup";
		}
		
	}


	private String createAlumno(Model model, String name, String role, String pass, String pass2) {
		if(!existName(name,role)) {
			if(pass.equals(pass2)){
				if (pass.matches("^(?!.*([A-Za-z0-9])\\1{1})(?=.*[A-Z].*[A-Z].*[A-Z])(?=.*[!@#$&;.,*].*[!@#$&;.,*].*[!@#$&;.,*])(?=.*[0-9].*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{15}$")) {
					Alumno admin = new Alumno();
	    			admin.setName(name);
	    			try {
	    				byte[] password = EncryptorPassword.encrypt(pass);
						admin.setPassword(password);
						List<byte[]> list = new ArrayList<byte[]>();
						list.add(password);
						admin.setHistoryPassword(list);
					} catch (Exception e) {
						System.out.println("error en la generacion del pass");
						e.printStackTrace();
					}
					admin.setRole(role);
					admin.setDelete(false);
					admin.setCuenta_iniciada(true);
					alumnodao.create(admin);
					model.addAttribute("msg2", "User update successfully completed");
			    	return "login";
				} else {
					model.addAttribute("msg1", "Error ... Password must meet security requirements");
					return "signup";
				}
			} else {
				model.addAttribute("msg1", "Error ... password do not match");
				return "signup";
			}
		}else {
			model.addAttribute("msg1", "Error ... incorrect name, already exists");
			return "signup";
		}
		
	}


	private String createDocente(Model model, String name, String role, String pass, String pass2) {
		if(!existName(name,role)) {
			if(pass.equals(pass2)){
				if (pass.matches("^(?!.*([A-Za-z0-9])\\1{1})(?=.*[A-Z].*[A-Z].*[A-Z])(?=.*[!@#$&;.,*].*[!@#$&;.,*].*[!@#$&;.,*])(?=.*[0-9].*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{15}$")) {
					Docente admin = new Docente();
	    			admin.setName(name);
	    			try {
	    				byte[] password = EncryptorPassword.encrypt(pass);
						admin.setPassword(password);
						List<byte[]> list = new ArrayList<byte[]>();
						list.add(password);
						admin.setHistoryPassword(list);
					} catch (Exception e) {
						System.out.println("error en la generacion del pass");
						e.printStackTrace();
					}
					admin.setRole(role);
					admin.setDelete(false);
					docentedao.create(admin);
					model.addAttribute("msg2", "User update successfully completed");
			    	return "login";
				} else {
					model.addAttribute("msg1", "Error ... Password must meet security requirements");
					return "signup";
				}
			} else {
				model.addAttribute("msg1", "Error ... password do not match");
				return "signup";
			}
		}else {
			model.addAttribute("msg1", "Error ... incorrect name, already exists");
			return "signup";
		}
		
	}


	private String createAdministrativo(Model model, String name, String role, String pass, String pass2) {
		if(!existName(name,role)) {
			if(pass.equals(pass2)){
				if (pass.matches("^(?!.*([A-Za-z0-9])\\1{1})(?=.*[A-Z].*[A-Z].*[A-Z])(?=.*[!@#$&;.,*].*[!@#$&;.,*].*[!@#$&;.,*])(?=.*[0-9].*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{15}$")) {
					Administrativo admin = new Administrativo();
	    			admin.setName(name);
	    			try {
	    				byte[] password = EncryptorPassword.encrypt(pass);
						admin.setPassword(password);
						List<byte[]> list = new ArrayList<byte[]>();
						list.add(password);
						admin.setHistoryPassword(list);
					} catch (Exception e) {
						System.out.println("error en la generacion del pass");
						e.printStackTrace();
					}
					admin.setRole(role);
					admin.setDelete(false);
					adminstrativodao.create(admin);
					model.addAttribute("msg2", "User update successfully completed");
			    	return "login";
				} else {
					model.addAttribute("msg1", "Error ... Password must meet security requirements");
					return "signup";
				}
			} else {
				model.addAttribute("msg1", "Error ... password do not match");
				return "signup";
			}
		}else {
			model.addAttribute("msg1", "Error ... incorrect name, already exists");
			return "signup";
		}
		
	}


	private String createAdmin(Model model, String name, String role, String pass, String pass2){
		if(!existName(name,role)) {
			if(pass.equals(pass2)){
				if (pass.matches("^(?!.*([A-Za-z0-9])\\1{1})(?=.*[A-Z].*[A-Z].*[A-Z])(?=.*[!@#$&;.,*].*[!@#$&;.,*].*[!@#$&;.,*])(?=.*[0-9].*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{15}$")) {
					Admin admin = new Admin();
	    			admin.setName(name);
	    			try {
	    				byte[] password = EncryptorPassword.encrypt(pass);
						admin.setPassword(password);
						List<byte[]> list = new ArrayList<byte[]>();
						list.add(password);
						admin.setHistoryPassword(list);
					} catch (Exception e) {
						System.out.println("error en la generacion del pass");
						e.printStackTrace();
					}
					admin.setRole(role);
					admin.setDelete(false);
					admindao.create(admin);
					model.addAttribute("msg2", "User update successfully completed");
			    	return "login";
				} else {
					model.addAttribute("msg1", "Error ... Password must meet security requirements");
					return "signup";
				}
			} else {
				model.addAttribute("msg1", "Error ... password do not match");
				return "signup";
			}
		}else {
			model.addAttribute("msg1", "Error ... incorrect name, already exists");
			return "signup";
		}	
	}


	private boolean existName(String name, String role) {
    	switch (role) {
		case "ADMIN":
			Admin admin = admindao.retrieveByName(name);
			if(admin != null)
				return true;
			break;
		case "ADMINISTRATIVO":
			Administrativo administrativo = adminstrativodao.retrieveByName(name);
			if(administrativo != null)
				return true;
			break;
		case "DOCENTE":
			Docente docente = docentedao.retrieveByName(name);
			if(docente != null)
				return true;
			break;
		case "ALUMNO":
			Alumno alumno = alumnodao.retrieveByName(name);
			if(alumno != null)
				return true;
			break;
		case "PADRE":
			Padre padre = padredao.retrieveByName(name);
			if(padre != null)
				return true;
			break;
		default:
			break;
		}
		return false;
	}


	@GetMapping("/randompassword")
    public void randompassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	    
 	   	String result = null;
     	Boolean complete = true;
     	
     	while(complete) {
     		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
         	String upperCase = lowerCase.toUpperCase();
         	String regex = "[" + lowerCase + "]{5}[!@#$&*]{3}[" + upperCase + "]{4}[123456789]{3}";
         	Xeger generator = new Xeger(regex);
         	result = generator.generate();
         	assert result.matches(regex);
     		
     		String match = "^(?!.*([A-Za-z0-9])\\1{1})(?=.*[A-Z].*[A-Z].*[A-Z])(?=.*[!@#$&;.,*].*[!@#$&;.,*].*[!@#$&;.,*])(?=.*[0-9].*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{15}$";
     		if(result.matches(match)) {
     			complete = false;
     		}
     	}

 	    response.setContentType("text/plain");
 	    response.setCharacterEncoding("UTF-8");
 	    response.getWriter().write(result);
 	}
    
    @GetMapping("/twoauthentication")
    public String load() {
    	return "twoAuthentication";
    }
    
    @PostMapping("/twoauthentication")
    public String twoAuthentication(Model model, @RequestParam("sixKey") String keyTSASend) {
//    	UserDAO userdao = new UserDAO();
//    	
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	
    //	User user = userdao.retrieveByName(auth.getName());
    	
//    	if(keyTSASend.equals(TOTPCode.getTOTPCode(user.getKeyTSA(), 0)) 
//    			|| keyTSASend.equals(TOTPCode.getTOTPCode(user.getKeyTSA(), 90000)) 
//    			|| keyTSASend.equals(TOTPCode.getTOTPCode(user.getKeyTSA(), -90000))) {
//    		Muestra el codigo valido para la autenticacion de dos pasos
//    		System.out.println(TOTPCode.getTOTPCode(key.getKey()));
    		
//    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//            authorities.add(new SimpleGrantedAuthority(user.getRole()));
//            Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), authorities);
//            SecurityContextHolder.getContext().setAuthentication(newAuth);
//            return "redirect:home/";
//    	}
//    	
//    	model.addAttribute("msg1", "Google authenticator verification code incorrect");
    	return "login";
    }

    @GetMapping("/logoutsession")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Destroy session
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null){
        	
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }
}
