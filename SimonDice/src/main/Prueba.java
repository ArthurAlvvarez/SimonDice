package main;

import java.util.Scanner;

/**
 * Clase Main
 */
public class Prueba {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		enum tColores {
			ROJO, VERDE, AZUL, DORADO
		}
		;
		// System.out.println(tColores.1);
		Colores color = new Colores();

		//System.out.println(color.charToColor('v'));
		//System.out.println(color.intToColor(2) + "\n");
		//for (int i = 0; i < 12; i++) {
			//System.out.println(color.getSecuenciaColores()[i]);
		//}
		color.play();
		
		
		
		
		
		
		
		
		/*for (int i = 0; i < secuencia && correcto; i++) {
			if (comprobarColor(i, charToColor(caracter)) == false) {
				System.out.println("Bien");
				caracter = sc.next().charAt(0);
			} else {
				System.out.println("Inutil");
				correcto = false;
			}
		*/
	}

}
