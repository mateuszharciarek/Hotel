
public class Klient extends Osoba{

	private final Str_k strategia;
	
	Klient(String imie, String nazwisko,Str_k strategia) {
		super(imie, nazwisko);
		this.strategia = strategia;
	}

	@Override
	public String toString() {
		return "Klient: " + imie + " " + nazwisko + ", " + strategia;
	}

	public Str_k getStrategia() {
		return strategia;
	}
	

}
