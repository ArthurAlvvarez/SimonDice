package files;

import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	private FileWriter w;
	
	/**
	 * constructora que recibe un string y ese string se le pasa por parámetros a la llamada de la
	 * constructora de la que hereda la clase.
	 * @param mensaje
	 * @throws IOException
	 */
	public CustomWriteFile(String mensaje) throws IOException {
		super(mensaje);
		this.w = new FileWriter("C:\\Users\\artur\\OneDrive\\Escritorio\\1ºGS DAM\\Programación\\Eclipse\\Eclipse\\SimonDice3\\src\\data\\top.txt");
	}
	

	@Override
	/**
	 * writeFile: método que recibe un string y lo escribe en el fichero.
	 */
	public void writeFile(String mensaje) {
		try {
			this.w.write(mensaje);
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}
	}
	
	@Override
	/**
	 * closeWriteFile: método que cierra la escritura en fichero.
	 */
	public void closeWriteFile() {
		try {
			this.w.close();
		} catch (IOException e) {
			System.out.println("No se puede cerrar el scanner de escritura");
		}
	}
}
