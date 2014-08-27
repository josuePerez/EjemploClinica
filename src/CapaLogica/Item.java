package CapaLogica;

public class Item {
	
	private String identficacion;
	private Resultado resul;
	private String idResultado;
	private String nombre;
	private String valor;
	private String unidadMedicion;
	private double limiteInfe;
	private double limiteSup;
	/**
	 *
	 *
	 */	
	public Item(String pid, String pidResul, String pnombre, String pvalor, String punidadMed, double plimiteInfe, double plimiteSup){
		setIdentficacion(pid);
		setIdResultado(pidResul);
		setNombre(pnombre);
		setValor(pvalor);
		setUnidadMedicion(punidadMed);
		setLimiteInfe(plimiteInfe);
		setLimiteSup(plimiteSup);
		resul = null;
	}
	/**
	 *
	 *
	 */	
	public String getIdentficacion() {
		return identficacion;
	}
	/**
	 *
	 *
	 */	
	public void setIdentficacion(String pidentficacion) {
		identficacion = pidentficacion;
	}
	/**
	 *
	 *
	 */	
	public Resultado getResul() throws Exception {
		if(resul == null){
			setResul((new MultiResultado().buscar(idResultado)));
		}
		return resul;
	}
	/**
	 *
	 *
	 */	
	public void setResul(Resultado presul) {
		resul = presul;
	}
	/**
	 *
	 *
	 */	
	public String getIdResultado() {
		return idResultado;
	}
	/**
	 *
	 *
	 */	
	public void setIdResultado(String pidResultado) {
		idResultado = pidResultado;
	}
	/**
	 *
	 *
	 */	
	public String getNombre() {
		return nombre;
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
	public String getValor() {
		return valor;
	}
	/**
	 *
	 *
	 */	
	public void setValor(String pvalor) {
		valor = pvalor;
	}
	/**
	 *
	 *
	 */	
	public String getUnidadMedicion() {
		return unidadMedicion;
	}
	/**
	 *
	 *
	 */	
	public void setUnidadMedicion(String punidadMedicion) {
		unidadMedicion = punidadMedicion;
	}
	/**
	 *
	 *
	 */	
	public double getLimiteInfe() {
		return limiteInfe;
	}
	/**
	 *
	 *
	 */	
	public void setLimiteInfe(double plimiteInfe) {
		limiteInfe = plimiteInfe;
	}
	/**
	 *
	 *
	 */	
	public double getLimiteSup() {
		return limiteSup;
	}
	/**
	 *
	 *
	 */	
	public void setLimiteSup(double plimiteSup) {
		limiteSup = plimiteSup;
	}
}
