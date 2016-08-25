import java.util.Calendar;
import java.util.LinkedList;

import enumerators.kolorystyka;
import enumerators.strona;
import enumerators.styl;


public class Pokoj extends Pokoje{
	
	private int numer;
	
	/*
	 * lista termiow zawiera atrape reprezentowana przez date z przeszlosci
	 * jej kolejne elementy to data rozpoczecia zarezerwowanego terminu a dalej data jego zakonczenia
	 * wiec lista ma postac:
	 * atrapa -> pocz_rezerwacji1 -> kon_rezerwacji1 -> pocz_rezerwacji2 -> kon_rezerwacji2 -> ...
	 * */
	private LinkedList<Calendar> lista_terminow;
	
	Pokoj(int numer,int liczba_osob,int cena,styl wystroj,kolorystyka kolor,strona kierunek,boolean internet){
		
		super(liczba_osob,cena,wystroj,kolor,kierunek,internet);
		this.numer = numer;
		
		Calendar poczatek = Calendar.getInstance();
		poczatek.set(1980,Calendar.JANUARY,1);
		
		this.setLista_terminow(new LinkedList<Calendar>());
		this.getLista_terminow().addFirst(poczatek);
	}
	
	public void dodaj_termin(Calendar termin){		

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println("--->" + format.format(getLista_terminow().get(0).getTime()));
		
		//Calendar pom = Calendar.getInstance();
		//pom.clone();
		
		
		int i = 0;
		Calendar pom = getLista_terminow().get(i);
		while(i < getLista_terminow().size() - 1 && pom.before(termin)){
			i++;
			pom = getLista_terminow().get(i);
		}
		
		pom = getLista_terminow().get(getLista_terminow().size() - 1);
		if(pom.before(termin))
			getLista_terminow().addLast((Calendar) termin.clone());
		else
			getLista_terminow().add(i, (Calendar) termin.clone());
	}

	
	public boolean czy_termin_jest_wolny(Calendar termin,int liczba_dni)
	{
		
		if(getLista_terminow().get(getLista_terminow().size() - 1).before(termin))
			return true;
		else{
			int i = 0;
			Calendar koniec = (Calendar) termin.clone();
			koniec.add(Calendar.DATE,liczba_dni);
			while(i < getLista_terminow().size() - 1 && !(getLista_terminow().get(i).before(termin) && getLista_terminow().get(i + 1).after(koniec))){
				i += 2;
			}
			
			if(i == getLista_terminow().size() - 1)
				return false;
			else
				return true;

		}
			
	}
	
	public void dodaj_pobyt(Calendar termin,int liczba_dni){
		
		this.dodaj_termin((Calendar)termin.clone());
		termin.add(Calendar.DATE,liczba_dni - 1);
		this.dodaj_termin((Calendar)termin.clone());
		termin.add(Calendar.DATE,-liczba_dni + 1);/*????*/
		
	}
	
	public String toString(){
		return("numer:" + this.numer + '\n' + super.toString());
	}
	
	public String toStringLine(){
		return("numer:" + this.numer + super.toStringLine());
	}
	
	public LinkedList<Calendar> getLista_terminow() {
		return lista_terminow;
	}

	public void setLista_terminow(LinkedList<Calendar> lista_terminow) {
		this.lista_terminow = lista_terminow;
	}

	public int getNumer() {
		return numer;
	}

}
