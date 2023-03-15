package vezbe3.primer1;

import java.io.File;
import java.io.IOException;

public class Fajlovi01 {

	// o izuzecima cemo kasnije u toku kursa, ovde mora da se doda throws IOException 
		public static void main(String[] args) throws IOException {
			
			//kreiranje File objekta koji reprezentuje current folder
			File current = new File(".");
			//Prikaz absolutne putanje ovog foldera
			System.out.println(current.getAbsolutePath());
			//prikaz sadrzaja ovog foldera
			if(current.isDirectory()){
				for (File file : current.listFiles()) {
					if(file.isDirectory())
						System.out.println(file.getName() + ", folder");
					else if(file.isFile()) //da li je potrebna ova provera?
						System.out.println(file.getName() + ", size (bytes): " + file.length());
				}
			}
			//separator putanje se pribavlja iz OS
			String sP = System.getProperty("file.separator");
			//TODO prikazati sadrzaj foldera materijali
			File materijali = new File("."+sP+"materijali");
			
		}
}
