package puntajes;

import java.util.*;
import java.io.*;

public class AdministradorPuntajesAltos {

	// Un arreglo de tipo Puntaje que vamos a usar para trabajar con los
	// puntajes
	private ArrayList<Puntaje> puntajes;

	// El nombre del archivo donde se van a guardar los puntajes altos
	private static final String PuntajesAltos_FILE = "puntajes.dat";

	// Inicializando el input y el output para trabajar con el archivo
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;

	// Boolean que me chequea si es la primera vez que se ejecuta el juego, en
	// este caso el archivo no existe y es creado
	private boolean seEjecutoUnaVez = false;

	public AdministradorPuntajesAltos() {
		// Inicializa el arreglo
		puntajes = new ArrayList<Puntaje>();
	}

	public ArrayList<Puntaje> getPuntajes() {
		cargarArchivoPuntajes();
		ordenar();
		return puntajes;
	}

	private void ordenar() {
		ComparadorPuntajes comparador = new ComparadorPuntajes();
		Collections.sort(puntajes, comparador);
	}

	public void agregarPuntaje(String nombre, int puntaje) {
		cargarArchivoPuntajes();
		puntajes.add(new Puntaje(nombre, puntaje));
		actualizarArchivoPuntajes();
	}

	public void cargarArchivoPuntajes() {
		try {
			inputStream = new ObjectInputStream(new FileInputStream(PuntajesAltos_FILE));
			puntajes = (ArrayList<Puntaje>) inputStream.readObject();
		} catch (FileNotFoundException e) {
			if (!seEjecutoUnaVez) {
				seEjecutoUnaVez = true;
			} else {
				System.out.println("FileNotFound Error: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("InputOutput Error: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound Error: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("InputOutput Error: " + e.getMessage());
			}
		}
	}

	public void actualizarArchivoPuntajes() {
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(PuntajesAltos_FILE));
			outputStream.writeObject(puntajes);
		} catch (FileNotFoundException e) {
			System.out
					.println("FileNotFound Error: " + e.getMessage() + ",el programa intentara crear un nuevo archivo");
		} catch (IOException e) {
			System.out.println("InputOutput Error: " + e.getMessage());
		} finally {
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				System.out.println("[Update] Error: " + e.getMessage());
			}
		}
	}

	// Auxiliar
	public String getPuntajesAltos() {
		String highscoreString = "";
		int max = 5;

		ArrayList<Puntaje> scores;
		scores = getPuntajes();

		int i = 0;
		int x = scores.size();
		if (x > max) {
			x = max;
		}
		while (i < x) {
			highscoreString += (i + 1) + ".\t " + scores.get(i).getNombre() + " \t\t" + scores.get(i).getPuntaje()
					+ "\n";
			i++;
		}
		return highscoreString;
	}

}
