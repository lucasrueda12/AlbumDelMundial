package albumMundial;

import java.util.Random;

public class Ftop10 extends Figurita {

	private String _paisSede;
	private String _balon;

	public Ftop10(String nombrePais, int numJugador, String paisSede, String balon) {
		super("Top10", numJugador, nombrePais);
		_paisSede = paisSede;
		_balon = balon;
	}

}
