package albumMundial;

import java.util.ArrayList;

public class Participante {
	
	private Integer _dni;
	private String _nombre;
	private AlbumDelMundial _album;
	private ArrayList <Figurita> _coleccionFiguritas;
	
	public Participante(Integer dni, String nombre, String tipoAlbum) {
		_dni = dni;
		_nombre = nombre;

	}
}
