package crearbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearCocheMySQL {

	private Connection conexion;
	public static void main(String[] args) {
		
		CrearCocheMySQL bd = new CrearCocheMySQL();
		bd.crearBBDD();
		
		
	}
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/coche";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean crearBBDD() {
		if(!abrirConexion()){
			return false;
		}
		boolean estaCreada = true;
		
		try {
			
			Statement state = conexion.createStatement();
			state.execute("CREATE TABLE coches ( id int(11) NOT NULL AUTO_INCREMENT,"
					+ " matricula varchar(45) DEFAULT NULL, marca varchar(45) DEFAULT NULL, modelo varchar(45) DEFAULT NULL, kilometros double DEFAULT NULL, PRIMARY KEY (id) );");
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al crear: ");
			estaCreada = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return estaCreada;
	}
		

	

}