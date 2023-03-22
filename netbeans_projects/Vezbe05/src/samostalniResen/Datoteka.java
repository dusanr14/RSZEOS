package samostalniResen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

//klasa koja ima dve staticke metode za rad sa CSV datotekom - ucitavanje i snimanje
public class Datoteka {
	
	public static List<Rezultat> citanjeDatoteke () throws IOException{
		List<Rezultat> rezultati = new ArrayList<Rezultat>();
		
		String sP = System.getProperty("file.separator");
		File rezultatiFajl = new File("."+sP+"materijali"+sP+"rezultati.csv");
		
		if(rezultatiFajl.exists()){
			BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream( 
				rezultatiFajl), "UTF8")); 
			String s2;
			while((s2 = in.readLine()) != null) {
				rezultati.add(new Rezultat(s2));
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
		
		return rezultati;
	}
	
	public static void upisUDatoteku (List<Rezultat> rezultati) throws UnsupportedEncodingException, FileNotFoundException{
		String sP = System.getProperty("file.separator");
		File rezultatiFajl = new File("."+sP+"materijali"+sP+"rezultati.csv");
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(rezultatiFajl), "UTF8"));
		for (Rezultat rez:rezultati) {
			out.println(rez.toCSV());
		}
		
		out.flush();
		out.close();
	}
}
