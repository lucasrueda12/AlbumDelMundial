package albumMundial;

import java.util.List;
import java.util.Map;

public class AlbumDelMundial implements IAlbumDelMundial {

	private Map<Integer, Integer> _albumesComprados;
	private Map<String, Pais> _paisesParticipantes;
	private Map<Integer, Figurita> _figuritas;
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
			throw new RuntimeException("Usted ya se encuentra registrado");

		} else if (!tipoAlbum.equals("web") || !tipoAlbum.equals("tradicional") || !tipoAlbum.equals("extendido")) {
			throw new RuntimeException("Usted ha ingresado un tipo de álbum incorrecto");
		}

		Album album;

		if (tipoAlbum.equals("web")) {
			album = fabrica.crearAlbumWeb(dni);

		} else if (tipoAlbum.equals("tradicional")) {

			album = fabrica.crearAlbumTradicional(dni);
		} else {
			album = fabrica.crearAlbumExtendido(dni);
		}

		Participante participante = new Participante(dni, nombre, album);

		registrarParticipante(dni, participante);

		return 0;
	}

	private void registrarParticipante(int dni, Participante participante) { //No sé si es necesario este método pero lo hice porque pensaba que el otro quedaba muy cargado xd
		_participantes.put(participante.getDni(), participante);
		_albumesComprados.put(dni, dni);
	}

	@Override
	public void comprarFiguritas(int dni) {

	}

	@Override
	public void comprarFiguritasTop10(int dni) {
		// TODO Auto-generated method stub

	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
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
