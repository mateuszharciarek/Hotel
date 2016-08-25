import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;


import enumerators.kolorystyka;
import enumerators.strona;
import enumerators.styl;

/**
 * Zadanie zaliczeniowe nr 1 na zajecia laboratoryjne z Programowania Obiektowego
 * Uniwersytet Warszawski wydzial Matematyki Informatyki Mechaniki semestr 2015/2016
 *
 * autor: Mateusz Harciarek <mh359520@students.mimuw.edu.pl>
 * data: 21.04.2016
 */
public class Hotel {
	
	/*
	 * Na formu w moodlu powstala rozbudowana dyskusja na temat struktury klasy hotel
	 * nie wynika z niej jednoznacznie jakie jest poprawne rozwiazanie a przedstawione
	 * tam propozycje wedlug mnie niepotrzebnie komplikuja program nie majac zadnego wplywu
	 * na jego dzialanie. Uznalem wiec ze stworzenie konstruktora w ten sposob i dodanie argumentow
	 * pokoje i recepcjonisci do klasy Hotel to baza do rozbudowy programu nie uzywana jednak w
	 * naszej wersji.
	 * */
	private Pokoj[] pokoje;
	private Recepcjonista[] recepcjonisci;
	
	Hotel(Pokoj [] pokoje, Recepcjonista [] recepcjonisci){
		this.pokoje = pokoje.clone();
		this.recepcjonisci = recepcjonisci.clone();
	}
	
	
	public static String losoj_wyraz(){
		
		Random generator = new Random();
		String losowy_wyraz = "";
		
		for(int i = 0;i < generator.nextInt(10) + 3;i++){
			losowy_wyraz += (char)(generator.nextInt(26) + 'a');
		}
		return losowy_wyraz;
	}
	
	public Zamowienie przyjmijZamowienie(Klient klient, Ankieta ankieta){
		Zamowienie tmp = new Zamowienie(klient,ankieta);
		return tmp;
	}
	
