package CapaAccesoBD;





 
public class Conector{
	
	private static AccesoBD conectorBD = null;
	
	/**
	 *
	 *
	 */	
	public static AccesoBD getConector() throws 
	java.sql.SQLException,Exception{
		if (conectorBD == null){		
//			conectorBD = new AccesoBD("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:BDCxC","sa","jass2002")
			conectorBD = new AccesoBD("sun.jdbc.odbc.JdbcOdbcDriver","jdbc:odbc:ODBCCLINANIMV2","","");
			}
		return conectorBD;
	}
	
}