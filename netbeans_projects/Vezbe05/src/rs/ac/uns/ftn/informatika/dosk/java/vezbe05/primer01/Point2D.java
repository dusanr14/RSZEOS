package rs.ac.uns.ftn.informatika.dosk.java.vezbe05.primer01;

public class Point2D {

	//kod nasledjivanja bitno je kako se pravima pristupa definisu atributi i metode osnovne klase
	protected double x;
	protected double y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void ispisNaEkran(){
		System.out.println("Ispis koordinata tacke, x osa " + x + " y osa" + y);
	}
}
