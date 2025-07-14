package logico;

import java.util.ArrayList;

public class Candidato extends Persona{
	private String profesion;
	private int aniosExperiencia;
	private String estadoLaboral;
	private ArrayList<Formacion> formacion;
	
	public Candidato(String codigo, String nombres, String apellidos, String identificacion, String direccion,
			String telefono, String correo, String profesion, int aniosExperiencia, String estadoLaboral) {
		super(codigo, nombres, apellidos, identificacion, direccion, telefono, correo);
		this.profesion = profesion;
		this.aniosExperiencia = aniosExperiencia;
		this.estadoLaboral = estadoLaboral;
		this.formacion = new ArrayList<>();
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getEstadoLaboral() {
		return estadoLaboral;
	}

	public void setEstadoLaboral(String estadoLaboral) {
		this.estadoLaboral = estadoLaboral;
	}

	public ArrayList<Formacion> getFormacion() {
		return formacion;
	}

	public void setFormacion(ArrayList<Formacion> formacion) {
		this.formacion = formacion;
	}

}
