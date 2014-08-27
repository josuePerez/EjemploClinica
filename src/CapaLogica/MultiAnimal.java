package CapaLogica;

import java.sql.*;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import CapaAccesoBD.Conector;

public class MultiAnimal {
	/**
	 *
	 *
	 */	
	public  Animal crear(String pidentificacion, String pnombre, String praza, String pedad, String pfechaNac, String pidResponsable) throws Exception{
		Animal animal=null;
		String sql;
		sql="INSERT INTO TAnimal "+
		"(identificacion, nombre, raza, edad, fechaNac, FK_idResponsable)"+
		"VALUES ('"+pidentificacion+"', '"+pnombre+"', '"+praza+"', '"+pedad+"', '"+pfechaNac+"', '"+pidResponsable+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			animal = new Animal(pidentificacion, pnombre, praza, pedad, pfechaNac, pidResponsable);
		}
		catch (Exception e) {
			throw new Exception ("La identificacion del animal ya está en el sistema.");
		}
		return animal;
	}
	
	public  Animal crear(String pidentificacion, String pnombre, String praza, String pedad, String pfechaNac, String pidResponsable,
			String panimalMadre, String panimalPadre) throws Exception{
		Animal animal=null;
		String sql;
		sql="INSERT INTO TAnimal "+
		"(identificacion, nombre, raza, edad, fechaNac, FK_idResponsable, animalMadre, animalPadre)"+
		"VALUES ('"+pidentificacion+"', '"+pnombre+"', '"+praza+"', '"+pedad+"', '"+pfechaNac+"', '"+pidResponsable+"', '"+panimalMadre+"'" +
				", '"+panimalPadre+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			animal = new Animal(pidentificacion, pnombre, praza, pedad, pfechaNac, pidResponsable, panimalMadre, panimalPadre);
		}
		catch (Exception e) {
			throw new Exception ("La identificacion del animal ya está en el sistema.");
		}
		return animal;
	}
	

	/**
	 *
	 *
	 */	
	public  Animal buscar(String pidentificacion) throws
			java.sql.SQLException,Exception{
		Animal animal = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT identificacion,nombre,raza,edad,fechaNac,Fk_idResponsable "+
		"FROM TAnimal "+
		"WHERE identificacion='"+pidentificacion+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			animal = new Animal(
				rs.getString("identificacion"),
				rs.getString("nombre"),
				rs.getString("raza"),
				rs.getString("edad"),
				rs.getString("fechaNac"),
				rs.getString("Fk_idResponsable"));
		} else {
			throw new Exception ("El animal no está registrado.");
		}
		rs.close();
		return animal;
	}
	
	
	
	
	/**
	 *
	 *
	 */	
	public  Vector buscarPorResponsable(String pidentificacion) throws java.sql.SQLException,Exception{
		java.sql.ResultSet rs;
	String sql;
	Animal animal=null;
	Vector mascotas=null;
	sql="SELECT identificacion,nombre,raza,edad,fechNac,Fk_idResponsable "+
	"FROM TAnimal "+
	"WHERE Fk_idResponsable='"+pidentificacion+"';";
	rs = Conector.getConector().ejecutarSQL(sql,true);
	mascotas = new Vector();
	while (rs.next()){
		animal = new Animal(
			rs.getString("identificacion"),
			rs.getString("Nombre"),
			rs.getString("Raza"),
			rs.getString("edad"),
			rs.getString("fechaNac"),
			rs.getString("FK_idResponsable"));
			mascotas.add(animal);
	}
	rs.close();
	return mascotas;
}
	
	public  Vector buscarPorVeterinario(String pidVeterinario) throws java.sql.SQLException,Exception{
		java.sql.ResultSet rs;
	String sql;
	Animal animal=null;
	Vector mascotas=null;
	sql="SELECT identificacion,nombre,raza,edad,fechaNac,Fk_idResponsable "+
	"FROM TAnimal "+
	"WHERE Fk_idResponsable='"+pidVeterinario+"';";
	rs = Conector.getConector().ejecutarSQL(sql,true);
	mascotas = new Vector();
	while (rs.next()){
		animal = new Animal(
			rs.getString("identificacion"),
			rs.getString("nombre"),
			rs.getString("raza"),
			rs.getString("edad"),
			rs.getString("fechaNac"),
			rs.getString("Fk_idResponsable"));
			mascotas.add(animal);
	}
	rs.close();
	return mascotas;
}
	
	public  void borrar(Animal animal) throws 
	java.sql.SQLException,Exception{
		String sql;
		sql = "DELETE FROM TAnimal "+
		"WHERE identificacion ='"+animal.getIdentificacion()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("El animal no existe.");
		}
	}

}
