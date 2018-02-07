package com.lgg.nticxs.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

import com.lgg.nticxs.web.DAO.AlumnoDAO;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Padre{

	@Id
	@GeneratedValue
	@Field(name = "_id")
	private String id;
	
	@Field (name = "name")
	private String name;
	
	@Field (name = "password")
	private byte[] password;
	
	@Field (name = "historyPassword")
	private List<byte[]> historyPassword;
	
	@Field (name = "delete")
	private Boolean delete;

	@Field (name = "role")
	private String role;
	
	@ElementCollection
	@Field(name="alumno")
	private List<String> alumno;
	
	
	public Padre(){
	}
	
	public Padre(ArrayList<String> alumnos){
		AlumnoDAO alumnodao = new AlumnoDAO();
		for(String alum: alumnos){
			Alumno estudiante = alumnodao.retrieveByName(alum);
			if(estudiante != null)
				alumno.add(estudiante.getName());
		}
	}

	public List<String> getAlumno() {
		return alumno;
	}

	public void setAlumno(List<String> alumno) {
		this.alumno = alumno;
	}
	
}
