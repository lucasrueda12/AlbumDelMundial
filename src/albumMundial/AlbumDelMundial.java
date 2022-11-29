package albumMundial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AlbumDelMundial implements IAlbumDelMundial {

	private Random random;
	private Map<Integer, Participante> _participantes;
	private Fabrica fabrica;

	public AlbumDelMundial() {

		fabrica = new Fabrica();
		_participantes = new HashMap<>();
		random = new Random();
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		sb.append("Cantidad de Participantes: ");
		sb.append(_participantes.size());
		sb.append("\n");
		sb.append("Cantidad de Ganadores: ");
		for (Participante  p : _participantes.values()) {
			if (p.albumCompleto()) {
				count++;
			}
		}
		sb.append(count);
		
		return sb.toString();
	}

	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {

		if (_participantes.containsKey(dni)) {
			throw new RuntimeException("Participante ya se encuentra registrado");

		} else if (!tipoAlbum.equals("Web") && !tipoAlbum.equals("Tradicional") && !tipoAlbum.equals("Extendido")) {
			throw new RuntimeException("Ha ingresado un tipo de álbum incorrecto");
		}
		if (dni < 0) {
			throw new RuntimeException("Ha ingresado un tipo de dni erróneo");
		}
		if (nombre == null)
			throw new RuntimeException("Ha ingresado un nombre inválido");

		Album album;

		if (tipoAlbum.equals("Web")) {
			album = fabrica.crearAlbumWeb();

		} else if (tipoAlbum.equals("Tradicional")) {

			album = fabrica.crearAlbumTradicional();
		} else {
			album = fabrica.crearAlbumExtendido();
		}

		album.cargarPaises(fabrica.get_paises()); // Se cargan todos los paises clasificados.

		Participante participante = new Participante(dni, nombre, album);

		_participantes.put(participante.getDni(), participante);

		return album.get_ID(); 
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

		} else if (!_participantes.get(dni).getTipoAlbum().equals("Extendido")) {
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
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}

		Participante participante = _participantes.get(dni);
		List<String> pegadas = new ArrayList<>();
		pegadas = participante.pegarFiguritas();

		return pegadas;
	}

	@Override
	public boolean llenoAlbum(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}

		Participante participante = _participantes.get(dni);

		return participante.albumCompleto();
	}

	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");

		} else if (!(_participantes.get(dni).getTipoAlbum().equals("Tradicional"))
				&& !(_participantes.get(dni).getTipoAlbum().equals("Extendido"))) {
			throw new RuntimeException("El participante no tiene un Álbum Tradicional");

		} else if (!_participantes.get(dni).tieneSorteoDisponible()) {
			throw new RuntimeException("El participante no tiene disponible el sorteo");
		}

		Participante participante = _participantes.get(dni);
		int numSorteo = random.nextInt(3);
		participante.usarSorteo();
		return fabrica.sortearPremio(numSorteo);
	}

	@Override
	public int buscarFiguritaRepetida(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}

		Participante participante = _participantes.get(dni);
		return participante.traerID_figuritaRepetida();
	}

	@Override
	public boolean intercambiar(int dni, int codFigurita) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}

		if (codFigurita < 1) {
			return false;
		}

		if (!_participantes.get(dni).poseeFigurita(codFigurita)) {
			throw new RuntimeException("No posee la figurita");
		}

		Participante participante = _participantes.get(dni);
		Figurita figurita = participante.traerFigurita(codFigurita);

		if (figurita == null) {
			return false;
		}

		for (Participante otroP : _participantes.values()) {

			if (!participante.equals(otroP)) { // Valida que sean dos participante diferentes, para que
															// dentro del map no tome al mismo participante.

				if (participante.getTipoAlbum().equals(otroP.getTipoAlbum())) { // Valida mismo album

					int otroCod = buscarFiguritaRepetidaMismoOMenorValor(figurita, otroP); // busca figurita repetida del mismo valor entre toda la coleccion del participante.

					if (otroCod != -1 && !participante.poseeFigurita(otroCod)) { //Verifica que los participantes no posean la misma figurita a intercambiar

						Figurita otraFigurita = otroP.traerFigurita(otroCod);

						// si una es top 10 y la otra es tradicional se intercambian si tienen el mismo
						// valor

							participante.intercambiar(figurita, otraFigurita);

							otroP.intercambiar(otraFigurita, figurita);

							return true;
						}
					}
				}
			}
		
		return false;
	}

	private boolean mismoOMenorValor(Figurita figurita, Figurita otraFigurita) {
		int val1 = fabrica.valorBase(figurita);
		int val2 = fabrica.valorBase(otraFigurita);

		if (figurita.get_tipo().equals("top10")) {
			Ftop10 f1 = (Ftop10) figurita;
			val1 *= f1.get_balon().equals("oro") ? 1.20 : 1.10;
		}
		if (otraFigurita.get_tipo().equals("top10")) {
			Ftop10 f2 = (Ftop10) otraFigurita;
			val1 *= f2.get_balon().equals("oro") ? 1.20 : 1.10;
		}
		return val1 >= val2;

	}
	
	private int buscarFiguritaRepetidaMismoOMenorValor(Figurita figuritaACambiar, Participante participante) { 
//	Este método se encarga de buscar una figurita dentro de la colección del participante 
//		que contenga el mismo o un menor valor que la figurita llegada como parámetro.	
		
//		Sin embargo, este método es dinámico por ende, el test 10 varía su resultado dependiendo de las figuritas que se generan aleatoriamente.
//		En algunos casos resulta ser el test fallido y en otros, resulta ser el test correcto sin ningún error.
		
		ArrayList <Figurita> figuritas = participante.get_coleccionFiguritas();
		
		for(Figurita figurita : figuritas) {
			
			if(mismoOMenorValor(figuritaACambiar, figurita) && !figurita.equals(figuritaACambiar)){ //Valida que las dos figuritas tengan un mismo o menor valor y que además sean diferentes.
				return figurita.get_id();
			}
		}
		return -1;
		
	}

	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}

		int codFig = buscarFiguritaRepetida(dni);
		return intercambiar(dni, codFig);
	}

	@Override
	public String darNombre(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		}
		Participante participante = _participantes.get(dni);
		return participante.get_nombre();
	}

	@Override
	public String darPremio(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");
		} else if (!_participantes.get(dni).albumCompleto()) {
			throw new RuntimeException("Todavia no completo el album");
		}

		Participante participante = _participantes.get(dni);

		return participante.darPremio();
	}

	@Override
	public String listadoDeGanadores() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, Participante> p : _participantes.entrySet()) {
			if (p.getValue().albumCompleto()) {
				sb.append(p.getValue().toString() + "\n");
			}
		}
		return sb.toString();
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		List<String> completaronPais = new ArrayList<>();
		for (Map.Entry<Integer, Participante> p : _participantes.entrySet()) {
			if (p.getValue().completoPais(nombrePais)) {
				completaronPais.add(p.getValue().toString());
			}
		}
		return completaronPais;
	}

}
