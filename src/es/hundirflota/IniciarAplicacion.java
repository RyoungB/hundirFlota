package es.hundirflota;
import static es.genesis.utilidades.Impresion.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static es.genesis.utilidades.Colores.*;




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
	   imprimirln(WHITE_BACKGROUND_BRIGHT +"\n=== HUNDIR LA FLOTA  ===");
		//recorrido del array
		for(int filas = 0; filas < tablero.length; filas++) {
			for(int columnas = 0; columnas <tablero[filas].length; columnas++) {
				//tablero[filas][columnas] = 0; PONE LA MATRIZ A 0
				//System.out.print(tablero[filas][columnas]+ " ");
				
				int valor = tablero[filas][columnas];
				if(valor == 0)imprimir(ANSI_BLUE+" ~ ");
				else if( valor == 1) imprimir(ANSI_YELLOW+" 🚢 "); //Barco
				else if( valor == 2) imprimir(ANSI_RED+" 💥 ");// impacto
				else if( valor == -1) imprimir(ANSI_RED+" ❌ "); // disparo
			}
			System.out.println();
		}
		
		imprimirln(ANSI_RESET+"\n======================================");
   }

   
   
   //metodo de prueba para mostrar los barcos 
   private static void colocarBarcos(int [][] tablero) {
	   // Establecer el tamaño del barco
	   imprimirln(" Introduce el tamaño del barco (1-4 casillas)");
	 int tamano = teclado.nextInt();
	 if (tamano < 1 || tamano > 4){
		 imprimirln("Tamaño inválido");
		 return;
	 }
	 
	 
	 //Orientacion del barco 
	 imprimirln("Introduce orientacion (H = Horizontal) , (V = Vertical)");
	 char orientacion = teclado.next().toUpperCase().charAt(0);
	 if(orientacion != 'H' && orientacion  != 'V') {
		 imprimirln("Orientacion inválida");
		 return;
	 }
	 
	 imprimir("Introduce la fila (0-9):  ");
	 int fila = teclado.nextInt();
	 imprimir("Introduce la columna (0-9):  ");
	 int columna = teclado.nextInt();
	 
	 // validacion para evitar la solapacion
	 
	 // 4. Validar si es posible colocarlo
	    if (posicionValida(tablero, fila, columna, tamano, orientacion)) {
	        // 5. Si es válido, se dibuja en la matriz cambiando los 0 por 1
	        insertarBarcoEnMatriz(tablero, fila, columna, tamano, orientacion);
	        imprimirln("Barco colocado!");
	    } else {
	    	imprimirln(" No se puede colocar el barco.POSICIÓN INVÁLIDA!");
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
   private static void ejecutarMenu(int [][] tablero) {
	    
		cabeceraMenu = "      ----------------\n"+
					   "       	MENU PRINCIPAL DE HUNDIR LA FLOTA \n"+
					   "      ----------------\n";
		opcionesMenu.add("    1.Mostrar el tablero\n");
		opcionesMenu.add("    2.Colocar un  barco\n");
		opcionesMenu.add("    3.Realizar un disparo\n");
		opcionesMenu.add("    4.Añadir otro jugador\n");
		opcionSalir =   ("    0.Salir\n");
		
		
		int opcion;
		do {
			imprimirln(cabeceraMenu);
			for(String opc : opcionesMenu) {
				imprimirln(opc);
			}
			imprimir(opcionSalir);
			imprimir("Selecciona una opción: ");
			
			opcion = teclado.nextInt();
			ejecutarOpcion(opcion, tablero);
			
		}while(opcion != 0);
		
		
		
   }
   
   
   private static void ejecutarOpcion(int opcion, int [][] tablero) {
	   switch(opcion) {
	    case 1: mostrarTablero(tablero); break;
		case 2: colocarBarcos(tablero);break;
		case 3: realizarDisparo(tablero);break;
		case 4: System.out.println("Añadir otro jugador");break;
		case 0: System.out.println("Fin del programa...\n"); return;
		default: imprimirln("Opción inválida.\n");
	   }
   }
   
   
   
   
   
   //metodo para hundir el barco 
   private static void realizarDisparo(int [][] tablero) {
	   
	   //introducimos las coordenadas
	   imprimirln("Introduce la posición de la  fila: casillas (0-9)");
	   int fila = teclado.nextInt();
	   
	   imprimir("Introduce la posición de la columna: casillas  (0-9)");
	   int columna = teclado.nextInt();
	   
	   //validamos el disparo
	   
	   if(fila < 0 ||fila >= 10 || columna < 0 || columna >= 10){
		   System.out.println("El disparo es inválido.");
	   }
	   
	   
	   if(tablero[fila][columna] == 1) {
		   tablero[fila][columna] = 2;
		   imprimir(" !!!!!  BARCO TOCADO  !!!");
		   
		   
		   //comprobacion
		   if(barcoHundido(tablero)) {
			   imprimirln("BARCO HUNDIDO!!");
		   }
		   
	   }else if(tablero[fila][columna] == 0) {
		   tablero[fila][columna] = -1;
		   imprimirln("AGUA");
	   }else {
		   imprimirln("Ya has disparado aqui");
	   }
	 
	   
   }
   
   
   
   private static boolean barcoHundido(int[][] tablero) {
	   for(int i = 0; i < tablero.length; i++) {
		   for(int j = 0; j < tablero.length; j++) {
			   if(tablero[i][j] == 1) {
				   return false;
			   }
		   }
	   }
	   return true;
   }
}
