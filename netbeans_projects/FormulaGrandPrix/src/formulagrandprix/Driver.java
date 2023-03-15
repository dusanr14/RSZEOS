/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulagrandprix;

/**
 *
 * @author student
 */
public class Driver {
    private String name;
    private int ranking;
    private String specialSkill;
    private boolean eligibleToRace;
    private int accumulated_Time;
    private int accumulatedPoints;

    public Driver(String name, int ranking, String specialSkill, boolean eligibleToRace, int accumulated_Time, int accumulatedPoints) {
        this.name = name;
        this.ranking = ranking;
        this.specialSkill = specialSkill;
        this.eligibleToRace = eligibleToRace;
        this.accumulated_Time = accumulated_Time;
        this.accumulatedPoints = accumulatedPoints;
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

    public int getAccumulated_Time() {
        return accumulated_Time;
    }

    public void setAccumulated_Time(int accumulated_Time) {
        this.accumulated_Time = accumulated_Time;
    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(int accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    public void useSpecialSkill(RNG rng){
        //if(rng.getRandomValue() < 10){
        //    
        //}
    }
    
    
}
