package CapaLogica;

import java.sql.SQLException;
import java.util.*;

import javax.swing.JOptionPane;


public class Gestor {
	/**
	 *
	 *
	 */	
	public void registrarExamen(String pid,String pnombreExamen, String pfecha_solic, String pfecha_realiz, String pdescrip, String pidConsulta)
	throws Exception{
		Examen examen;
		examen = (new MultiExamen()).crear(pid, pnombreExamen, pfecha_solic, pfecha_realiz, pdescrip, pidConsulta);
	}
	/**
	 *
	 *
	 */	
	public void registrarConsulta(String pidConsulta,String pidVeterinario, String pfecha_realiz, String pdescrip_proble, String pidExpediente,
			String ppeso,String paltura,String plongEspal,String plongPecho,String pdiaCuello)
	throws Exception{
		Consulta consulta;
		TreeMap datosConsul = null;
		Expediente expediente = null;
		expediente = ((new MultiExpediente()).buscarPorExpediente(pidExpediente));
		JOptionPane.showMessageDialog(null, "erereRFFDFvf");
		consulta = expediente.registrarConsulta(pidConsulta, pidVeterinario,pfecha_realiz, pdescrip_proble, pidExpediente, ppeso,paltura, 
				plongEspal, plongPecho,pdiaCuello);
		datosConsul = new TreeMap();
		datosConsul.put("FK_idVeterinario", consulta.getidVeterinario());
		datosConsul.put("fecha", consulta.getFecha_realiz());
		datosConsul.put("descrip",consulta.getDescrip_proble());
		datosConsul.put("FK_idExpediente",consulta.getIdExpediente());
		expediente.agregarConsulta(datosConsul);
	}
	/**
	 *
	 *
	 */	
	public void registrarExpediente(String pidAnimal,String pfechaApertura)throws Exception{
		Expediente expediente;
		expediente = (new MultiExpediente()).crear(pidAnimal, pfechaApertura);
	}
	/**
	 *
	 *
	 */	
	
	public void registrarResul(String pidExamen, String plugar, String pfecha, String pdescrip)throws Exception{
		Examen examen = null;
		Resultado resultado;
		examen = ((new MultiExamen()).buscarExamen(pidExamen));
		resultado = examen.agregarResultado(pidExamen, plugar, pfecha, pdescrip);
	}
	
	/**
	 *
	 *
	 */	
	
	public void registrarCita( String pfecha, String pdescrip, String pidExpediente, String pidVeterinario)throws Exception{
		Cita cita;
		cita = (new MultiCita()).crear(pfecha, pdescrip,pidExpediente, pidVeterinario, "Asignada");
	}
	/**
	 *
	 *
	 */	
	
