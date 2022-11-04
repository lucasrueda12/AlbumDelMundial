package albumMundial;

public class Web extends Album {

	private boolean _codigoProm;

	public Web(String tipo) {
		super(tipo);
		_codigoProm = true;
	}

	@Override
	public String darPremio() {
		return "Te ganaste una camiseta oficial de la selección!";
	}

	public void usarCodigo() {
		_codigoProm = false;
	}

	public boolean tieneCodigoDisponible() {
		return _codigoProm;
	}

}
