package enumerators;


public enum styl {
	orientalny, morski, nowoczesny, rustykalny, secesyjny;

	public static styl losuj(){
		return(values()[(int) (Math.random() * values().length)]);
	}
}
