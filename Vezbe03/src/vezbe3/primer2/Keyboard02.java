package vezbe3.primer2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Keyboard02 {
	public static void main(String[] args) throws IOException {
		
		String name;
		int height;
		//klasa Scanner se takodje moze koristiti za citanje sa tastature
		//ne radi samo sa stringovima
		Scanner sc = new Scanner(System.in); 
		System.out.print("Unesite svoje ime: ");
		name = sc.nextLine(); 
		System.out.println("Uneli ste: " + name);
		
		System.out.print("Unesite svoju visinu: ");
		//ovde je razlika
        height = sc.nextInt();
                
                System.out.println("Uneli ste: " + height);
		
		System.out.print("Unesite svoj broj cipela (moze i sa .): ");
                while(!sc.hasNextFloat()){
                    System.out.println("Unesi broj koji moze da se konvertuje u float");
                    sc.nextLine();//uklanja ono sto je vec bilo
                }
		float number = sc.nextFloat(); 
		System.out.println("Uneli ste: " + number);

		System.out.println("---------------------------------");
		System.out.println("Pregled sadrzaja foldera");
		//kreiranje File objekta koji reprezentuje current folder
		File current = new File(".");
		//prikaz sadrzaja ovog foldera
		File[] files = current.listFiles();
		if(current.isDirectory()){
			for (int i=0; i < files.length; i++) {
				File file = files[i];
				System.out.println(i + ") " + file.getName() + ((file.isDirectory())?(", folder"):(", size (bytes): " + file.length())));
			}
		}
		System.out.print("Odaberite redni broj foldera ciji sadrzaj zelite da vidite: ");
		int choice = sc.nextInt();
		if(files[choice].isDirectory()){
			for (File file: files[choice].listFiles()) {
				System.out.println(file.getName() + ((file.isDirectory())?(", folder"):(", size (bytes): " + file.length())));
			}
		}
		
		//TODO promeniti prethodni kod, tako da redni brojevi koje korisnik bira pocinju od 1, a ne od 0
		//TODO ako nije direktorijum obavestiti korisnika o tome
		
		
		System.out.println("Kraj programa");
	}
}
