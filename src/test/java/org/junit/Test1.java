package org.junit;

import java.util.Date;
import java.util.List;

//import org.junit.jupiter.api.Test;

import com.lgg.nticxs.web.DAO.AlumnoDAO;
import com.lgg.nticxs.web.DAO.DocenteDAO;
import com.lgg.nticxs.web.DAO.DocumentoDAO;
import com.lgg.nticxs.web.model.Alumno;
import com.lgg.nticxs.web.model.Asistencia;
import com.lgg.nticxs.web.model.Docente;
import com.lgg.nticxs.web.model.Documento;
import com.lgg.nticxs.web.model.Nota;

public class Test1 {

//	@Test
//	public void createAlumno(){
//		AlumnoDAO alumdao = new AlumnoDAO();
//		Alumno alumno = new Alumno();
//		alumno.setName("pablo");
//		alumdao.create(alumno);
//		System.out.println("termino");
//	}
	
//	@Test
//	public void createDocente(){
//		DocenteDAO docentedao= new DocenteDAO();
//		Docente docente = new Docente();
//		docente.setCurso("4");
//		docente.setDelete(false);
//		docente.setMateria("NTICXs");
//		docente.setName("Leandro Guzman");
//		docente.setPassword("leandro".getBytes());
//		docentedao.create(docente);
//		System.out.println("termino");
//	}
//	@Test
//	public void retrieveDocuments() {
//		DocumentoDAO docdao = new DocumentoDAO();
//		List<Documento> document = docdao.retrieveByMateria("nticxs");
//		System.out.println("lista de documentos: " +document.size());
//	}
	
//	@Test
//	public void retrieveDocuments() {
//		AlumnoDAO alumdao = new AlumnoDAO();
//		Alumno alumno = alumdao.retrieveByName("raro");
//		Nota nota = new Nota();
//		nota.setDescripcion("actividad de clase");
//		nota.setTipo(Nota.ACTIVIDADES);
//		nota.setFecha(new Date());
//		nota.setValor(10);
//		nota.setTrimestre(Nota.PRIMER_TRIMESTRE);
//		nota.setMateria("nticxs");
//		alumno.getNotas().add(nota);
//		alumdao.update(alumno);	
//		}
	@Test
	public void updateAsistencia() {
		AlumnoDAO alumdao = new AlumnoDAO();
		Alumno alumno = alumdao.retrieveByName("raro");
		Asistencia asistencia = new Asistencia();
		asistencia.setDescripcion("");
		asistencia.setFecha(new Date());
		asistencia.setMateria("nticxs");
		asistencia.setTipo(Asistencia.PRSENTE);
		alumno.getAsistencia().add(asistencia);
		alumdao.update(alumno);
	}
	
}
