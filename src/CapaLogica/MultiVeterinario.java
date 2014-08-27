package CapaLogica;

import java.sql.*;
import java.io.*;
import java.util.*;
import CapaAccesoBD.Conector;

public class MultiVeterinario {
	/**
	 *
	 *
	 */	
	public  Veterinario crear(String pidentificacion, String pnombre, String pespecialidad, String ptelefono)
			throws Exception{
		Veterinario vete=null;
		String sql;
		sql = "INSERT INTO TVeterinario "+
		"(identificacion, nombre, especialidad, telefono) "+
		"VALUES ('"+pidentificacion+"', '"+pnombre+"', '"+pespecialidad+"' , '"+ptelefono+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			vete = new Veterinario (pidentificacion, pnombre, pespecialidad, ptelefono);
		}
		catch (Exception e) {
			throw new Exception ("El número de identificación ya está en el sistema.");
		}
		return vete;
	}
	
	
	/**
	 *
	 *
	 */	
	public  Veterinario buscarId(String pidentificacion) throws
		java.sql.SQLException,Exception{
		Veterinario vet=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT identificacion, nombre, especialidad, telefono "+
		"FROM TVeterinario "+
		"WHERE identificacion='"+ pidentificacion +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			vet = new Veterinario (rs.getString("identificacion"), rs.getString("nombre"), rs.getString("especialidad"), rs.getString("telefono") );
		} else {
			throw new Exception ("El veterinario no está registrado.");
		}
		rs.close();
		return vet;
		}
	
		
	/**
	 *
	 *
	 */	
	public  Vector listarVeterinario() throws
		java.sql.SQLException,Exception{
		Veterinario vet=null;
		Vector veterinarios=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT identificacion, nombre, especialidad, telefono "+
		"FROM TVeterinario'" + "%';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		veterinarios = new Vector ();
		if (rs.next()) {
			do {
				vet = new Veterinario (rs.getString("identificacion"), rs.getString("nombre"), rs.getString("especialidad"), rs.getString("telefono"));
				veterinarios.add(vet);
			} while (rs.next());
		} else {
			throw new Exception ("No hay veterinarios registrados.");
		}
		rs.close();
		return veterinarios;
		}
	
	
	
		
	
	
	
}
