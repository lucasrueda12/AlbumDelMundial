package albumMundial;

public class Figurita {
	private static Integer cont=0;
	private Integer _id;
	private String _tipo;
	private int _numJugador;
	private String _nombrePais;

	public Figurita(String tipo, int numJugador, String nombrePais) {
		cont++;
		_tipo = tipo;
		_numJugador = numJugador;
		_nombrePais = nombrePais;
		_id = cont;
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
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Figurita)) {
			return false;
		}
		
		Figurita fig = (Figurita) obj;
		
		if(_numJugador == fig.get_numJugador() && _nombrePais.equals(fig.get_nombrePais()) && _tipo.equals(fig.get_tipo())) {
			return true;
		}
		return false;
	}
}
