package logico;

import java.time.LocalDate;

public abstract class Candidato{
	private String codigo;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private LocalDate fechaNacimiento;
	private String provincia;
	private String municio;
	private String telefono;
	private String correo;
	private boolean estaTrabajando;
	private boolean licenciaConducir;
	private boolean disposicionMudarse;
	private CondicionLaboral preferencia;
	
	public Candidato(String codigo, String nombres, String apellidos, String identificacion, LocalDate fechaNacimiento,
			String provincia, String municio, String telefono, String correo, boolean estaTrabajando,
			boolean licenciaConducir, boolean disposicionMudarse, CondicionLaboral preferencia) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
		this.municio = municio;
		this.telefono = telefono;
		this.correo = correo;
		this.estaTrabajando = estaTrabajando;
		this.licenciaConducir = licenciaConducir;
		this.disposicionMudarse = disposicionMudarse;
		this.preferencia = preferencia;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getMunicio() {
		return municio;
	}
	public void setMunicio(String municio) {
		this.municio = municio;
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
	public boolean isEstaTrabajando() {
		return estaTrabajando;
	}
	public void setEstaTrabajando(boolean estaTrabajando) {
		this.estaTrabajando = estaTrabajando;
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
	public CondicionLaboral getPreferencia() {
		return preferencia;
	}
	public void setPreferencia(CondicionLaboral preferencia) {
		this.preferencia = preferencia;
	}
	
}
