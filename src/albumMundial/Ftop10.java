package albumMundial;

import java.util.Random;

public class Ftop10 extends Figurita {

	private String _paisSede;
	private String _balon;

	public Ftop10(String nombrePais, int numJugador, String paisSede, String balon) {
		super("Top10", numJugador, nombrePais);
		_paisSede = paisSede;
		_balon = balon;
		this.set_id(hashCode());
	}
	
	
	
	@Override
	public int hashCode() {
		return super.hashCode() + _balon.length() * _paisSede.length() *10;
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
		
		return super.equals((Figurita)obj) && _paisSede.equals(fig.get_paisSede()) && _balon.equals(fig.get_balon()); 
		
	}

}
