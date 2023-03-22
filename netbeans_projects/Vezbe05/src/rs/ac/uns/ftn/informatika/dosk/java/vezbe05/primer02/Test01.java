package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer02;

public class Test01 {

	public static void main(String[] args) {
		
		Student [] studenti = new Student[3];
		
		studenti[0] = new Student("0000000000001,Petar Petrovic,Loznica,RS 02/11,10;9;");
		studenti[1] = new Student("0000000000002,Marko Markovic,Novi Sad,RS 01/11,;");
		studenti[2] = new Student("0000000000003,Jovan Jovanovic,Novi Sad,RS 03/11,6;7;8;");
		
		
		for (int i = 0; i < studenti.length; i++) {
			Student st = studenti[i];
			System.out.println(st);
		}
	}
}
