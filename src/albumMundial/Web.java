package albumMundial;

public class Web extends Album {

	private boolean _codigoProm;

	public Web(String tipo, Integer id) {
		super(tipo, id);
		_codigoProm = true;
	}

	@Override
	public String darPremio() {
		return "Te ganaste una camiseta oficial de la selección!";
	}

	public void usarCodigo() {
		_codigoProm = false;
	}

	@Override
	public boolean tieneCodigoDisponible() {
		return _codigoProm;
	}

}
