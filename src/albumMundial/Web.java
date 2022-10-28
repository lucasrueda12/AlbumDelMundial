package albumMundial;

public class Web extends AlbumDelMundial {

	private Integer _codigoProm;

	public Web() {
	}

	public Web(String tipo, Integer id) {
		super(tipo, id);
		// Falta ver que hacemos con el codigoPromocional;
	}

	@Override
	public String darPremio(int dni) {

//		Falta arrojar las excepciones de si el participante no está registrado
//		 o si no completó el album.

		return "Te ganaste una camiseta oficial de la selección!";
	}

}
