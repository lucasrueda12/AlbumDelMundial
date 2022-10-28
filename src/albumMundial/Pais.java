package albumMundial;

import java.util.Map;

public class Pais {

	private String _nombre;
	private Integer _ranking;
	private Map<Integer, Figurita> _figuritasDeJugadores; // Falta definir;

	public Pais(String nombre, Integer ranking) {
		_nombre = nombre;
		_ranking = ranking;
	}
}
