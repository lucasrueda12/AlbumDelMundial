package albumMundial;

import java.util.ArrayList;
import java.util.Map;

public class Extendido extends Tradicional{
	
	private Map <Integer, ArrayList <Ftop10>> _figuritasTop10; //Falta definir q chucha hacemos con el map.
//	Array de size 2 como value para que el primer elemento sea el jugador con balon de oro y el segundo con el de plata. 
	
	public Extendido() {	
	}

	public Extendido(String tipo, int id) {
		super(tipo, id);
		 
	}
	
	@Override
	public String darPremio() {
//		Falta arrojar las excepciones de si el participante no está registrado
//		 o si no completó el album.
		return "Te ganaste una pelota y un viaje!";
	}

}
