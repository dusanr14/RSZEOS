/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formulagrandprix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

public class Championship {
    private  ArrayList<Driver> drivers;
    private  ArrayList<Venue> venues;
    
    final int MINOR_MECHANICAL_FAULT_PROPABILITY = 5;
    final int MAJOR_MECHANICAL_FAULT_PROPABILITY = 3;
    final int UNRECOVERABLE_MECHANICAL_FAULT_PROPABILITY = 1;
    
    final int MINOR_REPARE_TIME = 20;
    final int MAJOR_REPARE_TIME = 120;
    
    final int SECOND_PLACE_INITIAL_DELAY = 3;
    final int THIRD_PLACE_INITIAL_DELAY = 5;
    final int FOURTH_PLACE_INITIAL_DELAY = 7;
    final int LAST_PLACES_INITIAL_DELAY = 10;
    
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Venue> getVenues() {
        return venues;
    }

    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
    }
    
    public Championship() throws FileNotFoundException, IOException {
        this.drivers = new ArrayList<>();
        this.venues = new ArrayList<>();
        
        File staze_file = new File("staze.txt");
        File vozaci_file = new File("vozaci.txt");
        
        if(staze_file.exists() && vozaci_file.exists()){
            BufferedReader br_staze = new BufferedReader(new FileReader("staze.txt"));
            BufferedReader br_vozaci = new BufferedReader(new FileReader("vozaci.txt"));

            String string;
            while((string = br_staze.readLine()) != null) {
                //System.out.println(string);
                String [] string_arr = string.split(",");
                Venue venue = new Venue(Integer.parseInt(string_arr[2]),Double.parseDouble(string_arr[3]),Integer.parseInt(string_arr[1]),string_arr[0]);
                this.venues.add(venue);
            }

            while((string = br_vozaci.readLine()) != null) {
                //System.out.println(string);
                String [] string_arr = string.split(",");
                Driver driver = new Driver(string_arr[0],Integer.parseInt(string_arr[1]),string_arr[2]);
                this.drivers.add(driver);
            }
        }
        else{
            System.out.println("No files found");
        }   
    }
    
 
    public String printDrivers() {
        String s = new String();
        for(Driver d : drivers) {
        s = s + "Name: " + d.getName() + "\nSpecial skill: " + d.getSpecialSkill() +
                "\nAccumulated time: " + d.getAccumulatedTime() +  "\nAccumulated points: " + d.getAccumulatedPoints()+"\n Ranking: " + d.getRanking()+"\n\n";
        }
        return s;
    }
    
     void prepareForTheRace(){
       Collections.sort(this.drivers, new DriverPointsComparator(-1));
       if(this.drivers.get(1).isEligibleToRace())
       this.drivers.get(1).setAccumulatedTime(this.drivers.get(1).getAccumulatedTime() + SECOND_PLACE_INITIAL_DELAY);
       if(this.drivers.get(2).isEligibleToRace())
       this.drivers.get(2).setAccumulatedTime(this.drivers.get(2).getAccumulatedTime() + THIRD_PLACE_INITIAL_DELAY);
       if(this.drivers.get(3).isEligibleToRace())
       this.drivers.get(3).setAccumulatedTime(this.drivers.get(3).getAccumulatedTime() + FOURTH_PLACE_INITIAL_DELAY);
       for (int i = 4; i < drivers.size(); i++) {
           if(this.drivers.get(i).isEligibleToRace())
           this.drivers.get(i).setAccumulatedTime(this.drivers.get(i).getAccumulatedTime() + LAST_PLACES_INITIAL_DELAY);
       }
    }
    
    void driveAverageLapTime(int i){
        int temp_time = this.venues.get(i).getAverageLapTime(); ;
        for (Driver d : drivers) {
           if(d.isEligibleToRace())
           d.setAccumulatedTime(d.getAccumulatedTime() + temp_time);
       }
    }
    
    void applySpecialSkills(int lapNumber){
        for (Driver d : drivers) {
           if(d.useSpecialSkill(lapNumber)){
            System.out.println("Driver "+ d.getName()+" applied his special skill" +d.getSpecialSkill()+" \n");
           }
       }
    }
    
    void checkMechanicalProblem(){
        int rand_num_100;
        for (Driver d : drivers) {
           if(d.isEligibleToRace()){
                rand_num_100 = RNG.getRandomValue(0, 99);
                if(rand_num_100 < MINOR_MECHANICAL_FAULT_PROPABILITY){
                    d.setAccumulatedTime(d.getAccumulatedTime() + MINOR_REPARE_TIME);
                    System.out.println("Driver "+ d.getName()+" has minor mechanical fault. \n");
                }else if (rand_num_100 >= MINOR_MECHANICAL_FAULT_PROPABILITY && rand_num_100 < MINOR_MECHANICAL_FAULT_PROPABILITY + MAJOR_MECHANICAL_FAULT_PROPABILITY){
                    d.setAccumulatedTime(d.getAccumulatedTime() + MAJOR_REPARE_TIME);
                    System.out.println("Driver "+ d.getName()+" has major mechanical fault. \n");
                }else if(rand_num_100 == 99){
                    d.setEligibleToRace(false);
                    System.out.println("Driver "+ d.getName()+" is eleminated form the race. \n");
                }
           }
       }
    }
    
    void printLeader(int lap){
        Collections.sort(this.drivers);
        System.out.println("Leader: \n");
        System.out.println(this.drivers.get(0) + "\n");
    }
    
    void printChampion(){
        Collections.sort(this.drivers, new DriverPointsComparator(-1));
        System.out.println("Champion: \n");
        System.out.println(this.drivers.get(0) + "\n");
    }
    
    void assignPointsAfterVenue(){
        Collections.sort(this.drivers);
        drivers.get(0).setAccumulatedPoints(drivers.get(0).getAccumulatedPoints() + 8);
        drivers.get(1).setAccumulatedPoints(drivers.get(1).getAccumulatedPoints() + 5);
        drivers.get(2).setAccumulatedPoints(drivers.get(2).getAccumulatedPoints() + 3);
        drivers.get(3).setAccumulatedPoints(drivers.get(3).getAccumulatedPoints() + 1);
        for (Driver d : drivers) {
            d.setAccumulatedTime(0);
        }
    }
    
    public void changeTires(int Lap){
        for (Driver d : drivers) {
            if(d.changeTire(Lap)){
                System.out.println("Driver "+ d.getName()+" changed tires. \n");
            }
        }
    }
    
    public void RainLap(Venue venue){
        if(RNG.getRandomValue(0, 99) < (venue.getChanceOfRain()*100)){
            for (Driver d : drivers) {
                if(d.getRainTires()== false){
                    d.setAccumulatedTime(d.getAccumulatedTime() + 5);
                    System.out.println("Driver "+ d.getName()+" has no rain tires. \n");
                }
            }
        }
    }
    /** METODA ZA SORTIRANJE STUDENATA****/

}
