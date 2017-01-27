package net.vompi;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by dani on 1/26/17.
 */
public class AthleteTest {
    @Test
    public void athleteAddsPenaltiesCorrectly(){
        Time time = new Time(30, 27);
        ArrayList<String> shots = new ArrayList<>();
        shots.add("xxxox");
        shots.add("xxxxx");
        shots.add("xxoxo");
        Athlete expected = new Athlete(11, "Umar Jorgson", "SK", time, shots);
        Time correctTime = new Time(30, 57);
        Assert.assertEquals(expected.getFinalTime(), correctTime);
    }

    @Test
    public void athleteWithoutPenaltiesKeepsTimeUnchanged(){
        Time time = new Time(30, 27);
        ArrayList<String> shots = new ArrayList<>();
        shots.add("xxxxx");
        shots.add( "xxxxx");
        shots.add( "xxxxx");
        Athlete expected = new Athlete(11, "Umar Jorgson", "SK", time, shots);
        Time correctTime = new Time(30, 27);
        Assert.assertEquals(expected.getFinalTime(), correctTime);
    }

    @Test
    public void athleteComparesCorrectlyWithAnotherOne(){
        Time time = new Time(30, 27);
        ArrayList<String> shots = new ArrayList<>();
        shots.add("xxxxx");
        shots.add("xxxxx");
        shots.add("xxxox");
        Athlete expected = new Athlete(11, "Umar Jorgson", "SK", time, shots);
        ArrayList<String> shots2 = new ArrayList<>();
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        shots2.add("xxxxx");
        Athlete expected2 = new Athlete(11, "Umar Jorgson", "SK", time, shots2);
        Assert.assertEquals(expected.compareTo(expected2), -1);
    }
}