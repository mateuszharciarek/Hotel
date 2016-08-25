

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Losowa extends Str_r{
	
	@Override
	public int wybierz_pokoj(Pokoj [] pokoje,Ankieta ankieta) {
		
		int i = 0;
		List<Integer> wolne_pokoje = new ArrayList<>();
		while(i < pokoje.length){
			if(pokoje[i].czy_termin_jest_wolny(ankieta.getData_przyjazdu(),ankieta.getCzas_pobytu())){
				wolne_pokoje.add(i);
			}
			i++;
		}
		
		if(wolne_pokoje.size() == 0){
			return -1;
		}
		else{
			Random generator = new Random();
			i = generator.nextInt(wolne_pokoje.size());
			return wolne_pokoje.get(i);
		}		
	}
	
	@Override
	public String toString() {
		return "Losowa";
	}

}
