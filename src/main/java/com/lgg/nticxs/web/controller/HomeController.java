package com.lgg.nticxs.web.controller;

import java.util.Iterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {
	@GetMapping("home/")
    public String pageLoad(Model model, @SessionAttribute User user) {
		
//		if(role.equals("ADMINISTRATIVO"))
//			return "home2";
//		else
		System.out.println("nombre: "+ user.getUsername());
		System.out.println("pass: "+ user.getPassword());
		Iterator<GrantedAuthority> autorizados=user.getAuthorities().iterator();
		while (autorizados.hasNext()) {
			GrantedAuthority type = autorizados.next();
			System.out.println("valor: "+ type.getAuthority());	
		}
			return "home";
		
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
}
