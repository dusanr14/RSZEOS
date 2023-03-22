package samostalniResen;

import java.io.IOException;

public class Test {
	
public static void main(String[] args) throws IOException {
		
		StudentskaSluzba.ucitavanjePodataka();
		int odluka;
		do {
			StudentskaSluzba.ispisiTekstOsnovneOpcije();
			System.out.print("opcija:");
			odluka = Utility.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					int odlukaR = -1;
					do{
						StudentskaSluzba.ispisiTekstRezultatOpcije();
						System.out.print("opcija:");
						odlukaR = Utility.ocitajCeoBroj();
						switch (odlukaR) {
							case 0:	
								System.out.println("Izlaz");	
								break;
							case 1:	
								StudentskaSluzba.ispisiSveRezultate();
								break;
							case 2:	
								StudentskaSluzba.unosNovogRezultata();	
								break;
							case 3:	
								StudentskaSluzba.izmenaPodatakaORezultatu();	
								break;
							case 4:
								StudentskaSluzba.brisanjePodatakaORezultatu();
								break;
							case 5:
								StudentskaSluzba.sortiranjeRezultata();
								break;
							default:
								System.out.println("Nepostojeca komanda");
								break;	
						}
					}while(odlukaR!= 0);
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}while(odluka!= 0);
		
		StudentskaSluzba.snimanjePodataka();
		
		System.out.print("Program izvrsen");
	}

}
