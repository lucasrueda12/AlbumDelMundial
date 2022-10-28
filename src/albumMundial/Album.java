package albumMundial;

import java.util.Map;

public class Album {
	private String _tipo;
	private Integer _id;
	private Map<String, Pais> _equipos;
	
	public Album() { // Sobrecarga.
	}
	
	public Album(String tipo, Integer id) {
		_tipo = tipo;
		_id = id; // Es igual al dni del participante que lo compra.

	}
	
	public String darPremio() {
		// TODO Auto-generated method stub
		return "";
	}
}
