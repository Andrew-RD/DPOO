package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class TecnicoSuperior extends Candidato {
	private String areaTecnica;
	private int aniosExperiencia;
	
	public TecnicoSuperior(String codigo, String identificacion, String nombres, String apellidos,
			LocalDate fechaNacimiento, String provincia, String municipio, String telefono, String correo,
			String jornada, String modalidad, float aspiracionSalarial, boolean licenciaConducir,
			boolean disposicionMudarse, ArrayList<String> idiomas, ArrayList<Solicitud> misSolicitudes,
			String areaTecnica, int aniosExperiencia) {
		super(codigo, identificacion, nombres, apellidos, fechaNacimiento, provincia, municipio, telefono, correo,
				jornada, modalidad, aspiracionSalarial, licenciaConducir, disposicionMudarse, idiomas, misSolicitudes);
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
