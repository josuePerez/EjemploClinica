package CapaLogica;

import CapaAccesoBD.Conector;

public class MultiItem {
	
	public Item crear(String pid, String pidResul, String pnombre, String pvalor, String punidadMed, double plimiteInfe, double plimiteSup)throws Exception{
		Item item = null;
		String sql;
		sql = "INSERT INTO TItem "+
		"(identificacion, Fk_idResul, nombre, valor, unidadMedicion, limiteInfe, limteSup) "+
		"VALUES ('"+pid+"','"+pidResul+"','"+pnombre+"','"+pvalor+"','"+punidadMed+"','"+plimiteInfe+"','"+plimiteSup+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			item = new Item (pid, pidResul, pnombre,  pvalor,  punidadMed, plimiteInfe, plimiteSup);
			
		}
		catch (Exception e) {
			
			throw new Exception ("El item ya existe en el sistema.");
		}
		return item;
	}
	
	public Item buscar(String pidResul)throws java.sql.SQLException,Exception{
		Item item = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TItem "+
		"WHERE Fk_idResul = '"+pidResul+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if(rs.next()){
			item = new Item(rs.getString("identificacion"),
							rs.getString("Fk_idResul"),
							rs.getString("nombre"), 
							rs.getString("valor"), 
							rs.getString("unidadMedicion"),
							rs.getDouble("limiteInfe"),
							rs.getDouble("limiteSup"));
		}else{
			throw new Exception ("El item no existe");
		}
		rs.close();
		
		return item;
	}

}
