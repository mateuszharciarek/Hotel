
public class Polowiczna_Klienta extends Str_k{

	@Override
	public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta) {
		
		int liczba_spelnionych = 0;
		
		if(pokoj.getCena() <= ankieta.getCena()){
			liczba_spelnionych++;
		}
		if(pokoj.isInternet() == ankieta.isInternet()){
			liczba_spelnionych++;
		}
		if(pokoj.getKierunek() == ankieta.getKierunek()){
			liczba_spelnionych++;
		}
		if(pokoj.getKolor() == ankieta.getKolor()){
			liczba_spelnionych++;
		}
		if(pokoj.getLiczba_osob() >= ankieta.getLiczba_osob()){
			liczba_spelnionych++;
		}
		if(pokoj.getWystroj() == ankieta.getWystroj()){
			liczba_spelnionych++;
		}
		
		if(liczba_spelnionych >= 3){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Polowiczna";
	}

}
