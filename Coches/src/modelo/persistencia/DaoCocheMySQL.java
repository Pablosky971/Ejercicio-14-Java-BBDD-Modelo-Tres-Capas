package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySQL implements DaoCoche{

	private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/coches";
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
	
	public boolean altaCoche(Coche c) {
		if(!abrirConexion()) {
			return false;
		}
		
		boolean alta = true;
		String query = "insert into coches (MATRICULA,MARCA,MODELO,KILOMETROS) " + " values(?,?,?,?)";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKilometros());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
				
			}
			
		} catch(SQLException e) {
			System.out.println("Error al insertar nuevo coche al ejecutar el alta " + c);
			alta = false;
			
			
		} finally { 
			cerrarConexion();
		}
		return alta;
	}


	public boolean bajaCoche(int id) {
		if(!abrirConexion()) {
			return false;
		}
		
		boolean baja = true;
		String query = "delete from coches where id = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
		
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				baja = false;
				
			}
			
		} catch(SQLException e) {
			System.out.println("Error al dar de baja al coche con id " + id);
			baja=false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return baja;
	}


	public boolean modificarCoche(Coche c) {
		if(!abrirConexion()) {
			return false;
		}
		
		boolean update = true;
		String query = "update coches set MATRICULA=?, MARCA=?, MODELO=?, KILOMETROS=? " + "WHERE ID=?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKilometros());
			ps.setInt(5, c.getId());
			
			
		} catch(SQLException e) {
			System.out.println("Error al modificar al coche " + c);
			update=false;
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		
		return update;
	}


	public Coche buscarCocheId(int id) {
		if(!abrirConexion()) {
			return null;
		}
		
		Coche c = null;
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches " + "where id = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setMarca(rs.getString(3));
				c.setModelo(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
			}
			
		} catch(SQLException e) {
			System.out.println("Error al obtener el coche con id " + id);
			c=null;
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		return c;
	}


	public Coche buscarCocheMatricula(String matricula) {
		if(!abrirConexion()) {
			return null;
		}
		
		Coche c = null;
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches " + "where matricula = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setMarca(rs.getString(3));
				c.setModelo(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
			}
			
		} catch(SQLException e) {
			System.out.println("Error al obtener el coche con matricula " + matricula);
			c=null;
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		return c;
	}


	public Coche buscarCocheMarca(String marca) {
		if(!abrirConexion()) {
			return null;
		}
		
		Coche c = null;
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches " + "where marca = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setMarca(rs.getString(3));
				c.setModelo(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
			}
			
		} catch(SQLException e) {
			System.out.println("Error al obtener el coche con marca " + marca);
			c=null;
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		return c;
		
	}

	public Coche buscarCocheModelo(String modelo) {
		if(!abrirConexion()) {
			return null;
		}
		
		Coche c = null;
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches " + "where modelo = ?";
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setMarca(rs.getString(3));
				c.setModelo(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
			}
			
		} catch(SQLException e) {
			System.out.println("Error al obtener el coche con modelo " + modelo);
			c=null;
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		return c;
	}


	public List<Coche> coches() {
		
		if(!abrirConexion()) {
			return null;
		}
		
		List<Coche> l = new ArrayList<>();
		String query = "select ID,MATRICULA,MARCA,MODELO,KILOMETROS from coches";
		
		
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Coche c = new Coche();
				c.setId(rs.getInt(1));
				c.setMatricula(rs.getString(2));
				c.setMarca(rs.getString(3));
				c.setModelo(rs.getString(4));
				c.setKilometros(rs.getDouble(5));
				
				l.add(c);
			}
			
		} catch(SQLException e) {
			System.out.println("Error al obtener los coches registrados en el sistema");
			
			e.printStackTrace();
			
		} finally {
			cerrarConexion();
		}
		
		return l;
	}

}
