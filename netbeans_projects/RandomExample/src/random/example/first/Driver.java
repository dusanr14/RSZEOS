/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package random.example.first;

    public class Driver {
    /**
    *
    * @author Dusan Radisic EE50/2022
    */
        
    private String ime;
    private String specialSkill;
    private int ranking;

    public Driver(String ime, String specialSkill, int ranking) {
        this.ime = ime;
        if(!specialSkill.equals("cornering") && !specialSkill.equals("breaking")& !specialSkill.equals("overtaking")) {
        } else {
            this.specialSkill = specialSkill;
        }
        this.ranking = ranking;
    }

    
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    
    

    
}
