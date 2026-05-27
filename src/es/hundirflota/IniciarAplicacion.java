package es.hundirflota;
import static es.genesis.utilidades.Impresion.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class IniciarAplicacion {
     private static Scanner teclado = new Scanner(System.in);
     private static List<String> opcionesMenu = new ArrayList<>();
 	 private static List<String> listadoNombres = new ArrayList<>();
 	 private static String cabeceraMenu, opcionSalir;
 	 
	public static void main(String[] args) {
		InicializarAplicacion();

	}
	
	//metodos
	private static void InicializarAplicacion() {
		//iniciar la matriz
		//1.Creamos el tablero 10x10
		int [][] barcos = new int[10][10];
		
		
		
		//2. rellenar por ceros
		inicializarTablero(barcos);
		//3.Colocación de los barcs
		colocarBarcos(barcos);
		//4.Menu
		ejecutarMenu(barcos);
	}
		
		
		
		
		
		
		
	
	//metodo para rellenar 
	public static void inicializarTablero(int [][] tablero) {
		//recorrido del array
		for(int filas = 0; filas < tablero.length; filas++) {
			for(int columnas = 0; columnas <tablero[filas].length; columnas++) {
				tablero[filas][columnas] = 0;
				//System.out.print(tablero[filas][columnas]+ " ");
			}
			//System.out.println();
		}
		
	}
	
	//fin de inicializarTablero
	

	
	//metodo para pintar los barcos
   public static void mostrarTablero(int [][] tablero) {
	   System.out.println("\n=== TABLERO DE JUEGO ===");
		//recorrido del array
		for(int filas = 0; filas < tablero.length; filas++) {
			for(int columnas = 0; columnas <tablero[filas].length; columnas++) {
				tablero[filas][columnas] = 0;
				System.out.print(tablero[filas][columnas]+ " ");
			}
			System.out.println();
		}
		
		System.out.println("\n======================================");
   }

   
   
   //metodo de prueba para mostrar los barcos de manera inicial
   public static void colocarBarcos(int [][] tablero) {
	 tablero[0][9] = 1;
	 tablero[1][1] = 1;
   }

   
   
   //metodoMenu
   public static void ejecutarMenu(int [][] tablero) {
	    
		cabeceraMenu = "      ----------------\n"+
					   "       	MENU PRINCIPAL DE HUNDIR LA FLOTA \n"+
					   "      ----------------\n";
		opcionesMenu.add("    1.Iniciar el tablero\n");
		opcionesMenu.add("    2.Colocar el barco\n");
		opcionesMenu.add("    3.Realizar un disparo\n");
		opcionesMenu.add("    4.Añadir otro jugador\n");
		opcionSalir =   ("    0.Salir\n");
		
		
		int opcion;
		do {
			System.out.println(cabeceraMenu);
			for(String opc : opcionesMenu) {
				System.out.println(opc);
			}
			System.out.print(opcionSalir);
			System.out.print("Selecciona una opción: ");
			
			opcion = teclado.nextInt();
			ejecutarOpcion(opcion, tablero);
			
		}while(opcion != 0);
		
		
		
   }
   
   public static void ejecutarOpcion(int opcion, int [][] tablero) {
	   switch(opcion) {
	   case 1: mostrarTablero(tablero); break;
		case 2: System.out.println("Colocar el barco");break;
		case 3: System.out.println("Realizar disparo");break;
		case 4: System.out.println("añadir otro jugador");break;
		case 0: System.out.println("Fin del programa...\n"); return;
		default: imprimir("Opción inválida.\n");
	   }
   }
}