	public void akceptuj(Zamowienie[] zamowienia, Pokoj[] pokoje, Recepcjonista[] recepcjonisci){
		
		int r = 0;
		int wybor;
		boolean czy_ok;
		boolean[] zaakceptowane = new boolean[zamowienia.length];
		Arrays.fill(zaakceptowane, false);
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < zamowienia.length; j++){
				if(!zaakceptowane[j]){
					if(r == recepcjonisci.length){
						r = 0;
					}
				
					wybor = recepcjonisci[r].getStrategia().wybierz_pokoj(pokoje,zamowienia[j].getAnkieta());
					
					czy_ok = false;
					if(wybor != -1){
						czy_ok = zamowienia[j].getKlient().getStrategia().czy_akceptuje_pokoj(pokoje[wybor], zamowienia[j].getAnkieta());
					}
					
					if(czy_ok){
						zaakceptowane[j] = true;
						pokoje[wybor].dodaj_pobyt(zamowienia[j].getAnkieta().getData_przyjazdu(),zamowienia[j].getAnkieta().getCzas_pobytu());
					}
					System.out.println(recepcjonisci[r].toString());
					System.out.print("Zamowienie:" + zamowienia[j].getAnkieta().toStringLine());
					if(wybor == -1){
						System.out.println("w tym terminie nie ma wolnego pokoju spelniajacego takie wymagania");
					}
					else{
						System.out.print("Proponowany pokoj:" + pokoje[wybor].toStringLine());
					}
					System.out.println(zamowienia[j].getKlient().toString());
					if(czy_ok){
						System.out.println("tak\n");
					}
					else{
						System.out.println("nie\n");
					}
					
				r++;
				}
			}
		}
	}
	
	public static void main(String[]args){
		
		/*aby zmienic liczbe losowo wygenerowanych pokoi,recepcjonistow,klientow wystarczy zmienic
		 * jedna z trzech ponizszych wartosci (ankiet i zamowien jest tyle co klientow i ankiety
		 * rowniez generuja sie losowo)*/
		int liczba_pokoi = 1000;
		int liczba_recepcjonistow = 10;
		int liczba_klientow = 100;
		
		Random generator = new Random();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Pokoj[] pokoje = new Pokoj[liczba_pokoi];
		
		for(int i = 0; i < liczba_pokoi; i++){
			pokoje[i] = new Pokoj(i+1,generator.nextInt(6) + 1,generator.nextInt(1200)/10 + 30,styl.losuj(),kolorystyka.losuj(),strona.losuj(),generator.nextBoolean());
		}
		
		Recepcjonista[] recepcjonisci = new Recepcjonista[liczba_recepcjonistow];
		
		Zlosliwa zlosliwa = new Zlosliwa();
		Aproksymacyjna aproksymacyjna = new Aproksymacyjna();
		Losowa losowa = new Losowa();
		Perfekcjonista perfekcjonista = new Perfekcjonista();
		
		Str_r [] strategie_r = new Str_r[4];
		strategie_r[0] = zlosliwa;
		strategie_r[1] = aproksymacyjna;
		strategie_r[2] = losowa;
		strategie_r[3] = perfekcjonista;		
		
		for(int i = 0; i < liczba_recepcjonistow; i++){
			recepcjonisci[i] = new Recepcjonista(losoj_wyraz(),losoj_wyraz(),strategie_r[generator.nextInt(4)]);
		}
		
		Klient[] klienci = new Klient[liczba_klientow];
		
		Perfekcjonista_Klient perfekcjonista_klient = new Perfekcjonista_Klient();
		Ugodowa_Klienta ugodowa_klienta = new Ugodowa_Klienta();
		Widokowa_Klienta widokowa_klienta = new Widokowa_Klienta();
		Polowiczna_Klienta polowiczna_klienta = new Polowiczna_Klienta();
		Budzetowa_Klienta budzetowa_klienta = new Budzetowa_Klienta();
		
		Str_k [] strategie_k = new Str_k[5];
		strategie_k[0] = perfekcjonista_klient;
		strategie_k[1] = ugodowa_klienta;
		strategie_k[2] = widokowa_klienta;
		strategie_k[3] = polowiczna_klienta;
		strategie_k[4] = budzetowa_klienta;

		for(int i = 0; i < liczba_klientow; i++){
			klienci[i] = new Klient(losoj_wyraz(),losoj_wyraz(),strategie_k[generator.nextInt(5)]);
		}
		
		Ankieta[] ankiety = new Ankieta[liczba_klientow];
		
		Calendar randomDate = Calendar.getInstance();

		for(int i = 0; i < liczba_klientow; i++){
			randomDate.set(2016 + generator.nextInt(2),generator.nextInt(12),generator.nextInt(30) + 1);
			ankiety[i] = new Ankieta ((Calendar)randomDate.clone(),generator.nextInt(19) + 1,generator.nextInt(6) + 1,generator.nextInt(1200)/10 + 30,styl.losuj(),kolorystyka.losuj(),strona.losuj(),generator.nextBoolean());
		}
		
		Hotel hotel1 = new Hotel(pokoje,recepcjonisci);
		
		Zamowienie[] zamowienia = new Zamowienie[liczba_klientow];
		for(int i = 0; i < liczba_klientow; i++){
			zamowienia[i] = hotel1.przyjmijZamowienie(klienci[i], ankiety[i]);
		}
		
		hotel1.akceptuj(zamowienia, pokoje, recepcjonisci);
		
		//wyswietlanie wszystkich pokoi
		/*
		for(int i = 0; i< liczba_pokoi; i++){
			System.out.println(pokoje[i].toString());
			for(int j = 0; j < pokoje[i].getLista_terminow().size();j++){
				System.out.println("->" + format.format(pokoje[i].getLista_terminow().get(j).getTime()));
			}
			System.out.println();
		}
		*/
		
		//wyswietlanie wszystkich recepcjonistow
		/*
		for(int i = 0; i < liczba_recepcjonistow; i++){
			System.out.println(recepcjonisci[i].toString());
		}
		System.out.println();
		*/
		
		//wyswietlanie wszystkich klientow
		/*
		for(int i = 0; i < liczba_klientow; i++){
			System.out.println(klienci[i].toString());
		}
		System.out.println();
		*/
		
		//wyswietlanie wszystkich ankiet
		/*				
		for(int i = 0; i < liczba_klientow; i++){
			System.out.println(ankiety[i].toString());
		}
		*/
	}
}
