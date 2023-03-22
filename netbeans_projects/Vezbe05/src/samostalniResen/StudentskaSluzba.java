package samostalniResen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentskaSluzba {

	/** ATRIBUTI KLASE ****/
	public static List<Rezultat> sviRezultati = new ArrayList<Rezultat>();
	
	//zauzimamo vise nego sto nam u startu treba, jer niz ne mozemo kasnije povecati
//	public static Rezultat[] sviRezultati = new Rezultat[100];
//	public static int brojRezultata = 0;
	
	/** METODE ZA ISPIS OPCIJA ****/
	//ispis teksta osnovnih opcija
	public static void ispisiTekstOsnovneOpcije(){	
		System.out.println("Rezultatska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa Rezultatima");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void ispisiTekstRezultatOpcije(){	
		System.out.println("Rad sa Rezultatima - opcije:");
		System.out.println("\tOpcija broj 1 - ispis svih Rezultata");
		System.out.println("\tOpcija broj 2 - unos novog Rezultata");
		System.out.println("\tOpcija broj 3 - izmena Rezultata");
		System.out.println("\tOpcija broj 4 - brisanje Rezultata");
		System.out.println("\tOpcija broj 5 - sortiranje Rezultata");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA ISPIS Rezultata i ocena ****/
	//ispisi sve Rezultate
	public static void ispisiSveRezultate(){
		for (int i = 0; i < sviRezultati.size(); i++) {
			System.out.println(sviRezultati.get(i));
		}
	}
		
	/** METODE ZA PRETRAGU Rezultata****/
	//pronadji Rezultata
	private static Rezultat pronadjiRezultat(){
		Rezultat retVal = null;
		System.out.println("Unesi indeks studenta:");
		String stIndex = Utility.ocitajTekst();
		retVal = pronadjiRezultat(stIndex);
		if(retVal == null)
			System.out.println("Rezultat za studenta sa indeksom " +stIndex + " ne postoji u evidenciji");
		return retVal;
	}
	
	//pronadji Rezultata
	private static Rezultat pronadjiRezultat(String stIndex){
		Rezultat retVal = null;
		for (int i = 0; i < sviRezultati.size(); i++) {
			Rezultat st = sviRezultati.get(i);
			if (st.equals(stIndex)) {
				retVal = st;
				break;
			}
		}
		return retVal;
	}
	
	/** METODE ZA UNOS, IZMENU i BRISANJE Rezultata****/
	
	//unos novog Rezultata
	public static void unosNovogRezultata(){
		System.out.print("Unesi index:");
		String stIndex = Utility.ocitajTekst();
		stIndex = stIndex.toUpperCase();
		while(pronadjiRezultat(stIndex) != null){
			System.out.println("Rezultat za studenta sa indeksom "+stIndex + " vec postoji");
			stIndex = Utility.ocitajTekst();
		}
		System.out.print("Unesi ime i prezime:");
		String stImeIPrezime = Utility.ocitajTekst();
		System.out.print("Unesi rezultat - teorija:");
		int bodoviTeorija  = Utility.ocitajCeoBroj();
		System.out.print("Unesi rezultat - zadaci:");
		int bodoviZadaci  = Utility.ocitajCeoBroj();
		
		Rezultat rez = new Rezultat(stIndex, stImeIPrezime, bodoviTeorija, bodoviZadaci);
		sviRezultati.add(rez);
//		sviRezultati[brojRezultata] = st;
//		brojRezultata++;
		
	}
	
	//izmena Rezultata
	public static void izmenaPodatakaORezultatu(){
		Rezultat rez  = pronadjiRezultat();
		if(rez != null){
			int choice; 
			do{
				System.out.println(rez);
				System.out.println("Izmena rezultata - opcije:");
				System.out.println("\tOpcija broj 1 - ime i prezime");
				System.out.println("\tOpcija broj 2 - bodovi teorija");
				System.out.println("\tOpcija broj 3 - bodovi zadaci");
				System.out.println("\t\t ...");
				System.out.println("\tOpcija broj 0 - IZLAZ");
				System.out.print("opcija: ");
				choice = Utility.ocitajCeoBroj();
				switch (choice) {
				case 1:
					System.out.print("Unesi ime i prezime:");
					String stImeIPrezime = Utility.ocitajTekst();
					rez.setImeIPrezime(stImeIPrezime);
					break;
				case 2:
					System.out.print("Unesi rezultat - teorija:");
					int bodoviTeorija  = Utility.ocitajCeoBroj();
					rez.setBrojBodovaTeorija(bodoviTeorija);
					break;
				case 3:
					System.out.print("Unesi rezultat - zadaci:");
					int bodoviZadaci  = Utility.ocitajCeoBroj();
					rez.setBrojBodovaZadaci(bodoviZadaci);
					break;
				}
			} while(choice != 0);
		}
	}
	
	//brisanje Rezultata
	public static void brisanjePodatakaORezultatu(){
		Rezultat rez  = pronadjiRezultat();
		if(rez != null){
			sviRezultati.remove(rez);
		}
	}
	
	/** METODA ZA SORTIRANJE STUDENATA****/
	public static void sortiranjeRezultata(){
		int choice; 
		do{
			System.out.println("Sortiranje rezultata - opcije:");
			System.out.println("\tOpcija broj 1 - po ukupnim bodovima");
			System.out.println("\tOpcija broj 2 - po broju indeksa");
			System.out.println("\t\t ...");
			System.out.println("\tOpcija broj 0 - IZLAZ");
			System.out.print("opcija: ");
			choice = Utility.ocitajCeoBroj();
			switch (choice) {
			case 1:
				sortirajRezultatePoBrojuBodova();
				break;
			case 2:
				sortirajRezultatePoBrojuIndeksa();
				break;
			}
			ispisiSveRezultate();
		} while(choice != 0);
		
	}
	
	private static void sortirajRezultatePoBrojuBodova(){
		Collections.sort(sviRezultati);
	}
	
	private static void sortirajRezultatePoBrojuIndeksa(){
		Collections.sort(sviRezultati, new RezultatBrojIndeksaComparator(1));
	}
	

		/** METODA ZA UCITAVANJE PODATAKA
		 * @throws IOException ****/
	public static void ucitavanjePodataka() throws IOException{
		sviRezultati = Datoteka.citanjeDatoteke();
	}
	
	public static void snimanjePodataka() throws UnsupportedEncodingException, FileNotFoundException {
		Datoteka.upisUDatoteku(sviRezultati);
	}
	

}
