package albumMundial;

public class Web extends Album {

	private boolean _codigoProm;

	public Web() {
	}

	public Web(String tipo, Integer id) {
		super(tipo, id);
		_codigoProm = false;
	}

	@Override
	public String darPremio() {
		return "Te ganaste una camiseta oficial de la selección!";
	}
	
	public boolean usoElCodigo() {
		return _codigoProm;
	}
	

}
