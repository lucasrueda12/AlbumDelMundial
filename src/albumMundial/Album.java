package albumMundial;

import java.util.Map;

public class Album {
	private static int count;
	private int _id;
	private String _tipo;
	private Map<String, Pais> _equipos;

	public Album(String tipo) {
		count++;
		_tipo = tipo;
		_id = count;

	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Album " + _tipo);
		sb.append("\n");
		sb.append("Paises: ");
		
		for(Pais pais : _equipos.values()) {
			sb.append(pais);
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public int get_ID() {
		return _id;
	}

	public String getTipo() {
		return _tipo;
	}

	public String darPremio() {
		return "";
	}
	
	public boolean sePegoFigurita(Figurita figurita) {
		// chequea que no sea nulla, si el tamaño de la coleccion es 0
		// es porque no tiene figuritas pegadas, en ambos caso retorna false
		// sino recorre la coleccion y comprueba que este pegada
		// y si coincide retorna true , si no se encuentra retorna false
		if (figurita == null) {
			return true;
		}
		if (!_equipos.containsKey(figurita.get_nombrePais())) {
			return false;
		}

		Pais pais = _equipos.get(figurita.get_nombrePais());

		return pais.sePegoFigPais(figurita);
	}

	public void pegarFigurita(Figurita figurita) {
		if (figurita == null) {
			throw new RuntimeException("Figurita nulla");
		}
		if (!_equipos.containsKey(figurita.get_nombrePais())) {
			throw new RuntimeException("Pais de la figurita inválido");
		}

		Pais pais = _equipos.get(figurita.get_nombrePais());
		pais.pegarFigPais(figurita);
	}

	public boolean estaCompletoAlbum() {
		boolean ret = true;
		for (Map.Entry<String, Pais> p : _equipos.entrySet()) {
			ret = ret && p.getValue().estaCompletoPais();
		}
		return ret;
	}

	public void cargarPaises(Map<String, Pais> _paises) {
		_equipos = _paises;
	}

	public boolean completoPais(String nombrePais) {
		if (!_equipos.containsKey(nombrePais)) {
			return false;
		}
		return _equipos.get(nombrePais).estaCompletoPais();
	}
}
