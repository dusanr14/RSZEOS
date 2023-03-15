FTN / Katedra za informatiku
Kurs iz Jave, 2014.
=================================

1. Opis vežbe
-------------------
Upoznavanje sa radom sa IO sistemom, klasom String i srodnim klasama

2. Sadržaj vežbe
-------------------
Čitanje datoteka i upis u datoteke, čitanje sa tastature, Cast-ovanje string vrednosti u celobrojne ili double vrednosti, 
rad sa stringovima, klasa String, podstring i metode String klase, parsiranje stringova, 
regularni izrazi, StringTokenizer, StringBuffer, StringBuilder.

3. Literatura
-------------------
materijali/slajdovi03.pdf
materijali/vezba03.pdf

4. Primeri
-------------------
primer01 - Čitanje iz i upis u datoteke  
primer02 - Čitanje sa tastature i pravljenje menija
primer03 - Rad sa stringovima

5. Zadatak na času
-------------------
Iz csv datoteke koja sadrži rezultate ispita (materijali/rezultati.csv) učitati podatke.
Rezultati ispita su opisani poljima indeks studenta, ime i prezime studenta, sifra predmeta, naziv predmeta,
broj bodova na teoriji, broj bodova na prakticnom delu ispita, prosecan broj bodova i konacna ocena.
Omoguciti sledecu funkcionalnost:
1. Ispis svih rezultata u formi redni broj, ime i prezime studenta, naziv predmeta i konacna ocena.
2. Ispis odredjenog rezultata
3. Izmena odredjenog rezultata
 
Sve izmene je potrebno sačuvati u csv datoteci u istom redu kao što je i bilo pre izmene.

6. Domaći zadatak
-------------------
Dom01
Isti zadatak kao na času, ali omogućiti da korisnik odabere koji podatak želi da menja i da samo njega menja
(broj bodova na teoriji i/ili prakticnom delu ispita, dok se prosecan broj bodova i konacna ocena automatski izracunavaju).
Student mora da dobije minimum 55 bodova iz svakog dela da bi prosao ispit.

Omoguciti ispis svih reultata odredjenog studenta.
Omoguciti ispis svih rezultata studenata sa istog smera.
Omoguciti ispis svih rezultata studenata koji su iste godine upisali fakultet.

Dom02
Kreirati program koji ispisuje podatke o artiklima. Tekst koji treba parsirati je:
"Coko plazma|s01|Bambi|85.30|akcija\nSmoki|s02|Stark|55.00|nije na akciji\Cipsi|s03|Marbo |115.20|nije na akciji\nKrem Bananica| s04|Stark|11.00|akcija\n"

Ponudjene opcije su:
a. Ispisuje spisak naziva svih artikala
b. Ispisuje podatke određenog artikla
c. Ispisuje samo artikle koji su na akciji
d. Ispisuje samo artikle od određenog proizvođača (korisnik unosi naziv proizvodjaca)

Dom03
Prosiriti Dom02 tako da se podaci upisuju u fajl artikli.txt 

Dom04
Prosiriti Dom03 tako da se podaci mogu ocitati iz fajl artikli.txt
