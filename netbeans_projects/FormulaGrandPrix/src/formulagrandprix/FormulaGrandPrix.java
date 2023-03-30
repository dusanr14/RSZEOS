/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formulagrandprix;

import java.io.IOException;
import java.util.Collections;
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
        int race = 0;
        int res = 0;
        // TODO code application logic here
        //Driver driver = new Driver("Milan",3,"overtaking");
        //System.out.println(driver.toString());
        
        String string1;
        String string2;
        Scanner sc = new Scanner(System.in);
        Championship championship = new Championship();
        do{
            System.out.println("Odaberi broj trka u sampionatu (od 3 do 5):");
            string1 = sc.nextLine();
            numOfRaces = Integer.parseInt(string1);
        }while(numOfRaces < 3 || numOfRaces > 5);
        
        for(int i = 0; i < championship.getVenues().size(); i++){
            System.out.println("Odaberi trku broj "+ i+1 + ":");
            for(int j = 0; j < championship.getVenues().size(); j++){
                System.out.println(j +". "+championship.getVenues().get(j).getVenueName());
            }
            string2 = sc.nextLine();
            race = Integer.parseInt(string2);
            System.out.println("Race No "+ i + "START!!!\n\n");
            if(i == 0){
                sortDriversByRank(championship);
            }
            else{
                sortDriversByPoints(championship);
            }
            
            championship.prepareForTheRace();
            for (int j = 0; j < championship.getVenues().get(race).getNumberOfLaps(); j++){
                championship.changeTires(j);
                championship.RainLap(championship.getVenues().get(race));
                championship.driveAverageLapTime(i);
                championship.applySpecialSkills(j);
                championship.checkMechanicalProblem();
                sortDriversByTime(championship);
                championship.printLeader(0);
                string2 = sc.nextLine();
            }
            championship.getVenues().remove(i);
            
            championship.assignPointsAfterVenue();
            for (Driver d : championship.getDrivers()) {
                d.setEligibleToRace(true);
                d.setRainTires(false);
            }
        }
        championship.printChampion();
    }
    
	public static void sortDriversByTime(Championship championship){
		Collections.sort(championship.getDrivers());
	}
        public static void sortDriversByPoints(Championship championship){
		Collections.sort(championship.getDrivers(), new DriverPointsComparator(-1));
	}
        public static void sortDriversByRank(Championship championship){
		Collections.sort(championship.getDrivers(), new DriverRankingComparator(1));
	}
        
}
