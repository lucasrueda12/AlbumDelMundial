package albumMundial;

import java.util.Random;

public class Ftop10 extends Figurita {
	
	private String _paisSede;
	private String _balon;

	public Ftop10( String nombrePais, String paisSede, String balon) {
		super("Top10", generarNum() , nombrePais);
		_paisSede = paisSede;
		_balon = balon;
	}

	private static int generarNum() {
		Random r = new Random();
		int r2 = r.nextInt(12);
		return r2 +1;
	}

}
