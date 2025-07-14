package logico;

public abstract class Persona {
	private String codigo;
	private String nombres;
	private String apellidos;
	private String identificacion;
	private String direccion;
	private String telefono;
	private String correo;
	
	public Persona(String codigo, String nombres, String apellidos, String identificacion, String direccion,
			String telefono, String correo) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

}
