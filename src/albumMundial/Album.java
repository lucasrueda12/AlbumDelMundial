package albumMundial;

import java.util.Map;

public class Album {
	private String _tipo;
	private int _id;
	private Map<String, Pais> _equipos;

	public Album() {

	}

	public Album(String tipo, int id) {
		_tipo = tipo; // tipo lo usamos para saber que album vamos a construir, y guardamos esta
						// referencia
		_id = id; // Es igual al dni del participante que lo compra.

	}

	public String darPremio() {
		return "";
	}

	public String getTipo() {
		return _tipo;
	}

	public boolean tieneCodigoDisponible() {
		return false;
	}
}
