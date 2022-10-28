package albumMundial;

import java.util.Map;

public class Extendido extends Tradicional{
	
	private Map <Integer, Ftop10> _figuritasTop10; //Falta definir q chucha hacemos con el map.
	
	public Extendido() {	
		}
	
	public Extendido(String tipo, Integer id) {
		super(tipo, id);
		 
	}
	
	@Override
	public String darPremio() {
//		Falta arrojar las excepciones de si el participante no está registrado
//		 o si no completó el album.
		return "Te ganaste una pelota y un viaje!";
	}

}
