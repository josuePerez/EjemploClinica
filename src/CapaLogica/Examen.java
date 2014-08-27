package CapaLogica;

public class Examen {
	
	private String nombreExamen; 	
	private String fecha_solic;		
	private String fecha_realiz;	
	private String descrip;	
	private String idConsulta;
	private Consulta consul;
	private Resultado resul;

	
	
	/**
	 *
	 *
	 */	
	public Examen(String pnombreExamen, String pfecha_solic, String pfecha_realiz, String pdescrip, String pidConsulta){
		
		setNombreExamen(pnombreExamen);
		setFecha_solic(pfecha_solic);
		setFecha_realiz(pfecha_realiz);
		setDescrip(pdescrip);
		setIdConsulta(pidConsulta);
	}
	/**
	 *
	 *
	 */	
	public void setNombreExamen(String pnombreExamen){nombreExamen = pnombreExamen;}
	/**
	 *
	 *
	 */	
	private void setFecha_solic(String pfecha_solic){fecha_solic = pfecha_solic;}
	/**
	 *
	 *
	 */	
	public void setFecha_realiz(String pfecha_realiz){fecha_realiz = pfecha_realiz;}
	/**
	 *
	 *
	 */	
	private void setDescrip(String pdescrip){descrip = pdescrip;}
	/**
	 *
	 *
	 */	
	private void setIdConsulta(String pidConsulta){idConsulta = pidConsulta;}
	/**
	 *
	 *
	 */	
	public String getNombreExamen(){return nombreExamen;}
	/**
	 *
	 *
	 */	
	public String getFecha_solic(){return fecha_solic;}
	/**
	 *
	 *
	 */	
	public String getFecha_realiz(){return fecha_realiz;}
	/**
	 *
	 *
	 */	
	public String getDescrip(){return descrip;}
	/**
	 *
	 *
	 */	
	public String getIdConsulta(){return idConsulta;} 
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
	public Resultado agregarResultado(String pidExamen, String plugarRealiz, String pfechaEntrega, String pdescrip)
										throws Exception{
		Resultado resultado;
		
		resultado = (new MultiResultado()).crear(pidExamen, plugarRealiz, pfechaEntrega, pdescrip);		
		
		return resultado;
	}
	
	
}
