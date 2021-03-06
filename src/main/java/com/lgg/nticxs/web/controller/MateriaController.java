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
import com.lgg.nticxs.web.DAO.SimpleMateriaDAO;
import com.lgg.nticxs.web.model.Alumno;
import com.lgg.nticxs.web.model.Asistencia;
import com.lgg.nticxs.web.model.Asistencia2;
import com.lgg.nticxs.web.model.Documento;
import com.lgg.nticxs.web.model.Materia;
import com.lgg.nticxs.web.model.Nota;
import com.lgg.nticxs.web.model.Nota2;
import com.lgg.nticxs.web.model.Padre;
import com.lgg.nticxs.web.model.SimpleAlumno;
import com.lgg.nticxs.web.model.SimpleAlumnoFilter;
import com.lgg.nticxs.web.model.SimpleMateria;

@Controller
public class MateriaController {	
	DocumentoDAO docdao = new DocumentoDAO();
	PadreDAO padredao = new PadreDAO();
	AlumnoDAO alumdao = new AlumnoDAO();
	DocenteDAO docentedoa = new DocenteDAO();
	AdminDAO admindao = new AdminDAO();
	NotaDAO notasdao = new NotaDAO();
	AsistenciaDAO asistenciadao = new AsistenciaDAO();
	AdministrativoDAO administdao = new AdministrativoDAO();
	Integer trimestreActual = Utils.TrimestreActual();
	Integer anioActual = Utils.AnioActual();
	SimpleMateriaDAO smateriadao = new SimpleMateriaDAO();
	
	@GetMapping("/usuario/{usuario}/role/{role}/materias/{materia}")
	public String initMateria(@PathVariable String usuario,@PathVariable String materia,
			Model model, @PathVariable("role") String role) 
			throws IOException {
		System.out.println("ENTRO");
		Alumno alumno = alumdao.retrieveByName(usuario.replaceAll("\\.", " "));
		List<Nota2> notas = notasdao.retrieveByUserMatter(usuario, materia, anioActual);
		//clasificar las notas por trimestre
			
		//obtener notas del timestre
		
		List<Asistencia2> faltas = asistenciadao.retrieveByUserMatter(usuario, materia,anioActual);
		//clasificar las faltas por trimestre
			//clasificar asistencia por presente,ausente, ausentejustificado
		if(!role.equals("PADRE")){
			List<Documento> documents = new ArrayList<>();
	    	if(documents != null)
	    		documents=docdao.retrieveByMateriaAnio(materia,anioActual);
	    	model.addAttribute("documents", documents);
		}
    	//model.addAttribute("materia", materia);
    	//model.addAttribute("role",role);
    	//model.addAttribute("usuario",usuario);
    	System.out.println("SALIO");
    	//return new ModelAndView("redirect:/home/documentos", model);
    	//return "redirect:/"+usuario+"/"+role+"/"+materia+"/informaciongeneral";
    	SimpleMateria smateria = smateriadao.retrieveByMatterForFilter(materia);
    	loadPageAlumno(model,smateria,usuario.replaceAll("\\.", " "));
    	return "home";
	}
	
	@PostMapping("/usuario/{usuario}/role/{role}/materias/{materia}")
	public String testHome(@PathVariable String usuario,@PathVariable String materia,
			Model model, @PathVariable("role") String role){
		System.out.println("entro al POST");
		SimpleMateria smateria = smateriadao.retrieveByMatterForFilter(materia);
		loadPageAlumno(model,smateria,usuario.replaceAll("\\.", " "));
		model.addAttribute("role", role);
		return "home";
	}
	
	
	@PostMapping("/usuario/{usuario}/role/{role}/alumno/{alumno}/materias/{materia}")
	public String testHomePadre(@PathVariable String usuario,@PathVariable String materia,
			Model model, @PathVariable("role") String role, @PathVariable String alumno){
		
		
		System.out.println("entro al POST PADRE");
		System.out.println("usuario (padre): "+ usuario);
		System.out.println("alumno: "+ alumno);
		SimpleMateria smateria = smateriadao.retrieveByMatterForFilter(materia);
		loadPagePadre(model,usuario.replaceAll("\\.", " "),smateria,alumno.replaceAll("\\.", " "));
		model.addAttribute("role", role);
		return "home";
	}
	
	
	
//    @GetMapping("/{usuario}/{role}/{materia}/informaciongeneral")
//    public String  provisioning(Model model,@PathVariable String usuario,@PathVariable String materia){
//    	loadPagePadreAlumno(model,materia,usuario.replaceAll("\\.", " "));
//        return "home";
//    }
    
	
//	@RequestMapping("/home22")
//	public String books(@RequestParam("role") String role,@RequestParam("usuario") String usuario, Model model){
//		if(role.equals("PADRE")){
//	    	Padre padre =padredao.retrieveByName(usuario);
//	    	List<SimpleAlumno> infoHijoMateria  = new ArrayList<SimpleAlumno>();
//	    	List<SimpleAlumnoFilter> estudent= new ArrayList<SimpleAlumnoFilter>();
//	    	for (String hijo : padre.getAlumno()) {
//	    		SimpleAlumnoFilter student = new SimpleAlumnoFilter(hijo);
//	    		estudent.add(student);
//				Alumno alumno = alumdao.retrieveByName(hijo);
//				//asociacionMAt
//				List<Materia.materia> mat= alumno.getCiclolectivo().getMaterias().getMateria();
//				for(Materia.materia mate :mat){
//					SimpleAlumno estudiante = new SimpleAlumno(alumno.getName(), mate.getName());
//					infoHijoMateria.add(estudiante);
//				}
//			}
//	    	model.addAttribute("hijoMateria", infoHijoMateria);
//	    	model.addAttribute("hijos", estudent);
//	    }else{ 
//	    	Alumno alumno = alumdao.retrieveByName(usuario);
//	    	List<Materia.materia> mat= alumno.getCiclolectivo().getMaterias().getMateria();
//	    	List<String> materias = new ArrayList<>();
//	    	for(Materia.materia mate :mat){
//	    		materias.add( mate.getName());
//	    	}
//	    	model.addAttribute("materias", materias);
//	    }
//		model.addAttribute("usuario", usuario);
//	    model.addAttribute("role", role);
//	    
//	    return "home";
//	}
	
