package model;

import java.util.Scanner;

public class Vista {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Board tablero = new Board();
		boolean siguiente;
		boolean error = false;
		boolean error1 = false;
		int accion = 1;
		int contador = 0;
		int x;
		int y;
		
		
		for(int i = 0 ; i < 5 ; i++) {
			siguiente = false;
			do {
				switch(accion) {
				case 1:
					do {
						if(contador > 0) {
							tablero.deleteBarco(tablero.getShips()[i]);
						}
						
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println(tablero);
						System.out.println("    +-----------------------------------+");
						System.out.println("    Barco "+(i+1)+(error1 ? " ERROR, POSICION INCORRECTA" : " "));
						System.out.print("    Ingrese posicion en horizontal :");
						x = input.nextInt();
						System.out.print("    Ingrese posicion en vertical   :");
						y = input.nextInt();
						error = tablero.putBarco(tablero.getShips()[i], x, y);
						error1 = !error;
					}	while(!error);
					error = false;
					contador ++;
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println(tablero);
					System.out.println("    +-----------------------------------+");
					System.out.println("    Barco "+(i+1));
					System.out.println("    1. Reubicar   2. Girar   3. Siguiente");
					System.out.print("    Introduzca la accion a hacer: ");
					accion = input.nextInt();
					break;
				
				case 2:
					tablero.turnBarco(tablero.getShips()[i]);
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println(tablero);
					System.out.println("    +-----------------------------------+");
					System.out.println("    Barco "+(i+1));
					System.out.println("    1. Reubicar   2. Girar   3. Siguiente");
					System.out.print("    Introduzca la accion a hacer: ");
					accion = input.nextInt();
					break;
				
				case 3:
					siguiente = true;
					contador = 0;
					accion = 1;
				}
			} while(!siguiente);
		}

	}
}
