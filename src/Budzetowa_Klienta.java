
public class Budzetowa_Klienta extends Str_k{

	@Override
	public boolean czy_akceptuje_pokoj(Pokoj pokoj, Ankieta ankieta) {
		
		if(pokoj.getCena() <= ankieta.getCena()){
			return true;
		}
		else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Budzetowa";
	}

}
