package logico;

import java.util.ArrayList;

import exception.NotRemovableException;

public class BolsaLaboral {
	
	public static int genCodigoCandidato = 1;
	public static int genCodigoSolicitud = 1;
	public static int genCodigoOferta = 1;
	public static int genCodigoCentro = 1;
	public static int genCodigoVacanteCompletada = 1;
	private ArrayList<Candidato> candidatos;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<OfertaLaboral> ofertas;
	private ArrayList<CentroEmpleador> centros;
	private ArrayList<VacanteCompletada> vacantes;
	public static BolsaLaboral instancia;

	private BolsaLaboral() {
		candidatos = new ArrayList<Candidato>();
		solicitudes = new ArrayList<Solicitud>();
		ofertas = new ArrayList<OfertaLaboral>();
		centros = new ArrayList<CentroEmpleador>();
		vacantes = new ArrayList<VacanteCompletada>();
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public ArrayList<OfertaLaboral> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<OfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}

	public ArrayList<CentroEmpleador> getCentros() {
		return centros;
	}

	public void setCentros(ArrayList<CentroEmpleador> centros) {
		this.centros = centros;
	}
	

	public ArrayList<VacanteCompletada> getVacantes() {
		return vacantes;
	}

	public void setVacantes(ArrayList<VacanteCompletada> vacantes) {
		this.vacantes = vacantes;
	}

	public static BolsaLaboral getInstancia() {
		if(instancia == null) {
			instancia = new BolsaLaboral();
		}
		return instancia;
	}
	
	public void registrarCentroTrabajo(CentroEmpleador nuevoCentro) {
		centros.add(nuevoCentro);
		genCodigoCentro++;
	}
	
	public int buscarIndiceCentroByCodigo(String codigo) {
		int indice = 0;
		boolean encontrado = false;
		
		while(encontrado == false && indice < centros.size()) {
			if(centros.get(indice).getCodigo().equalsIgnoreCase(codigo)) {
				encontrado = true;
			}
			else {
				indice++;
			}
		}
		
		return encontrado ? indice : -1;
	}
	
	public boolean modificarCentroTrabajo(CentroEmpleador centroModificar) {
		int indice = buscarIndiceCentroByCodigo(centroModificar.getCodigo());
		if(indice != -1) {
			centros.set(indice,centroModificar);
			return true;
		}
		return false;
	}
	
	public void eliminarCentroTrabajo(CentroEmpleador centroEliminar) throws NotRemovableException{
		if(centroEliminable(centroEliminar)) {
			centros.remove(centroEliminar);
		}
		else {
			throw new NotRemovableException("El centro de trabajo no puede ser eliminado ya que posee ofertas existentes.");
		}
	}
	
	public void registrarCandidato(Candidato nuevoCandidato) {
		candidatos.add(nuevoCandidato);
		genCodigoCandidato++;
	}
	
	public void eliminarCandidato(Candidato candidatoEliminar) throws NotRemovableException{
		if(candidatoEliminable(candidatoEliminar)) {
			candidatos.remove(candidatoEliminar);
		}
		else {
			throw new NotRemovableException("El candidato no puede ser eliminado ya que esta vinculado con una solicitud.");
		}
	}
	
	public Candidato buscarCandidatoByCodigo(String codigo) {
		Candidato encontrado = null;
		int indice = 0;
		while(encontrado == null && indice < candidatos.size()) {
			if(candidatos.get(indice).getCodigo().equals(codigo)) {
				encontrado = candidatos.get(indice);
			}
			indice++;
		}
		return encontrado;
	}
	
	public CentroEmpleador buscarCentroByCodigo(String codigo) {
		CentroEmpleador encontrado = null;
		int indice = 0;
		while(encontrado == null && indice < centros.size()) {
			if(centros.get(indice).getCodigo().equals(codigo)) {
				encontrado = centros.get(indice);
			}
			indice++;
		}
		return encontrado;
	}

	
	public boolean centroEliminable(CentroEmpleador centro) {
		return true;
	}
	
	public boolean candidatoEliminable(Candidato candidato) {
		return true;
	}
	
	private boolean ofertaEliminable(OfertaLaboral seleccionado) {
		return false;
	}
	
	public void matcheoPosiblesContrataciones (){
		for(OfertaLaboral oferta : ofertas) {
			int cantMatch = 0;
			for(Solicitud sld : solicitudes) {
				
			}
		}
	}

	public OfertaLaboral buscarOfertaByCodigo(String codigo) {
		OfertaLaboral encontrado = null;
		int indice = 0;
		while(encontrado == null && indice < ofertas.size()) {
			if(ofertas.get(indice).getCodigo().equals(codigo)) {
				encontrado = ofertas.get(indice);
			}
			indice++;
		}
		return encontrado;
	}

	public void eliminarOfertaTrabajo(OfertaLaboral seleccionado) throws NotRemovableException{
		if(ofertaEliminable(seleccionado)) {
			ofertas.remove(seleccionado);
		}
		else {
			throw new NotRemovableException("La oferta no es eliminable ya que esta vinculada con una solicitud.");
		}
	}



}
