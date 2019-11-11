package ohtu;

import java.util.Date;

public class Player {

    private int goals;
    private int assists;
    private String name;
    private int penalties;
    private String team;
    private String nationality;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeaam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return this.team;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getAssists() {
        return this.assists;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getNationality(){
        return this.nationality;
    }

    @Override
    public String toString() {
        return name + " team " +team + " goals " + goals + " assists " + assists;
    }

}
