import enumerators.kolorystyka;
import enumerators.strona;
import enumerators.styl;



public class Pokoje {
	protected int liczba_osob;
	protected int cena;
	protected styl wystroj;
	protected kolorystyka kolor;
	protected strona kierunek;
	protected boolean internet;
	
	Pokoje (int liczba_osob,int cena,styl wystroj,kolorystyka kolor,strona kierunek,boolean internet){
		this.liczba_osob = liczba_osob;
		this.cena = cena;
		this.wystroj = wystroj;
		this.kolor = kolor;
		this.kierunek = kierunek;
		this.internet = internet;
	}
	
	public String toString(){
		return("liczba osob: " + this.liczba_osob + '\n' + "cena: " + this.cena + '\n' + "wystroj: "
	+ this.wystroj + '\n' + "kolor: " + this.kolor + '\n' + "kierunek: " + this.kierunek + '\n'
	+ "internet: " + this.internet + '\n');
	}

	public String toStringLine(){
		return("liczba osob:" + this.liczba_osob +  ",cena: " + this.cena +  ",wystroj:"
	+ this.wystroj + ",kolor:" + this.kolor + ",kierunek:" + this.kierunek
	+ ",internet:" + this.internet + '\n');
	}
	
	public int getLiczba_osob() {
		return liczba_osob;
	}

	public int getCena() {
		return cena;
	}

	public styl getWystroj() {
		return wystroj;
	}

	public kolorystyka getKolor() {
		return kolor;
	}

	public strona getKierunek() {
		return kierunek;
	}

	public boolean isInternet() {
		return internet;
	}

	
}