	public TreeMap buscarExpedientePorIDPaciente(String pidPaciente)throws Exception{
		Expediente objExpediente;
		TreeMap datosExpediente = new TreeMap ();
		objExpediente = (new MultiExpediente()).buscarPorPaciente(pidPaciente);
		datosExpediente.put("identificacion",objExpediente.getNumExp());
		datosExpediente.put("fechaApertura", objExpediente.getFechaApertura());
		Animal animal;
		animal = objExpediente.getAnimal();
		datosExpediente.put("nombre", animal.getNombre());
		datosExpediente.put("raza", animal.getRaza());
		datosExpediente.put("edad", animal.getEdad());
		
		return datosExpediente;
		
	}
	/**
	 *
	 *
	 */	
	public TreeMap buscarExpedientePorIDExpediente(String pidExpediente)throws Exception{
		Expediente objExpediente;
		TreeMap datosExpediente = new TreeMap();
		objExpediente = (new MultiExpediente()).buscarPorExpediente(pidExpediente);
		datosExpediente.put("identificacion",objExpediente.getNumExp());
		datosExpediente.put("fechaApertura", objExpediente.getFechaApertura());
		return datosExpediente;
	}
	/**
	 *
	 *
	 */	
	public Vector buscarConsultas(String pidExpediente)throws Exception{
		Expediente objExpediente;
		Consulta objConsulta;
		Examen examen;
		Vector infoConsultas = new Vector();
		Vector datosConsultas;
		Vector datosExamen;
		objExpediente = (new MultiExpediente()).buscarPorExpediente(pidExpediente);
		objConsulta = (new MultiExpediente()).buscarConsultas(pidExpediente);
		datosConsultas = objExpediente.getConsultas();
		for(int i= 0 ; i<datosConsultas.size(); i++){
			objConsulta = ((Consulta) datosConsultas.get(i));
			TreeMap infoConsul = new TreeMap();
			infoConsul.put("fecha", "" + objConsulta.getFecha_realiz());
			infoConsul.put("FK_idExpediente", ""+ objConsulta.getIdExpediente());
			infoConsul.put("Fk_idVeterinario", objConsulta.getidVeterinario());
			infoConsul.put("descrip", objConsulta.getDescrip_proble());
			infoConsul.put("id", objConsulta.getIdConsulta());
			infoConsultas.add(infoConsul);
			
		}
		return infoConsultas;
		
	}
	/**
	 *
	 *
	 */	
	public Vector buscarConsultasPorFecha(String pfecha, String pidExpediente)throws Exception{
		Expediente objExpediente;
		Consulta objConsulta;
		Examen examen;
		Vector infoConsultas = new Vector();
		Vector datosConsultas;
		Vector datosExamen;
		objExpediente = (new MultiExpediente()).buscarPorExpediente(pidExpediente);
		objConsulta = (new MultiExpediente()).buscarConsultasPorFecha(pfecha);
		datosConsultas = objExpediente.getConsultas();
		for(int i= 0 ; i<datosConsultas.size(); i++){
			objConsulta = ((Consulta) datosConsultas.get(i));
			TreeMap infoConsul = new TreeMap();
			infoConsul.put("fecha", "" + objConsulta.getFecha_realiz());
			infoConsul.put("FK_idExpediente", ""+ objConsulta.getIdExpediente());
			infoConsul.put("Fk_idVeterinario", objConsulta.getidVeterinario());
			infoConsul.put("descrip", objConsulta.getDescrip_proble());
			infoConsul.put("id", objConsulta.getIdConsulta());
			infoConsultas.add(infoConsul);
			
		}
		return infoConsultas;
		
	}
	/**
	 *
	 *
	 */	
	public void eliminarExamen(String pnombreExamen, String pidConsulta) throws SQLException, Exception{
		Examen examen;
		examen = (new MultiExamen()).buscarExamen(pidConsulta);
		(new MultiExamen()).borrar(examen);
	}
	/**
	 *
	 *
	 */	
	public void modificarExamen(String pnombre, String pfechaRealiz, String pidConsulta)throws Exception{
		Examen examen;
		examen = (new MultiExamen()).buscarExamen(pidConsulta);
		examen.setNombreExamen(pnombre);
		examen.setFecha_realiz(pfechaRealiz);
		(new MultiExamen()).modificar(pnombre, pfechaRealiz, pidConsulta);
	}
	/**
	 *  
	 *  
	 * 
	 *
	 */
	public Vector buscarExamenes(String pidConsulta) throws SQLException, Exception{
		Consulta consulta = null;
		Examen examen = null;
		Vector examenes;
		Vector infoExamenes = new Vector();
		consulta = ((new MultiConsulta().buscar(pidConsulta)));
		examenes = consulta.getExamenes();
		for (int i=0; i<examenes.size(); i++) {
			examen = ((Examen)examenes.get(i));
			TreeMap datosExamen = new TreeMap();
			//datosExamen.put("id", examen.getIdExamen());
			datosExamen.put("nombre", examen.getNombreExamen());
			datosExamen.put("fechSolicitud", examen.getFecha_solic());
			datosExamen.put("fechRealizacion", examen.getFecha_realiz());
			datosExamen.put("descrip", examen.getDescrip());
			infoExamenes.add(datosExamen);
			
		}
		return infoExamenes;
	}
	/**
	 *
	 *
	 */	
	public Vector buscarMedicinas(String pidConsulta) throws SQLException, Exception{
		Consulta consulta = null;
		Medicina medicina = null;
		Vector medicinas;
		Vector infoMedicinas = new Vector();
		consulta = ((new MultiConsulta().buscar(pidConsulta)));
		medicinas = consulta.getMedicinas();
		for (int i=0; i<medicinas.size(); i++) {
			medicina = ((Medicina)medicinas.get(i));
			TreeMap datosMedicina = new TreeMap();
			datosMedicina.put("nombre", medicina.getNombre());
			datosMedicina.put("dosis", medicina.getDosis());
			datosMedicina.put("numDias", medicina.getNumDias());
			datosMedicina.put("FK_idConsulta", medicina.getIdConsulta());
			infoMedicinas.add(datosMedicina);
		}
		return infoMedicinas;
	}
		
