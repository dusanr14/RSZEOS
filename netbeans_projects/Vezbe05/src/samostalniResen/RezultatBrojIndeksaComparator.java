package samostalniResen;

import java.util.Comparator;

public class RezultatBrojIndeksaComparator implements Comparator<Rezultat>{

	int direction = 1;
	
	public RezultatBrojIndeksaComparator(int direction) {
		if(direction!=1 && direction!=-1){
			direction = 1;
		}
		this.direction = direction;
	}

	public int compare(Rezultat ob1, Rezultat ob2) {
		int retVal = 0;
		if(ob1!= null && ob2!=null){
			retVal = ob1.getIndex().compareTo(ob2.getIndex());
		}
		return retVal * direction;
	}
}