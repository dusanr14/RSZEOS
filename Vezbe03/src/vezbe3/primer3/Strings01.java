package vezbe3.primer3;

public class Strings01 {
public static void main(String[] args) {
		
		//Definisanje promenljive tipa string	
		String a 	= "Ovo Je Tekst";
		String a1	= "ovo je tekst";
						
		//Provera da li su stringovi sadrze isti niz karaktera
		if(a.equals(a1))
			System.out.println("1. Nizovi a i a1 su slicni");
		else
			System.out.println("1. Nizovi a i a1 nisu slicni");
						
		if(a.equalsIgnoreCase(a1))
			System.out.println("2. Nizovi a i a1 su slicni");
		else
			System.out.println("2. Nizovi a i a1 nisu slicni");
		
		//prebacivanje velikih u mala slova
		System.out.println("OvO JE TeKsT".toLowerCase());
		
		
		a = "ovo je tekst";
		a1 = a.substring(0,5);
		//Provera da li string a zapoceinje sa karakterima iz stringa a1
		if(a.startsWith(a1))
			System.out.println("3. Zapocinje");
		else
			System.out.println("3. Ne zapocinje");
		
		//Provera da li string a sadrzi rec
		if(a.contains("tekst"))
			System.out.println("4. Sadrzi rec");
		else
			System.out.println("4. Ne sadrzi rec");
		
		//leksikografsko poredjenje stringova
		String name = "Aca";
		String name1 = "Ana";
		if(name.compareTo(name1)>0)		//razlika pozicija c i n 
			System.out.println("5. posle");
		else if(name.compareTo(name1)<0)
			System.out.println("5. pre");
		else
			System.out.println("5. isti");
	}

}
