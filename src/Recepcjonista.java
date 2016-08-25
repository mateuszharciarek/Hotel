
public class Recepcjonista extends Osoba{

	private final Str_r strategia;
	
	Recepcjonista(String imie, String nazwisko,Str_r strategia) {
		super(imie, nazwisko);
		this.strategia = strategia;
	}

	@Override
	public String toString() {
		return "Recepcjonista: " + imie + " " + nazwisko + ", " + strategia;
	}

	public Str_r getStrategia() {
		return strategia;
	}


	

}
