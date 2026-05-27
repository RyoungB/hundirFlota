package es.hundirflota;

public class IniciarAplicacion {

	public static void main(String[] args) {
		
		//iniciar la matriz
		int [][] barcos = new int[10][10];
		
		//recorrido del array
		for(int filas = 0; filas < barcos.length; filas++) {
			for(int columnas = 0; columnas <barcos[filas].length; columnas++) {
				barcos[filas][columnas] = 0;
				System.out.print(barcos[filas][columnas]+ " ");
			}
			System.out.println();
		}

	}

}
