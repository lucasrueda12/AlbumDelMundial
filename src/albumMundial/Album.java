package albumMundial;

import java.util.List;
import java.util.Map;

public class Album {
	private String _tipo;
	private int _id;
	private Map<String, Pais> _equipos;  //cambie el map por un array
	//pq solo necesitamos saber el pais y el numero para saber si esta pegada
	private Fabrica fabrica;
	
	public Album() {

	}

	public Album(String tipo) {
		_tipo = tipo; // tipo lo usamos para saber que album vamos a construir, y guardamos esta
						// referencia
		_equipos = fabrica.get_paises();
	}

	public String darPremio() {
		return "";
	}

	public String getTipo() {
		return _tipo;
	}

	
	
	public boolean sePegoFigurita(Figurita f) {
		// chequea que no sea nulla, si el tamaño de la coleccion es 0
		// es porque no tiene figuritas pegadas, en ambos caso retorna false
		// sino recorre la coleccion y comprueba que este pegada
		// y si coincide retorna true , si no se encuentra retorna false
		if(f == null) {
			return false;
		}
		if(!_equipos.containsKey(f.get_nombrePais())) {
			return false;
		}
		
		Pais p= _equipos.get(f.get_nombrePais());
		
		return p.sePegoFigPais(f);
	}
	
	public void pegarFigurita(Figurita f) {
		if(f == null) {
			throw new RuntimeException("figurita nulla");
		}
		if(!_equipos.containsKey(f.get_nombrePais())) {
			throw new RuntimeException("pais de la figurita invalido");
		}
		
		Pais p= _equipos.get(f.get_nombrePais());
		p.pegarFigPais(f);
	}
	
	public boolean estaCompletoA() {
		boolean ret=true;
		for(Map.Entry<String, Pais> p: _equipos.entrySet()) {
			ret = ret && p.getValue().estaCompletoP();
		}
		return ret;
	}

	public Map<String, Pais> get_equipos() {
		return _equipos;
	}

	public boolean completoPaisX(String nombrePais) {
		if(!_equipos.containsKey(nombrePais)) {
			return false;
		}
		return _equipos.get(nombrePais).estaCompletoP();
	}
}
