package albumMundial;

import java.util.Objects;

public class Figurita {
	private Integer _id;
	private String _tipo;
	private int _numJugador;
	private String _nombrePais;

	public Figurita(String tipo, int numJugador, String nombrePais) {
		_tipo = tipo;
		_numJugador = numJugador;
		_nombrePais = nombrePais;
		set_id(hashCode());
	}
	
	@Override
	public String toString() {
		return String.format("%s - %d", _nombrePais, _numJugador);
	}
	
	public void set_id(int x) {
		_id = x;
	}
	public int get_id() {
		return _id;
	}
	
	public int get_numJugador(){
		return _numJugador;
	}
	
	
	public String get_tipo() {
		return _tipo;
	}

	public String get_nombrePais() {
		return _nombrePais;
	}

	@Override
	public int hashCode() {
		return ( _nombrePais.length() + _numJugador + _tipo.length())* 7 + _numJugador;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Figurita)) {
			return false;
		}
		
		Figurita fig = (Figurita) obj;
		
		return _numJugador == fig.get_numJugador() && _nombrePais.equals(fig.get_nombrePais()) && _tipo.equals(fig.get_tipo());
	}
	
}
