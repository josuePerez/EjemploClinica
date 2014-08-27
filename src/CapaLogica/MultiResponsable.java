package CapaLogica;

import java.sql.*;
import java.io.*;
import java.util.*;
import CapaAccesoBD.Conector;

public class MultiResponsable {
	/**
	 *
	 *
	 */	
	public  Responsable crear(String pidentificacion,String pnombre,String pdireccion, String ptelefono)
			throws Exception{
		Responsable responsable=null;
		String sql;
		sql = "INSERT INTO TResponsable "+
		"(identificacion, nombre, direccion, telefono ) "+
		"VALUES ('"+pidentificacion+"', '"+pnombre+"', '"+pdireccion+"', '"+ptelefono+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			responsable = new Responsable (pidentificacion, pnombre, pdireccion, ptelefono );
		}
		catch (Exception e) {
			throw new Exception ("El número de identificación ya está en el sistema.");
		}
		return responsable;
	}
	/**
	 *
	 *
	 */	
	public  Responsable buscar(String pidentificacion) throws
			java.sql.SQLException,Exception{
		Responsable responsable=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT identificacion, pnombre, pdireccion, ptelefono "+
		"FROM TResponsable "+
		"WHERE fk_idResponsable='"+ pidentificacion +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			responsable = new Responsable (rs.getString("identificacion"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"));
		} else {
			throw new Exception ("El responsable no está registrado.");
		}
		rs.close();
		return responsable;
	}

}
