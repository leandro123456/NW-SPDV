package com.lgg.nticxs.web.controller;

import org.ietf.tools.TOTPCode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgg.nticxs.web.model.ListCardLotsUser;
import com.lgg.nticxs.web.model.ListLotsUser;
import com.lgg.nticxs.utils.EncryptorPassword;
import com.lgg.nticxs.utils.WSLogger;
import com.lgg.nticxs.web.DAO.UserDAO;
import com.lgg.nticxs.web.model.User;

import nl.flotsam.xeger.Xeger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by movasim on 05/09/16.
 */
@Controller
public class LoginController{
	
	private static WSLogger logger = new WSLogger();
	
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
        return "signup";
    }
    
    @PostMapping("/signup")
    public String addNewUser(Model model,
    		@RequestParam("action") String action,
    		@RequestParam(name="newName", required=false) String name,
    		@RequestParam(name="role", required=false) String role,
    		@RequestParam(name="newPass", required=false) String pass, 
    		@RequestParam(name="newPass2", required=false) String pass2) throws Exception{

    	//Verifico en la DB si hay algun usuario con el nombre
    	//del nuevo usuario que quiero crear
    	UserDAO userdao = new UserDAO();
    	User verifyUserName = userdao.retrieveByName(name);
    	
    	if (action.compareTo("save") == 0) {
    		
    		if(name.isEmpty()) {
        		logger.logger("ERROR", "SM-WEB", "User", "", "", "addNewUser()", "", "", name, "Incorrect name, is empty");
    			model.addAttribute("msg1", "Error ... incorrect name, is empty");
    			return "signup";
        	}
    		
    		//Si no hay ningun usuario con el nombre que quiero usar
    		//se procede a la creacion del usuario
    		if(verifyUserName==null) {
    			//Verificacion de password
    			if(pass.equals(pass2)){

    				//Verificacion de seguridad de la clave
    				if (pass.matches("^(?!.*([A-Za-z0-9])\\1{1})(?=.*[A-Z].*[A-Z].*[A-Z])(?=.*[!@#$&;.,*].*[!@#$&;.,*].*[!@#$&;.,*])(?=.*[0-9].*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{15}$")) {
    					
    					User user = new User();
    	    			
    	    			user.setName(name);

    	    			//Encripto y seteo la password
    	    			byte[] password = EncryptorPassword.encrypt(pass);
    					user.setPassword(password);
    					
    					//Creo una lista vacia para el historial de claves, agrego la clave y la seteo 
    					List<byte[]> list = new ArrayList<byte[]>();
    					list.add(password);
    					user.setHistoryPassword(list);
    					
    					//Creo la key TSA y la seteo
    					user.setKeyTSA(TOTPCode.getRandomSecretKey());
    					
    					//Creo al usuario con el rol VISITOR por defecto 
    					//(por medidas de seguridad) y lo seteo 
    					user.setRole("VISITOR");
    					
    					//Creo una lista de lotes vacia y la seteo
    					ListLotsUser listLotsUser = new ListLotsUser();
    					
    					List<String> listEmpty = new ArrayList<>();
    					listLotsUser.setListEdit(listEmpty);
    					listLotsUser.setListView(listEmpty);
    					
    					user.setListLots(listLotsUser);
    					
    					//Creo una lista de lotes de tarjetas vacias y la seteo
    					ListCardLotsUser listCardLotsUser = new ListCardLotsUser();
    					
    					List<String> listCardLotsUserEmpty = new ArrayList<>();
    					listCardLotsUser.setListLotsCardsEdit(listCardLotsUserEmpty);
    					listCardLotsUser.setListLotsCardsView(listCardLotsUserEmpty);
    					
    					user.setListCardLots(listCardLotsUser);
    					
    					//Seteo false el parametro delete
    					user.setDelete(false);
    					
    					//Guardo el nuevo usuario en DB
    					userdao.create(user);
    					logger.logger("DEBUG", "WEB", "User", "", "Signup", "addNewUser()", "", "", "", "New user created with name: " + user.getName());
    					
    					model.addAttribute("msg2", "User update successfully completed");
    			    	String barCodeData = TOTPCode.getGoogleAuthenticatorBarCode(user.getKeyTSA(), user.getName(), "eReach");
    			    	model.addAttribute("imgQR", barCodeData);
    			    	return "login";
    			    	
    				} else {
    					logger.logger("ERROR", "SM-WEB", "User", "", "", "addNewUser()", "", "", "", "Password does not accomplish the requirements of security");
    					model.addAttribute("msg1", "Error ... Password must meet security requirements");
    					return "signup";
    				}

    			} else {
    				logger.logger("ERROR", "SM-WEB", "User", "", "", "addNewUser()", "", "", "", "Password do not match");
    				model.addAttribute("msg1", "Error ... password do not match");
    				return "signup";
    			}
    			
    		} else {
    			logger.logger("ERROR", "SM-WEB", "User", "", "", "addNewUser()", "", "", name, "Incorrect name, already exists");
    			model.addAttribute("msg1", "Error ... incorrect name, already exists");
    			return "signup";
    		}
    	} 
    
    	return "login";
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
    	UserDAO userdao = new UserDAO();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	
    	User user = userdao.retrieveByName(auth.getName());
    	
    	if(keyTSASend.equals(TOTPCode.getTOTPCode(user.getKeyTSA(), 0)) 
    			|| keyTSASend.equals(TOTPCode.getTOTPCode(user.getKeyTSA(), 30000)) 
    			|| keyTSASend.equals(TOTPCode.getTOTPCode(user.getKeyTSA(), -30000))) {
//    		Muestra el codigo valido para la autenticacion de dos pasos
//    		System.out.println(TOTPCode.getTOTPCode(key.getKey()));
    		
    		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), authorities);
            SecurityContextHolder.getContext().setAuthentication(newAuth);
            logger.logger("DEBUG", "SM-WEB", "Login", "", "Two step authentication", "twoAuthentication()", "", "", "", "Google authenticator verification code correct");
            logger.logger("DEBUG", "SM-WEB", "Login", "", "Login successfull (complete)", "", "", "", "", "User name = " + user.getName() + ", Role: " + user.getRole());
            return "redirect:home/";
    	}
    	
    	logger.logger("ERROR", "SM-WEB", "Login", "", "Two step authentication", "twoAuthentication()", "", "", "", "Google authenticator verification code incorrect");
    	model.addAttribute("msg1", "Google authenticator verification code incorrect");
    	return "login";
    }

    @GetMapping("/logoutsession")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Destroy session
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null){
        	logger.logger("INFO", "SM-WEB", "Login", "", "", "logout()", "", "", auth.getName(), "Log out and destroy session of: " + auth.getName());
        	
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/login";
    }
}
