package CapaLogica;

import java.util.*;

import javax.swing.JOptionPane;

import CapaAccesoBD.Conector;

public class MultiExpediente {
	
	/**
	 *
	 *
	 */	
	public Expediente crear(String pidAnimal, String pfechaApertura)throws Exception{
		Expediente expediente = null;
		String sql;
		sql = "INSERT INTO TExpediente "+
		"(identificacion, fechaApertura) "+
		"VALUES ('"+pidAnimal+"','"+pfechaApertura+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			expediente = new Expediente (pidAnimal, pfechaApertura);
			
		}
		catch (Exception e) {
			
			throw new Exception ("El expediente ya existe en el sistema.");
		}
		return expediente;
	}
	/**
	 *
	 *
	 */	
	public Expediente buscarPorPaciente(String pidPaciente)throws
		java.sql.SQLException,Exception{
		Expediente expediente = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TExpediente "+
		"WHERE identificacion = '"+pidPaciente+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			expediente = new Expediente(rs.getString("identificacion"), rs.getString("fechaApertura"));
			
		} else {
			throw new Exception ("El expediente no está registrado en el sistema.");
		}
		rs.close();
		return expediente;
	}
	/**
	 *
	 *
	 */	
	public Expediente buscarPorExpediente(String pidExpediente)throws
		java.sql.SQLException,Exception{
		Expediente expediente = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT identificacion, fechaApertura "+
		"FROM TExpediente "+
		"WHERE identificacion='"+ pidExpediente +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			expediente = new Expediente(rs.getString("identificacion"), rs.getString("fechaApertura"));
			
		} else {
			throw new Exception ("El expediente no está registrado en el sistema.");
		}
		rs.close();
		return expediente;
		
	}
	/**
	 *
	 *
	 */	
	public Consulta buscarConsultas(String pidExpediente) throws
			java.sql.SQLException,Exception{
		Consulta consulta = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TConsulta "+
		"WHERE Fk_idExpediente='"+pidExpediente+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			consulta = new Consulta(
				rs.getString("id"),
				rs.getString("FK_idVeterinario"),
				rs.getString("fecha"),
				rs.getString("descrip"),
				rs.getString("Fk_idExpediente"),rs.getString("peso"),
				rs.getString("altura"),rs.getString("longEspal"), rs.getString("longPecho"),rs.getString("diaCuello"));
		} else {
			throw new Exception ("La consulta no existe.");
		}
		rs.close();
		return consulta;
	}
	
	public Consulta buscarConsultasPorFecha(String pfecha) throws
	java.sql.SQLException,Exception{
		Consulta consulta = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TConsulta "+
		"WHERE fecha='"+pfecha+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			consulta = new Consulta(
					rs.getString("id"),
					rs.getString("FK_idVeterinario"),
					rs.getString("fecha"),
					rs.getString("descrip"),
					rs.getString("Fk_idExpediente"),rs.getString("peso"),
					rs.getString("altura"),rs.getString("longEspal"), rs.getString("longPecho"),rs.getString("diaCuello"));
		} else {
			throw new Exception ("La consulta no existe.");
		}
		rs.close();
		return consulta;
	}
	
	public  void borrar(Expediente expediente) throws 
	java.sql.SQLException,Exception{
		String sql;
		sql = "DELETE FROM TExpediente "+
		"WHERE numExp ='"+expediente.getNumExp()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El expediente no existe.");
		}
	}
}


