package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.Query;

import files.CustomReadFile;
import files.CustomWriteFile;

public class Record {
	final private int MAX_JUGADORES = 10;
	private int cont = 0;
	private Jugador[] jugadores;
	private int max = 0;
	
	public Record() {
		this.cont = 0;
		this.max = 0;
		this.jugadores = new Jugador[MAX_JUGADORES];
	}
	/**
	 * añadirJugador: método que recibe por parámetro un Jugador y lo añade al array jugadores
	 * si llega a más de 10 jugadores el siguiente lo actualiza con el jugador que menos puntos
	 * tenga del array.
	 * @param _jugador recibe un Objeto de tipo Jugador
	 */
	public void anadirJugador(Jugador _jugador) {
		if (this.cont < this.MAX_JUGADORES) {
			this.jugadores[cont] = _jugador;
			this.cont++;
		} else {
			this.jugadores[MAX_JUGADORES -1] = _jugador;
			}
	}
	/**
	 * maximo: metodo que se va a encargar de determinar cuantos jugadores hay hasta el momento
	 * en el array.
	 */
	public void maximo() {
		if (cont < MAX_JUGADORES) {
			max = cont;
		} else {
			max = MAX_JUGADORES;
		}
	}
	/**
	 * ordenarRanking: método que ordena de mayor a menor los jugadores por su puntuacion.
	 */
	public void ordenarRanking() {
		maximo();
		for (int i = 0; i < this.max - 1; i++) {
			for (int j = 0; j < this.max - 1; j++) {
				if (jugadores[j].getPuntuacion() < jugadores[j + 1].getPuntuacion()) {
					Jugador temp = jugadores[j + 1];
					jugadores[j + 1] = jugadores[j];
					jugadores[j] = temp;
				}
			}
		}
	}
	/**
	 * showRanking: Muetra los 10 mejores jugadores
	 */
	public void showRanking() {
		maximo();
		for (int i = 0; i < this.max; i++) {
			System.out.println(i + 1 + "." + jugadores[i].getNombre() + " " + jugadores[i].getPuntuacion());
		}
	}
	/**
	 * buscarJugador: Recibe un string el cual usa para buscar en el array jugadores para encontrar
	 * el jugador con el mismo nombre y devuelve el objeto jugador. Si no lo encuentra devuelve null
	 * @param _nombre Recibe un String
	 * @return Devuelve un tipo Jugador o null.
	 */
	public Jugador buscarJugador(String _nombre) {
		maximo();
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < max) {
			if (_nombre.equals(jugadores[i].getNombre()))
				encontrado = true;
			else
				i++;
		}
		if (encontrado) {
			return jugadores[i];
		} else {
			return null;
		}
	}
	/**
	 * showRanking: método que muestra el mejor jugador pero si hay más de un jugador con la misma
	 * puntuacion que el primero también los muestra.
	 */
	public void showBestPlayer() {
		int i = 1;
		System.out.println("1." + jugadores[0].getNombre() + " " + jugadores[0].getPuntuacion());
		while (i < this.max) {
			if (jugadores[0].getPuntuacion() == jugadores[i].getPuntuacion()) {
				System.out.println(i + 1 + "." + jugadores[i].getNombre() + " " + jugadores[i].getPuntuacion());
				i++;
			} else
				i++;

		}
	}
	/**
	 * escribirRanking: método que recorre el array jugadores y llama al metodo writefile 
	 * para escribir en el fichero la puntuacion y el nombre de los jugadores.
	 */
	public void escribirRanking() {
		try {
			this.maximo();
			CustomWriteFile w = new CustomWriteFile("C:\\Users\\artur\\OneDrive\\Escritorio\\1ºGS DAM\\Programación\\Eclipse\\Eclipse\\SimonDice3\\src\\data\\jugadores.txt");
			String nombre = "";
			for (int i = 0; i < this.max; i++) {
				 nombre = this.jugadores[i].getPuntuacion() + " " + this.jugadores[i].getNombre() + "\n";
				 w.writeFile(nombre);
			}
			w.closeWriteFile();
		} catch (IOException e) {
			System.out.println(e);
			
		}
	}
	/**
	 * metodo cargarRanking: metodo que se encarga de leer del fichero con el metodo leerJugadores 
	 * de la clase custom read file
	 */
	public void cargarRanking() throws IOException{
			CustomReadFile r = new CustomReadFile("C:\\Users\\artur\\OneDrive\\Escritorio\\1ºGS DAM\\Programación\\Eclipse\\Eclipse\\SimonDice3\\src\\data\\top.txt");
			ArrayList<Jugador> a = new ArrayList<Jugador>();
			a = r.leerJugadores();
			if(a == null) {
				return;
			}
			for(int i = 0; i < a.size() && i < MAX_JUGADORES; i++) {
				anadirJugador(a.get(i));
			}
		
	}
}
