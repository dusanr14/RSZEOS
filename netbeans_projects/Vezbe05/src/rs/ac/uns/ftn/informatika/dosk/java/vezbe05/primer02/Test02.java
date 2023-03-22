package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer02;

public class Test02 {

public static void main(String[] args) {
		
		Osoba[] osobe = new Osoba[2];
		osobe[0] = new Student("0000000000001,Petar Petrovic,Loznica,RS 02/11,10;9;");

		Osoba os = osobe[0];
//		os.setIndex("e1");
		System.out.println(os);
		
		if(osobe[0] instanceof Student){
			Student st = (Student) osobe[0];
			st.setIndex("e2");
			System.out.println(st);
		}
	
		/* TODO
		 po ugledu na kalsu student napraviti klasu profesor
		 klasa profesor je osoba koja ima zvanje, plata, radno mesto, predmeti,
		 predmet je atibut tipa niz Stringova
		 */
		
//		osobe[1] = new Profesor("0000000000002","Marko Markovic","Novi Sad","docent",40000,"predavac");		
//		Profesor prof = null;
//		
//		if(osobe[1] instanceof Profesor){
//			prof = (Profesor) osobe[1];
//		}
//		
//		if (prof != null) {
//			prof.setZvanje("vanr. prof.");
//			System.out.println(prof);
//		}

	}
}
