package enumerators;

public enum strona {
	polnoc, poludnie, wschod, zachod;

	public static strona losuj(){
		return(values()[(int) (Math.random() * values().length)]);
	}
	
}
