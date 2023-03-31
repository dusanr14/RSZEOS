/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulagrandprix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student
 */
public class Driver implements Comparable<Driver> {
    private String name;
    private int ranking;
    private String specialSkill;
    private boolean eligibleToRace;
    private int accumulatedTime;
    private int accumulatedPoints;
    private boolean rainTires;
    
    final int LOWER_TH_CORNERING = 1;
    final int HIGHER_TH_CORNERING = 8;
    
    final int LOWER_TH_BREAKING = 1;
    final int HIGHER_TH_BREAKING = 8;
    
    final int LOWER_TH_OVERTAKING = 10;
    final int HIGHER_TH_OVERTAKING = 20;
    
    public Driver(String name, int ranking, String specialSkill) {
        this.name = name;
        this.ranking = ranking;
        this.specialSkill = specialSkill;
        this.eligibleToRace = true;
        this.accumulatedTime = 0;
        this.accumulatedPoints = 0;
        this.rainTires = false;
    }

    public String getName() {
        return name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getSpecialSkill() {
        return specialSkill;
    }

    public boolean isEligibleToRace() {
        return eligibleToRace;
    }

    public void setEligibleToRace(boolean eligibleToRace) {
        this.eligibleToRace = eligibleToRace;
    }

    public int getAccumulatedTime() {
        return accumulatedTime;
    }

    public void setAccumulatedTime(int accumulatedTime) {
        this.accumulatedTime = accumulatedTime;
    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(int accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public boolean getRainTires() {
        return rainTires;
    }

    public void setRainTires(boolean rainTires) {
        this.rainTires = rainTires;
    }
    
    public boolean useSpecialSkill(int lapNumber){
        boolean temp = false;
        int timeShortage = 0;
        if (this.specialSkill.equals("Cornering")){
            timeShortage = RNG.getRandomValue(LOWER_TH_CORNERING,HIGHER_TH_CORNERING);
            temp = true;
        } else if (this.specialSkill.equals("Braking")) {
            timeShortage = RNG.getRandomValue(LOWER_TH_BREAKING,HIGHER_TH_BREAKING);
            temp = true;
        } else if (this.specialSkill.equals("Overtaking")) {
            if(lapNumber % 3 == 2){
                timeShortage = RNG.getRandomValue(LOWER_TH_OVERTAKING,HIGHER_TH_OVERTAKING);
                temp = true;
            }
        }
        this.accumulatedTime -= timeShortage;
        return temp;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + "\nSpecial skill: " + this.specialSkill +
                "\nAccumulated time: " + this.accumulatedTime +  "\nAccumulated points: " + this.accumulatedPoints+
                "\nRanking: " + this.ranking;
    }
    
    @Override
    public int compareTo(Driver d) {
        return -Integer.compare(d.accumulatedTime, this.accumulatedTime);
    }
    
    public boolean changeTire(int lap){
        boolean temp;
        if(lap == 1 && RNG.getRandomValue(0,1)== 0){
            temp = true;
        }else{
            temp = false;
        }
        this.rainTires = temp;
        return temp;
    }
}
