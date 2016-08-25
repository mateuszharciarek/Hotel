


public class Perfekcjonista extends Str_r{

	@Override
	public int wybierz_pokoj(Pokoj [] pokoje,Ankieta ankieta) {
		
		int i = 0;
		while(i < pokoje.length){
			if(pokoje[i].czy_termin_jest_wolny(ankieta.getData_przyjazdu(),ankieta.getCzas_pobytu())){
				if(pokoje[i].getCena() <= ankieta.cena &&
						pokoje[i].isInternet() == ankieta.isInternet() &&
						pokoje[i].getKierunek() == ankieta.getKierunek() &&
						pokoje[i].getKolor() == ankieta.getKolor() &&
						pokoje[i].getLiczba_osob() >= ankieta.getLiczba_osob() &&
						pokoje[i].getWystroj() == ankieta.getWystroj()){
					return i;
				}
			}
			i++;
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		return "Perfekcjonista";
	}


}
