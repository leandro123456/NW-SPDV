package com.lgg.nticxs.web.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lgg.nticxs.web.utils.Utils;
import com.lgg.nticxs.web.DAO.AdminDAO;
import com.lgg.nticxs.web.DAO.AdministrativoDAO;
import com.lgg.nticxs.web.DAO.AlumnoDAO;
import com.lgg.nticxs.web.DAO.AsistenciaDAO;
import com.lgg.nticxs.web.DAO.DocenteDAO;
import com.lgg.nticxs.web.DAO.DocumentoDAO;
import com.lgg.nticxs.web.DAO.NotaDAO;
import com.lgg.nticxs.web.DAO.PadreDAO;
import com.lgg.nticxs.web.model.Alumno;
import com.lgg.nticxs.web.model.Asistencia;
import com.lgg.nticxs.web.model.Documento;
import com.lgg.nticxs.web.model.Materia;
import com.lgg.nticxs.web.model.Nota;
import com.lgg.nticxs.web.model.Padre;
import com.lgg.nticxs.web.model.SimpleAlumno;

@Controller
public class HomeController {
	DocumentoDAO docdao = new DocumentoDAO();
	PadreDAO padredao = new PadreDAO();
	AlumnoDAO alumdao = new AlumnoDAO();
	DocenteDAO docentedoa = new DocenteDAO();
	AdminDAO admindao = new AdminDAO();
	NotaDAO notasdao = new NotaDAO();
	AsistenciaDAO asistenciadao = new AsistenciaDAO();
	AdministrativoDAO administdao = new AdministrativoDAO();
	Integer trimestreActual = Utils.TrimestreActual();
	
	@GetMapping("homepage/")
    public ModelAndView pageLoad(HttpServletRequest request, ModelMap model) {
		String role= "";
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			@SuppressWarnings("unchecked")
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
		    for (GrantedAuthority grantedAuthority : authorities) {
		    	role=grantedAuthority.getAuthority();
		    	model.addAttribute("role", role);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		String nombre = request.getUserPrincipal().getName();
		model.addAttribute("usuario", nombre);
		if(role.equals("ADMINISTRATIVO") || role.equals("DOCENTE") || role.equals("ADMIN")) {
			return new ModelAndView("redirect:/home/provisioning", model);
		}else {
			return new ModelAndView("redirect:/home", model);

		}	
    }
	
	@RequestMapping("/home")
	public String books(@RequestParam("role") String role,@RequestParam("usuario") String usuario, Model model){
	   Map<String, Materia> asociacionMAt= new HashMap<>();
		if(role.equals("PADRE")){
	    	System.out.println("nombre de padre: "+ usuario);
	    	Padre padre =padredao.retrieveByName(usuario);
	    	List<SimpleAlumno> infoHijoMateria  = new ArrayList<SimpleAlumno>();
	    	for (String hijo : padre.getAlumno()) {
				System.out.println("nombreHijo: "+ hijo);
				Alumno alumno = alumdao.retrieveByName(hijo);
				//asociacionMAt
				List<Materia.materia> mat= alumno.getCiclolectivo().getMaterias().getMateria();
				for(Materia.materia mate :mat){
					SimpleAlumno estudiante = new SimpleAlumno(alumno.getName(), mate.getName());
					infoHijoMateria.add(estudiante);
				}
			}
	    	model.addAttribute("hijoMateria", infoHijoMateria);
	    	model.addAttribute("hijos", padre.getAlumno());
	    }else{ //SERIA ALUMNO
	    	
	    }
		model.addAttribute("usuario", usuario);
	    model.addAttribute("role", role);
	    
	    return "origin";
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
	
	
	private void loadPageAlumno(Model model, String materia) {
		List<Documento> documentos = docdao.retrieveByMateria(materia);
		model.addAttribute("documentos", documentos);
	}
	
	private void loadPagePadreAlumno(Model model, String materia, String alumnoName) {
		Alumno alumno = alumdao.retrieveByName(alumnoName);
		List<Nota> notas = notasdao.retrieveByAlumno(alumno.getId());
		List<Asistencia> asistencias = asistenciadao.retrieveByAlumno(alumno.getId());
		Double promediotareas = promedio(notas,Nota.ACTIVIDADES);
		Double promediotp = promedio(notas,Nota.TRABAJO_PRACTICO);
		Double promedioev = promedio(notas,Nota.EVALUACION);
		Double promediotrimestre = promedio(notas,"trimestre");
		Integer asistenciaFaltas = promedioAsistencia(asistencias);
		Integer asistenciaPresente = promedioAsistencia(asistencias);
		
		model.addAttribute("promediotareas", promediotareas*10);
		model.addAttribute("promediotp", promediotp*10);
		model.addAttribute("promedioev", promedioev*10);
		model.addAttribute("promediotrimestre", promediotrimestre*10);

		model.addAttribute("notas", notas);
		model.addAttribute("asistencias", asistencias);
		model.addAttribute("asistenciaFaltas",asistenciaFaltas);
		model.addAttribute("asistenciaPresente",asistenciaPresente);
		
	}

	private Integer promedioAsistencia(List<Asistencia> asistencia) {
		Integer asistenciaTotal = 0;
		if(asistencia!= null) {
			if(Asistencia.AUSENTE_JUSTIFICADO != null) {
				for(Asistencia asist : asistencia) {
					if(asist.getTipo().equals(Asistencia.AUSENTE) || asist.getTipo().equals(Asistencia.AUSENTE_JUSTIFICADO))
						asistenciaTotal+=1;
				}
			}else {
				for(Asistencia asist : asistencia) {
					if(asist.getTipo().equals(Asistencia.PRESENTE))
						asistenciaTotal+=1;
				}
			}
		}
		return asistenciaTotal;
	}

	private Double promedio(List<Nota> notas, String tipo) {
		Double promedio = 0.0;
		Double total=0.0;
		Integer cantidad = 0;
		
		if (notas != null) {
			for(Nota nota : notas){
				if(nota.getTrimestre() == trimestreActual && nota.getTipo().equals(tipo)){
					cantidad +=1;
					total=total+nota.getValor();
				}
			}
		}
		if(cantidad != 0)
		promedio = (double) (total/cantidad);
		return promedio;
	}


}
