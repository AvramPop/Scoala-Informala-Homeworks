package net.vompi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws  IOException{
        File csv = new File("/home/dani/Desktop/code/Scoala-Informala-Homeworks/tema8/data/input.csv");
        ArrayList<Athlete> athletes = getAthletesFromFile(csv);

        BiathlonCompetition biathlonCompetition = new BiathlonCompetition(athletes);
        System.out.println("All athletes sorted:");
        System.out.println(biathlonCompetition.getAthletesInDescendingOrder());
        System.out.println("Winners:");

        System.out.println("Winner - " + biathlonCompetition.getWinners().get(0));
        System.out.println("Runner-up - " + biathlonCompetition.getWinners().get(1));
        System.out.println("Third place - " + biathlonCompetition.getWinners().get(0));
    }

    private static ArrayList<Athlete> getAthletesFromFile(File file) {
        ArrayList<Athlete> athletes = new ArrayList<>();
        try (AthleteReader reader = new AthleteReader(Files.newBufferedReader(file.toPath()))) {
            athletes = reader.readAthletes();
        } catch (IOException e) {
            System.err.println("File not found!");
            e.printStackTrace();
        }
        return athletes;
    }
}
