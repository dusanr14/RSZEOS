package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer04;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Test {
	
public static void main(String[] args) {
		
		try {
			StudentskaSluzba.ucitavanj ePodataka();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int odluka = -1;
		while(odluka!= 0){
			StudentskaSluzba.ispisiTekstOsnovneOpcije();
			System.out.print("opcija:");
			odluka = Utility.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					int odlukaS = -1;
					while(odlukaS!= 0){
						StudentskaSluzba.ispisiTekstStudentOpcije();
						System.out.print("opcija:");
						odlukaS = Utility.ocitajCeoBroj();
						switch (odlukaS) {
							case 0:	
								System.out.println("Izlaz");	
								break;
							case 1:	
								StudentskaSluzba.unosNovogStudenta();	
								break;
							case 2:	
								StudentskaSluzba.izmenaPodatakaOStudentu();	
								break;
							case 3:	
								StudentskaSluzba.ispisiSveStudente();
								break;
							case 4:	
								Student st = StudentskaSluzba.pronadjiStudenta();
								if(st!=null){
									System.out.println(st);
									StudentskaSluzba.ispisiOcene(st);
								}	
								break;
							case 5:	
								Student ocStudent = StudentskaSluzba.pronadjiStudenta();
								if(ocStudent!=null){
									ocStudent.getOcene().clear();
									StudentskaSluzba.unosOcena(ocStudent);
								}	
								break;
							case 6:
								StudentskaSluzba.sortirajStudentePoBrojuIndeksa();
								StudentskaSluzba.ispisiSveStudente();
								break;
							case 7:
								StudentskaSluzba.sortirajStudentePoImenu();
								StudentskaSluzba.ispisiSveStudente();
								break;
							default:
								System.out.println("Nepostojeca komanda");
								break;	
						}
					}
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}
		try {
			StudentskaSluzba.snimanjePodataka();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("Program izvrsen");
	}

}
