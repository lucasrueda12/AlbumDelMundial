package albumMundial;

import java.util.ArrayList;
import java.util.Iterator;
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
		_coleccionFiguritas = new ArrayList<>();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Participante)) {
			return false;
		}

		Participante participante = (Participante) obj;

		return _dni == participante._dni && _nombre == participante._nombre;

	}

	@Override
	public String toString() {
		return String.format(" - (%d) %s: %s", _dni, _nombre, darPremio()) + "\n" + _album.toString(); 
	}

	public String get_nombre() {
		return _nombre;
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
		if (!(_album instanceof Web)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}
		Web web = (Web) _album;
		return web.tieneCodigoDisponible(); // si todavia no uso el codigo retorna true
	}

	public boolean tieneSorteoDisponible() {
		if (!(_album instanceof Tradicional)) {
			throw new RuntimeException(
					"No es posible utilizar este método. Participante no tiene un Álbum Tradicional");
		}
		Tradicional trad = (Tradicional) _album;
		return !trad.solicitoSorteo(); // si no solicito el sorteo antes esto retorna true
	}

	public void usarCodigo() {
		if (!(_album instanceof Web)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}

		Web web = (Web) _album;
		web.usarCodigo(); // usa el codigo volviendolo false
	}

	public void usarSorteo() {
		if (!(_album instanceof Tradicional)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}

		Tradicional trad = (Tradicional) _album;
		trad.sorteoRealizado(); // uso el sorteo por lo que cambio su valor a true
	}

	public List<String> pegarFiguritas() {

		List<String> peg = new ArrayList<>();
		Iterator<Figurita> it = _coleccionFiguritas.iterator();

		while (it.hasNext()) {

			Figurita figurita = it.next();

			if (figurita.get_tipo().equals("Top10") && _album.getTipo().equals("Extendido")) {

				Extendido extendido = (Extendido) _album;

				Ftop10 figuritaTop10 = (Ftop10) figurita;

				extendido.pegarFiguritasTop10(figuritaTop10);

				peg.add(figurita.toString());

				it.remove();
			}

			if (figurita.get_tipo().equals("Tradicional") && !_album.sePegoFigurita(figurita)) {

				_album.pegarFigurita(figurita);

				peg.add(figurita.toString());

				it.remove();
			}

		}
		return peg;
	}

	public boolean albumCompleto() {
		return _album.estaCompletoAlbum(); 
	}

	public String darPremio() {
		return _album.darPremio();
	}

	public int traerID_figuritaRepetida() {

		if (_coleccionFiguritas.size() == 0) {
			return -1;
		}
		
		return _coleccionFiguritas.get(0).get_id();
	}
	
	public boolean completoPais(String nombrePais) {
		return _album.completoPais(nombrePais);
	}

	public boolean poseeFigurita(int codFigurita) {

		if (codFigurita == -1) {
			throw new RuntimeException("codigo invalido");
		}
		if (_coleccionFiguritas.size() == 0) {
			return false;
		}
		for (Figurita figurita : _coleccionFiguritas) {
			if (figurita.get_id() == codFigurita) {
				return true;
			}
		}
		return false;
	}

	public Figurita traerFigurita(int codFigurita) {
		if (codFigurita < 1) {
			throw new RuntimeException("codigo invalido");
		}

		for (Figurita figurita : _coleccionFiguritas) {
			if (figurita.get_id() == codFigurita) {
				return figurita;
			}
		}
		return null;
	}

	public void intercambiar(Figurita figurita, Figurita nuevaFigurita) {
		_coleccionFiguritas.remove(figurita);
		_coleccionFiguritas.add(nuevaFigurita);
	}
}
