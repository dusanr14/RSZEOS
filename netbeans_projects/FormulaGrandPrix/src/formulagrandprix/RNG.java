/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulagrandprix;

import java.util.Random;

/**
 *
 * @author student
 */
public class RNG {
    private int minimumValue;
    private int maximumValue;
    static Random rnd = new Random();

    public RNG(int minimumValue, int maximumValue) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }
    
    public int getRandomValue(){
        return rnd.nextInt(maximumValue - minimumValue) + minimumValue;
    }
    
    static public int getRandomValue(int minimumValue, int maximumValue){
        return rnd.nextInt(maximumValue - minimumValue) + minimumValue;
    }
    
    public int getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(int maximumValue) {
        this.maximumValue = maximumValue;
    }
    
    
}
