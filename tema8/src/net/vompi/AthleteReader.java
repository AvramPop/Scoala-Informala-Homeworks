package net.vompi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


/**
 * The AthleteReader class offers the possibility to read information from a Reader object
 * and parse it into Athlete objects.
 */
public class AthleteReader extends BufferedReader{

    private static final String SEPARATOR = ",";

    public AthleteReader(Reader in) {
        super(in);
    }

    /**
     * The readAthletes method parses the information found in the object's provided Reader,
     * and transforms it in a ArrayList of Athletes.
     * @return the ArrayList of Athlete objects which can be found in the provided Reader
     * @throws IOException if the file to read from is broken
     */

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
        ArrayList<String> shots = new ArrayList<>();
        shots.add(tokens[4]);
        shots.add(tokens[5]);
        shots.add(tokens[6]);
        return new Athlete(Integer.valueOf(tokens[0]), tokens[1], tokens[2], time, shots);
    }
}
