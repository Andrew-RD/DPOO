package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Universitario extends Candidato {
	private String universidad;
	private String carrera;
	private String nivelAcademico;
	
	public Universitario(String codigo, String identificacion, String nombres, String apellidos,
			LocalDate fechaNacimiento, String provincia, String municipio, String telefono, String correo,
			String jornada, String modalidad,String areaDeInteres ,float aspiracionSalarial, boolean licenciaConducir,
			boolean disposicionMudarse, ArrayList<String> idiomas, ArrayList<Solicitud> misSolicitudes,
			String universidad, String carrera, String nivelAcademico) {
		super(codigo, identificacion, nombres, apellidos, fechaNacimiento, provincia, municipio, telefono, correo,
				jornada, modalidad,areaDeInteres ,aspiracionSalarial, licenciaConducir, disposicionMudarse, idiomas, misSolicitudes);
		this.universidad = universidad;
		this.carrera = carrera;
		this.nivelAcademico = nivelAcademico;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}
}
