package enumerators;

public enum kolorystyka {
	szary, stalowy, purpurowy, morski, seledynowy, jaznozielony;
	
	public static kolorystyka losuj(){
		return(values()[(int) (Math.random() * values().length)]);
	}

}