	public void RegistrarVeterinario(String pidentificacion, String pnombre, String pespecialidad, String ptelefono) throws Exception {
		Veterinario vet;
		vet = (new MultiVeterinario()).crear(pidentificacion, pnombre, pespecialidad, ptelefono);
	}
	/**
	 *
	 *
	 */	
	public TreeMap ConsultarVeterinarioID(String pidentificacion) throws Exception {
		TreeMap datos = null;
		Veterinario vet=null;
		String nombre;
		datos = new TreeMap();
		vet = (new MultiVeterinario()).buscarId(pidentificacion);
		datos.put("identificacion", vet.getIdentificacion());
		datos.put("nombre", vet.getNombre());
		datos.put("especialidad", vet.getEspecialidad());
		datos.put("telefono", vet.getTelefono());
		return datos;
	}
	
	/**
	 *
	 *
	 */	
	public Vector ConsultarVeterinario() throws Exception {
		Vector veterinarios;
		Vector infoVeterinarios = new Vector();
		Veterinario vet;
		veterinarios = (new MultiVeterinario()).listarVeterinario();
		for (int i=0; i<veterinarios.size(); i++) {
			vet = ((Veterinario)veterinarios.get(i));
			TreeMap datosVeterinario = new TreeMap();
			datosVeterinario.put("identificacion", vet.getIdentificacion());
			datosVeterinario.put("nombre", vet.getNombre());
			datosVeterinario.put("especialidad", vet.getEspecialidad());
			datosVeterinario.put("telefono", vet.getTelefono());
			infoVeterinarios.add(datosVeterinario);
		}
		return infoVeterinarios;
	}
	/**
	 *
	 *
	 */	
	public void RegistrarMedicina(String pnombre, String pdosis, String pnumDias, String pidConsulta, String pfechaInicio,
			String pfechaFinal,String pprecauciones) throws Exception {
		Medicina med;
		med = (new MultiMedicina()).crear(pnombre, pdosis, pnumDias, pidConsulta, pfechaInicio, pfechaFinal, pprecauciones);
	}
	/**
	 *
	 *
	 */	
	public void RegistrarDuenno(String pidentificacion, String pnombre, String pdireccion, String ptelefono ) throws Exception {
		Responsable responsable;
		responsable = (new MultiResponsable()).crear(pidentificacion, pnombre, pdireccion, ptelefono);
	}
	/**
	 *
	 *
	 */	
	public void RegistrarAnimal(String pidentificacion, String pnombre, String praza, String pedad, String pfechaNac, String pidResponsable ) 
			throws Exception {
		Animal animal;
		animal = (new MultiAnimal()).crear(pidentificacion, pnombre, praza, pedad, pfechaNac, pidResponsable);
	}
	/**
	 *
	 *
	 */	
	public void RegistrarAnimal(String pidentificacion, String pnombre, String praza, String pedad, String pfechaNac, String pidResponsable,
			String panimalMadre, String panimalPadre) throws Exception {
		Animal animal;
		animal = (new MultiAnimal()).crear(pidentificacion, pnombre, praza, pedad, pfechaNac, pidResponsable, panimalMadre, panimalPadre);
	}
	/**
	 *
	 *
	 */	
	public void RegistrarItem(String pid, String pidResul, String pnombre, String pvalor, String punidadMed, double plimiteInfe,
								double plimiteSup) throws Exception {
		Item item = null;
		Resultado resultado;
		resultado = ((new MultiResultado()).buscar(pidResul));
		item = resultado.agregarItem(pid, pidResul, pnombre, pvalor, punidadMed, plimiteInfe, plimiteSup);
	}
	/**
	 *
	 *
	 */	
	public TreeMap buscarAnimalID(String pidAnimal)throws Exception{
		Animal objAnimal;
		TreeMap datosAnimal = new TreeMap();
		objAnimal = (new MultiAnimal()).buscar(pidAnimal);
		datosAnimal.put("identificacion",objAnimal.getIdentificacion());
		datosAnimal.put("nombre", objAnimal.getNombre());
		datosAnimal.put("raza", objAnimal.getRaza());
		datosAnimal.put("edad", objAnimal.getEdad());
		datosAnimal.put("fechaNac", objAnimal.getFechaNac());
		datosAnimal.put("Fk_idResponsable", objAnimal.getidResponsable());
		return datosAnimal;
	}
	/**
	 *
	 *
	 */	
	public void cancelarCita(String pidExpediente) throws SQLException, Exception{
		Cita cita;
		String pdescrip,pidVeterinario, pestado;
		cita = (new MultiCita()).buscar(pidExpediente);
		pdescrip = cita.getDescrip();
		pestado = cita.getEstado();
		pidVeterinario = cita.getIdVeterinario();
		(new MultiCita()).cancelarCita(pdescrip, pidExpediente, pidVeterinario, pestado);
	}
	/**
	 *
	 *
	 */	
	public void anularCita(String pidExpediente) throws SQLException, Exception{
		(new MultiCita()).anularCita(pidExpediente);
	}
	/**
	 *
	 *
	 */	
	public Vector<Cita> consultarCitasVeterinario(String pidVeterinario) throws Exception{
		Vector citas;
		Vector infoCitas = new Vector();
		Cita cita;
		citas = (new MultiCita()).buscarCitasVeterinario(pidVeterinario);
		for (int i=0; i<citas.size(); i++) {
			cita = ((Cita)citas.get(i));
			TreeMap datosVeterinario = new TreeMap();
			datosVeterinario.put("fechaCita", cita.getFechaCita());
			datosVeterinario.put("descrip", cita.getDescrip());
			datosVeterinario.put("Fk_idExpediente", cita.getIdExpediente());
			datosVeterinario.put("Fk_idVeterinario", cita.getIdVeterinario());
			infoCitas.add(datosVeterinario);
		}
		return infoCitas;
	}
	/**
	 *
	 *
	 */	
	public Vector<Animal> consultarAnimalesVeterinario(String pidVeterinario) throws Exception{
		Vector animales;
		Vector infoAnimales = new Vector();
		Animal animal;
		animales = (new MultiAnimal()).buscarPorVeterinario(pidVeterinario);
		for (int i=0; i<animales.size(); i++) {
			animal = ((Animal)animales.get(i));
			TreeMap datosVeterinario = new TreeMap();
			datosVeterinario.put("identificacion", animal.getIdentificacion());
			datosVeterinario.put("nombre", animal.getNombre());
			datosVeterinario.put("raza", animal.getRaza());
			datosVeterinario.put("edad", animal.getEdad());
			datosVeterinario.put("fechaNac", animal.getFechaNac());
			datosVeterinario.put("Fk_idResponsable", animal.getidResponsable());
			/**datosVeterinario.put("animalMadre", animal.getAnimalMadre());
			datosVeterinario.put("animalPadre", animal.getAnimalPadre());*/
			infoAnimales.add(datosVeterinario);
		}
		return infoAnimales;
	}
	/**
	 *
	 *
	 */	
	public void eliminarAnimal(String pidAnimal) throws SQLException, Exception{
		Animal animal;
		animal = (new MultiAnimal()).buscar(pidAnimal);
		(new MultiAnimal()).borrar(animal);
	}

}
