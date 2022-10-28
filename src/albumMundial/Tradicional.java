package albumMundial;

public class Tradicional extends AlbumDelMundial {

	private Integer _numeroSorteo;

	public Tradicional() {
	}

	public Tradicional(String tipo, Integer id) {
		super(tipo, id);
		// Falta definir como declaramos el numero del sorteo;

	}

	@Override
	public String darPremio(int dni) {
//		Falta arrojar las excepciones de si el participante no está registrado
//		 o si no completó el album.
		return "Te ganaste una pelota!";
	}

}
