package samostalniResen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SamostalniVezbe3Zad01 {

	public static void main(String[] args) throws IOException {
		
		//brojac rezultata
		int brojacRezultata = 0;
		
		//definisanje odgovarajucih struktura 
		String [] indexSt = new String [100];
		String [] namesSt = new String [100];
		String [] codePr = new String [100];
		String [] namesPr = new String [100];
		int []    pointsT = new int    [100];
		int []    pointsP = new int    [100];
		double [] average = new double [100];
		int []    grades  = new int    [100];		
				
		String sP = System.getProperty("file.separator");
		File rezultati = new File("."+sP+"materijali"+sP+"rezultati.csv");
		
		
		if(rezultati.exists()){
//			BufferedReader in = new BufferedReader(
//				new InputStreamReader(new FileInputStream( 
//				rezultati), "UTF8")); 
			BufferedReader in = new BufferedReader(new FileReader(rezultati));
			String s2;
			
			while((s2 = in.readLine()) != null) {
//				System.out.println(s2);
				
				String [] infoSt = s2.split(",");
				//popunjavanje podataka
				indexSt[brojacRezultata] 	= infoSt[0];
				namesSt[brojacRezultata]	= infoSt[1];
				codePr[brojacRezultata]		= infoSt[2];
				namesPr[brojacRezultata]	= infoSt[3];
				pointsT[brojacRezultata]	= Integer.parseInt(infoSt[4]);
				pointsP[brojacRezultata]	= Integer.parseInt(infoSt[5]);
				average[brojacRezultata]	= Double.parseDouble(infoSt[6]);
				grades[brojacRezultata]		= Integer.parseInt(infoSt[7]);	

				//uvecavamo brojac da znamo koliko rezultata smo do sada ocitali
				brojacRezultata++;
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
			System.exit(0);
		}
		
		//LOGIKA APLIKACIJE
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int n = 0;
		do{
			//definisanje izgleda menija
			System.out.println("-----------------------------------");
			System.out.println("Studentska Sluzba opcije:");
			System.out.println("\t1.Ispis svih rezultata");
			System.out.println("\t2.Ispis podataka o odredjenom rezultatu");
			System.out.println("\t3.Izmena odredjenog rezultata");
			System.out.println("\t0.Izlaz iz programa");
			
			//citanje odluke
			System.out.println("-----------------------------------");
			System.out.print("Odaberite opciju: ");
			choice = sc.nextInt();
			sc.nextLine();
			
			//ispisivanje podataka u odnosu na odluku
			System.out.println("Odluka je:"+choice);
			switch (choice) {
				case 1: 
					System.out.println("-----------------------------------");
					for (int i = 0; i < brojacRezultata; i++) {
						System.out.println((i+1) + namesSt[i]+" "+namesPr[i]+" "+grades[i]);
					}
					break;
				case 2: 
					System.out.println("-----------------------------------");
					System.out.print("Unesite redni broj rezultata: ");
					n = sc.nextInt();
					sc.nextLine();
					n -=1;
					System.out.println("-----------------------------------");
					System.out.println("Student:"+namesSt[n]+" sa indeksom:"+indexSt[n]+" na predmetu "+namesPr[n]+
							" sa sifrom "+codePr[n]+" ima "+pointsT[n]+"+"+pointsP[n]+"="+average[n]+ " i dobio je "+grades[n]);
					break;
				case 3:
					System.out.println("-----------------------------------");
					System.out.print("Unesite redni broj rezultata: ");
					n = sc.nextInt();
					sc.nextLine();
					n -=1;
					System.out.println("Unesite novi broj bodova iz teorije:");
					int brTeorija = sc.nextInt();
					sc.nextLine();
					System.out.println("Unesite novi broj bodova iz prakticnog dela:");
					int brPrakticni = sc.nextInt();
					sc.nextLine();
					System.out.println("Unesite prosecan broj bodova:");
					double brProsecni = sc.nextDouble();
					sc.nextLine();
					System.out.println("Unesite konacnu ocenu:");
					int ocena = sc.nextInt();
					sc.nextLine();
					pointsT[n]	= brTeorija;
					pointsP[n]	= brPrakticni;
					average[n]	= brProsecni;
					grades[n]	= ocena;
					break;
				case 0:
					System.out.println("--------IZLAZ------------");
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
			
		}while (choice != 0);
		sc.close();
		System.out.println("---------SNIMANJE----------");
		
//		PrintWriter out2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(rezultati), "UTF8"));
		PrintWriter out2 = new PrintWriter(new FileWriter(rezultati));		
		for (int i = 0; i < brojacRezultata; i++) {
			
			StringBuilder buf = new StringBuilder(indexSt[i]+","+namesSt[i]+","); //ubaci indeks, ime studenta
			buf.append(codePr[i]).append(",").append(namesPr[i]).append(","); //sifru predmeta, ime predmeta
			buf.append(pointsT[i]).append(",").append(pointsP[i]).append(","); //bodove iz teorije i prakticnog dela
			buf.append(average[i]).append(",").append(grades[i]); //prosecan broj bodova i konacnu ocenu
			out2.println(buf.toString());
		}
		out2.flush();
		out2.close();
		System.out.println("--------Snimanje Zavrseno-----");

		
		System.out.println("Program izvrsen");
	}
}
