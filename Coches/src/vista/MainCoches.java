package vista;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class MainCoches {

	public static void main(String[] args) {
		System.out.println("Bienvenido al sistema de gesti�n de coches");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorCoche g = new GestorCoche();
		
		do {
			menu();
			System.out.println("Indica el n�mero correspondiente a la opci�n que desee efectuar.");
			int opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduzca los valores del coche:");
				
				System.out.println("Matricula (recuerde que ha de ser �nica y tener una longitud de 7 caracteres):");
				String matricula = sc.next();
				
				System.out.println("Marca:");
				String marca = sc.next();
				
				System.out.println("Modelo:");
				String modelo = sc.next();
				
				System.out.println("Kilometros (recuerde que no puede ser un n�mero negativo):");
				double km = sc.nextDouble();
				
				Coche c = new Coche();
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKilometros(km);
				
				int alta = g.alta(c);
				
				if(alta==0) {
					System.out.println("Coche dado de alta con �xito");
				} else if(alta==1) {
					System.out.println("Ha ocurrido error en la conexi�n con la base de datos.");
				} else if(alta==2) {
					System.out.println("Error: la matr�cula que ha establecido ya se encuentra registrada en el sistema.");
				} else if(alta==3) {
					System.out.println("Error: la matr�cula ha de estar compuesta por 7 caracteres");
				} else {
					System.out.println("Error: el n�mero de kilometros no puede ser negativo");
				}
				break;
			
			case 2:
				System.out.println("Introduzca el id del coche que quiere dar de baja: ");
				int id = sc.nextInt();
				
				boolean baja = g.baja(id);
				
				if(baja) {
					System.out.println("El coche indicado con id " + id + " se ha dado de baja con �xito.");
				} else {
					System.out.println("Error: no se ha logrado dar de baja al coche indicado.");
				}
				break;
			
			case 3:
				System.out.println("Introduzca el id del coche que desea modificar, y los valores que desea establecer para cada uno de sus atributos.");
				
				System.out.println("Indique el id del coche que desea modificar");
				id = sc.nextInt();
				
				System.out.println("Matricula (recuerde que ha de ser �nica y tener una longitud de 7 caracteres):");
				matricula = sc.next();
				
				System.out.println("Marca:");
				marca = sc.next();
				
				System.out.println("Modelo:");
				modelo = sc.next();
				
				System.out.println("Kilometros (recuerde que no puede ser un n�mero negativo):");
				km = sc.nextDouble();
				
				c = new Coche();
				c.setId(id);
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKilometros(km);
				
				int update = g.modificar(c);
				
				if(update==0) {
					System.out.println("Coche indicado modificado con �xito");
				} else if(update==1) {
					System.out.println("Ha ocurrido error en la conexi�n con la base de datos.");
				} else if(update==2) {
					System.out.println("Error: la matr�cula que ha establecido ya se encuentra registrada en el sistema.");
				} else if(update==3) {
					System.out.println("Error: la matr�cula ha de estar compuesta por 7 caracteres");
				} else {
					System.out.println("Error: el n�mero de kilometros no puede ser negativo");
				}
				break;
			case 4:
				System.out.println("Introduzca el id del coche que quiere obtener: ");
				id = sc.nextInt();
				
				Coche ch = g.obtenerCocheId(id);
				
				if(ch != null) {
					System.out.println("Coche con id " + id + " obtenido");
					System.out.println(ch);
				} else {
					System.out.println("Error: el id que ha introducido no correponde a ning�n coche registrado en el sistema.");
				}
				break;
			case 5:
				System.out.println("Introduzca la matr�cula del coche que quiere obtener: ");
				matricula = sc.next();
				
				ch = g.obtenerCocheMatricula(matricula);
				
				if(ch != null) {
					System.out.println("Coche con matr�cula " + matricula + " obtenido");
					System.out.println(ch);
				} else {
					System.out.println("Error: la matr�cula que ha introducido no correponde a ning�n coche registrado en el sistema.");
				}
				break;
			case 6:
				System.out.println("Introduzca la marca del coche que quiere obtener: ");
				marca = sc.next();
				
				ch = g.obtenerCocheMarca(marca);
				
				if(ch != null) {
					System.out.println("Coche con marca " + marca + " obtenido");
					System.out.println(ch);
				} else {
					System.out.println("Error: la marca que ha introducido no correponde a ning�n coche registrado en el sistema.");
				}
				break;
			case 7:
				System.out.println("Introduzca la modelo del coche que quiere obtener: ");
				modelo = sc.next();
				
				ch = g.obtenerCocheModelo(modelo);
				
				if(ch != null) {
					System.out.println("Coche modelo " + modelo + " obtenido");
					System.out.println(ch);
				} else {
					System.out.println("Error: el modelo que ha introducido no correponde a ning�n coche registrado en el sistema.");
				}
				break;
			case 8:
				List<Coche> coches = g.listarCoches();
				
				int i = 1;
				for(Coche coche: coches) {
					
					System.out.println("Coche " + i);
					System.out.println("Identificador: " + coche.getId());
					System.out.println("Matr�cula: " + coche.getMatricula());
					System.out.println("Marca: " + coche.getMarca());
					System.out.println("Modelo: " + coche.getModelo());
					System.out.println("Kilometros: " + coche.getKilometros());
					
					i++;
				}
				break;
			
			case 9:
				fin=true;
				break;
			
			
			}
		}while(!fin);
		
		System.out.println("Fin de programa");
	}
	
	private static void menu() {
		
		System.out.println("1- Alta de coche");
		System.out.println("2- Eliminar coche por id");
		System.out.println("3- Modificar coche por id");
		System.out.println("4- Buscar coche por id");
		System.out.println("5- Buscar coche por matricula");
		System.out.println("6- Buscar coche por marca");
		System.out.println("7- Buscar coche por modelo");
		System.out.println("8- Listar todos los coches");
		System.out.println("9- Salir de la aplicaci�n");
		
	}

}
