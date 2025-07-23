package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class TecnicoSuperior extends Candidato {
	private String areaTecnica;
	private int aniosExperiencia;
	
	
	public TecnicoSuperior(String codigo, String identificacion, String nombres, String apellidos,
			LocalDate fechaNacimiento, String genero, String provincia, String municipio, String telefono,
			String correo, String jornada, String modalidad, String areaDeInteres, float aspiracionSalarial,
			boolean licenciaConducir, boolean disposicionMudarse, ArrayList<String> idiomas, String areaTecnica, int aniosExperiencia) {
		super(codigo, identificacion, nombres, apellidos, fechaNacimiento, genero, provincia, municipio, telefono,
				correo, jornada, modalidad, areaDeInteres, aspiracionSalarial, licenciaConducir, disposicionMudarse,
				idiomas);
		this.areaTecnica = areaTecnica;
		this.aniosExperiencia = aniosExperiencia;
	}
	public String getAreaTecnica() {
		return areaTecnica;
	}
	public void setAreaTecnica(String areaTecnica) {
		this.areaTecnica = areaTecnica;
	}
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
}
