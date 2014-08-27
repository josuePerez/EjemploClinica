package CapaLogica;

import java.util.Date;
import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiCita {
	
	public Cita crear(String pfechaCita, String pdescrip, String pidExpediente, String pidVeterinario, String pestado)throws Exception{
		Cita cita = null;
		String sql;
		sql = "INSERT INTO TCita "+
		"(fechaCita, descrip, Fk_idExpediente, Fk_idVeterinario, estado) "+
		"VALUES ('"+pfechaCita+"','"+pdescrip+"','"+pidExpediente+"','"+pidVeterinario+"','"+"Asignada"+"');";
		
		try {
			Conector.getConector().ejecutarSQL(sql);
			cita = new Cita (pfechaCita, pdescrip, pidExpediente, pidVeterinario, pestado);
		}
		catch (Exception e) {
			throw new Exception ("La cita esta registrada.");
		}
		return cita;
	}
	
	public Cita buscar(String pidExpediente)throws java.sql.SQLException,Exception{
		Cita cita = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT fechaCita, descrip, Fk_idExpediente, Fk_idVeterinario,estado "+
		"FROM TCita "+
		"WHERE Fk_idExpediente= '"+pidExpediente+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if(rs.next()){
			cita = new Cita(rs.getString("fechaCita"),
							rs.getString("descrip"),
							rs.getString("Fk_idExpediente"),
							rs.getString("Fk_idVeterinario"),
							rs.getString("estado"));
		}else{
			throw new Exception ("La cita no existe");
		}
		rs.close();
		
		return cita;
	}
	
	public void modificar(String pdescrip, String pidVeterinario, String pidExpediente)throws Exception{
		String sql;
		sql = "UPDATE TCita "+
		"SET descrip='"+pdescrip+"' "+
		"SET Fk_idVeterinario = '"+pidVeterinario+"'"+
		"WHERE Fk_idExpediente='"+pidExpediente+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("La cita no está registrada.");
		}
	}
	
	public void modificarEstado(String pestado, String pidExpediente)throws Exception{
		String sql;
		sql = "UPDATE TCita "+
		"SET estado='"+pestado+"' "+
		"WHERE Fk_idExpediente='"+pidExpediente+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("La cita no está registrada.");
		}
	}
	
	public void cancelarCita(String pdescrip, String pidExpediente, String pidVeterinario, String pestado)throws Exception{
		Date pfecha = new Date();
		Cita cita = null;
		String pfechaCita = ""+pfecha;
		cita = this.crear(pfechaCita, pdescrip, pidExpediente, pidVeterinario, pestado);
	}
	
	public void anularCita(String pidExpediente)throws Exception{
		String sql;
		sql = "UPDATE TCita "+
		"SET estado = '"+"Anulada"+"'"+
		"WHERE Fk_idExpediente='"+pidExpediente+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("La cita no está registrada.");
		}
	}
	
	public Vector<Cita> buscarCitasVeterinario(String pidVeterinario)throws java.sql.SQLException,Exception{
		Cita cita = null;
		Vector<Cita> citas;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT fechaCita, descrip, Fk_idExpediente, Fk_idVeterinario,estado "+
		"FROM TCita "+
		"WHERE Fk_idVeterinario= '"+pidVeterinario+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		citas = new Vector<Cita>();
		if(rs.next()){
			do{
			cita = new Cita(rs.getString("fechaCita"),
							rs.getString("descrip"),
							rs.getString("Fk_idExpediente"),
							rs.getString("Fk_idVeterinario"),
							rs.getString("estado"));
			citas.add(cita);
			}while(rs.next());
		}else{
			throw new Exception ("El veterinario no tiene citas asignadas");
		}
		rs.close();
		
		return citas;
	}
}
