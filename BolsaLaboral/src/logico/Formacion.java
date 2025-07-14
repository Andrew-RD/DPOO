package logico;

import java.time.LocalDate;

public abstract class Formacion {

	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;
	private String institucion;
	
	public Formacion(LocalDate fechaInicio, LocalDate fechaFinalizacion, String institucion) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.institucion = institucion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

}
