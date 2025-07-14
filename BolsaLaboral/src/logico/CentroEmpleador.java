package logico;

import java.util.ArrayList;

public class CentroEmpleador {
	private String codigo;
	private String nombre;
	private String sector;
	private String provincia;
	private String municipio;
	private String telefono;
	private String correo;
	private ArrayList<OfertaLaboral> ofertasLaborales;

	public CentroEmpleador(String codigo, String nombre, String sector, String ciudad, String direccion, String telefono, String correo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.sector = sector;
		this.provincia = ciudad;
		this.municipio = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.ofertasLaborales = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCiudad() {
		return provincia;
	}

	public void setCiudad(String ciudad) {
		this.provincia = ciudad;
	}

	public String getDireccion() {
		return municipio;
	}

	public void setDireccion(String direccion) {
		this.municipio = direccion;
	}

	public ArrayList<OfertaLaboral> getOfertasLaborales() {
		return ofertasLaborales;
	}

	public void setOfertasLaborales(ArrayList<OfertaLaboral> ofertasLaborales) {
		this.ofertasLaborales = ofertasLaborales;
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
