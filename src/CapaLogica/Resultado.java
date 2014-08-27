package CapaLogica;

import java.sql.SQLException;
import java.util.Vector;

public class Resultado {
	private String lugarRealiz;
	private String fechaEntrega;
	private String descrip;
	private String idExamen;
	private Examen examen;
	private Vector<Item> items;
	/**
	 *
	 *
	 */	
	public Resultado(String pidExamen, String plugarRealiz, String pfechaEntrega, String pdescrip){
		setIdExamen(pidExamen);
		setLugarRealiz(plugarRealiz);
		setFechaEntrega(pfechaEntrega);
		setDescrip(pdescrip);
		examen = null;
		items = null;
	}
	/**
	 *
	 *
	 */	
	public String getLugarRealiz() {
		return lugarRealiz;
	}
	/**
	 *
	 *
	 */	
	public void setLugarRealiz(String plugarRealiz) {
		lugarRealiz = plugarRealiz;
	}
	/**
	 *
	 *
	 */	
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	/**
	 *
	 *
	 */	
	public void setFechaEntrega(String pfechaEntrega) {
		fechaEntrega = pfechaEntrega;
	}
	/**
	 *
	 *
	 */	
	public String getDescrip() {
		return descrip;
	}
	/**
	 *
	 *
	 */	
	public void setDescrip(String pdescrip) {
		this.descrip = pdescrip;
	}
	/**
	 *
	 *
	 */	
	public String getIdExamen() {
		return idExamen;
	}
	/**
	 *
	 *
	 */	
	public void setIdExamen(String pidExamen) {
		idExamen = pidExamen;
	}
	/**
	 *
	 *
	 */	
	public void setExamen(Examen pexamen) {
		examen = pexamen;
	}
	/**
	 *
	 *
	 */	
	public Examen getExamen() throws Exception{
		if(examen == null){
			setExamen((new MultiExamen().buscarExamen(idExamen)));
		}
		return examen;
	}
	/**
	 *
	 *
	 */	
	public Item agregarItem(String pid, String pidResul, String pnombre, String pvalor, String punidadMed, double plimiteInfe, 
							double plimiteSup) throws Exception{
		
		Item item;
		
		item = (new MultiItem()).crear(pid, pidResul, pnombre, pvalor, punidadMed, plimiteInfe, plimiteSup);		
		
		return item;
	}
	
}
