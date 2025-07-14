package logico;

import java.util.ArrayList;

public class CentroEmpleador {
	private String codigo;
	private String nombre;
	private String sector;
	private String ciudad;
	private String direccion;
	private Representante representante;
	private ArrayList<OfertaLaboral> ofertasLaborales;

	public CentroEmpleador(String codigo, String nombre, String sector, String ciudad, String direccion, Representante representante) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.sector = sector;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.representante = representante;
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
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

	public ArrayList<OfertaLaboral> getOfertasLaborales() {
		return ofertasLaborales;
	}

	public void setOfertasLaborales(ArrayList<OfertaLaboral> ofertasLaborales) {
		this.ofertasLaborales = ofertasLaborales;
	}

}
