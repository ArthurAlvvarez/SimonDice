package main;

import java.util.Scanner;

/**
 * Clase Colores
 */
public class Colores {

	private Scanner sc = new Scanner(System.in);

	private enum tColores {
		Rojo, Verde, Azul, Dorado
	};

	final private int MAX_COLORES_SEQ = 12;
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * charToColor: recibe un char el cual se comprueba en el switch y devuelve uno
	 * de los colores del tipo tColores, si no existe el color devuelve null
	 * 
	 * @param _color recibe una variable de tipo char
	 * @return devuelve un color del tipo tColores
	 */
	public tColores charToColor(char _color) {
		char color = Character.toUpperCase(_color);
		switch (color) {
		case 'R':
			return tColores.Rojo;
		case 'V':
			return tColores.Verde;
		case 'A':
			return tColores.Azul;
		case 'D':
			return tColores.Dorado;
		default:
			return null;
		}
	}

	/**
	 * intToColor: recibe un int que lo compara con todos los posibles casos del
	 * switch y devuelve el color del tipo tColores equivalente.
	 * 
	 * @param _numero recibe una variable de tipo int
	 * @return devuelve un color de tipo tColores
	 */
	public tColores intToColor(int _numero) {
		switch (_numero) {
		case 0:
			return tColores.Rojo;
		case 1:
			return tColores.Verde;
		case 2:
			return tColores.Azul;
		case 3:
			return tColores.Dorado;
		default:
			return null;
		}
	}

	/**
	 * generarSecuencia: rellena de elementos todos los index del array con numeros
	 * aleatorios, se llama al metodo intToColor y por su parametro se pasa
	 * numeroaleatorio para generar colores aleatorios para todas las posiciones del
	 * array gracias al for.
	 * 
	 * @param _numColores recibe una variable de tipo int
	 */
	public void generarSecuencia(int _numColores) {
		int numeroAleatorio;
		for (int i = 0; i < MAX_COLORES_SEQ; i++) {
			numeroAleatorio = 0 + (int) (Math.random() * (_numColores - 0 + 1));
			this.secuenciaColores[i] = intToColor(numeroAleatorio);
		}
	}

	/**
	 * comprobarColor: comprueba si el color introducido por el usuario es correcto
	 * o falso comparando el elemento del array que se encuentra en la posicion que entra por parametros, con el colordel tipo tColores
	 * introducido por parámetros
	 * 
	 * @param _index recibe una variable de tipo int
	 * @param _color también recibe una variable de tipo tColores
	 * @return devuelve true o false
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;
	}

	/**
	 * mostrarSecuencia: muestra el numero de elementos del array que se le indique
	 * por parámetros
	 * 
	 * @param _numero recibe una variable de tipo int
	 */
	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}

	/**
	 * play: recoge todos los elementos anteriores y secrea un objeto de la clase
	 * jugador con el que poder identificarnos en el juego, un menú en el que
	 * saldremos del juego una vez pulsemos 0 y jugaremos introduciendo un 1 por
	 * pantalla, si el usuario acierta la secuencia se añadirá una más larga y así
	 * hasta que gane o pierda y vuelve al menú.
	 */
	public void play() {
		int opcion;
		int numeroSecuencia;
		int coloresSecuencia;
		boolean correcto;
		boolean hasGanado;
		System.out.println("¡Bienvenido a Simon Dice!");
		System.out.print("¿Como te llamas? ");
		String nombre = sc.nextLine();
		do {
			generarSecuencia(tColores.values().length -1);
			Jugador jugador1 = new Jugador(nombre);
			System.out.println("Hola " + jugador1.getNombre());
			numeroSecuencia = 1;
			coloresSecuencia = 3;
			correcto = true;
			hasGanado = false;

			System.out.println("¿Que quieres hacer?: \n" + "\n1.Jugar \n" + "0.Salir");
			opcion = sc.nextInt();
			sc.nextLine();

			while (coloresSecuencia <= MAX_COLORES_SEQ && correcto && hasGanado == false && opcion == 1) {
				System.out.print("Secuencia numero " + numeroSecuencia + ": ");
				mostrarSecuencia(coloresSecuencia);
				System.out.println("\n" + "Memoriza la secuencia y pulsa ENTER para continuar... (Enter)");
				sc.nextLine();
				for (int j = 0; j < 50; ++j) {
					System.out.println();
				}

				int i = 0;
				while (i < coloresSecuencia && correcto) {
					char caracter = sc.next().charAt(0);
					sc.nextLine();
					if (comprobarColor(i, charToColor(caracter))) {
						System.out.println("Bien");
						i++;
					} else {
						System.out.println("Vaya has fallado... Vuelve a intentarlo \n");
						correcto = false;
					}
				}

				if (correcto && coloresSecuencia < MAX_COLORES_SEQ) {
					System.out.println("¡Perfecto! Vamos a por la siguiente secuencia" + "\n");
					numeroSecuencia++;
					coloresSecuencia++;
				} else if (correcto && coloresSecuencia == MAX_COLORES_SEQ) {
					System.out.println("¡Enhorabuena, has ganado!");
					hasGanado = true;
				}

			}

		} while (opcion != 0);
		System.out.println("¡Hasta la proxima!");
	}
}
