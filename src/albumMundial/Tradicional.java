package albumMundial;

public class Tradicional extends Album {

	private boolean _solicitoSorteo;

	public Tradicional(String tipo) {
		super(tipo);
		_solicitoSorteo = false;
	}

	public boolean solicitoSorteo() {
		return _solicitoSorteo;
	}

	public void sorteoRealizado() {
		this._solicitoSorteo = true;
	}

	@Override
	public String darPremio() {
		return "Te ganaste una pelota!";
	}


}
