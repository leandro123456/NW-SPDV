package com.lgg.nticxs.web.controller;


import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.lgg.nticxs.web.DAO.DocumentoDAO;
import com.lgg.nticxs.web.model.Docente;
import com.lgg.nticxs.web.model.Documento;

@Controller
public class HomeController {
	DocumentoDAO docdao = new DocumentoDAO();
	
	@GetMapping("home/")
    public String pageLoad(HttpServletRequest request, Model model) {
		String role= "";
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			@SuppressWarnings("unchecked")
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
		    for (GrantedAuthority grantedAuthority : authorities) {
		    	role=grantedAuthority.getAuthority();
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			model.addAttribute("usuario", request.getUserPrincipal().getName());
		} catch (Exception e) {
			System.out.println("error");
		}
		
		if(role.equals("ADMINISTRATIVO") || role.equals("DOCENTE") || role.equals("ADMIN")) {
			return "provisioning";
		
		}else {
			loadPageUser(model);
			return "home";
		}	
    }

	@PostMapping("home/")
	public String sendMail(Model model, String Mensaje) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("Username", "PassWord");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Username"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("leandrogabrielguzman@gmail.com"));
			message.setSubject("Activacion de Cuenta de Email");
			message.setText(Mensaje);

			Transport.send(message);
			model.addAttribute("msg1", "Su mensaje se envio correctamente");


		} catch (MessagingException e) {
			model.addAttribute("msg1", "Fallo el envio de sucorrectamente");
			throw new RuntimeException(e);
		}
		return "home";
	}
	
//    @RequestMapping("home/download/documento")
//    public void playMerged( @PathVariable("name") String nombre, HttpServletRequest request,
//            HttpServletResponse response) {
//            String mergedAudioPath = service.getMergedAudio(nombre);
//            MultipartFileSender.fromPath(Paths.get(mergedAudioPath)).with(request).with(response).serveResource();
//   }
    
    
//	public void store(MultipartFile file){
//		try {
//            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
//        } catch (Exception e) {
//        	throw new RuntimeException("FAIL!");
//        }
//	}
	
 
    public Resource loadFile(String filename) {
    	Path rootLocation = Paths.get("upload-dir");
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
            	throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
        	throw new RuntimeException("FAIL!");
        }
    }
    
	@GetMapping("home/download/documento")
	public ResponseEntity<Resource> getFile(@RequestParam("name") String filename) {
		Resource file = loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
	
	
	
	
	
	
	private void loadPageUser(Model model) {
		
		
	}
}
