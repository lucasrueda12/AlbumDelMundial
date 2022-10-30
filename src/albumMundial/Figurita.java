package albumMundial;

public class Figurita {
	private static Integer cont=0;
	private Integer _id;
	private String _tipo;
	private Integer _valorBase;
	private int _nombreJugador;
	private String _nombrePais;

	public Figurita(String tipo, int nombreJugador, String nombrePais) {
		cont++;
		_tipo = tipo;
		_nombreJugador = nombreJugador;
		_nombrePais = nombrePais;
		_id = cont;

	}
}
