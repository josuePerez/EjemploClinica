package CapaLogica;

import java.util.*;
import java.text.*;

public class Animal {
	private String identificacion;
	private String nombre;
	private String raza;
	private String edad;
	private String fechaNac;
	private String idResponsable;
	private String animalMadre;
	private String animalPadre;
	private String estado;
	private Responsable duenno;
	private String idVeterinario;
	private Veterinario vet;
	private Expediente expediente;
	private String idExpediente;
	


	/**
	 *
	 *
	 */	
	public Animal(String pidentificacion, String pnombre, String praza, String pedad, String pfechaNac, String pidResponsable ){
		setIdentificacion(pidentificacion);
		setNombre(pnombre);
		setRaza(praza);
		setEdad(pedad);
		setFechaNac(pfechaNac);
		setIdResponsable(pidResponsable);
		duenno=null;
		vet = null;
		expediente = null;
	}
	
	public Animal(String pidentificacion, String pnombre, String praza, String pedad, String pfechaNac, String pidResponsable,String pAnimalMadre,
			String panimalPadre){
		setIdentificacion(pidentificacion);
		setNombre(pnombre);
		setRaza(praza);
		setEdad(pedad);
		setFechaNac(pfechaNac);
		setIdResponsable(pidResponsable);
		setAnimalMadre(pAnimalMadre);
		setAnimalPadre(panimalPadre);
		duenno=null;
		vet = null;
		expediente = null;
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
	public void setRaza(String praza) {
		raza=praza;	
	}
	/**
	 *
	 *
	 */	
	public void setEdad(String pedad) {
		edad=pedad;	
	}
	/**
	 *
	 *
	 */	
	public void setFechaNac(String pfechaNac) {
		fechaNac=pfechaNac;	
	}
	/**
	 *
	 *
	 */	
	public void setIdResponsable(String pidResponsable) {
		idResponsable=pidResponsable;	
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
	public String getRaza(){
		return raza;
	}
	/**
	 *
	 *
	 */	
	public String getEdad(){
		return edad;
	}
	/**
	 *
	 *
	 */	
	public String getFechaNac(){
		return fechaNac;
	}
	/**
	 *
	 *
	 */	
	public String getidResponsable(){
		return idResponsable;
	}
	/**
	 *
	 *
	 */	
	public Responsable getDuenno() throws Exception{
		if (duenno== null) {
			setDuenno((new MultiResponsable()).buscar(identificacion));
		}
		return duenno;
	}
	/**
	 *
	 *
	 */	
	public void setDuenno(Responsable pduenno){
		duenno = pduenno;
	}
	/**
	 *
	 *
	 */	
	public String getAnimalMadre() {
		return animalMadre;
	}
	/**
	 *
	 *
	 */	
	public void setAnimalMadre(String panimalMadre) {
		animalMadre = panimalMadre;
	}
	/**
	 *
	 *
	 */	
	public String getAnimalPadre() {
		return animalPadre;
	}
	/**
	 *
	 *
	 */	
	public void setAnimalPadre(String panimalPadre) {
		animalPadre = panimalPadre;
	}
	/**
	 *
	 *
	 */	
	public String getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(String pidVeterinario) {
		idVeterinario = pidVeterinario;
	}
	/**
	 *
	 *
	 */	
	public Veterinario getVet() throws Exception {
		if(vet == null){
			setVet((new MultiVeterinario()).buscarId(idVeterinario));
		}
		return vet;
	}
	/**
	 *
	 *
	 */	
	public void setVet(Veterinario pvet) {
		vet = pvet;
	}
	/**
	 *
	 *
	 */	
	public String getEstado() {
		return estado;
	}
	/**
	 *
	 *
	 */	
	public void setEstado(String pestado) {
		estado = pestado;
	}
	/**
	 *
	 *
	 */	
	public Expediente getExpediente() throws Exception {
		if(expediente == null){
			setExpediente((new MultiExpediente().buscarPorExpediente(idExpediente)));
		}
		return expediente;
	}
	/**
	 *
	 *
	 */	
	public void setExpediente(Expediente pexpediente) {
		expediente = pexpediente;
	}
}
