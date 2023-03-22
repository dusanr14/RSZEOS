package samostalniResen;

import java.util.Scanner;

public class Utility {

	static Scanner sc = new Scanner(System.in);
	
	//citanje promenljive String
	public static String ocitajTekst(){
		String tekst = "";
		while(tekst == null || tekst.equals(""))
			tekst = sc.nextLine();
		
		return tekst;
	}
		
	//citanje promenljive integer
	public static int ocitajCeoBroj(){
		int ceoBroj = 0;
		boolean ocitan = false;
		while(ocitan == false) {
			if (sc.hasNextInt()) {
				ceoBroj = sc.nextInt();
				ocitan = true;
			} else {
				System.out.println("GRESKA - Pogresno unsesena vrednost za ceo broj, pokusajte ponovo: ");
				sc.nextLine();
			}
		}
		return ceoBroj;
	}
		
	//citanje promenljive double
	public static float ocitajRealanBroj(){
		float realanBroj = 0;
		boolean ocitan = false;
		while(ocitan == false) {
			if (sc.hasNextFloat()) {
				realanBroj = sc.nextFloat();
				ocitan = true;
			} else {
				System.out.println("GRESKA - Pogresno unsesena vrednost za realan broj, pokusajte ponovo: ");
				sc.nextLine();
			}
		}
		return realanBroj;
	}
		
	//citanje promenljive char
	public static char ocitajKarakter(){
		char karakter = ' ';
		boolean ocitan = false;
		while(ocitan == false) {
			String text = sc.next();
			if(text.length()==1){
				karakter = text.charAt(0);
				ocitan = true;
			}
			else {
				System.out.println("GRESKA - Pogresno unsesena vrednost za karakter, pokusajte ponovo: ");
				sc.nextLine();
			}
		}
		return karakter;
	}
	
	//citanje promenljive char
	public static char ocitajOdlukuOPotvrdi(String tekst){
		System.out.println("Da li zelite " + tekst + " [Y/N]:");
		char odluka = ' ';
		while( !(odluka == 'Y' || odluka == 'N') ){
			odluka = ocitajKarakter();
			if (!(odluka == 'Y' || odluka == 'N')) {
				System.out.println("Opcije su Y ili N");
			}
		}
		return odluka;
	}
}
