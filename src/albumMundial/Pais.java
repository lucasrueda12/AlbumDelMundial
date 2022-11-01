package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pais {

	private String _nombre;
	private Integer _ranking;
	private List<Figurita> _figuritasDeJugadores; // Falta definir;

	public Pais(String nombre, Integer ranking) {
		_nombre = nombre;
		_ranking = ranking;
		_figuritasDeJugadores = new ArrayList<>();
	}
	
	public boolean sePegoFigPais(Figurita f) {
		if(f == null) {
			return false;
		}
		if(_figuritasDeJugadores.size() == 0) {
			return false;
		}
		
		for(Figurita x: _figuritasDeJugadores) {
			if(x.equals(f)) return true;
		}
		return false;
	}
	
	public void pegarFigPais(Figurita f) {
		if(f == null) {
			throw new RuntimeException("figurita nulla");
		}
		if(!sePegoFigPais(f)) {
			_figuritasDeJugadores.add(f);
		}
	}
	
	public boolean estaCompletoP(){
		return _figuritasDeJugadores.size() == 12;
	}
}
