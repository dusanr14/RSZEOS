package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer03;

import java.util.ArrayList;
import java.util.Collections;

public class Test2 {
	
	public static ArrayList<Osoba> osobe = new ArrayList<Osoba>();

	public static void main(String[] args) {

		osobe.add(new Student("0000000000001,Petar Petrovic,Loznica,RS 02/11,10;9;"));
		osobe.add(new Student("0000000000002,Marko Markovic,Novi Sad,RS 01/11,;"));
		osobe.add(new Student("0000000000003,Jovan Jovanovic,Novi Sad,RS 03/11,6;7;8;"));
		
		Collections.sort(osobe, new OsobaNameComparator(1));
		
		for (Osoba os : osobe) {
			System.out.println(os);
		}
	}
}
