package logico;

public class CondicionLaboral {
	private String jornada;
	private String modalidad;

	public CondicionLaboral(String jornada, String modalidad) {
		super();
		this.jornada = jornada;
		this.modalidad = modalidad;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

}
