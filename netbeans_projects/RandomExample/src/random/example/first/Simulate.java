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


    static private int minimumValue;
    static private int maximumValue;
    static Random rnd = new Random();
    
    public int getRandomValue(){
        return rnd.nextInt(maximumValue) + minimumValue;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a;
        minimumValue = 5;
        maximumValue = 20;
        for (int i = 0; i < 10000; i++){
            a = rnd.nextInt(maximumValue - minimumValue) + minimumValue;
            if(a < minimumValue || a > maximumValue){
                System.out.println("ERRORR");
                System.out.println(a);
            }
        }
        System.out.println("gotovo");
    }
    
}
