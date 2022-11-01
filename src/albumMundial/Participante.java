package albumMundial;

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
		return _album.tieneCodigoDisponible();
	}

	public void usarCodigo() {
		if(!(_album instanceof Web)) {
			throw new RuntimeException("No es posible utilizar este método. Participante no tiene un Álbum Web");
		}
		
		Web web = (Web) _album;
		web.usarCodigo();
	}

}
