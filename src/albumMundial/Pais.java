package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pais {

	private String _nombre;
	private Integer _ranking;
	private List<Figurita> _figuritasDeJugadores;

	public Pais(String nombre, Integer ranking) {
		_nombre = nombre;
		_ranking = ranking;
		_figuritasDeJugadores = new ArrayList<>();
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Figuritas obtenidas: ");
		sb.append("\n");
		for(Figurita figurita : _figuritasDeJugadores) {
			sb.append(figurita);
			sb.append("\n");
		}
		return sb.toString();
	}

	public boolean sePegoFigPais(Figurita figurita) {

		if (figurita == null) {
			return true;
		}
		if (_figuritasDeJugadores.size() == 0) {
			return false;
		}

		return _figuritasDeJugadores.contains(figurita);
	}

	public void pegarFigPais(Figurita figurita) {
		if (figurita == null) {
			throw new RuntimeException("figurita nulla");
		}
		if (!sePegoFigPais(figurita)) {
			_figuritasDeJugadores.add(figurita);
		}
	}

	public boolean estaCompletoPais() {
		return _figuritasDeJugadores.size() == 12;
	}
}
