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
	
	
	
	public String get_paisSede() {
		return _paisSede;
	}

	public String get_balon() {
		return _balon;
	}
	
	@Override 
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Ftop10)) {
			return false;
		}
		
		Ftop10 fig = (Ftop10) obj;
		
		return super.equals(obj) && _paisSede.equals(fig.get_paisSede()) && _balon.equals(fig.get_balon()); 
		//Dudo de que super.equals(obj) esté bien o tenga que hacer el equals aparte de Ftop10 y poner los atributos de 
		//Figurita en protected.
	}

}
