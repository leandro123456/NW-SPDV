package com.lgg.nticxs.web.controller;


import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
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

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
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
			System.out.println("nombre: "+ request.getLocalAddr());
			System.out.println("nombre: "+ request.getRemoteUser());
			System.out.println("nombre: "+ request.getUserPrincipal().getName());
			model.addAttribute("usuario", request.getUserPrincipal().getName());
		} catch (Exception e) {
			System.out.println("error");
		}
		
		if(role.equals("ADMINISTRATIVO") || role.equals("DOCENTE")) {
			return "home2";
		
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
	
	@PostMapping("home/")
	public String downloadFile(Model model, String action) {
		File ficheroXLS = new File("");
		FacesContext ctx = FacesContext.getCurrentInstance();
		FileInputStream fis = new FileInputStream(ficheroXLS);
		byte[] bytes = new byte[1000];
		int read = 0;

		if (!ctx.getResponseComplete()) {
		   String fileName = ficheroXLS.getName();
		   String contentType = "application/vnd.ms-excel";
		   //String contentType = "application/pdf";
		   HttpServletResponse response =(HttpServletResponse) ctx.getExternalContext().getResponse();
		   response.setContentType(contentType);
		   response.setHeader("Content-Disposition","attachment;filename=\"" + fileName + "\"");
		   ServletOutputStream out = response.getOutputStream();

		   while ((read = fis.read(bytes)) != -1) {
		        out.write(bytes, 0, read);
		   }

		   out.flush();
		   out.close();
		   System.out.println("\nDescargado\n");
		   ctx.responseComplete();
		}
	}
	
	
	
	private void loadPageUser(Model model) {
		
		
	}
}
