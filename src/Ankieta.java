import java.text.SimpleDateFormat;
import java.util.Calendar;

import enumerators.kolorystyka;
import enumerators.strona;
import enumerators.styl;



public class Ankieta extends Pokoje{
	
	private int czas_pobytu;
	private Calendar data_przyjazdu;
	
	Ankieta (Calendar data,int czas_pobytu,int liczba_osob,int cena,styl wystroj,kolorystyka kolor,strona kierunek,boolean internet){
		
		super(liczba_osob,cena,wystroj,kolor,kierunek,internet);
		this.setCzas_pobytu(czas_pobytu);
		this.setData_przyjazdu(data);
	}

	public Calendar getData_przyjazdu() {
		return data_przyjazdu;
	}

	public void setData_przyjazdu(Calendar data_przyjazdu) {
		this.data_przyjazdu = data_przyjazdu;
	}

	public int getCzas_pobytu() {
		return czas_pobytu;
	}

	public void setCzas_pobytu(int czas_pobytu) {
		this.czas_pobytu = czas_pobytu;
	}
	
	public String toString(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		return("data przyjazdu: " + format.format(this.data_przyjazdu.getTime()) + "\n" + "czas pobytu:" + this.czas_pobytu + '\n' + super.toString());
	}
	
	public String toStringLine(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		return("data przyjazdu:" + format.format(this.data_przyjazdu.getTime()) + ",czas pobytu:" + this.czas_pobytu + super.toStringLine());
	}

}
