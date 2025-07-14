package logico;

public class Representante extends Persona{

	private String cargo;

	public Representante(String codigo, String nombres, String apellidos, String identificacion, String direccion,
			String telefono, String correo, String cargo) {
		super(codigo, nombres, apellidos, identificacion, direccion, telefono, correo);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
