package logico;

import java.util.ArrayList;

public class OfertaLaboral {
	private String codigo;
	private String puesto;
	private String descripcion;
	private String area;
	private String modalidad;
	private String jornada;
	private String estado;
	private float salario;
	private int experienciaMinima;
	private int vacantes;
	private CentroEmpleador ofertador;
	private boolean ofreceReubicacion;
	private boolean obligatorioMayorDeEdad;
	private String nivelAcademico;
	private ArrayList<String> requisitos;
	private ArrayList<String> idiomasRequeridas;
	
	public OfertaLaboral(String codigo, String puesto, String descripcion, String area,
			String modalidad, String jornada, String estado, float salario, int experienciaMinima, int vacantes,
			CentroEmpleador ofertador, boolean ofreceReubicacion, boolean mayorDeEdadObligatorio,
			String nivelAcademico, ArrayList<String> requisitos, ArrayList<String> idiomasRequeridas) {
		super();
		this.codigo = codigo;
		this.puesto = puesto;
		this.area = area;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.jornada = jornada;
		this.estado = estado;
		this.salario = salario;
		this.experienciaMinima = experienciaMinima;
		this.vacantes = vacantes;
		this.ofertador = ofertador;
		this.ofreceReubicacion = ofreceReubicacion;
		this.obligatorioMayorDeEdad = mayorDeEdadObligatorio;
		this.nivelAcademico = nivelAcademico;
		this.requisitos = requisitos;
		this.idiomasRequeridas = idiomasRequeridas;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public int getExperienciaMinima() {
		return experienciaMinima;
	}

	public void setExperienciaMinima(int experienciaMinima) {
		this.experienciaMinima = experienciaMinima;
	}

	public int getVacantes() {
		return vacantes;
	}

	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}

	public CentroEmpleador getOfertador() {
		return ofertador;
	}

	public void setOfertador(CentroEmpleador ofertador) {
		this.ofertador = ofertador;
	}

	public boolean isOfreceReubicacion() {
		return ofreceReubicacion;
	}

	public void setOfreceReubicacion(boolean ofreceReubicacion) {
		this.ofreceReubicacion = ofreceReubicacion;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public ArrayList<String> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(ArrayList<String> requisitos) {
		this.requisitos = requisitos;
	}

	public ArrayList<String> getIdiomasRequeridas() {
		return idiomasRequeridas;
	}

	public void setIdiomasRequeridas(ArrayList<String> idiomasRequeridas) {
		this.idiomasRequeridas = idiomasRequeridas;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public boolean isObligatorioMayorDeEdad() {
		return obligatorioMayorDeEdad;
	}

	public void setObligatorioMayorDeEdad(boolean obligatorioMayorDeEdad) {
		this.obligatorioMayorDeEdad = obligatorioMayorDeEdad;
	}

	public void agregarIdioma(String idioma) {
		idiomasRequeridas.add(idioma);
	}
	
	public void agregarRequisito(String requisito) {
		requisitos.add(requisito);
	}
	
}
