package logico;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JOptionPane;

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
	    	if(candidato.getEstado().equals("Desempleado")) {
		        int puntaje = calcularPuntaje(candidato, oferta);
		        
		        if (puntaje >= oferta.getPorcentajeMinimo()) {
		            String condicion = obtenerCondicion(puntaje, oferta.getPorcentajeMinimo());

		            ResultadoMatcheo resultadoMatcheo = new ResultadoMatcheo(oferta, candidato, puntaje, condicion);

		            ordenados.add(resultadoMatcheo);
		        }
	    	}
	    }
	    
	    Comparator<ResultadoMatcheo> c = (a, b) -> b.getPorcentaje() - a.getPorcentaje();
	    
	    ordenados.sort(c);

	    return ordenados;
	}

	
	private int calcularPuntaje(Candidato candidato, OfertaLaboral oferta) {
	    int puntaje = 0;
	    
	    if (candidato.getModalidad().equalsIgnoreCase(oferta.getModalidad())) {
	        puntaje += 10;
	    }
	    
	    if (candidato.getJornada().equalsIgnoreCase(oferta.getJornada())) {
	        puntaje += 10;
	    }
	    
	    if (candidato.getAreaDeInteres().equalsIgnoreCase(oferta.getArea())) {
	        puntaje += 20;
	    }
	    
	    if (candidato.getProvincia().equalsIgnoreCase(oferta.getOfertador().getProvincia())) {
	        puntaje += 10;
	    } else if (candidato.isDisposicionMudarse() || oferta.isOfreceReubicacion()) {
	        puntaje += 5;
	    }
	    
	    if (candidato.getAspiracionSalarial() <= oferta.getSalario()) {
	        puntaje += 10;
	    } else {
	        float exceso = candidato.getAspiracionSalarial() - oferta.getSalario();
	        float porcentajeExceso = exceso / oferta.getSalario();

	        if (porcentajeExceso <= 0.35f) {
	            puntaje += Math.round(10 * (1 - porcentajeExceso / 0.35f));
	        }
	    }
	    
	    int idiomasRequeridos = oferta.getCantIdiomas();
	    int idiomasPuntos = 0;
	    for (String idioma : oferta.getIdiomasRequeridas()) {
	        if (candidato.getIdiomas().contains(idioma)) {
	            idiomasPuntos++;
	        }
	    }
	    
	    puntaje += Math.min(10, (idiomasPuntos*10)/Math.max(1, idiomasRequeridos));
	    
	    if (candidato instanceof Universitario && oferta.getNivelAcademico().equalsIgnoreCase("Estudiante Universitario")) {
	    	Universitario u = (Universitario) candidato;
	    	puntaje += 5;
	    	if(u.getCarrera().equals(oferta.getRequisitos().get(0))) {
	    		puntaje += 15;
	    	}
	    } else if (candidato instanceof TecnicoSuperior && oferta.getNivelAcademico().equalsIgnoreCase("Estudiante Tecnico")) {
	        TecnicoSuperior t = (TecnicoSuperior) candidato;
	        puntaje += 5;
	        if(t.getAreaTecnica().equals(oferta.getRequisitos().get(0))) {
	        	puntaje += 10;
	        }
	        if (t.getAniosExperiencia() >= oferta.getExperienciaMinima()) {
	            puntaje += 5;
	        }
	    } else if (candidato instanceof Obrero && oferta.getNivelAcademico().equalsIgnoreCase("Obrero")) {
	        Obrero o = (Obrero) candidato;
	        puntaje += 10;
	        int habilidadPuntos = 0;
	        int habilidadesRequeridas = oferta.getCantRequisitos();
	        for (String habilidad : oferta.getRequisitos()) {
	            if (o.getHabilidades().contains(habilidad)) {
	                habilidadPuntos++;
	            }
	        }
	        puntaje+= Math.min(10, (habilidadPuntos*10)/Math.max(1, habilidadesRequeridas));
	    }
	    
	    if (oferta.isobligatorioLicencia()) {
	        if (candidato.isLicenciaConducir()) {
	            puntaje += 5;
	        } else {
	            puntaje -= 20;
	        }
	    } else if (candidato.isLicenciaConducir()) {
	        puntaje += 2;
	    }
	    
	    if(oferta.isObligatorioMayorDeEdad()) {
	    	if(candidato.getEdad() >= 18) {
	    		puntaje += 5;
	    	} else {
	    		puntaje -= 25;
	    	}
	    } else {
	    	puntaje += 5;
	    }
	    
	    return Math.max(0, puntaje);
	}

	public void eliminarOfertaTrabajo(OfertaLaboral seleccionado) throws NotRemovableException{
		if(ofertaEliminable(seleccionado)) {
			seleccionado.getOfertador().getOfertasLaborales().remove(seleccionado);
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
		nuevaOferta.getOfertador().getOfertasLaborales().add(nuevaOferta);
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
	    VacanteCompletada nuevaVacante = new VacanteCompletada(codigoVacante, solicitudContratada, oferta,LocalDate.now());
	    
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
		boolean aux = true;
		for(Solicitud sol : solicitudes) {
			if(sol.getOfertaSolicitada().equals(seleccionado)) {
				aux = false;
			}
		}
		return aux;
	}
	
	public ArrayList<OfertaLaboral> ofertasDisponibles(){
		ArrayList<OfertaLaboral> ofertasDisponibles = new ArrayList<>();
		for(OfertaLaboral ofr: ofertas) {
			if(ofr.getVacantes() > 0) {
				ofertasDisponibles.add(ofr);
			}
		}
		return ofertasDisponibles;
	}
	
	public ArrayList<ResultadoMatcheo> procesamientoAvanzando(){
		ArrayList<ResultadoMatcheo> resultados = new ArrayList<>();
		for(OfertaLaboral ofr : ofertas) {
			if(ofr.getVacantes() > 0) {
				resultados.addAll(obtenerCandidatosOrdenadosParaOferta(ofr));
			}
		}
		
		return resultados;
	}
	
	public String obtenerCondicion(int puntaje, int limitePuntaje) {
	    double noRecomendadoMax = Math.max(Math.min(limitePuntaje * 1.3, 65), 50);
	    double aceptableMax = Math.max(Math.min(limitePuntaje * 1.6, 85), 65);

	    if (puntaje < noRecomendadoMax) {
	        return "No recomendado";
	    } else if (puntaje < aceptableMax) {
	        return "Aceptable";
	    } 
	    return "Recomendado";
	}
	
	public ResultadoMatcheo buscarResultado(ArrayList<ResultadoMatcheo> resultados, String codigoOferta, String codigoCandidato) {
		ResultadoMatcheo resultado = null;
		
		int indice = 0;
		while(indice < resultados.size() && resultado == null) {
			if(resultados.get(indice).getOferta().getCodigo().equals(codigoOferta) && resultados.get(indice).getSolicitante().getCodigo().equals(codigoCandidato)) {
				resultado = resultados.get(indice);
			}
			else {
				indice++;
			}
		}
		return resultado;
	}

	public boolean vincularOferta(ResultadoMatcheo resMatchSelec) {
		boolean aux = false;
		if(resMatchSelec.getOferta().getVacantes() > 0) {
			Solicitud sol = new Solicitud("SOL-" + genCodigoSolicitud, LocalDate.now(),"Enviada",resMatchSelec.getSolicitante(),resMatchSelec.getOferta());
			if(verificarSolicitud(sol)) {
				solicitudes.add(sol);
				resMatchSelec.getSolicitante().addSolicitud(sol);
				resMatchSelec.getSolicitante().setEstado("En Espera");
				genCodigoSolicitud++;
				aux = true;
			}
		}
		return aux;
	}
	
	public boolean verificarSolicitud(Solicitud solicitud) {
		boolean aux = true;
		
		for(Solicitud sol : solicitudes) {
			if(matchSolicitud(sol, solicitud)) {
				aux = false;
			}
		}
		
		return aux;
	}
	
	public boolean matchSolicitud(Solicitud s1, Solicitud s2) {
		boolean aux = true;
		
		aux &= s1.getFechaSolicitud().equals(s2.getFechaSolicitud());
		aux &= s1.getEstado().equals(s2.getEstado());
		aux &= s1.getSolicitante().equals(s2.getSolicitante());
		aux &= s1.getOfertaSolicitada().equals(s2.getOfertaSolicitada());
		
		return aux;
	}
	
	public void contratarCandidato(Solicitud solicitud) {
		VacanteCompletada vacante = new VacanteCompletada("VAC-" + genCodigoVacanteCompletada,solicitud,solicitud.getOfertaSolicitada(),LocalDate.now());
		solicitud.setEstado("Aprovada");
		solicitud.getOfertaSolicitada().setVacantes(solicitud.getOfertaSolicitada().getVacantes() - 1);
		solicitud.getSolicitante().setEstado("Empleado");
		solicitud.getSolicitante().cambiarEstadoSolicitudesAEmpleado();
		
		if(solicitud.getOfertaSolicitada().getVacantes() == 0) {
			solicitud.getOfertaSolicitada().setEstado("Completada");
		}
		genCodigoVacanteCompletada++;
		vacantes.add(vacante);
	}
	
	public void rechazarCandidato(Solicitud solicitud) {
		solicitud.setEstado("Rechazada");
		solicitud.getSolicitante().setEstado("Desempleado");
		solicitud.getSolicitante().cambiarEstadoSolicitudesADesempleado();
	}

	public Solicitud buscarSolicitudByCodigo(String codigo) {
		Solicitud encontrado = null;
		int indice = 0;
		while(encontrado == null && indice < solicitudes.size()) {
			if(solicitudes.get(indice).getCodigo().equals(codigo)) {
				encontrado = solicitudes.get(indice);
			}
			indice++;
		}
		return encontrado;
	}

	public boolean esProcesable(Solicitud seleccionado) {
		if(seleccionado.getEstado().equals("Rechazada") || seleccionado.getEstado().equals("Aprovada")) {
			return false;
		}
		return true;
	}
	
	public ArrayList<Solicitud> obtenerSolicitudesVinculadas(OfertaLaboral oferta){
		ArrayList<Solicitud> solicitudesV = new ArrayList<Solicitud>();
		for(Solicitud sol : solicitudes) {
			if(sol.getOfertaSolicitada().getCodigo().equals(oferta.getCodigo())) {
				solicitudesV.add(sol);
			}
		}
			
		return solicitudesV;
	}
	
	public int calcularTasaCovertura() {
		int cantVacantes = 0;
		for(OfertaLaboral ofr : ofertas) {
			cantVacantes += ofr.getVacantes();
		}
		
		if(ofertas.size() > 0) {
			return Math.round(((float)cantVacantes / (float)ofertas.size()) * 100);
		}
		else {
			return 0;
		}
	}
	
	
	public int obtenerOfertasVacias() {
		int cantidad = 0;
		for(OfertaLaboral ofr: ofertas) {
			boolean encontrado = false;
			
			int indice = 0;
			while(indice < solicitudes.size() && encontrado == false) {	
				if(solicitudes.get(indice).getOfertaSolicitada().equals(ofr)) {
					encontrado = true;
				}
				else {
					indice++;
				}
			}
			
			if(encontrado == false) {
				cantidad++;
			}
		}
		
		return cantidad;
	}
}
