
public class Widokowa_Klienta extends Str_k{

	@Override
	public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta) {
		
		if(pokoj.getKierunek() == ankieta.getKierunek()){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Widokowa";
	}

}
