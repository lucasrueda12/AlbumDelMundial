package albumMundial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Extendido extends Tradicional {

	private List<Ftop10> _figuritasTop10;

	public Extendido(String tipo) {
		super(tipo);
		_figuritasTop10 = new ArrayList<>();
	}

	@Override
	public String darPremio() {
		return "Te ganaste una pelota y un viaje!";
	}

	public boolean sePegoFiguritaTop10(Ftop10 figurita) {

		if (figurita == null) {
			return true;
		}

		return _figuritasTop10.contains(figurita);
	}

	public void pegarFiguritasTop10(Ftop10 figurita) {

		if (figurita == null) {
			throw new RuntimeException("figurita nulla");
		}

		if (!_figuritasTop10.contains(figurita)) {

			_figuritasTop10.add(figurita);
		}

	}

	@Override
	public boolean estaCompletoAlbum() {
		return super.estaCompletoAlbum() && _figuritasTop10.size() == 20;
	}

}
