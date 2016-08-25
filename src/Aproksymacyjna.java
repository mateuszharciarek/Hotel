


public class Aproksymacyjna extends Str_r{
	
	@Override
	public int wybierz_pokoj(Pokoj[] pokoje, Ankieta ankieta) {
		
		int max_liczba_spelnionych = -1;
		int obecna_liczba_spelnionych = 0;
		int nasz_pokoj = -1;
		int i = 0;
		
		while(i < pokoje.length){
			obecna_liczba_spelnionych = 0;
			if(pokoje[i].czy_termin_jest_wolny(ankieta.getData_przyjazdu(),ankieta.getCzas_pobytu())){
				if(pokoje[i].getCena() <= ankieta.getCena()){
					obecna_liczba_spelnionych++;
				}
				if(pokoje[i].isInternet() == ankieta.isInternet()){
					obecna_liczba_spelnionych++;
				}
				if(pokoje[i].getKierunek() == ankieta.getKierunek()){
					obecna_liczba_spelnionych++;
				}
				if(pokoje[i].getKolor() == ankieta.getKolor()){
					obecna_liczba_spelnionych++;
				}
				if(pokoje[i].getLiczba_osob() >= ankieta.getLiczba_osob()){
					obecna_liczba_spelnionych++;
				}
				if(pokoje[i].getWystroj() == ankieta.getWystroj()){
					obecna_liczba_spelnionych++;
				}
				
				if(obecna_liczba_spelnionych > max_liczba_spelnionych){
					max_liczba_spelnionych = obecna_liczba_spelnionych;
					nasz_pokoj = i;
				}
				else{
					if(obecna_liczba_spelnionych == max_liczba_spelnionych){
						if(pokoje[nasz_pokoj].getCena() < pokoje[i].getCena() && pokoje[nasz_pokoj].getCena() <= ankieta.getCena()){
							nasz_pokoj = i;
						}
					}
				}
				
			}
			i++;
		}
		
		return nasz_pokoj;
	}
	
	@Override
	public String toString() {
		return "Aproksymacyjna";
	}


}
