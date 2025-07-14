package logico;

import java.time.LocalDate;

public class FormacionLaboral extends Formacion{
	private String puesto;
	private String sector;
	
	public FormacionLaboral(LocalDate fechaInicio, LocalDate fechaFinalizacion, String institucion, String puesto,
			String sector) {
		super(fechaInicio, fechaFinalizacion, institucion);
		this.puesto = puesto;
		this.sector = sector;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

}
