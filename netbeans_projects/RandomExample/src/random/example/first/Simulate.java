/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package random.example.first;

import java.util.Random;

/**
 *
 * @author zaposleni
 */
public class Simulate {

    static Random rnd = new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i < 100; i++){
            System.out.println(rnd.nextInt(100));
        }
    }
    
}
