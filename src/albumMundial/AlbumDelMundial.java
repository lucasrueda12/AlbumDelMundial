package albumMundial;

import java.util.List;
import java.util.Map;

public class AlbumDelMundial implements IAlbumDelMundial {

	private String _tipo;
	private Integer _id;
	private Map<String, Pais> _equipos;

	public AlbumDelMundial() { // Sobrecarga.
	}

	public AlbumDelMundial(String tipo, Integer id) {
		_tipo = tipo;
		_id = id; // Es igual al dni del participante que lo compra.

	}

	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void comprarFiguritas(int dni) {
		// TODO Auto-generated method stub

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
