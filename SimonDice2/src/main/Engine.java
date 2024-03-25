package main;

import java.security.PublicKey;
import java.util.Scanner;

/**
 * Clase Engine
 */
public class Engine {

	private Scanner sc = new Scanner(System.in);

	private enum tColores {
		Rojo, Verde, Azul, Dorado, Blanco, Marron, Naranja
	};

	private enum tModo {
		Facil, Dificil;

	};

	final private int MAX_COLORES_SEQ = 15;
	final private int MAX_COLORES_FACIL = 3;
	final private int MAX_COLORES_DIFICIL = 6;
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	private int ayuda = 2;

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
		case 'B':
			return tColores.Blanco;
		case 'M':
			return tColores.Marron;
		case 'N':
			return tColores.Naranja;
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
		case 4:
			return tColores.Blanco;
		case 5:
			return tColores.Marron;
		case 6:
			return tColores.Naranja;
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
	 * o falso con el método equals
	 * 
	 * @param _index recibe una variable de tipo int
	 * @param _color también recibe una variable de tipo tColores
	 * @return devuelve true o false
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		tColores ColorSecuencia = secuenciaColores[_index];
		if (ColorSecuencia.equals(_color)) {
			return true;
		} else {
			return false;
		}
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
	 * usarAyuda: metodo que recibe que al llamarlo muestra el color del array en la
	 * posicion que entra por parametro.
	 * 
	 * @param _index recibe un int que equivale a la posicion iesima del array
	 * @return devuelve true o false dependiendo si quedan ayudas o no.
	 */
	public boolean usarAyuda(int _index) {
		if (ayuda > 0) {
			ayuda -= 1;
			System.out.println("El siguiente color es el: " + secuenciaColores[_index] + ". Te quedan " + ayuda + " ayudas.");
			return false;
		} else {
			System.out.println("No te quedan ayudas");
			return true;
		}
	}

	/**
	 * play: metodo que muestra las secuencias segun el usuario vaya acertanto,
	 * devuelve tambien la puntuacion por cada vez que aciertas. Si el modo de juego
	 * es dificil multiplica la puntuacion por 2.
	 * 
	 * @param _jugador    recibe un objeto de tipo jugador para poder sumar los
	 *                    puntos
	 * @param _dificultad recibe un tModo que equivale al modo de juego.
	 */
	public int play (tModo _dificultad) {
		int numeroSecuencia;
		int coloresSecuencia;
		int puntuacion = 0;
		boolean fallo;
		numeroSecuencia = 1;
		coloresSecuencia = 3;
		fallo = true;
		this.ayuda = 3;
		
		if(_dificultad == tModo.Dificil) {
			generarSecuencia(MAX_COLORES_DIFICIL);
		}else {
			generarSecuencia(MAX_COLORES_FACIL);
		}
		sc.nextLine();
		while (coloresSecuencia <= MAX_COLORES_SEQ && fallo) {
			System.out.print("Secuencia numero " + numeroSecuencia + ": ");
			mostrarSecuencia(coloresSecuencia);
			System.out.println("\n" + "Memoriza la secuencia de " + coloresSecuencia + " colores (X para la ayuda)");
			sc.nextLine();
			for (int j = 0; j < 50; ++j) {
				System.out.println();
			}
			int i = 0;
			while (i < coloresSecuencia && fallo) {
				char caracter = sc.next().charAt(0);
				sc.nextLine();
				if ((caracter == 'X' || caracter == 'x') && ayuda >= 1) {
					usarAyuda(i);
					puntuacion -= 8;
					i++;
				} else if ((caracter == 'X' || caracter == 'x') && ayuda < 1) {
					usarAyuda(i);

				} else if (comprobarColor(i, charToColor(caracter))) {
					System.out.println("Bien");
					i++;
					puntuacion += 2;
				} else {
					System.out.println("Vaya has fallado... Vuelve a intentarlo");
					fallo = false;
				}
			}

			if (fallo && coloresSecuencia < MAX_COLORES_SEQ) {
				System.out.println("¡Perfecto! Vamos a por la siguiente secuencia" + "\n");
				numeroSecuencia++;
				coloresSecuencia++;
				puntuacion += 8;
			} else if (fallo && coloresSecuencia == MAX_COLORES_SEQ) {
				System.out.println("¡Enhorabuena, has ganado!");
				puntuacion += 40;
				fallo = false;
			}
		}
		return puntuacion;
	}

	/**
	 * El metodo start se encarga de iniciar el juego en la dificultad que el
	 * usuario diga o de salir del juego
	 */
	public void start() {
		int opcion;
		System.out.println("¡Bienvenido a Simon Dice!");
		System.out.print("¿Como te llamas? ");
		String nombre = sc.nextLine();
		do {
			Jugador jugador1 = new Jugador(nombre);
			System.out.println("Hola " + jugador1.getNombre());
			System.out.println("¿Que quieres hacer?: \n" + "\n1.Jugar en modo facil \n" + "2.Jugar en modo dificil \n"
					+ "0.Salir");
			opcion = sc.nextInt();
			switch (opcion) {
			case 0:
				System.out.println("Hasta la proxima");
				break;
			case 1:
				jugador1.setPuntuacion(play(tModo.Facil));
				System.out.println("Puntuacion final: " + jugador1.getPuntuacion());
				break;
			case 2:
				jugador1.setPuntuacion(play(tModo.Dificil));
				System.out.println("Puntuacion final: " + jugador1.getPuntuacion() * 2);
				break;
			default:
				System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}
}