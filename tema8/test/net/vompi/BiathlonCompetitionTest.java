package net.vompi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by dani on 1/27/17.
 */
public class BiathlonCompetitionTest {
    @Test
    public void competitionWithUnsortedAthletesHasThemSorted(){
        Time t1 = new Time(30, 20);
        Time t2 = new Time(31, 20);
        ArrayList<String> shots1 = new ArrayList<>();
        ArrayList<String> shots2 = new ArrayList<>();
        shots1.add("xxxxx");
        shots1.add("xxxxx");
        shots1.add("xxxxx");
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        Athlete a1 = new Athlete(2, "as", "as", t1, shots1);
        Athlete a2 = new Athlete(2, "as", "as", t2, shots1);
        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(a2);
        athletes.add(a1);
        BiathlonCompetition biathlonCompetition = new BiathlonCompetition(athletes);
        ArrayList<Athlete> result;
        result = biathlonCompetition.getAthletesInDescendingOrder();

        ArrayList<Athlete> expected = new ArrayList<>();
        expected.add(a1);
        expected.add(a2);

        Assert.assertEquals(result.equals(expected), true);
    }

    @Test
    public void competitionWithSortedAthletesHasThemUnchanged(){
        Time t1 = new Time(30, 20);
        Time t2 = new Time(31, 20);
        ArrayList<String> shots1 = new ArrayList<>();
        ArrayList<String> shots2 = new ArrayList<>();
        shots1.add("xxxxx");
        shots1.add("xxxxx");
        shots1.add("xxxxx");
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        Athlete a1 = new Athlete(2, "as", "as", t1, shots1);
        Athlete a2 = new Athlete(2, "as", "as", t2, shots1);
        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(a1);
        athletes.add(a2);
        BiathlonCompetition biathlonCompetition = new BiathlonCompetition(athletes);
        ArrayList<Athlete> result;
        result = biathlonCompetition.getAthletesInDescendingOrder();

        ArrayList<Athlete> expected = new ArrayList<>();
        expected.add(a1);
        expected.add(a2);

        Assert.assertEquals(result.equals(expected), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void competitionWithEmptyAthletesListThrowsException(){
        ArrayList<Athlete> athletes = new ArrayList<>();
        BiathlonCompetition biathlonCompetition = new BiathlonCompetition(athletes);
    }

    @Test(expected = IllegalArgumentException.class)
    public void competitionWithNullAthletesListThrowsException(){
        ArrayList<Athlete> athletes = null;
        BiathlonCompetition biathlonCompetition = new BiathlonCompetition(athletes);
    }
}