package CapaLogica;

import java.util.*;

public class Consulta {
	
	private String idVeterinario;
	private Veterinario veterinario;
	private String descrip_proble;
	private String fecha_realiz;
	private Expediente expediente;
	private String idExpediente;
	private String peso;
	private String altura;
	private String longEspal;
	private String longPecho;
	private String diaCuello;
	private String idConsulta;
	private Vector examenes;
	private Vector medicinas;
	/**
	 *
	 *
	 */	
	public Consulta(String pidConsulta, String pidVeterinario, String pfecha_realiz, String pdescrip_proble, String pidExpediente, String ppeso,
			String paltura, String plongEspalda, String plongPecho, String pdiaCuello){
		setIdConsulta(pidConsulta);
		setIdVeterinario(pidVeterinario);
		setFecha_realiz(pfecha_realiz);
		setDescrip_proble(pdescrip_proble);
		setIdExpediente(pidExpediente);
		setPeso(ppeso);
		setAltura(paltura);
		setLongEspal(plongEspalda);
		setLongPecho(plongPecho);
		veterinario = null;
		examenes = null;
		medicinas = null;
	}
	/**
	 *
	 *
	 */	
	private void setIdConsulta(String pidConsulta){idConsulta= pidConsulta;}
	/**
	 *
	 *
	 */	
	private void setIdVeterinario(String pidVeterinario){idVeterinario = pidVeterinario;}
	/**
	 *
	 *
	 */	
	private void setDescrip_proble(String pdescrip_proble){descrip_proble = pdescrip_proble;}
	/**
	 *
	 *
	 */	
	private void setFecha_realiz(String pfecha_realiz){fecha_realiz = pfecha_realiz;}
	/**
	 *
	 *
	 */	
	private void setIdExpediente(String pidExpediente){idExpediente = pidExpediente;}
	/**
	 *
	 *
	 */	
	private void setVeterinario(Veterinario pveterinario){veterinario = pveterinario;}
	/**
	 *
	 *
	 */	
	private void setExamenes(Vector pexamenes){examenes = pexamenes;}
	/**
	 *
	 *
	 */	
	private void setMedicinas(Vector pmedicinas){medicinas = pmedicinas;}
	/**
	 *
	 *
	 */	
	public String getIdConsulta(){return idConsulta;}
	/**
	 *
	 *
	 */	
	public String getidVeterinario(){return idVeterinario;}
	/**
	 *
	 *
	 */	
	public String getDescrip_proble(){return descrip_proble;}
	/**
	 *
	 *
	 */	
	public String getFecha_realiz(){return fecha_realiz;}
	/**
	 *
	 *
	 */	
	public String getIdExpediente(){return idExpediente;}
	/**
	 *
	 *
	 */	
	public Veterinario getVeterinario()throws Exception{
		if(veterinario == null){
			setVeterinario((new MultiVeterinario()).buscarId(idVeterinario));
		}
		return veterinario;
	}
	/**
	 *
	 *
	 */	
	public Vector<Examen> getExamenes()throws java.sql.SQLException,Exception{
		if(examenes == null){
			setExamenes((new MultiExamen()).buscar(idConsulta));
		}
		return examenes;
	}
	/**
	 *
	 *
	 */	
	public Vector<Medicina> getMedicinas()throws java.sql.SQLException,Exception{
		if(medicinas == null){
			setMedicinas((new MultiMedicina()).buscar(idConsulta));
		}
		return medicinas;
	}
	/**
	 *
	 *
	 */	
	public String getPeso() {
		return peso;
	}
	/**
	 *
	 *
	 */	
	public void setPeso(String ppeso) {
		peso = ppeso;
	}
	/**
	 *
	 *
	 */	
	public String getAltura() {
		return altura;
	}
	/**
	 *
	 *
	 */	
	public void setAltura(String paltura) {
		altura = paltura;
	}
	/**
	 *
	 *
	 */	
	public String getLongEspal() {
		return longEspal;
	}
	/**
	 *
	 *
	 */	
	public void setLongEspal(String plongEspal) {
		longEspal = plongEspal;
	}
	/**
	 *
	 *
	 */	
	public String getLongPecho() {
		return longPecho;
	}
	/**
	 *
	 *
	 */	
	public void setLongPecho(String plongPecho) {
		longPecho = plongPecho;
	}
	/**
	 *
	 *
	 */	
	public String getDiaCuello() {
		return diaCuello;
	}
	/**
	 *
	 *
	 */	
	public void setDiaCuello(String pdiaCuello) {
		diaCuello = pdiaCuello;
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
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	/**
	 *
	 *
	 */	
	public String getIdVeterinario() {
		return idVeterinario;
	}
	
}
