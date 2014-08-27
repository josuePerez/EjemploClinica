package CapaLogica;

public class Cita {
	private String fechaCita;
	private String descrip;
	private String estado;
	private Veterinario vet;
	private Expediente expediente;
	private String idExpediente;
	private String idVeterinario;
	/**
	 *
	 *
	 */	
	public Cita(String pfechaCita,String pdescrip, String pidExpediente, String pidVeterinario, String pestado){
		setFechaCita(pfechaCita);
		setDescrip(pdescrip);
		setIdExpediente(pidExpediente);
		setIdVeterinario(pidVeterinario);
		setEstado(pestado);
		
	}
	/**
	 *
	 *
	 */	
	public String getFechaCita() {
		return fechaCita;
	}
	/**
	 *
	 *
	 */	
	public void setFechaCita(String pfechaCita) {
		fechaCita = pfechaCita;
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
		descrip = pdescrip;
	}
	/**
	 *
	 *
	 */	
	public String getIdExpediente() {
		return idExpediente;
	}
	/**
	 *
	 *
	 */	
	public void setIdExpediente(String pidExpediente) {
		idExpediente = pidExpediente;
	}
	/**
	 *
	 *
	 */	
	public String getIdVeterinario() {
		return idVeterinario;
	}
	/**
	 *
	 *
	 */	
	public void setIdVeterinario(String pidVeterinario) {
		idVeterinario = pidVeterinario;
	}
	/**
	 *
	 *
	 */	
	public void setVeterinario(Veterinario pvet){
		vet = pvet;
	}
	/**
	 *
	 *
	 */	
	public Veterinario getVeterinario()throws Exception{
		if(vet == null){
			setVeterinario((new MultiVeterinario().buscarId(idVeterinario)));
		}
		return vet;
	}
	/**
	 *
	 *
	 */	
	public void setExpediente(Expediente pexpediente){
		expediente = pexpediente;
	}
	/**
	 *
	 *
	 */	
	public Expediente getExpediente()throws Exception{
		if(expediente == null){
			setExpediente((new MultiExpediente().buscarPorExpediente(idExpediente)));
		}
		return expediente;
	}
	/**
	 *
	 *
	 */	
	public void setEstado(String pestado){
		estado = pestado;
	}
	/**
	 *
	 *
	 */	
	public String getEstado(){return estado;}
	
}
