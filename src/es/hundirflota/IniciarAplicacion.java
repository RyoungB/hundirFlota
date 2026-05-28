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
		
		
		
		//4.Menu
		ejecutarMenu(barcos);
		//2. rellenar por ceros
		//inicializarTablero(barcos);
		//3.Colocación de los barcs
		//colocarBarcos(barcos);
	}
		
		
		
		
		
		
		
	
	//metodo para rellenar 
	/*public static void inicializarTablero(int [][] tablero) {
		//recorrido del array
		for(int filas = 0; filas < tablero.length; filas++) {
			for(int columnas = 0; columnas <tablero[filas].length; columnas++) {
				tablero[filas][columnas] = 0;
				//System.out.print(tablero[filas][columnas]+ " ");
			}
			//System.out.println();
		}
		
	}*/
	
	//fin de inicializarTablero
	

	
	//metodo para pintar los barcos
   public static void mostrarTablero(int [][] tablero) {
	   System.out.println("\n=== TABLERO DE JUEGO ===");
		//recorrido del array
		for(int filas = 0; filas < tablero.length; filas++) {
			for(int columnas = 0; columnas <tablero[filas].length; columnas++) {
				//tablero[filas][columnas] = 0; PONE LA MATRIZ A 0
				//System.out.print(tablero[filas][columnas]+ " ");
				System.out.print((tablero[filas][columnas] == 0 ? " - " : "B") + " ");
			}
			System.out.println();
		}
		
		System.out.println("\n======================================");
   }

   
   
   //metodo de prueba para mostrar los barcos 
   public static void colocarBarcos(int [][] tablero) {
	   // Establecer el tamaño del barco
	 System.out.println(" Introduce el tamaño del barco (1-4 casillas)");
	 int tamano = teclado.nextInt();
	 if (tamano < 1 || tamano > 4){
		 System.out.println("Tamaño inválido");
		 return;
	 }
	 
	 
	 //Orientacion del barco 
	 System.out.println("Introduce orientacion (H = Horizontal) , (V = Vertical)");
	 char orientacion = teclado.next().toUpperCase().charAt(0);
	 if(orientacion != 'H' && orientacion  != 'V') {
		 System.out.println("Orientacion inválida");
		 return;
	 }
	 
	 System.out.print("Introduce la fila (0-9):  ");
	 int fila = teclado.nextInt();
	 System.out.print("Introduce la columna (0-9):  ");
	 int columna = teclado.nextInt();
	 
	 // validacion para evitar la solapacion
	 
	 // 4. Validar si es posible colocarlo
	    if (posicionValida(tablero, fila, columna, tamano, orientacion)) {
	        // 5. Si es válido, se dibuja en la matriz cambiando los 0 por 1
	        insertarBarcoEnMatriz(tablero, fila, columna, tamano, orientacion);
	        System.out.println("Barco colocado!");
	    } else {
	        System.out.println(" No se puede colocar el barco.POSICIÓN INVÁLIDA!");
	    }
	 
	 
	 
	 
	 
	 
	 
  }

   
   //metodo para validar posicion del barco
   private static boolean posicionValida(int[][] tablero, int fila, int columna, int tamano, char orientacion) {
	   // Comprobar coordenadas iniciales básicas
	    if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) return false;

	    if (orientacion == 'H') {
	        // ¿Se sale por la derecha?
	        if (columna + tamano > 10) return false;
	        // ¿Choca con otro barco?
	        for (int i = 0; i < tamano; i++) {
	            if (tablero[fila][columna + i] != 0) return false;
	        }
	    } else if (orientacion == 'V') {
	        // ¿Se sale por abajo?
	        if (fila + tamano > 10) return false;
	        // ¿Choca con otro barco?
	        for (int i = 0; i < tamano; i++) {
	            if (tablero[fila + i][columna] != 0) return false;
	        }
	    }
	    return true;
   }
   
   
// Método que realiza la escritura final en la matriz
private static void insertarBarcoEnMatriz(int[][] tablero, int fila, int columna, int tamano, char orientacion) {
    if (orientacion == 'H') {
        for (int i = 0; i < tamano; i++) {
            tablero[fila][columna + i] = 1; 
        }
    } else if (orientacion == 'V') {
        for (int i = 0; i < tamano; i++) {
            tablero[fila + i][columna] = 1;
        }
    }
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
		case 2: colocarBarcos(tablero);break;
		case 3: System.out.println("Realizar disparo");break;
		case 4: System.out.println("añadir otro jugador");break;
		case 0: System.out.println("Fin del programa...\n"); return;
		default: imprimir("Opción inválida.\n");
	   }
   }
}
