package CapaLogica;

import java.util.Vector;

import CapaAccesoBD.Conector;

public class MultiExamen {
	/**
	 *
	 *
	 */	
	public Examen crear(String pid,String pnombreExamen, String pfecha_solic, String pfecha_realiz, String pdescrip, String pidConsulta)
			throws Exception{
		Examen examen = null;
		String sql;
		sql = "INSERT INTO TExamen "+
		"(nombre, fechSolicitud, fechRealizacion, descrip, FK_idConsulta) "+
		"VALUES ('"+pnombreExamen+"','"+pfecha_solic+"' ,'"+pfecha_realiz+"' ,'"+pdescrip+"' ,'"+pidConsulta+"');";
		
		try {
			Conector.getConector().ejecutarSQL(sql);
			examen = new Examen (pnombreExamen,pfecha_solic,pfecha_realiz, pdescrip,  pidConsulta);
		}
		catch (Exception e) {
			
			throw new Exception ("El examen ya existe en el sistema.");
		}
		return examen;
	}
	/**
	 *
	 *
	 */	
	public Vector buscar(String pidConsulta)throws
	java.sql.SQLException,Exception{
		Examen examen = null;
		Vector  examenes;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT nombre, fechSolicitud, fechRealizacion, descrip, FK_idConsulta "+
		"FROM TExamen "+
		"WHERE FK_idConsulta = '"+pidConsulta+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		examenes = new Vector<Examen>();
		if(rs.next()){
			do {
				examen = new Examen (rs.getString("nombre"), rs.getString("fechSolicitud"), rs.getString("fechRealizacion"),
						rs.getString("descrip"), rs.getString("FK_idConsulta"));
				examenes.add(examen);
				} while (rs.next());
			} else {
				throw new Exception ("No hay examenes de ese paciente.");
		}
		rs.close();
		
		return examenes;
	}
	/**
	 *
	 *
	 */	
	public Examen buscarExamen(String pid)throws
	java.sql.SQLException,Exception{
		Examen examen = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT nombre, fechSolicitud, fechRealizacion, descrip, FK_idConsulta "+
		"FROM TExamen "+
		"WHERE id='"+pid+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if(rs.next()){
			do {
				examen = new Examen (rs.getString("nombre"), rs.getString("fechSolicitud"), rs.getString("fechRealizacion"),
						rs.getString("descrip"), rs.getString("FK_idConsulta"));
				
				} while (rs.next());
			} else {
				throw new Exception ("No hay examenes de ese paciente.");
		}
		rs.close();
		
		return examen;
	}
		
	
	/**
	 *
	 *
	 */	
	public void modificar(String pnombre, String pfechaRealiz, String pidConsulta)throws Exception{
		String sql;
		sql = "UPDATE  TExamen "+
		"SET nombre='"+pnombre+"' "+
		"SET fechRealizacion = '"+pfechaRealiz+"'"+
		"WHERE FK_idConsulta='"+pidConsulta+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El examen no está registrado.");
		}
	}
	/**
	 *
	 *
	 */	
	public  void borrar(Examen pexamen) throws 
	java.sql.SQLException,Exception{
		String sql;
		sql = "DELETE FROM TExamen "+
		"WHERE FK_idConsulta ='"+pexamen.getIdConsulta()+"'" +  "AND nombre = '"+pexamen.getNombreExamen()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El examen no existe.");
		}
	}
}
