package vezbe3.primer3;

import java.util.Scanner;

public class Strings02 {

	public static void main(String[] args) {

		//CITANJE PODATAKA IZ FAJLA
		
		//Sadrzaj txt fajla koji cuva podatke o studentima i njihovim ocenama
		//pretpostavka je da svaki student ima 4 ocene
		String text = "e10001|Petar Petrovic|Novi Sad|10;9;8;9\n" +
				"e10002|Marko Markovic|Loznica|7;9;8;10\n" +
				"e10003|Dejan Dejanovic|Indjija|8;7;6;8\n";
		
		//Alternativa ovome je upotreba StringTokenizer-a, koji radi nesto drugacije
		// zasto je dva puta slash pre n?
		// parametar split metode je regularni izraz, sta je regularni izraz?
		String [] studentsAllInfo = text.split("\\n");
		
		//definisanje odgovarajucih struktura 
		String [] indexSt = new String [studentsAllInfo.length];
		String [] namesSt = new String [studentsAllInfo.length];
		String [] citiesSt = new String [studentsAllInfo.length];
		String [] [] marksSt = new String [studentsAllInfo.length] [4];
		
		//popunjavanje podataka
		for (int i = 0; i < studentsAllInfo.length; i++) {
			String [] infoSt = studentsAllInfo[i].split("\\|");
			indexSt[i] 		= infoSt[0];
			namesSt[i]		= infoSt[1];
			citiesSt[i] 	= infoSt[2];
			marksSt[i] 		= infoSt[3].split(";");
		}
		
		//LOGIKA APLIKACIJE
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int n = 0;
		do{
			//definisanje izgleda menija
			System.out.println("-----------------------------------");
			System.out.println("Studentska Sluzba opcije:");
			System.out.println("\t1.Ispis imena svih studenata");
			System.out.println("\t2.Ispis podataka o studentu");
			System.out.println("\t3.Ispis ocena studenta");
			System.out.println("\t4.Izlaz iz programa");
			
			//citanje odluke
			System.out.println("-----------------------------------");
			System.out.print("Odaberite opciju: ");
			choice = sc.nextInt();
			
			//ispisivanje podataka u odnosu na odluku
			System.out.println("Odluka je:"+choice);
			switch (choice) {
				case 1: 
					System.out.println("-----------------------------------");
					for (int i = 0; i < namesSt.length; i++) {
						System.out.println((i+1) + namesSt[i]);
					}
					break;
				case 2: 
					System.out.println("-----------------------------------");
					System.out.print("Unesite redni broj studenta: ");
					n = sc.nextInt();
					n -=1;
					System.out.println("-----------------------------------");
					System.out.println("Student:"+namesSt[n]+" sa indeksom:"+indexSt[n]+" je iz grada:"+citiesSt[n]);
					break;
				case 3:
					System.out.println("-----------------------------------");
					System.out.print("Unesite redni broj studenta: ");
					n = sc.nextInt();
					n -=1;
					System.out.println("-----------------------------------");
					System.out.println("Student:"+namesSt[n] +" ima ocene:");
					for (int i = 0; i < marksSt[n].length; i++) {
						System.out.println(marksSt[n][i]);
					}
					break;
				default: 
					System.out.println("Nepostojeca komanda");
					break;
			}
		}while (choice != 4);
			
		StringBuffer buf = new StringBuffer();
		//TODO pokusati napraviti meni pomocu StringBuffer i StringBuilder klase
		//TODO pronaci na Internetu koja je razlika izmedju StringBuffer i StringBuilder klase
	}

}
