package albumMundial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlbumDelMundial implements IAlbumDelMundial {

	private Map<Integer, Integer> _albumesComprados; // no se para q vamos a usar esto tampoco, si para eso vemos el
														// listado de participantes
	private Map<String, Pais> _paisesParticipantes;
	private Map<Integer, Participante> _participantes;
	private Map<Integer, Figurita> _solicitudesDeIntercambio; // Vamo a ver si la usamos.
	private Fabrica fabrica;

	public AlbumDelMundial() { // Sobrecarga.
		fabrica = new Fabrica();

	}

// Se podran cambiar los int por Integer ¿¿

	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {

		if (_participantes.containsKey(dni)) {
			throw new RuntimeException("Participante ya se encuentra registrado");

		} else if (!tipoAlbum.equals("Web") || !tipoAlbum.equals("Tradicional") || !tipoAlbum.equals("Extendido")) {
			throw new RuntimeException("Ha ingresado un tipo de álbum incorrecto");
		}

		Album album;

		if (tipoAlbum.equals("Web")) {
			album = fabrica.crearAlbumWeb();

		} else if (tipoAlbum.equals("Tradicional")) {

			album = fabrica.crearAlbumTradicional();
		} else {
			album = fabrica.crearAlbumExtendido();
		}

		Participante participante = new Participante(dni, nombre, album);

		registrarParticipante(dni, participante);

		return 0;
	}

	private void registrarParticipante(int dni, Participante participante) { // No sé si es necesario este método pero
																				// lo hice porque pensaba que el otro
																				// quedaba muy cargado xd
		_participantes.put(participante.getDni(), participante);
		_albumesComprados.put(dni, dni);
	}

	@Override
	public void comprarFiguritas(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}
		Participante participante = _participantes.get(dni);

		participante.agregarSobreAColeccion(fabrica.generarSobre(4));
	}

	@Override
	public void comprarFiguritasTop10(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");

		} else if (!_participantes.get(dni).getTipoAlbum().equals("Top10")) {
			throw new RuntimeException("El participante no cuenta con un Álbum Extendido");
		}

		Participante participante = _participantes.get(dni);

		participante.agregarSobreAColeccion(fabrica.generarSobreTop10(4));

	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");

		} else if (!_participantes.get(dni).getTipoAlbum().equals("Web")) {
			throw new RuntimeException("El participante no tiene un Álbum Web");

		} else if (!_participantes.get(dni).tieneCodigoDisponible()) {
			throw new RuntimeException("El participante no tiene disponible el código promocional");

		}

		Participante participante = _participantes.get(dni);

		participante.usarCodigo();
		participante.agregarSobreAColeccion(fabrica.generarSobre(4));

	}

	@Override
	public List<String> pegarFiguritas(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean llenoAlbum(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}

		return null;
	}

	@Override
	public int buscarFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean intercambiar(int dni, int codFigurita) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String darNombre(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String darPremio(int dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listadoDeGanadores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		// TODO Auto-generated method stub
		return null;
	}

}
