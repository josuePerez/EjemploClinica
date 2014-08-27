package CapaLogica;

import java.util.*;

import javax.swing.JOptionPane;

import CapaAccesoBD.Conector;

public class MultiConsulta {
	/**
	 *
	 *
	 */	
	public Consulta crear(String pidConsulta,String pidVeterinario, String pfecha_realiz, String pdescrip_proble, String pidExpediente,
			String ppeso, String paltura,String plongEspal,String plongPecho,String pdiaCuello)
			throws Exception{
		Consulta consulta = null;
		Expediente expediente = null;
		String sql;
		sql = "INSERT INTO TConsulta "+
		"(id, FK_idVeterinario, fecha, descrip, FK_idExpediente, peso,altura, longEspal, longPecho, diaCuello) "+
		"VALUES ('"+pidConsulta+"','"+pidVeterinario+"','"+pfecha_realiz+"','"+pdescrip_proble+"','"+pidExpediente+"','"+ppeso+"','"+paltura+"'," +
				"'"+plongEspal+"'" +",'"+plongPecho+"','"+pdiaCuello+"');";
		
		try {
			
			Conector.getConector().ejecutarSQL(sql);
			consulta = new Consulta (pidConsulta, pidVeterinario, pfecha_realiz, pdescrip_proble, pidExpediente, ppeso,paltura, 
					plongEspal, plongPecho, pdiaCuello);
		}
		catch (Exception e) {
			
			throw new Exception ("El id de la consulta ya está en el sistema.");
		}
		return consulta;
	}
	/**
	 *
	 *
	 */	
	public Consulta buscar(String pidConsulta)throws java.sql.SQLException,Exception{
		Consulta consulta = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id, FK_idVeterinario, fecha, descrip, FK_idExpediente,peso,altura, longEspal, longPecho, diaCuello "+
		"FROM TConsulta "+
		"WHERE id = '"+pidConsulta+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if(rs.next()){
			consulta = new Consulta(rs.getString("id"),rs.getString("FK_idVeterinario"),
						rs.getString("fecha"), rs.getString("descrip"), rs.getString("FK_idExpediente"),rs.getString("peso"),
						rs.getString("altura"),rs.getString("longEspal"), rs.getString("longPecho"),rs.getString("diaCuello"));
		}else{
			throw new Exception ("La consulta no existe");
		}
		rs.close();
		
		return consulta;
	}
	
	public Vector<Consulta> buscarConsultas(String pidExpediente)throws 
	java.sql.SQLException,Exception{
		Consulta consulta = null;
		Vector <Consulta> consultas;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id, FK_idVeterinario, fecha, descrip, FK_idExpediente "+
		"FROM TConsulta "+
		"WHERE FK_idExpediente = '"+pidExpediente+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		consultas = new Vector<Consulta>();
		if(rs.next()){
			do {
				consulta = new Consulta (rs.getString("id"),rs.getString("FK_idVeterinario"),
						rs.getString("fecha"), rs.getString("descrip"), rs.getString("FK_idExpediente"),rs.getString("peso"),
						rs.getString("altura"),rs.getString("longEspal"), rs.getString("longPecho"),rs.getString("diaCuello"));
				consultas.add(consulta);
				} while (rs.next());
			} else {
				throw new Exception ("No hay consultas de ese paciente.");
		}
		rs.close();
		
		return consultas;
	}
	public Vector<Examen> buscarExamen(String pidConsulta)throws java.sql.SQLException,Exception{
		Examen examen = null;
		Vector<Examen> examenes;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id, nombre, fechSolicitud, fechRealizacion, descrip, FK_idConsulta "+
		"FROM TExamen "+
		"WHERE FK_idConsulta='"+pidConsulta+"';";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		examenes = new Vector <Examen>();
		if(rs.next()){
			do{
				examen = new Examen(rs.getString("nombre"), 
									rs.getString("fechSolicitud"),
									rs.getString("fechRealizacion"),
									rs.getString("descrip"),
									rs.getString("FK_idConsulta"));
				examenes.add(examen);
			} while (rs.next());
			
		}else {
			throw new Exception("No hay examenes en esa consulta");
		}
		rs.close();
		
		return examenes;
		
	}
}