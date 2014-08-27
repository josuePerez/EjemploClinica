package CapaLogica;

import java.util.*;

import javax.swing.JOptionPane;

public class Expediente {
	private int num = 0;
	private String numero;
	private String fechaApertura;
	private Animal animal;
	private String idAnimal;
	private Vector consultas;
	private boolean estado; 
	/**
	 *
	 *
	 */	
	public Expediente(String pidAnimal,String pfechaApertura){
		setNumExp(num);
		setFechaApertura(pfechaApertura);
		setIdAnimal(pidAnimal);
		num++;
	}
	/**
	 *
	 *
	 */	
	private void setNumExp(int pnumExp){numero = " ExpAnimal- " + pnumExp;}
	/**
	 *
	 *
	 */	
	private void setFechaApertura(String pfechaApertura){fechaApertura = pfechaApertura;}
	/**
	 *
	 *
	 */	
	private void setIdAnimal(String pidAnimal){idAnimal = pidAnimal;}
	/**
	 *
	 *
	 */	
	private void setAnimal(Animal panimal){animal = panimal;}
	/**
	 *
	 *
	 */	
	private void setConsultas(Vector pconsultas){consultas = pconsultas;}
	/**
	 *
	 *
	 */	
	public String getNumExp(){return numero;}
	/**
	 *
	 *
	 */	
	public String getFechaApertura(){return fechaApertura;}
	/**
	 *
	 *
	 */	
	public String getIdAnimal(){return idAnimal;}
	/**
	 *
	 *
	 */	
	public Animal getAnimal()throws Exception{
		if(animal == null){
			setAnimal((new MultiAnimal()).buscar(idAnimal));
		}
		return animal;
	}
	/**
	 *
	 *
	 */	
	public void agregarConsulta(TreeMap datos){
		consultas.add(datos);
	}
	/**
	 *
	 *
	 */	
	public Vector getConsultas()throws Exception{
		if(consultas == null){
			setConsultas((new MultiConsulta ()).buscarConsultas(idAnimal));
		}
		return consultas;
	}
	/**
	 *
	 *
	 */	
	public Consulta registrarConsulta(String pidConsulta,String pidVeterinario, String pfecha_realiz, String pdescrip_proble, 
			String pidExpediente,String ppeso,String paltura,String plongEspal,String plongPecho,String pdiaCuello) throws Exception{
		
		Consulta consulta;
		consulta = (new MultiConsulta()).crear(pidConsulta, pidVeterinario, pfecha_realiz, pdescrip_proble, 
											   pidExpediente, ppeso,paltura, plongEspal, plongPecho, pdiaCuello);
		
		return consulta;
	}
	/**
	 *
	 *
	 */	
	public boolean isEstado() {
		return estado;
	}
	/**
	 *
	 *
	 */	
	public void setEstado(boolean pestado) {
		estado = pestado;
	}
	
	
}
