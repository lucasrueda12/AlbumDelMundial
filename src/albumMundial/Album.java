package albumMundial;

import java.util.List;
import java.util.Map;

public class Album {
	private String _tipo;
	private int _id;
	private Map<String, Pais> _equipos;  //cambie el map por un array
	//pq solo necesitamos saber el pais y el numero para saber si esta pegada


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

	
	
	public boolean sePegoFigurita(Figurita figurita) {
		// chequea que no sea nulla, si el tamaño de la coleccion es 0
		// es porque no tiene figuritas pegadas, en ambos caso retorna false
		// sino recorre la coleccion y comprueba que este pegada
		// y si coincide retorna true , si no se encuentra retorna false
		if(figurita == null) {
			return true;
		}
		if(!_equipos.containsKey(figurita.get_nombrePais())) {
			return false;
		}
		
		Pais pais= _equipos.get(figurita.get_nombrePais());
		
		return pais.sePegoFigPais(figurita);
	}
	
	public void pegarFigurita(Figurita figurita) {
		if(figurita == null) {
			throw new RuntimeException("figurita nulla");
		}
		if(!_equipos.containsKey(figurita.get_nombrePais())) {
			throw new RuntimeException("pais de la figurita invalido");
		}
		
		Pais pais = _equipos.get(figurita.get_nombrePais());
		pais.pegarFigPais(figurita);
	}
	
	public boolean estaCompletoAlbum() {
		boolean ret=true;
		for(Map.Entry<String, Pais> p: _equipos.entrySet()) {
			ret = ret && p.getValue().estaCompletoPais();
		}
		return ret;
	}

	
	public void cargarPaises(Map<String, Pais> _paises) {
		_equipos = _paises;
	}

	public boolean completoPais(String nombrePais) {
		if(!_equipos.containsKey(nombrePais)) {
			return false;
		}
		return _equipos.get(nombrePais).estaCompletoPais();
	}
}
