/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formulagrandprix;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class FormulaGrandPrix {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        int numOfRaces = 0;
        int res = 0;
        // TODO code application logic here
        Driver driver = new Driver("Milan",3,"overtaking");
        System.out.println(driver.toString());
        
        String string1;
        
        Championship championship = new Championship();
        Scanner sc = new Scanner(System.in); 
        string1 = sc.nextLine();
        numOfRaces = Integer.getInteger(string1);
        res = numOfRaces + 100;
        //System.out.println(championship.drivers);
    }
    
}
