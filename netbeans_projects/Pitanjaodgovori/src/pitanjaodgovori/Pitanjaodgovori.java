/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pitanjaodgovori;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author student
 */
public class Pitanjaodgovori {

    /**
     * @param args the command line arguments
     * 
     */
    
                
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String sP = System.getProperty("file.separator");
        
        String string1;
        Scanner sc = new Scanner(System.in); 
        
        File pitanja = new File("pitanja.txt");
        File odgovori = new File("odgovori.txt");
        if(pitanja.exists()){
            BufferedReader br = new BufferedReader(new FileReader("pitanja.txt"));
            String s2;
            PrintWriter pw = new PrintWriter(new FileWriter("odgovori.txt", true));
                            while((s2 = br.readLine()) != null) {
                                    System.out.println(s2);
                                    string1 = sc.nextLine();
                                    pw.println(string1);
                                    System.out.println("upisao si: "+ string1);
                            }
                            br.close();
                            pw.close();
        } else {
			System.out.println("Ne postoji fajl!");
		}
//        File current = new File(".");
//        
//        
//		File rezultati2 = new File("."+sP+"materijali"+sP+"rezultati2.csv");
//		PrintWriter pw = new PrintWriter(new FileWriter("odgovori.txt", true));
//		pw.println("marko");
//		pw.flush();
//		pw.close();
                
    }
    
}
