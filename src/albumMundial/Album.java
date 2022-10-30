package albumMundial;

import java.util.Map;

public class Album {
	private String _tipo;
	private int _id;
	private Map<String, Pais> _equipos;
	
	public Album() {
		
	}
	
	public Album(String tipo, int id) {
		_tipo = tipo;
		_id = id; // Es igual al dni del participante que lo compra.

	}
	
	public String darPremio() {
		return "";
	}
}
