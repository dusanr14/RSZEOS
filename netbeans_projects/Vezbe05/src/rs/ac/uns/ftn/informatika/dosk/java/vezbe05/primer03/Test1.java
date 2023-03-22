package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer03;

import java.util.ArrayList;

public class Test1 {
	
	public static ArrayList<Osoba> osobe = new ArrayList<Osoba>();
	public static ArrayList<Student> studenti = new ArrayList<Student>();
	
	public static void main(String[] args) {

		Student st1 = new Student("0000000000001,Petar Petrovic,Loznica,RS 02/11,10;9;");
		Student st2 = new Student("0000000000002,Marko Markovic,Novi Sad,RS 01/11,;");
		Student st3 = new Student("0000000000003,Jovan Jovanovic,Novi Sad,RS 03/11,6;7;8;");
		
		//zbog toga sto je Osoba osnovna klasa mozemo dodavati studente u listu osoba
		osobe.add(st1);
		osobe.add(st2);
		osobe.add(st3);
		
		System.out.println("Broj osoba je:"+osobe.size());
		System.out.println("Ispis druge osobe "+ osobe.get(1));
		
		//dodavanje studenata
		studenti.add(st1);
		studenti.add(st2);
		studenti.add(1, st3);
		
		studenti.set(0, new Student("0000000000004,Danijel Danilovic,Vrsac,RS 55/55,;"));
	
		System.out.println("******************************");
		//ispis svih studenata 1 NACIN
		for (int i = 0; i < studenti.size(); i++) {
			System.out.println(studenti.get(i));
		}
		System.out.println("******************************");
		//ispis svih studenata 1 NACIN
		for (Student st : studenti) {
			System.out.println(st);
		}
		
		System.out.println("******************************");
		//uklanjanje elemenata iz liste, ne i brisanje
		studenti.remove(2);
		
		//uklanjanje svih elemenata iz liste
		studenti.clear();
		System.out.println("Broj studenata je:"+studenti.size());
	}
}
