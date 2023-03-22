FTN / Katedra za informatiku
Kurs iz Jave, 2014.
=================================

1. Opis vežbe
-------------------
Upoznavanje sa mehanizmima nasleđivanja i implementacija interfejsa u Javi, 
vrstama kolekcija u Javi i sa obradom izuzetaka u Javi

2. Sadržaj vežbe
-------------------
Nasledjivanje klasa, interfejsi i implementacija interfejsa, cast-ovanje klasa, 
Kolekcije - Liste, Mape, Setovi, 
Exceptions handling – throw, throws, try-catch, finally. 

3. Literatura
-------------------
materijali/slajdovi05.pdf
materijali/vezba05.pdf

4. Primeri
-------------------
primer01 - Nasleđivanje
primer02 - Apstraktne Klase, Polimorfizam,   
primer03 - Interfejsi, ArrayList, HashMap
primer04 - try-catch, Studentska sluzba kompletan zadatak

5. Zadatak na času
-------------------
Definisati klasu Rezultat koja sadrzi sledece osobine indeks, ime i prezime studenta, broj bodova teorija, 
broj bodova zadaci, ukupan broj bodova, konacna ocena. Napisati sve potrebne konstruktore i metode(get/set, equals, to string, toCSV, 
compareTo - po ukupnom broj bodova). Napisati metodu za racunanje konacne ocene. 
Voditi racuna da prilikom izmene broja bodova na teoriji ili zadacima potrebno je ponovo izracunati ukupan broj bodova i konacnu ocenu.
Jedinstveni identifikator rezultata je broj indeksa.

Po ugledu na primer04 omoguciti rad sa rezultatima ispita. Na pocetku programa ocitati rezultate a na kraju sacuvati.
Omoguciti korisniku rad sa sledecim opcijama.
	1. Ispis svih Rezultata
	2. Unos novog Rezultata
	3. Izmena Rezultata
	4. Brisanje Rezultata
	5. Sortiranje Rezultata (dve podopcije, po broju bodova ili po indeksu)

6. Domaći zadatak
-------------------
Prosirite aplikaciju tako da ona radi i sa drugim entitetima: 
Studentima (JMBG, ime i prezime, grad rodjenja, broj indeksa, ocene) - (vecinski uradjeno u paketu primer 04, indeks - je jedinstvena vrednost), 
Profesorima (JMBG, ime i prezime, grad rodjenja, zvanje)- (radili slicno u paketu primer 02, JMBG - je jedinstvena vrednost), 
Predmetima(šifra predmeta, naziv, broj ESBP poena koje nosi predmet) - sifra predmeta je jedinstvena vrednost.

Cilj ovoga zadatka je da dobijete sto vise rutine u programiranju. Nemate sustinski novih problema.
