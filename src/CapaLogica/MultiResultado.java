package CapaLogica;

import CapaAccesoBD.Conector;

public class MultiResultado {
	
	public Resultado crear(String pidExamen, String plugarRealiz, String pfechaEntrega, String pdescrip)throws Exception{
		Resultado resultado = null;
		String sql;
		sql = "INSERT INTO TResultado "+
		"(idExamen, lugarRealiz, fechaEntrega, descrip) "+
		"VALUES ('"+pidExamen+"','"+plugarRealiz+"','"+pfechaEntrega+"','"+pdescrip+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			resultado = new Resultado (pidExamen, plugarRealiz, pfechaEntrega, pdescrip);
			
		}
		catch (Exception e) {
			
			throw new Exception ("El resultado ya existe en el sistema.");
		}
		return resultado;
	}
	
	public Resultado buscar(String pidExamen)throws java.sql.SQLException,Exception{
		Resultado resultado = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TResultado "+
		"WHERE idExamen = '"+pidExamen+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if(rs.next()){
			resultado = new Resultado(rs.getString("idExamen"),rs.getString("lugarRealiz"),
						rs.getString("fechaEntrega"), rs.getString("descrip"));
		}else{
			throw new Exception ("El resultado no existe");
		}
		rs.close();
		
		return resultado;
	}
}
