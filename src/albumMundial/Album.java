package albumMundial;

import java.util.Map;

public class Album {
	private String _tipo;
	private int _id;
	private Map<String, Pais> _equipos;

	public Album() {

	}

	public Album(String tipo) {
		_tipo = tipo; // tipo lo usamos para saber que album vamos a construir, y guardamos esta
						// referencia

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
