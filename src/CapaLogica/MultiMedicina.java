package CapaLogica;

import java.sql.*;
import java.io.*;
import java.util.*;

import CapaAccesoBD.Conector;

public class MultiMedicina {
	/**
	 *
	 *
	 */	
	public  Medicina crear(String pnombre, String pdosis, String pnumDias, String pidConsulta, String pfechaInicio,String pfechaFinal,
			String pprecauciones)
			throws Exception{
		Medicina med=null;
		String sql;
		sql = "INSERT INTO TMedicina "+
		"(nombre, dosis, numDias, FK_IdConsulta, fechaInicio, fechaFinal, precauciones) "+
		"VALUES ('"+pnombre+"', '"+pdosis+"', '"+pnumDias+"', '"+pidConsulta+"', '"+pfechaInicio+"', '"+pfechaFinal+"', '"+pprecauciones+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			med = new Medicina (pnombre, pdosis, pnumDias, pidConsulta, pfechaInicio, pfechaFinal, pprecauciones);
		}
		catch (Exception e) {
			throw new Exception ("No se ha registrado la medicina.");
		}
		return med;
	}
	/**
	 *
	 *
	 */	
	public Vector buscar(String pidConsulta)throws
	java.sql.SQLException,Exception{
		Medicina medicina = null;
		Vector  medicinas;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id, nombre,dosis, numDias, FK_idConsulta, fechaInicio, fechaFinal, precauciones "+
				"FROM TMedicina "+
				"WHERE FK_idConsulta='"+pidConsulta+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		medicinas = new Vector<Medicina>();
		if(rs.next()){
			do {
				medicina = new Medicina (rs.getString("nombre"), rs.getString("dosis"), rs.getString("numDias"),
						rs.getString("FK_idConsulta"), rs.getString("fechaInicio"), rs.getString("fechaFinal"), rs.getString("precauciones"));
				medicinas.add(medicina);
				} while (rs.next());
			} else {
				throw new Exception ("No hay examenes de ese paciente.");
		}
		rs.close();
		
		return medicinas;
	}

	
	
	
}
