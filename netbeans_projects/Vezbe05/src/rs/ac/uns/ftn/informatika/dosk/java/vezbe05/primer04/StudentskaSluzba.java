package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentskaSluzba {

	/** ATRIBUTI KLASE ****/
	//posto radimo sa ArrayList, ne moramo inicijalno reci velicinu
	public static List<Student> sviStudenti = new ArrayList<Student>();
	//ovo nam vise ne treba, mozemo da vidimo velicinu sa sviStudenti.size()
	//	public static int brojStudenata = 0;
	
	/** METODE ZA ISPIS OPCIJA ****/
	//ispis teksta osnovnih opcija
	public static void ispisiTekstOsnovneOpcije(){	
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void ispisiTekstStudentOpcije(){	
		System.out.println("Rad sa studentima - opcije:");
		System.out.println("\tOpcija broj 1 - unos podataka o novom studentu");
		System.out.println("\tOpcija broj 2 - izmena podataka o studentu");
		System.out.println("\tOpcija broj 3 - ispis podataka svih studenata");
		System.out.println("\tOpcija broj 4 - ispis podataka o odredenom studentu sa njegovim ocenama");
		System.out.println("\tOpcija broj 5 - unos ocena i racunanje proseka studenta");
		System.out.println("\tOpcija broj 6 - sortiranje studenata po indeksu");
		System.out.println("\tOpcija broj 7 - sortiranje studenata po imenu");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA ISPIS STUDENATA i ocena ****/
	//ispisi sve studente
	public static void ispisiSveStudente(){
		for (int i = 0; i < sviStudenti.size(); i++) {
			System.out.println(sviStudenti.get(i));
		}
	}
		
	//ispisi ocene studenta
	public static void ispisiOcene(Student st){
		System.out.println(st.toStringOcene());
	}
	
	/** METODE ZA PRETRAGU STUDENATA****/
	//pronadji studenta
	public static Student pronadjiStudenta(){
		Student retVal = null;
		System.out.println("Unesi indeks studenta:");
		String stIndex = Utility.ocitajTekst();
		retVal = pronadjiStudenta(stIndex);
		if(retVal == null)
			System.out.println("Student sa indeksom " +stIndex + " ne postoji u evidenciji");
		return retVal;
	}
	
	//pronadji studenta
	public static Student pronadjiStudenta(String stIndex){
		Student retVal = null;
		for (int i = 0; i < sviStudenti.size(); i++) {
			Student st = sviStudenti.get(i);
			if (st.equals(stIndex)) {
				retVal = st;
				break;
			}
		}
		return retVal;
	}
	public static int pronadjiPozicijuStudenta(){
		int retVal = -1;
		System.out.println("Unesi indeks studenta:");
		String stIndex = Utility.ocitajTekst();
		for (int i = 0; i < sviStudenti.size(); i++) {
			Student st = sviStudenti.get(i);
			if (st.equals(stIndex)) {
				retVal = i;
				break;
			}
		}
		if(retVal == -1)
			System.out.println("Student sa indeksom " +stIndex + " ne postoji u videnciji");
		return retVal;
	}
	
	/** METODE ZA UNOS i IZMENU STUDENATA****/
	
	//unos novog studenta
	public static void unosNovogStudenta(){
		System.out.print("Unesi index:");
		String stIndex = Utility.ocitajTekst();
		stIndex = stIndex.toUpperCase();
		while(pronadjiStudenta(stIndex) != null){
			System.out.println("Student sa indeksom "+stIndex + " vec postoji");
			stIndex = Utility.ocitajTekst();
		}
		System.out.print("Unesi JMBG:");
		String stJMBG = Utility.ocitajTekst();
		System.out.print("Unesi ime i prezime:");
		String stImeIPrezime = Utility.ocitajTekst();
		System.out.print("Unesi grad:");
		String stGrad  = Utility.ocitajTekst();
		
		Student st = new Student(stJMBG, stImeIPrezime, stGrad, stIndex);
		sviStudenti.add(st);
		//ovako je bilo ranije
//		sviStudenti[brojStudenata] = st;
//		brojStudenata++;
		
		if (Utility.ocitajOdlukuOPotvrdi("uneti ocene") == 'Y') {
			unosOcena(st);
		}
	}
	
	//izmena studenta
	public static void izmenaPodatakaOStudentu(){
		Student st  = pronadjiStudenta();
		if(st != null){
			System.out.print("Unesi JMBG:");
			String stJMBG = Utility.ocitajTekst();
			System.out.print("Unesi ime i prezime:");
			String stImeIPrezime = Utility.ocitajTekst();
			System.out.print("Unesi grad:");
			String stGrad  = Utility.ocitajTekst();
			
			st.setJMBG(stJMBG);
			st.setImeIPrezime(stImeIPrezime);
			st.setGrad(stGrad);
			
			
			if (Utility.ocitajOdlukuOPotvrdi("izmeniti ocene") == 'Y') {
				st.getOcene().clear();
				//ovako je bilo ranije
//				st.setOcene(new int[4]);
				unosOcena(st);
			}
		}
	}
	
	/** METODA ZA UNOS i IZMENU OCENA STUDENTA****/
	//unos ocene studenta
	public static void unosOcena(Student st){
		//menjamo nacin unosa, vise ne znamo koliko ce biti ocena
//		for(int i=0; i < st.getOcene().size(); i++){
		char odluka;
		do {
			System.out.print("Unesi ocenu:");
			int ocOcena  = -1;
			do {
				ocOcena = Utility.ocitajCeoBroj();
			}while ((ocOcena < 5) || (ocOcena > 10));
			
			st.getOcene().add(ocOcena);
			odluka = Utility.ocitajOdlukuOPotvrdi("uneti jos ocena");
		} while (odluka == 'Y');
	}
	
	/** METODA ZA SORTIRANJE STUDENATA****/
	public static void sortirajStudentePoBrojuIndeksa(){
		Collections.sort(sviStudenti);
	}
	
	public static void sortirajStudentePoImenu(){
		Collections.sort(sviStudenti, new OsobaNameComparator(1));
	}

	/** METODE ZA UCITAVANJE I SNIMANJE PODATAKA
	 * @throws IOException ****/
	public static void ucitavanjePodataka() throws IOException{

		//	ucitavanje studenata
		//sada moze biti razliciti broj ocena
		//ucitavamo iz studenti.csv
		String sP = System.getProperty("file.separator");
		File studenti = new File("."+sP+"materijali"+sP+"studenti.csv"); 
		//provera da li postoji fajl
		if(studenti.exists()){
			//koristimo reader, a ne stream, da bi bilo sve korektno sa UTF8 enkodingom
			BufferedReader in = new BufferedReader(
					new FileReader(studenti));
			String s2;
			while((s2 = in.readLine()) != null) {
				sviStudenti.add(new Student(s2));
			}
			in.close();
		}else {
			System.out.println("Ne postoji fajl!");
		}
		//ovako je bilo ranije
//		sviStudenti[brojStudenata] = new Student("e1|Petar Petrovic|Novi Sad|8;9;7;9");
//		brojStudenata++;
//		sviStudenti[brojStudenata] = new Student("e2|Marko Markovic|Loznica|8;7;7;6");
//		brojStudenata++;
//		sviStudenti[brojStudenata] = new Student("e3|Nikolic Nikolic|Indjija|9;8;8;7");
//		brojStudenata++;
	}
	
	public static void snimanjePodataka() throws UnsupportedEncodingException, FileNotFoundException, IOException {

		//	ucitavanje studenata
		//sada moze biti razliciti broj ocena
		//ucitavamo iz studenti.csv
		String sP = System.getProperty("file.separator");
		File studenti = new File("."+sP+"materijali"+sP+"studenti.csv"); 
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(studenti), "UTF8"));
//		PrintWriter out = new PrintWriter(new FileWriter(studenti));
		for (Student student : sviStudenti) {
			out.println(student.toCSV());
		}
		out.flush();
		out.close();
	}
}
