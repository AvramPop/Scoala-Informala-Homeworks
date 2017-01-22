package net.vompi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 1/21/17.
 */
public class Athlete implements Comparable<Athlete> {
    private final int number;
    private final String name;
    private final String nationality;
    private Time time;
    private List<String> shots = new ArrayList<>();

    public Athlete(int number, String name, String nationality, Time time, List<String> shots) {
        this.number = number;
        this.name = name;
        this.nationality = nationality;
        this.time = time;
        this.shots = shots;
        computeTimeWithPenalties();
    }

    public Time getFinalTime() {
        return time;
    }

    private void computeTimeWithPenalties() {
        for(String shotSeries : shots){
            time.addTime(timePenaltyForShootSeries(shotSeries));
        }
    }

    private Time timePenaltyForShootSeries(String shotSeries) {
        String [] result = shotSeries.split("");
        Time timePenalty = new Time();
        for(String s : result){
            if(s == "o"){
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
        return "Athlete{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", time=" + time +
                ", shots=" + shots +
                "}\n";
    }
}
