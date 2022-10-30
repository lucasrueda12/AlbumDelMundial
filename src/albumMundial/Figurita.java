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
}
