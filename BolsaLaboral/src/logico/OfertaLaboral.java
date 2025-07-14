package logico;

import java.util.ArrayList;

public class OfertaLaboral {
	private String codigo;
	private String puesto;
	private ArrayList<String> requisitos;
	private String descripcion;
	private String nivelAcademico;
	private float salario;
	private CondicionLaboral condiciones;
	private String estado;
	private CentroEmpleador ofertador;

	public OfertaLaboral(String codigo, String puesto, ArrayList<String> requisitos, String descripcion,
			String nivelAcademico, float salario, CondicionLaboral condiciones, String estado,
			CentroEmpleador ofertador) {
		super();
		this.codigo = codigo;
		this.puesto = puesto;
		this.requisitos = new ArrayList<String>();
		this.descripcion = descripcion;
		this.nivelAcademico = nivelAcademico;
		this.salario = salario;
		this.condiciones = condiciones;
		this.estado = estado;
		this.ofertador = ofertador;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public ArrayList<String> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(ArrayList<String> requisitos) {
		this.requisitos = requisitos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public CondicionLaboral getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(CondicionLaboral condiciones) {
		this.condiciones = condiciones;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CentroEmpleador getOfertador() {
		return ofertador;
	}

	public void setOfertador(CentroEmpleador ofertador) {
		this.ofertador = ofertador;
	}

}
