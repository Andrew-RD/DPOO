package logico;

import java.util.ArrayList;

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
	public void matcheoPosiblesContrataciones (){
		for(OfertaLaboral oferta : ofertas) {
			int cantMatch = 0;
			for(Solicitud sld : solicitudes) {
				
			}
		}
	}

}
