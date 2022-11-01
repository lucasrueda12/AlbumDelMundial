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
		return web.tieneCodigoDisponible();
	}
	
	public boolean tieneSorteoDisponible() {
		if(!(_album instanceof Tradicional)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Tradicional");
		}
		Tradicional trad = (Tradicional) _album;
		return !trad.solicitoSorteo();
	}

	public void usarCodigo() {
		if(!(_album instanceof Web)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}
		
		Web web = (Web) _album;
		web.usarCodigo();
	}
	
	public void usarSorteo() {
		if(!(_album instanceof Tradicional)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}
		
		Tradicional trad = (Tradicional) _album;
		trad.sorteoRealizado();
	}

	public List<String> pegarFiguritas() {
		// genera una lista y comienza a intentar pegar
		//las figuritas posibles
		List<String> peg = new ArrayList<>();
		for(Figurita f: _coleccionFiguritas) {
			if(!_album.sePegoFigurita(f)) {
				_album.pegarFigurita(f);
				peg.add(f.get_nombrePais() + "-" +f.get_numJugador());
			}
		}
		return peg;
	}
	
	public boolean albumCompleto() {
		return _album.estaCompletoA();
	}

}
