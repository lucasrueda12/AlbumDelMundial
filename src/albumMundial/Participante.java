package albumMundial;

import java.util.ArrayList;

public class Participante {
	
	private Integer _dni;
	private String _nombre;
	private Album _album;
	private ArrayList <Figurita> _coleccionFiguritas;
	
	public Participante(Integer dni, String nombre, Album album) {
		_dni = dni;
		_nombre = nombre;
		_album = album;

	}
	
	public int getDni() {
		return _dni;
	}
	
	public void agregarSobreAColeccion (ArrayList <Figurita> sobre) {
		
		for(Figurita figurita : sobre) {
			_coleccionFiguritas.add(figurita);
		}
	}
}
