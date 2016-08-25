
public class Perfekcjonista_Klient extends Str_k{

	@Override
	public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta) {
		
		if(pokoj.getCena() <= ankieta.cena &&
				pokoj.isInternet() == ankieta.isInternet() &&
				pokoj.getKierunek() == ankieta.getKierunek() &&
				pokoj.getKolor() == ankieta.getKolor() &&
				pokoj.getLiczba_osob() >= ankieta.getLiczba_osob() &&
				pokoj.getWystroj() == ankieta.getWystroj()){
		return true;
		}
		else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "Perfekcjonista";
	}

}
