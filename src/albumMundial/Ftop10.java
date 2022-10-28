package albumMundial;

public class Ftop10 extends Figurita {

	private String _paisSede;
	private Integer _anio;
	private String _balon;

	public Ftop10(String nombreJugador, String nombrePais, String paisSede, Integer anio, String balon) {
		super("Top10", nombreJugador, nombrePais);

		_paisSede = paisSede;
		_anio = anio;
		_balon = balon;

	}

}
