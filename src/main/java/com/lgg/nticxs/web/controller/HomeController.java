package com.lgg.nticxs.web.controller;


import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.lgg.nticxs.web.DAO.AdminDAO;
import com.lgg.nticxs.web.DAO.AdministrativoDAO;
import com.lgg.nticxs.web.DAO.AlumnoDAO;
import com.lgg.nticxs.web.DAO.DocenteDAO;
import com.lgg.nticxs.web.DAO.DocumentoDAO;
import com.lgg.nticxs.web.DAO.PadreDAO;
import com.lgg.nticxs.web.model.Alumno;
import com.lgg.nticxs.web.model.Documento;
import com.lgg.nticxs.web.model.Padre;

@Controller
public class HomeController {
	DocumentoDAO docdao = new DocumentoDAO();
	PadreDAO padredao = new PadreDAO();
	AlumnoDAO alumdao = new AlumnoDAO();
	DocenteDAO docentedoa = new DocenteDAO();
	AdminDAO admindao = new AdminDAO();
	AdministrativoDAO administdao = new AdministrativoDAO();
	
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
		String nombre = request.getUserPrincipal().getName();
			model.addAttribute("usuario", nombre);
			
		if(role.equals("ADMINISTRATIVO") || role.equals("DOCENTE") || role.equals("ADMIN")) {
			return "provisioning";
		}else {
			if(role.equals("PADRE")) {
				Padre padre= padredao.retrieveByName(nombre);
			}
			if(role.equals("ALUMNO")) {
				Alumno alumno = alumdao.retrieveByName(nombre);
				
			}
			loadPageUser(model, "nticxs");
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
	
 
 
    
//	@GetMapping("home/download/documento")
//	public ResponseEntity<Resource> getFile(@RequestParam("name") String filename) {
//		Resource file = loadFile(filename);
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//				.body(file);
//	}
	
	@GetMapping( "home/download/document/{docId}")
	public String downloadDocument(@PathVariable String docId, HttpServletResponse response) 
			throws IOException {
		Documento document = docdao.retrieveById(docId);
        response.setContentLength(document.getDocumento().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
 
        FileCopyUtils.copy(document.getDocumento(), response.getOutputStream());
 
 		return "home";
	}
	
	
	
	
	
	private void loadPageUser(Model model, String materia) {
		List<Documento> documentos = docdao.retrieveByMateria(materia);
		model.addAttribute("documentos", documentos);
	}
}
