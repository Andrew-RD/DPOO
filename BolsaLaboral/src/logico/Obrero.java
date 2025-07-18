package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public class Obrero extends Candidato {
	private ArrayList <String> habilidades;

	public Obrero(String codigo, String identificacion, String nombres, String apellidos, LocalDate fechaNacimiento,
			String provincia, String municipio, String telefono, String correo, String jornada, String modalidad, String AreaDeInteres,
			float aspiracionSalarial, boolean licenciaConducir, boolean disposicionMudarse, ArrayList<String> idiomas,
			ArrayList<Solicitud> misSolicitudes, ArrayList<String> habilidades) {
		super(codigo, identificacion, nombres, apellidos, fechaNacimiento, provincia, municipio, telefono, correo,
				jornada, modalidad,AreaDeInteres, aspiracionSalarial, licenciaConducir, disposicionMudarse, idiomas, misSolicitudes);
		this.habilidades = habilidades;
	}

	public ArrayList<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<String> habilidades) {
		this.habilidades = habilidades;
	}

}
