package net.vompi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dani on 1/21/17.
 */
public class BiathlonCompetition {
    private List<Athlete> athletes = new ArrayList<>();
    private List<Athlete> winners = new ArrayList<>();

    public BiathlonCompetition(ArrayList<Athlete> athletes) {
        this.athletes = athletes;
        Collections.sort(this.athletes);
        winners.add(0, athletes.get(0));
        winners.add(1, athletes.get(1));
        winners.add(2, athletes.get(2));
    }

    public List<Athlete> getWinners() {
        return winners;
    }

    public List<Athlete> getAthletesInDescendingOrder() {
        return athletes;
    }
}
