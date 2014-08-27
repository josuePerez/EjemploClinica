package CapaLogica;

public class Veterinario {
	private String identificacion;
	private String nombre;
	private String especialidad;
	private String telefono;
	private Consulta consul;
	private String idConsul;

	/**
	 *
	 *
	 */	
	public Veterinario(String pidentificacion, String pnombre, String pespecialidad, String ptelefono){
		setIdentificacion(pidentificacion);
		setNombre(pnombre);
		setEspecialidad(pespecialidad);
		setTelefono(ptelefono);
	}
	/**
	 *
	 *
	 */	
	public void setIdentificacion(String pidentificacion){
		identificacion = pidentificacion;
	}
	/**
	 *
	 *
	 */	
	public void setNombre(String pnombre){ 
		nombre = pnombre;
	}
	/**
	 *
	 *
	 */	
	public void setEspecialidad(String pespecialidad){
		especialidad = pespecialidad;
	}
	/**
	 *
	 *
	 */	
	public void setTelefono(String ptelefono){
		telefono = ptelefono;
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
	public String getEspecialidad(){
		return especialidad;
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
	public Consulta getConsul() throws Exception {
		if(consul == null){
			setConsul((new MultiConsulta().buscar(idConsul)));
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
	/**
	 *
	 *
	 */	
	public String getIdConsul() {
		return idConsul;
	}
	/**
	 *
	 *
	 */	
	public void setIdConsul(String pidConsul) {
		idConsul = pidConsul;
	}
	
	
	

}

