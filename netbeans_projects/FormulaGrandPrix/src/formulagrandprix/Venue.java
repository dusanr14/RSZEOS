/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulagrandprix;

/**
 *
 * @author Dusan
 */
public class Venue {
    private int averageLapTime;
    private double chanceOfRain;
    private int numberOfLaps;
    private String venueName;

    
    public Venue(int averageLapTime, double chanceOfRain, int numberOfLaps, String venueName) {
        this.averageLapTime = averageLapTime;
        this.chanceOfRain = chanceOfRain;
        this.numberOfLaps = numberOfLaps;
        this.venueName = venueName;
    }

    public int getAverageLapTime() {
        return averageLapTime;
    }

    public double getChanceOfRain() {
        return chanceOfRain;
    }

    public int getNumberOfLaps() {
        return numberOfLaps;
    }

    public String getVenueName() {
        return venueName;
    }
    
    @Override
    public String toString() {
        return "Venue name: " + this.venueName + "\n Average Lap Time: " + this.averageLapTime +
                "\n Number of Laps: " + this.numberOfLaps +  "\n Chance of Rain: " + this.chanceOfRain + "\n\n";
    }
}
