package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import exception.NotRemovableException;

public class BolsaLaboral implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
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
	private ArrayList<Usuario> usuarios; 
	public static BolsaLaboral instancia;
	private Usuario usuarioActual;

	private BolsaLaboral() {
		candidatos = new ArrayList<Candidato>();
		solicitudes = new ArrayList<Solicitud>();
		ofertas = new ArrayList<OfertaLaboral>();
		centros = new ArrayList<CentroEmpleador>();
		vacantes = new ArrayList<VacanteCompletada>();
		usuarios = new ArrayList<Usuario>();
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
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(Usuario usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	public static BolsaLaboral getInstancia() {
		if(instancia == null) {
			instancia = new BolsaLaboral();
		}
		return instancia;
	}
	
	public static void setInstancia(BolsaLaboral bolsa) {
		instancia = bolsa;
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
	
	public ArrayList<ResultadoMatcheo> obtenerCandidatosOrdenadosParaOferta(OfertaLaboral oferta) {
	    ArrayList<ResultadoMatcheo> ordenados = new ArrayList<>();

	    for (Candidato candidato : candidatos) {
	        int puntaje = calcularPuntaje(candidato, oferta);
	        
	        if (puntaje >= 50) {
	            String condicion;
	            if (puntaje < 70) {
	                condicion = "No recomendado";
	            } else if (puntaje < 80) {
	                condicion = "Aceptable";
	            } else {
	                condicion = "Recomendado";
	            }

	            ResultadoMatcheo resultadoMatcheo = new ResultadoMatcheo(oferta, candidato, puntaje, condicion);

	            int i = 0;
	            while (i < ordenados.size() && ordenados.get(i).getPorcentaje() >= puntaje) {
	                i++;
	            }
	            ordenados.add(i, resultadoMatcheo);
	        }
	    }

	    return ordenados;
	}

	
	private int calcularPuntaje(Candidato candidato, OfertaLaboral oferta) {
	    int puntaje = 0;
	    
	    if (candidato.getModalidad().equalsIgnoreCase(oferta.getModalidad())) {
	        puntaje += 15;
	    }
	    
	    if (candidato.getJornada().equalsIgnoreCase(oferta.getJornada())) {
	        puntaje += 15;
	    }
	    
	    if (candidato.getAreaDeInteres().equalsIgnoreCase(oferta.getArea())) {
	        puntaje += 20;
	    }
	    
	    if (candidato.getProvincia().equalsIgnoreCase(oferta.getOfertador().getProvincia())) {
	        puntaje += 15;
	    } else if (candidato.isDisposicionMudarse()) {
	        puntaje += 8;
	    }
	    
	    if (candidato.getAspiracionSalarial() <= oferta.getSalario()) {
	        puntaje += 10;
	    }
	    
	    int idiomasPuntos = 0;
	    for (String idioma : oferta.getIdiomasRequeridas()) {
	        if (candidato.getIdiomas().contains(idioma)) {
	            idiomasPuntos += 2;
	        }
	    }
	    puntaje += Math.min(10, idiomasPuntos);
	    
	    if (candidato instanceof Universitario && oferta.getNivelAcademico().equalsIgnoreCase("Estudiante Universitario")) {
	    	puntaje += 15;
	    } else if (candidato instanceof TecnicoSuperior && oferta.getNivelAcademico().equalsIgnoreCase("Estudiante Tecnico")) {
	        TecnicoSuperior t = (TecnicoSuperior) candidato;
	        if (t.getAniosExperiencia() >= oferta.getExperienciaMinima()) {
	            puntaje += 15;
	        }
	    } else if (candidato instanceof Obrero && oferta.getNivelAcademico().equalsIgnoreCase("Obrero")) {
	        Obrero o = (Obrero) candidato;
	        int habilidadPuntos = 0;
	        for (String habilidad : oferta.getRequisitos()) {
	            if (o.getHabilidades().contains(habilidad)) {
	                habilidadPuntos += 5;
	            }
	        }
	        puntaje+= Math.min(15, habilidadPuntos);
	    }
	    
	    return puntaje;
	}

	public void eliminarOfertaTrabajo(OfertaLaboral seleccionado) throws NotRemovableException{
		if(ofertaEliminable(seleccionado)) {
			ofertas.remove(seleccionado);
		}
		else {
			throw new NotRemovableException("La oferta no es eliminable ya que esta vinculada con una solicitud.");
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
	
	public int buscarIndiceOfertaByCodigo(String codigo) {
		int indice = 0;
		boolean encontrado = false;
		
		while(encontrado == false && indice < ofertas.size()) {
			if(ofertas.get(indice).getCodigo().equalsIgnoreCase(codigo)) {
				encontrado = true;
			}
			else {
				indice++;
			}
		}
		
		return encontrado ? indice : -1;
	}
	
	public void registrarOfertaLaboral(OfertaLaboral nuevaOferta) {
		ofertas.add(nuevaOferta);
		genCodigoOferta++;
	}
	
	public boolean modificarOfertaLaboral(OfertaLaboral ofertaModificar) {
		int indice = buscarIndiceOfertaByCodigo(ofertaModificar.getCodigo());
		if(indice != -1) {
			ofertas.set(indice,ofertaModificar);
			return true;
		}
		return false;
	}

	public boolean ofertaVinculada(OfertaLaboral oferta) {
		boolean aux = false;
		for(Solicitud solicitud : solicitudes) {
			if(solicitud.getOfertaSolicitada().getCodigo().equals(oferta.getCodigo())) {
				aux = true;
			}
		}
		return aux;
	}
	
	public void regVacanteCompletada(Solicitud solicitudContratada) {
	    solicitudContratada.setEstado("Empleado");
	    OfertaLaboral oferta = solicitudContratada.getOfertaSolicitada();
	    oferta.setVacantes(oferta.getVacantes() - 1);
	    if (oferta.getVacantes() <= 0) {
	        oferta.setEstado("Inactiva");
	    }
	  
	    Candidato candidatoContratado = solicitudContratada.getSolicitante();
	    candidatoContratado.cambiarEstadoSolicitudesAEmpleado();
	    
	    String codigoVacante = "VAC-" + genCodigoVacanteCompletada;
	    VacanteCompletada nuevaVacante = new VacanteCompletada(
	            codigoVacante, 
	            solicitudContratada, 
	            oferta,
	            LocalDate.now()
	    );
	    
	    vacantes.add(nuevaVacante);
	    genCodigoVacanteCompletada++;
	}
	
	public void regUsuario(Usuario user) {
		usuarios.add(user);
	}

	public Usuario login(String nombre, String clave) {
		Usuario aux = null;
		for(Usuario user : usuarios) {
			if(user.match(nombre, clave)) {
				aux = user;
			}
		}
		return aux;
	}
	
	public boolean centroEliminable(CentroEmpleador centro) {
		if(centro.getOfertasLaborales().size() != 0) {
			return false;
		}
		return true;
	}
	
	public boolean candidatoEliminable(Candidato candidato) {
		if(candidato.getMisSolicitudes().size() != 0) {
			return false;
		}
		return true;
	}
	
	private boolean ofertaEliminable(OfertaLaboral seleccionado) {
		return false;
	}
	

}
