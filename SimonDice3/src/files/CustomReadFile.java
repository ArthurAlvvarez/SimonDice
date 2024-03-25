package files;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import main.Jugador;

public class CustomReadFile extends FileReader implements ICustomReadFile {
	private FileReader r;
	private Scanner sc;
	
	/**
	 * CustomReadFile: constructora que recibe un string y se lo pasa por parametros a la llamada de
	 * la constructora de la que hereda la clase.
	 * @param mensaje
	 * @throws FileNotFoundException
	 */
	public CustomReadFile(String mensaje) throws FileNotFoundException {
		super(mensaje);
		this.r = new FileReader("C:\\Users\\artur\\OneDrive\\Escritorio\\1ºGS DAM\\Programación\\Eclipse\\Eclipse\\SimonDice3\\src\\data\\top.txt");
		this.sc = new Scanner(this);
	}
	/**
	 * closeReadFile: cierra la lectura del fichero
	 */
	public void closeReadFile() {
		try {
			this.r.close();
		} catch (IOException e) {
			System.out.println("No se consigue cerrar el scanner de lectura");
		}
	}
	@Override
	/**
	 * leerJugadores: todos los jugadores del fichero los lee y los añade a un array list y lo retorna
	 */
	public ArrayList<Jugador> leerJugadores(){
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		while (sc.hasNextLine()) {
			int punt = sc.nextInt();
            String texto = sc.nextLine();
			Jugador j = new Jugador(texto);
			j.setPuntuacion(punt);
			jugadores.add(j);
		}
			closeReadFile();
			return jugadores;
	}

	

}
