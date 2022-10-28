package albumMundial;

public class Figurita {
	private static Integer cont;
	private Integer _id;
	private String _tipo;
	private Integer _valorBase;
	private String _nombreJugador;
	private String _nombrePais;

	public Figurita(String tipo, String nombreJugador, String nombrePais) {
		cont++;
		_tipo = tipo;
		_nombreJugador = nombreJugador;
		_nombrePais = nombrePais;
		_id = cont;

	}
}
