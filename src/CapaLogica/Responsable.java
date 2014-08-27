package CapaLogica;

import java.util.Vector;

public class Responsable {
	private String identificacion;
	private String nombre;
	private String direccion;
	private String telefono;
	private Vector mascotas;
	/**
	 *
	 *
	 */	
	public Responsable(String pidentificacion, String pnombre, String pdireccion, String ptelefono){
		setIdentificacion(pidentificacion);
		setNombre(pnombre);
		setDireccion(pdireccion);
		setTelefono(ptelefono);
		mascotas=null;
		
	}
	/**
	 *
	 *
	 */	
	public void setIdentificacion(String pidentificacion) {
		identificacion=pidentificacion;	
	}
	/**
	 *
	 *
	 */	
	public void setNombre(String pnombre) {
		nombre=pnombre;	
	}
	/**
	 *
	 *
	 */	
	public void setDireccion(String pdireccion) {
		direccion=pdireccion;	
	}
	/**
	 *
	 *
	 */	
	public void setTelefono(String ptelefono) {
		telefono=ptelefono;	
	}
	/**
	 *
	 *
	 */	
	public String getIdentificacion(){
		return identificacion;
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
	public String getDireccion(){
		return direccion;
	}
	/**
	 *
	 *
	 */	
	public String getTelefono(){
		return telefono;
	}
	/**
	 *
	 *
	 */	
	public Vector getMascotas() throws Exception{
		if (mascotas == null) {
			setMascotas((new MultiAnimal()).buscarPorResponsable(identificacion));
		}
		return mascotas;
	}
	
	/**
	 *
	 *
	 */	
	public void setMascotas(Vector pmascotas){
		mascotas = pmascotas;
	}

}
