package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer02;

public class Student extends Osoba {

	private String index;
	private int[] ocene;
	
	public Student() {
		super();
		ocene = new int[4];
	}
	
	public Student(String JMBG, String imeIPrezime, String grad, String index) {
		super(JMBG, imeIPrezime, grad);
		this.index = index;
		this.ocene = new int[4];
	}

	public Student(String jMBG, String imeIPrezime, String grad, String index,
			int[] ocene) {
		super(jMBG, imeIPrezime, grad);
		this.index = index;
		this.ocene = ocene;
	}

	public Student(String tekst){
		String [] tokeni = tekst.split(",");
		//npr. "0000000000001,Petar Petrovic,Loznica,RS 01/11,8;7;6;"
		//tokeni 0				1				2		3		4	
		
		if(tokeni.length!=5){
			System.out.println("Greska pri ocitavanju 1-Student " +tekst);
			System.exit(0);
		}
		this.JMBG = tokeni[0];
		this.imeIPrezime = tokeni[1];
		this.grad = tokeni[2];
		this.index = tokeni[3];
	
		//npr. 		"8;9;7;8;"
		//tokeni 	 0 1 2 3
		String [] oceneTekst = tokeni[4].split(";");
		
		//samo ako nema ocena
		if(oceneTekst.length==0){
			this.ocene = new int[4];
			return;
		}
		
		this.ocene = new int [oceneTekst.length];
		
		for (int i = 0; i < oceneTekst.length; i++) {
			try {
				ocene[i] = Integer.parseInt(oceneTekst[i]);
			} catch (Exception e) {
				System.out.println("Greska pri ocitavanju cene");
				System.exit(0);
			}
		}
	}
	
	public double izracunajProsek(){	
		double retVal = 0;
		if(ocene == null)
			return retVal;
		
		int suma = 0;
		for (int i = 0; i < ocene.length; i++) {
			suma+=ocene[i];
		}
		retVal = (double)suma/ocene.length;
		return retVal;
	}
	
	//prebacivanje objekta Student u string reprezentaciju
	
	public String toString() {
		return "Student sa indeksom:" + index + " cije je ime " + imeIPrezime
				+ " iz grada " + grad + " ima prosecnu ocenu:" + izracunajProsek();
	}
	//da li su dva objekta Student ista (isti su ako imaju isti index), 
	//	ali moze i Student da se poredi sa String-om koji je broj indeksa
	@Override
	public boolean equals(Object obj) {
		boolean isti = false;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof Student) {
			Student objStudent = (Student) obj;
			if(this.index.equals(objStudent.index))
				return true;
		}
		//porednjenje Studenta i Stringa koji je broj indeksa
		if (obj instanceof String) {
			if(this.index.equals(obj))
				return true;
		}
		return isti;
	}

	public String toStringOcene() {
		String retVal = "";
		for (int i = 0; i < ocene.length; i++) {
			int oc  = ocene[i];		
			retVal+=(i+1)+": "+oc+"\n";
		}
		return retVal;		
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int[] getOcene() {
		return ocene;
	}

	public void setOcene(int[] ocene) {
		this.ocene = ocene;
	}
}
