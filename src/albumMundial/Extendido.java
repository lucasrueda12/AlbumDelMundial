package albumMundial;

import java.util.ArrayList;
import java.util.Map;

public class Extendido extends Tradicional{
	
	private Map <Integer, Ftop10> _figuritasTop10; //Falta definir q chucha hacemos con el map.
//	Array de size 2 como value para que el primer elemento sea el jugador con balon de oro y el segundo con el de plata. 
	
	public Extendido() {	
	}

	public Extendido(String tipo) {
		super(tipo);
		 
	}
	
	@Override
	public String darPremio() {
		return "Te ganaste una pelota y un viaje!";
	}

}
