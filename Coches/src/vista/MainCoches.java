package vista;

import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;

public class MainCoches {

	public static void main(String[] args) {
		System.out.println("Bienvenido al sistema de gestión de coches");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorCoche g = new GestorCoche();
		
		do {
			menu();
			System.out.println("Indica el número correspondiente a la opción que desee efectuar.");
			int opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Introduzca los valores del coche:");
				
				System.out.println("Matricula (recuerde que ha de ser única y tener una longitud de 7 caracteres):");
				String matricula = sc.next();
				
				System.out.println("Marca:");
				String marca = sc.next();
				
				System.out.println("Modelo:");
				String modelo = sc.next();
				
				System.out.println("Kilometros (recuerde que no puede ser un número negativo):");
				double km = sc.nextDouble();
				
				Coche c = new Coche();
				c.setMatricula(matricula);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKilometros(km);
				
				int alta = g.alta(c);
				
				if(alta==0) {
					System.out.println("Coche dado de alta con éxito");
				} else if(alta==1) {
					System.out.println("Ha ocurrido error en la conexión con la base de datos.");
				} else if(alta==2) {
					System.out.println("Error: la matrícula que ha establecido ya se encuentra registrada en el sistema.");
				} else if(alta==3) {
					System.out.println("Error: la matrícula ha de estar compuesta por 7 caracteres");
				} else {
					System.out.println("Error: el número de kilometros no puede ser negativo");
				}
				break;
			
			case 2:
				System.out.println("Introduzca el id del coche que quiere dar de baja: ");
				int id = sc.nextInt();
				
				boolean baja = g.baja(id);
				
				if(baja) {
					System.out.println("El coche indicado con id " + id + "se ha dado de baja con éxito.");
				} else {
					System.out.println("Error: no se ha logrado dar de baja al coche indicado.");
				}
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			
			case 9:
				fin=true;
				break;
			
			
			}
		}while(!fin);
		
		System.out.println("Fin de programa");
	}
	
	private static void menu() {
		
		System.out.println("1- Alta de persona");
		System.out.println("2- Eliminar coche por id");
		System.out.println("3- Modificar coche por id");
		System.out.println("4- Buscar coche por id");
		System.out.println("5- Buscar coche por matricula");
		System.out.println("6- Buscar coche por marca");
		System.out.println("7- Buscar coche por modelo");
		System.out.println("8- Listar todos los coches");
		System.out.println("9- Salir de la aplicación");
		
	}

}
