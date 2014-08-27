package CapaLogica;

public class Medicina {
	private String nombre;
	private String dosis;
	private String numDias;
	private String idConsulta;
	private String fechaInicio;
	private String fechaFinal;
	private String precauciones;
	private Consulta consul;
	/**
	 *
	 *
	 */	
	public Medicina(String pnombre, String pdosis, String pnumDias, String pidConsulta, String pfechaInicio, String pfechaFinal,
			String pprecauciones){
		setNombre(pnombre);
		setDosis(pdosis);
		setNumDias(pnumDias);
		setIdConsulta(pidConsulta);
		setFechaInicio(pfechaInicio);
		setFechaFinal(pfechaFinal);
		setPrecauciones(pprecauciones);
		consul = null;
	}

	/**
	 *
	 *
	 */	
	public void setNombre(String pnombre) {
		nombre = pnombre;
	}
	/**
	 *
	 *
	 */	
	public void setDosis(String pdosis) {
		dosis = pdosis;
	}
	/**
	 *
	 *
	 */	
	public void setNumDias(String pnumDias) {
		numDias = pnumDias;
	}
	/**
	 *
	 *
	 */	
	public void setIdConsulta(String pidConsulta) {
		idConsulta = pidConsulta;
	}
	/**
	 *
	 *
	 */	
	public String getNombre(){
		return nombre;
	}
	/**
	 *
	 *
	 */	
	public String getDosis(){
		return dosis;
	}
	/**
	 *
	 *
	 */	
	public String getNumDias(){
		return numDias;
	}
	/**
	 *
	 *
	 */	
	public String getIdConsulta(){
		return idConsulta;
	}
	/**
	 *
	 *
	 */	
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 *
	 *
	 */	
	public void setFechaInicio(String pfechaInicio) {
		fechaInicio = pfechaInicio;
	}
	/**
	 *
	 *
	 */	
	public String getFechaFinal() {
		return fechaFinal;
	}
	/**
	 *
	 *
	 */	
	public void setFechaFinal(String pfechaFinal) {
		fechaFinal = pfechaFinal;
	}
	/**
	 *
	 *
	 */	
	public String getPrecauciones() {
		return precauciones;
	}
	/**
	 *
	 *
	 */	
	public void setPrecauciones(String pprecauciones) {
		precauciones = pprecauciones;
	}
	/**
	 *
	 *
	 */	
	public Consulta getConsul() throws Exception {
		if(consul == null){
			setConsul((new MultiConsulta().buscar(idConsulta)));
		}
		return consul;
	}
	/**
	 *
	 *
	 */	
	public void setConsul(Consulta pconsul) {
		consul = pconsul;
	}
	
}
