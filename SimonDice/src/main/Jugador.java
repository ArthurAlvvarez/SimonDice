package main;

/**
 * clase Jugador
 */
public class Jugador {
	private int puntuacion;
	private String nombre;

	/**
	 * Jugador: constructora que establece un estado inicial de 0 en puntuación y con lo que recibimos por 
	 * parametro le damos un valor a nombre
	 * @param _nombre recibe una variable de tipo String
	 */
	public Jugador(String _nombre) {
		this.nombre = _nombre;
		this.puntuacion = 0;
	}

	/**
	 * getPuntuacion: devuelve el valor de puntuacion
	 * @return devuelve la variable int puntuación
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}
	/**
	 * getNombre: devuelve el valor de nombre
	 * @return devuelve nombre que es de tipo String
	 */
	public String getNombre() {
		return this.nombre;
	}
}
