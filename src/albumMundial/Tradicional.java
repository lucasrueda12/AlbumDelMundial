package albumMundial;

public class Tradicional extends Album {

	private boolean _solicitoSorteo;

	public Tradicional() {
	}

	public Tradicional(String tipo) {
		super(tipo);
		// Falta definir como declaramos el numero del sorteo;
		_solicitoSorteo = false;
	}

	public boolean solicitoSorteo() {
		return _solicitoSorteo;
	}

	public void sorteoRealizado() {
		this._solicitoSorteo = true;
	}

	@Override
	public String darPremio() {
//		Falta arrojar las excepciones de si el participante no está registrado
//		 o si no completó el album.
		return "Te ganaste una pelota!";
	}


}
