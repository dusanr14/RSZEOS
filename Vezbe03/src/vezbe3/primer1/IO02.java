package vezbe3.primer1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IO02 {

	// o izuzecima cemo kasnije u toku kursa, ovde mora da se doda throws IOException 
	public static void main(String[] args) throws IOException {
		
		//separator putanje se pribavlja iz OS
		String sP = System.getProperty("file.separator");
		
		System.out.println("-------------------------------------");
		//kreiranje File objekta koji reprezentuje rezultati.csv fajl
		File rezultati = new File("."+sP+"materijali"+sP+"rezultati.csv");
		//provera da li postoji fajl
		if(rezultati.exists()){
			//koristimo reader, a ne stream, da bi bilo sve korektno sa UTF8 enkodingom
			//reader je buffer-izovan zbog performansi
			BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream( 
				rezultati), "UTF8")); 
			String s2;
			while((s2 = in.readLine()) != null) {
				//da bi se videla cirilicna slova, mora se podesiti enkoding 
				//ici na Run->Run configurations->Common->Encoding->Other UTF8
				System.out.println(s2);
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
		
		//ovako bi kreirali fajl rezultati2 i nesto upisali u njega
		File rezultati2 = new File("."+sP+"materijali"+sP+"rezultati2.csv");
		PrintWriter out2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(rezultati2), "UTF8"));
		out2.println("marko");
		out2.flush();
		out2.close();
		
		System.out.println("-------------------------------------");
		//moze se i ovako ispisivati na ekran, cak je i bolje jer je ovo writer, a ne stream
		//System.out je stream pa u nekim situacijama moze biti problema sa enkodingom
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF8"));
		out.println("marko");
		out.flush();
		out.close();
		
	}

}
