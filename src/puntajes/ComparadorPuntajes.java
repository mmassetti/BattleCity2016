package puntajes;

import java.util.Comparator;

public class ComparadorPuntajes implements Comparator<Puntaje> {
	public int compare(Puntaje puntaje1, Puntaje puntaje2) {

		int sc1 = puntaje1.getPuntaje();
		int sc2 = puntaje2.getPuntaje();

		if (sc1 > sc2)
			return -1;
		else 
			if (sc1 < sc2)
				return +1;
			else
				return 0;
	}
}