package vezbe3.primer2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Keyboard01 {

	public static void main(String[] args) throws IOException {
		//Buferizovani reader za tastaturu
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in)); 
		//nije println, nego print da bismo ostali u istom redu
		System.out.print("Unesite svoje ime: ");
		String name = in.readLine(); 
                
		System.out.println("Uneli ste: " + name);
		
		System.out.print("Unesite svoju visinu: ");
		int height = Integer.parseInt(in.readLine()); 
		System.out.println("Uneli ste: " + height);
		
	}

}
