package albumMundial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AlbumDelMundial implements IAlbumDelMundial {
	
	private Random random;
	
	private Map<Integer, Integer> _albumesComprados; // no se para q vamos a usar esto tampoco, si para eso vemos el map de participantes												// listado de participantes
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
		if(dni <0) {
			throw new RuntimeException("Ha ingresado un tipo de dni erroneo");
		}
		if(nombre == null) throw new RuntimeException("Ha ingresado un nombre invalido");

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

		return dni;
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

		} else if (!_participantes.get(dni).getTipoAlbum().equals("extendido")) {
			throw new RuntimeException("El participante no cuenta con un Álbum Extendido");
		}

		Participante participante = _participantes.get(dni);

		participante.agregarSobreAColeccion(fabrica.generarSobreTop10(4));

	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		if (!_participantes.containsKey(dni)) {
			throw new RuntimeException("No se encuentra registrado");

		} else if (!_participantes.get(dni).getTipoAlbum().equals("web")) {  // cuidado con las mayusculas, para el tipo de album
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
		
		if(pegadas.size() == 0) {
			pegadas.add("No se pego ninguna figurita");
		}
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

		} else if (!_participantes.get(dni).getTipoAlbum().equals("tradicional")) {  // cuidado con las mayusculas, para el tipo de album
			throw new RuntimeException("El participante no tiene un Álbum Web");

		} else if (!_participantes.get(dni).tieneSorteoDisponible()) {
			throw new RuntimeException("El participante no tiene disponible el código promocional");

		}
		
		Participante participante= _participantes.get(dni);
		int x = random.nextInt(4);
		participante.usarSorteo();
		return fabrica.sortearPremio(x);
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
		}else if(!_participantes.get(dni).albumCompleto()) {
			throw new RuntimeException("Todavia no completo el album");
		}
		
		Participante participante = _participantes.get(dni);
		
		return participante.darPremio();
	}

	@Override
	public String listadoDeGanadores() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, Participante> p: _participantes.entrySet()) {
			if(p.getValue().albumCompleto()) {
				sb.append(p.getValue().toString() + "\n");
			}
		}
		return sb.toString();
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		List<String> completaronPais= new ArrayList<>();
		for(Map.Entry<Integer, Participante> p: _participantes.entrySet()) {
			if(p.getValue().completoPais(nombrePais)) {
				completaronPais.add(p.getValue().toString());
			}
		}
		if(completaronPais.size() == 0) {
			completaronPais.add("Nadie completo el pais");
		}
		return completaronPais;
	}

}
