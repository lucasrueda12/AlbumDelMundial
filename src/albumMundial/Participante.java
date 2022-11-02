package albumMundial;

import java.util.ArrayList;
import java.util.List;

public class Participante {

	private Integer _dni;
	private String _nombre;
	private List<Figurita> _coleccionFiguritas;
	private Album _album;

	public Participante(Integer dni, String nombre, Album album) {
		_dni = dni;
		_nombre = nombre;
		_album = album;

	}
	
	public String get_nombre() {
		return _nombre;
	}

	@Override
	public String toString() {
		return String.format(" - (%d) %s: %s", _dni, _nombre, darPremio());
	}

	public int getDni() {
		return _dni;
	}

	public void agregarSobreAColeccion(List<Figurita> sobre) {

		for (Figurita figurita : sobre) {
			_coleccionFiguritas.add(figurita); 
		}
	}

	public String getTipoAlbum() {
		return _album.getTipo();
	}

	public boolean tieneCodigoDisponible() {
		if(!(_album instanceof Web)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}
		Web web = (Web) _album;
		return web.tieneCodigoDisponible(); // si todavia no uso el codigo retorna true
	}
	
	public boolean tieneSorteoDisponible() {
		if(!(_album instanceof Tradicional)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Tradicional");
		}
		Tradicional trad = (Tradicional) _album;
		return !trad.solicitoSorteo(); // si no solicito el sorteo antes esto retorna true
	}

	public void usarCodigo() {
		if(!(_album instanceof Web)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}
		
		Web web = (Web) _album;
		web.usarCodigo(); // usa el codigo volviendolo false
	}
	
	public void usarSorteo() {
		if(!(_album instanceof Tradicional)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}
		
		Tradicional trad = (Tradicional) _album;
		trad.sorteoRealizado(); // uso el sorteo por lo que cambio su valor a true
	}

	public List<String> pegarFiguritas() {
		// genera una lista y comienza a intentar pegar
		//las figuritas posibles
		List<String> peg = new ArrayList<>();
		List<Figurita> noPegadas = new ArrayList<>(); // almaceno las figuritas no pegadas para remplazar la antigua coleccion
		for(Figurita f: _coleccionFiguritas) {
			if(!_album.sePegoFigurita(f)) {
				_album.pegarFigurita(f);
				peg.add(f.get_nombrePais() + "-" +f.get_numJugador());
			}else {
				noPegadas.add(f);  // agrego las que no fueron pegadas
			}
		}
		_coleccionFiguritas = noPegadas; // La coleccion ahora tendra las figuritas que no fueron pegadas
		return peg; // retorno la lista de strings
	}
	
	
	
	public boolean albumCompleto() {
		return _album.estaCompletoA();  // le pregunta a album si esta completo
	}
	
	public String darPremio() {
		return _album.darPremio();
	}
	

	public int traerID_figuritaRepetida() { // envia el id de alguna figurita repetida, si no hay manda -1
		for(Figurita f: _coleccionFiguritas) { // recorro la coleccion
			if(_album.sePegoFigurita(f)) { 
				return f.get_id();  // si la figurita ya fue pegada entonces es repetida
			}else {
				int cont =0;  // sino busco que tenga mas de una
				for(Figurita otraf: _coleccionFiguritas) { 
					if(f.equals(otraf)) {
						cont++;
					}
				}
				if(cont>1) {  // si tiene mas de una es que esta repetida y la retorno
					return f.get_id();
				}
			}
		}
		return -1; // no encontro ninguna repetida, retorno -1
	}

	public boolean completoPais(String nombrePais) {
		if(!_album.get_equipos().containsKey(nombrePais)) {
			return false;
		}
		
		return _album.completoPaisX(nombrePais);
	}

	public boolean poseeFigurita(int codFigurita) {
		if(codFigurita <= 0) {
			throw new RuntimeException("codigo invalido");
		}
		for(Figurita f: _coleccionFiguritas) {
			if(f.get_id() == codFigurita) {
				return true;
			}
		}
		return false;
	}

	public Figurita traerFigurita(int codFigurita) {
		if(codFigurita <= 0) {
			throw new RuntimeException("codigo invalido");
		}
		
		for(Figurita f: _coleccionFiguritas) {
			if(f.get_id() == codFigurita) {
				return f;
			}
		}
		return null;
	}

	public void intercambiar(Figurita f, Figurita x) {
		
		_coleccionFiguritas.remove(f);
		_coleccionFiguritas.add(x);
	}
}
