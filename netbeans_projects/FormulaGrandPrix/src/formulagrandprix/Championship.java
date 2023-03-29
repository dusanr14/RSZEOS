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
import java.util.List;

public class Championship {
    public static ArrayList<Driver> drivers = new ArrayList<Driver>();
    public static ArrayList<Venue> venues = new ArrayList<Venue>();
    
    final int MINOR_MECHANICAL_FAULT = 5;
    final int MAJOR_MECHANICAL_FAULT = 3;
    final int UNRECOVERABLE_MECHANICAL_FAULT = 1;

    public ArrayList<Driver> getDrivers(int i) {
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
        //this.drivers = new ArrayList<>();
        //this.venues = new ArrayList<>();
        
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
                "\nAccumulated time: " + d.getAccumulatedTime() +  "\nAccumulated points: " + d.getAccumulatedPoints()+"\n";
        }
        return s;
    }
    
    public void sortirajVozacePoVremenu(){
		Collections.sort(this.drivers);
	}
    
    static void prepareForTheRace(){
       for (Driver d : drivers) {
           d.setAccumulatedTime(RNG.getRandomValue(0, 8));
       }
    }
    
    
    
    
    
    /** METODA ZA SORTIRANJE STUDENATA****/

}
