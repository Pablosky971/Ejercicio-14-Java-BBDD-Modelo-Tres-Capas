package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySQL;
import modelo.persistencia.interfaces.DaoCoche;

public class GestorCoche {

	private DaoCoche daoCoche = new DaoCocheMySQL();
	
	public List<Coche> listarCoches() {
		List<Coche> l = daoCoche.coches();
		return l;
	}
	
	/**
	 * Método que da de alta a un coche en la base de datos, validando que cumpla con las reglas de negocio definidas.
	 * @param c es el coche al que se quiere dar de alta.
	 * @return 0 si se da de alta correctamente, 1 si falla la conexión con la base de datos, 2 si la matrícula del coche se encuentra ya registrada en el sistema, 3 si la matrícula no tiene siete caracteres,
	 * y 4 si el número de kilometros es negativo.
	 */
	public int alta(Coche c) {
		
		List<Coche> l = listarCoches();
		
		if(c.getMatricula().length() != 7) {
			return 3;
		}
		
		if(c.getKilometros() < 0) {
			return 4;
		}
		
		for(Coche ch: l) {
			
			if(c.getMatricula().equals(ch.getMatricula())) {
				continue;
				
			} else {
					return 2;
			
		}
		}	
		boolean alta = daoCoche.altaCoche(c);
				
		if(alta) {
				return 0;
		} else {
				return 1;
		}
				
				
}
	
	public boolean baja(int id) {
		boolean baja = daoCoche.bajaCoche(id);
		return baja;
	}
	
	/**
	 * Método que modifica un coche en la base de datos, validando que cumpla con las reglas de negocio definidas.
	 * @param c es el coche al que se quiere modificar.
	 * @return 0 si se da de alta correctamente, 1 si falla la conexión con la base de datos, 2 si la matrícula del coche se encuentra ya registrada en el sistema, 3 si la matrícula no tiene siete caracteres,
	 * y 4 si el número de kilometros es negativo.
	 */
	public int modificar(Coche c) {
		List<Coche> l = listarCoches();
				
				if(c.getMatricula().length() != 7) {
					return 3;
				}
				
				if(c.getKilometros() < 0) {
					return 4;
				}
				
				for(Coche ch: l) {
					
					if(c.getMatricula().equals(ch.getMatricula())) {
						continue;
						
					} else {
							return 2;
					
				}
				}	
				boolean update = daoCoche.modificarCoche(c);
						
				if(update) {
						return 0;
				} else {
						return 1;
				}
	}
	
	public Coche obtenerCocheId(int id) {
		Coche c = daoCoche.buscarCocheId(id);
		return c;
	}
	
	public Coche obtenerCocheMatricula(String matricula) {
	
		Coche c = daoCoche.buscarCocheMatricula(matricula);
		return c;
	}
	
	public Coche obtenerCocheMarca(String marca) {
		Coche c = daoCoche.buscarCocheMarca(marca);
		return c;
	}
	
	public Coche obtenerCocheModelo(String modelo) {
		Coche c = daoCoche.buscarCocheMarca(modelo);
		return c;
	}
	
	
					
		
	}

