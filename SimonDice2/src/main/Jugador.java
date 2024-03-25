package main;

/**
 * clase Jugador
 */
public class Jugador {
	private int puntuacion;
	private String nombre;

	/**
	 * 
	 * @param _nombre recibe una variable de tipo String
	 */
	public Jugador(String _nombre) {
		this.nombre = _nombre;
		this.puntuacion = 0;
	}

	/**
	 * 
	 * @return devuelve la variable int puntuación
	 */
	public int getPuntuacion() {
		if(this.puntuacion < 0) {
			return this.puntuacion = 0;
		}else {
			return this.puntuacion;
		}
		
	}
	/**
	 * metodo que recibe el valor de puntuacion
	 */
	public void setPuntuacion(int x) {
		this.puntuacion = x;
	}

	/**
	 * 
	 * @return devuelve nombre que es de tipo String
	 */
	public String getNombre() {
		return this.nombre;
	}
}