package logico;

import java.time.LocalDate;

public class FormacionAcademica extends Formacion{
	private String titulo;
	private String tipo;
	
	public FormacionAcademica(LocalDate fechaInicio, LocalDate fechaFinalizacion, String institucion, String titulo,
			String tipo) {
		super(fechaInicio, fechaFinalizacion, institucion);
		this.titulo = titulo;
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



}
