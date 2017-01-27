package net.vompi;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by dani on 1/26/17.
 */
public class AthleteReaderTest {
    @Test
    public void readAthleteFromGoodCSV_AndParseHimIntoAList() throws IOException {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";
        StringReader sr = new StringReader(csv);
        try (AthleteReader athleteReader = new AthleteReader(sr)) {
            ArrayList<Athlete> athletes = athleteReader.readAthletes();
            Assert.assertEquals(1, athletes.size());
            Time time = new Time(30, 27);
            ArrayList<String> shots = new ArrayList<>();
            shots.add(0, "xxxox");
            shots.add(1, "xxxxx");
            shots.add(2, "xxoxo");
            System.out.println(athletes.get(0));
            Athlete expected = new Athlete(11, "Umar Jorgson", "SK", time, shots);
            Assert.assertEquals(athletes.get(0), expected);
        }
    }

    @Test
    public void readTwoAthletesFromGoodCSV_AndParseThemIntoAList() throws IOException {
        String csv = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo";
        StringReader sr = new StringReader(csv);
        try (AthleteReader athleteReader = new AthleteReader(sr)) {
            ArrayList<Athlete> athletes = athleteReader.readAthletes();
            Assert.assertEquals(2, athletes.size());
            Time time = new Time(30, 27);
            ArrayList<String> shots = new ArrayList<>();
            shots.add("xxxox");
            shots.add("xxxxx");
            shots.add("xxoxo");
            ArrayList<Athlete> expected = new ArrayList<>();
            expected.add(new Athlete(11, "Umar Jorgson", "SK", time, shots));
            time = new Time(29, 15);
            ArrayList<String> shots2= new ArrayList<>();
            shots2.add("xxoox");
            shots2.add( "xooxo");
            shots2.add("xxxxo");
            expected.add(new Athlete(1, "Jimmy Smiles", "UK", time, shots2));
            Assert.assertEquals(athletes.equals(expected), true);
        }
    }
}