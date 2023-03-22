package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer04;

import java.util.ArrayList;
import java.util.List;

public class Student extends Osoba implements Comparable<Student>{

	private String index;
	//nije vise hard kodirano da mora biti cetiri ocene
	private List<Integer> ocene;
	
	public Student() {
		super();
		ocene = new ArrayList<Integer>();
	}
	
	public Student(String JMBG, String imeIPrezime, String grad, String index) {
		super(JMBG, imeIPrezime, grad);
		this.index = index;
		ocene = new ArrayList<Integer>();
	}

	public Student(String jMBG, String imeIPrezime, String grad, String index,
			List<Integer> ocene) {
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
	
		this.ocene = new ArrayList<Integer>();
		String [] oceneTekst = tokeni[4].split(";");
		//npr. 		"8;9;7;8"
		//tokeni 	 0 		1	   2
		for (int i = 0; i < oceneTekst.length; i++) {
			try {
				ocene.add(Integer.parseInt(oceneTekst[i]));
			} catch (Exception e) {
				System.out.println("Greska pri ocitavanju 4");
				System.exit(0);
			}
		}
	}
	
	public String toCSV(){
		StringBuffer stBuf = new StringBuffer();
		stBuf.append(JMBG + "," + imeIPrezime + ","+ grad  + "," + index+",");
		if(ocene.isEmpty())
			stBuf.append(";"); //zbog provere u konstruktoru da li ima bas 5 tokena
		else {
			for (Integer oc : ocene) {
				stBuf.append(oc+";");
			}
		}
		return stBuf.toString();
	}
	
	public double izracunajProsek(){	
		double retVal = 0;
		if(ocene == null || ocene.isEmpty())
			return retVal;
		
		int suma = 0;
		for (int i = 0; i < ocene.size(); i++) {
			suma+=ocene.get(i);
		}
		retVal = (double)suma/ocene.size();
		return retVal;
	}
	
	//prebacivanje objekta Student u string reprezentaciju
	@Override
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
	
	//ovo ce nam omoguciti da sortiramo po broju indeksa
	@Override
	public int compareTo(Student o) {
		//ako je objekat u zagradi null ili njegov index je null onda je on na kraju liste
		if((o == null) || (o.index == null))
			return -1;
		//ako je this.index null onda je this na kraju liste
		if(this.index == null)
			return 1;
		//pozivamo compareTo metodu Stringa koja poredi leksikografski stringove
		return this.index.compareTo(o.index);
	} 
	
	public String toStringOcene() {
		String retVal = "";
		for (int i = 0; i < ocene.size(); i++) {
			int oc  = ocene.get(i);		
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
	

	public List<Integer> getOcene() {
		return ocene;
	}

	public void setOcene(List<Integer> ocene) {
		this.ocene = ocene;
	}
}