	@PostMapping("home22/")
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
	
	@GetMapping( "home22/download/document/{docId}")
	public String downloadDocument(@PathVariable String docId, HttpServletResponse response) 
			throws IOException {
		Documento document = docdao.retrieveById(docId);
        response.setContentLength(document.getDocumento().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
        FileCopyUtils.copy(document.getDocumento(), response.getOutputStream());
 		return "home";
	}
	
	
//	private void loadPageAlumno(Model model, String materia) {
//		List<Documento> documentos = docdao.retrieveByMateria(materia);
//		model.addAttribute("documentos", documentos);
//	}
	
	private void loadPageAlumno(Model model, SimpleMateria materia, String alumnoName) {
		try {
		Alumno alumno = alumdao.retrieveByName(alumnoName);
		System.out.println("NOMBRE DE LA MATERIA: "+ materia);
		try {
			System.out.println("INFO DE LA MATERIA SIMPLE");
			System.out.println(materia.getCurso());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		List<Nota2> notas = notasdao.retrieveByAlumno(alumno.getId());
		List<Asistencia2> asistencias = asistenciadao.retrieveByAlumno(alumno.getId());
		Double promediotareas = promedio(notas,Nota.ACTIVIDADES);
		Double promediotp = promedio(notas,Nota.TRABAJO_PRACTICO);
		Double promedioev = promedio(notas,Nota.EVALUACION);
		Double promediotrimestre = promedio(notas,"trimestre");
		Integer asistenciaFaltas = promedioAsistencia(asistencias);
		Integer asistenciaPresente = promedioAsistencia(asistencias);
		
		model.addAttribute("smateria", materia);
		model.addAttribute("materia", materia.getMateria());
		model.addAttribute("promediotareas", promediotareas*10);
		model.addAttribute("promediotp", promediotp*10);
		model.addAttribute("promedioev", promedioev*10);
		model.addAttribute("promediotrimestre", promediotrimestre*10);
		model.addAttribute("usuario", alumnoName);
		model.addAttribute("notas", notas);
		model.addAttribute("asistencias", asistencias);
		model.addAttribute("asistenciaFaltas",asistenciaFaltas);
		model.addAttribute("asistenciaPresente",asistenciaPresente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	private void loadPagePadre(Model model,String padre, SimpleMateria materia, String alumnoName) {
		try {
		Alumno alumno = alumdao.retrieveByName(alumnoName);
		System.out.println("NOMBRE DE LA MATERIA: "+ materia+ "padre:" +padre);
		
		try {
			System.out.println("INFO DE LA MATERIA SIMPLE");
			System.out.println(materia.getCurso());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		List<Nota2> notas = notasdao.retrieveByAlumnoMateria(alumnoName,materia.getMateria(),anioActual);
		List<Asistencia2> asistencias = asistenciadao.retrieveByAlumno(alumno.getId());
		Double promediotareas = promedio(notas,Nota.ACTIVIDADES);
		Double promediotp = promedio(notas,Nota.TRABAJO_PRACTICO);
		Double promedioev = promedio(notas,Nota.EVALUACION);
		Double promediotrimestre = promedio(notas,"trimestre");
		List<Nota2> trimestreCerrado = notasdao.retrieveByAlumnoMateriaTrimestres(alumnoName,materia.getMateria(),anioActual);
		Integer asistenciaFaltas = promedioAsistencia(asistencias);
		Integer asistenciaPresente = promedioAsistencia(asistencias);
		
		if(trimestreCerrado!= null)
			model.addAttribute("trimestrecerrado", trimestreCerrado);
		model.addAttribute("smateria", materia);
		model.addAttribute("materia", materia.getMateria());
		model.addAttribute("promediotareas", promediotareas*10);
		model.addAttribute("promediotp", promediotp*10);
		model.addAttribute("promedioev", promedioev*10);
		model.addAttribute("promediotrimestre", promediotrimestre*10);
		model.addAttribute("usuario", padre);
		model.addAttribute("alumno", alumnoName);
		
		model.addAttribute("notas", notas);
		model.addAttribute("asistencias", asistencias);
		model.addAttribute("asistenciaFaltas",asistenciaFaltas);
		model.addAttribute("asistenciaPresente",asistenciaPresente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private Integer promedioAsistencia(List<Asistencia2> asistencia) {
		Integer asistenciaTotal = 0;
		if(asistencia!= null) {
			if(Asistencia.AUSENTE_JUSTIFICADO != null) {
				for(Asistencia2 asist : asistencia) {
					if(asist.getTipo().equals(Asistencia.AUSENTE) || asist.getTipo().equals(Asistencia.AUSENTE_JUSTIFICADO))
						asistenciaTotal+=1;
				}
			}else {
				for(Asistencia2 asist : asistencia) {
					if(asist.getTipo().equals(Asistencia.PRESENTE))
						asistenciaTotal+=1;
				}
			}
		}
		return asistenciaTotal;
	}

	private Double promedio(List<Nota2> notas, String tipo) {
		Double promedio = 0.0;
		Double total=0.0;
		Integer cantidad = 0;
		
		if (notas != null) {
			for(Nota2 nota : notas){
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
