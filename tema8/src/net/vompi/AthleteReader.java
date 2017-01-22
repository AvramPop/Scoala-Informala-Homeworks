package net.vompi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 1/22/17.
 */
public class AthleteReader extends BufferedReader{

    private static final String SEPARATOR = ",";

    public AthleteReader(Reader in) {
        super(in);
    }

    public ArrayList<Athlete> readAthletes() throws IOException {
        String line = readLine();
        ArrayList<Athlete> athletes = new ArrayList<>();
        while(line != null){
            Athlete athlete = parseAthlete(line);
            athletes.add(athlete);
            line = readLine();
        }
        return athletes;
    }

    private Athlete parseAthlete(String source) {
        String [] tokens = source.split(SEPARATOR);
        String [] times = tokens[3].split(":");
        Time time = new Time(Integer.valueOf(times[0]), Integer.valueOf(times[1]));
        List<String> shots = new ArrayList<>();
        shots.add(tokens[4]);
        shots.add(tokens[5]);
        shots.add(tokens[6]);
        return new Athlete(Integer.valueOf(tokens[0]), tokens[1], tokens[2], time, shots);
    }
}
