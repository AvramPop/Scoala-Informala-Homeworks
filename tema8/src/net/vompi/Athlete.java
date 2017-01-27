package net.vompi;

import java.util.ArrayList;

/**
 * The Athlete class models a sport-player who has a shirt-number, a name,
 * a nationality, a time, and a ArrayList of shot results. It implements the Comparable
 * interface on objects of same type, in order to make the collections of this object
 * sortable.
 */
public class Athlete implements Comparable<Athlete> {
    private final int number;
    private final String name;
    private final String nationality;
    private Time time;
    private Time initialTime;
    private int penaltiesInSeconds = 0;
    private ArrayList<String> shots = new ArrayList<>();

    public Athlete(int number, String name, String nationality, Time time, ArrayList<String> shots) {
        this.number = number;
        this.name = name;
        this.nationality = nationality;
        this.time = time;
        initialTime = time;
        this.shots = shots;
        computeTimeWithPenalties();
    }

    /**
     * The getFinalTime returns the final time of the athlete, that is, his time with the penalties added.
     * @return the final time
     */

    public Time getFinalTime() {
        return time;
    }

    private void computeTimeWithPenalties() {
        Time penalty = new Time();
        for(String shotSeries : shots){
            penalty = timePenaltyForShootSeries(shotSeries);
            penaltiesInSeconds += penalty.getMinutes() * 60 + penalty.getSeconds();
            time.addTime(penalty);
        }
    }

    private Time timePenaltyForShootSeries(String shotSeries) {
        String [] result = shotSeries.split("");
        Time timePenalty = new Time();
        for(String s : result){
            if(s.equals("o")){
                timePenalty.increaseSecondsWith(10);
            }
        }
        return timePenalty;
    }

    @Override
    public int compareTo(Athlete o) {
        return this.time.compareTo(o.getFinalTime());
    }

    @Override
    public String toString() {
        return  name + " " +
                time.getMinutes() + ":" + time.getSeconds() +
                "(" + initialTime.getMinutes() + ":" + initialTime.getSeconds() +
                " + " + penaltiesInSeconds + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Athlete athlete = (Athlete) o;

        if (number != athlete.number) return false;
        if (name != null ? !name.equals(athlete.name) : athlete.name != null) return false;
        if (nationality != null ? !nationality.equals(athlete.nationality) : athlete.nationality != null) return false;
        if (time != null ? !time.equals(athlete.time) : athlete.time != null) return false;
        return shots != null ? shots.equals(athlete.shots) : athlete.shots == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (shots != null ? shots.hashCode() : 0);
        return result;
    }
}
