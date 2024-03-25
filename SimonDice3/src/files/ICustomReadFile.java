package files;

import java.util.ArrayList;

import main.Jugador;

public interface ICustomReadFile {
	ArrayList<Jugador> leerJugadores();
	void closeReadFile();
}
