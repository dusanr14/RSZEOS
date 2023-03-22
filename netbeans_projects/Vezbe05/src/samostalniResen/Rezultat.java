package samostalniResen;



public class Rezultat implements Comparable<Rezultat> {

	private String index;
	private String imeIPrezime;
	private int brojBodovaTeorija;
	private int brojBodovaZadaci;
	private int ukupanBrojBodova;
	private int konacnaOcena;

	public Rezultat(String red) {
		String[] tokeni = red.split(",");

		this.index = tokeni[0];
		this.imeIPrezime = tokeni[1];
		this.brojBodovaTeorija = Integer.parseInt(tokeni[2]);
		this.brojBodovaZadaci = Integer.parseInt(tokeni[3]);
		this.ukupanBrojBodova = Integer.parseInt(tokeni[4]);
		this.konacnaOcena = Integer.parseInt(tokeni[5]);
	}

	public Rezultat(String index, String imeIPrezime, int brojBodovaTeorija,
			int brojBodovaZadaci) {
		super();
		this.index = index;
		this.imeIPrezime = imeIPrezime;
		this.brojBodovaTeorija = brojBodovaTeorija;
		this.brojBodovaZadaci = brojBodovaZadaci;
		izracunajOcenu();
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}

	public int getBrojBodovaTeorija() {
		return brojBodovaTeorija;
	}

	public void setBrojBodovaTeorija(int brojBodovaTeorija) {
		this.brojBodovaTeorija = brojBodovaTeorija;
		izracunajOcenu();
	}

	public int getBrojBodovaZadaci() {
		return brojBodovaZadaci;
	}

	public void setBrojBodovaZadaci(int brojBodovaZadaci) {
		this.brojBodovaZadaci = brojBodovaZadaci;
		izracunajOcenu();
	}

	public int getUkupanBrojBodova() {
		return ukupanBrojBodova;
	}

	public void setUkupanBrojBodova(int ukupanBrojBodova) {
		this.ukupanBrojBodova = ukupanBrojBodova;
	}

	public int getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public int izracunajOcenu() {
		ukupanBrojBodova = brojBodovaTeorija + brojBodovaZadaci;
		int ocena;
		if (ukupanBrojBodova >= 95)
			ocena = 10;
		else if (ukupanBrojBodova >= 85)
			ocena = 9;
		else if (ukupanBrojBodova >= 75)
			ocena = 8;
		else if (ukupanBrojBodova >= 65)
			ocena = 7;
		else if (ukupanBrojBodova >= 55)
			ocena = 6;
		else
			ocena = 5;

		konacnaOcena=ocena;
		return ocena;
	}

	@Override
	public String toString() {
		return "Student sa indeksom:" + index + " cije je ime " + imeIPrezime
				+ " ostvario je sledeci rezultat - teorija: " + brojBodovaTeorija + ", zadaci:  "
				+ brojBodovaZadaci + ", ukupno: " + ukupanBrojBodova
				+ ", ocena: " + konacnaOcena;
	}
	
	public String toCSV() {
		return index + "," + imeIPrezime + ","
				+ brojBodovaTeorija + ","
				+ brojBodovaZadaci + "," + ukupanBrojBodova
				+ "," + konacnaOcena;
	}

	//metoda odgovara da li su dva objekta Rezultat ista (isti su ako imaju isti index studenta ciji je to rezultat), 
	//	ali moze i Rezultat da se poredi sa String-om koji je broj indeksa
	@Override
	public boolean equals(Object obj) {
		boolean isti = false;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof Rezultat) {
			Rezultat objRezultat = (Rezultat) obj;
			if(this.index.equals(objRezultat.index))
				return true;
		}
		//porednjenje Rezultata i Stringa koji je broj indeksa
		if (obj instanceof String) {
			if(this.index.equals(obj))
				return true;
		}
		return isti;
	}
	
	//ovo ce nam omoguciti da sortiramo rezultate po ukupnim bodovima
	@Override
	public int compareTo(Rezultat anotherRez) {
		//ako je objekat u zagradi null onda je this veci od njega
		if(anotherRez == null)
			return 1;

		int retVal = 0;
		if(ukupanBrojBodova> anotherRez.ukupanBrojBodova)
			retVal = 1;
		else if(ukupanBrojBodova> anotherRez.ukupanBrojBodova)
			retVal = -1;
		
		return retVal * (-1); //-1 za opadajuce
	} 

}
