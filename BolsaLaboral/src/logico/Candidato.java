package logico;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Candidato{
	private String codigo;
	private String identificacion;
	private String nombres;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String genero;
	private String provincia;
	private String municipio;
	private String telefono;
	private String correo;
	private String jornada;
	private String modalidad;
	private String areaDeInteres;
	private float aspiracionSalarial;
	private boolean licenciaConducir;
	private boolean disposicionMudarse;
	private ArrayList<String> idiomas;
	private ArrayList<Solicitud> misSolicitudes;

	public Candidato(String codigo, String identificacion, String nombres, String apellidos, LocalDate fechaNacimiento,
			String genero, String provincia, String municipio, String telefono, String correo, String jornada,
			String modalidad, String areaDeInteres, float aspiracionSalarial, boolean licenciaConducir,
			boolean disposicionMudarse, ArrayList<String> idiomas) {
		super();
		this.codigo = codigo;
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.provincia = provincia;
		this.municipio = municipio;
		this.telefono = telefono;
		this.correo = correo;
		this.jornada = jornada;
		this.modalidad = modalidad;
		this.areaDeInteres = areaDeInteres;
		this.aspiracionSalarial = aspiracionSalarial;
		this.licenciaConducir = licenciaConducir;
		this.disposicionMudarse = disposicionMudarse;
		this.idiomas = idiomas;
		this.misSolicitudes =  new ArrayList<Solicitud> ();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public float getAspiracionSalarial() {
		return aspiracionSalarial;
	}

	public void setAspiracionSalarial(float aspiracionSalarial) {
		this.aspiracionSalarial = aspiracionSalarial;
	}

	public boolean isLicenciaConducir() {
		return licenciaConducir;
	}

	public void setLicenciaConducir(boolean licenciaConducir) {
		this.licenciaConducir = licenciaConducir;
	}

	public boolean isDisposicionMudarse() {
		return disposicionMudarse;
	}

	public void setDisposicionMudarse(boolean disposicionMudarse) {
		this.disposicionMudarse = disposicionMudarse;
	}

	public ArrayList<String> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}

	public ArrayList<Solicitud> getMisSolicitudes() {
		return misSolicitudes;
	}

	public void setMisSolicitudes(ArrayList<Solicitud> misSolicitudes) {
		this.misSolicitudes = misSolicitudes;
	}

	public String getAreaDeInteres() {
		return areaDeInteres;
	}

	public void setAreaDeInteres(String areaDeInteres) {
		this.areaDeInteres = areaDeInteres;
	}
	

	
	
}
