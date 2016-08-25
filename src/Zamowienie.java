

public class Zamowienie{
	
	private Klient klient;
	private Ankieta ankieta;
	
	public Klient getKlient() {
		return klient;
	}

	public Ankieta getAnkieta() {
		return ankieta;
	}

	Zamowienie(Klient klient, Ankieta ankieta) {
		super();
		this.klient = klient;
		this.ankieta = ankieta;
	}


}