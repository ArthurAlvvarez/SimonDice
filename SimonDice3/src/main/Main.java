package main;

import java.io.IOException;

/**
 * Clase Main
 */
public class Main {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Engine jugar = new Engine();
		jugar.start();
		/*Record jugadores = new Record();
		jugadores.cargarRanking();
		jugadores.showRanking();*/
		/*Jugador jugador1 = new Jugador("Arturo");
		Jugador jugador2 = new Jugador("Alvaro");
		Jugador jugador3 = new Jugador("Pacheco");
		Jugador jugador4 = new Jugador("Jonathan");
		Jugador jugador5 = new Jugador("Ruben");
		Jugador jugador6 = new Jugador("JC");
		Jugador jugador7 = new Jugador("Gabi");
		Jugador jugador8 = new Jugador("Fer");
		Jugador jugador9 = new Jugador("Oscar");
		Jugador jugador10 = new Jugador("Jose");
		Jugador jugador11 = new Jugador("Carlos");
		jugador1.setPuntuacion(150);
		jugador2.setPuntuacion(10);
		jugador3.setPuntuacion(20);
		jugador4.setPuntuacion(60);
		jugador5.setPuntuacion(608);
		jugador6.setPuntuacion(100);
		jugador7.setPuntuacion(200);
		jugador8.setPuntuacion(608);
		jugador9.setPuntuacion(5);
		jugador10.setPuntuacion(107);
		jugador11.setPuntuacion(109);
		jugadores.añadirJugador(jugador1);
		jugadores.añadirJugador(jugador2);
		jugadores.añadirJugador(jugador3);
		jugadores.añadirJugador(jugador4);
		jugadores.añadirJugador(jugador5);
		jugadores.añadirJugador(jugador6);
		jugadores.añadirJugador(jugador7);
		jugadores.añadirJugador(jugador8);
		jugadores.añadirJugador(jugador9);
		jugadores.añadirJugador(jugador10);
		jugadores.añadirJugador(jugador11);
		jugadores.showRanking();
		jugadores.ordenarRanking();
		jugadores.escribirRanking();
		/*System.out.println(jugadores.buscarJugador("Arturo"));
		jugadores.showBestPlayer();*/
		

	}
}