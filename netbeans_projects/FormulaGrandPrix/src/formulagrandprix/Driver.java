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

    public void useSpecialSkill(RNG rng){
        int timeShortage = 0;
        if (this.specialSkill.equals("cornering")){
            timeShortage = RNG.getRandomValue(LOWER_TH_CORNERING,HIGHER_TH_CORNERING);
        } else if (this.specialSkill.equals("breaking")) {
            timeShortage = RNG.getRandomValue(LOWER_TH_BREAKING,HIGHER_TH_BREAKING);
        } else if (this.specialSkill.equals("overtaking")) {
            timeShortage = RNG.getRandomValue(LOWER_TH_OVERTAKING,HIGHER_TH_OVERTAKING);
        }
        this.accumulatedTime -= timeShortage;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + "\n Special skill: " + this.specialSkill +
                "\n Accumulated time: " + this.accumulatedTime +  "\n Accumulated points: " + this.accumulatedPoints;
    }
    
    @Override
    public int compareTo(Driver d) {
        return Integer.compare(d.accumulatedTime, this.accumulatedTime);
    }
    
}
