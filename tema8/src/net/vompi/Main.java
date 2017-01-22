package net.vompi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        File csv = new File("/home/dani/Desktop/code/Scoala-Informala-Homeworks/tema8/data/input.csv");
        ArrayList<Athlete> athletes = new ArrayList<>();
        try (AthleteReader reader = new AthleteReader(Files.newBufferedReader(csv.toPath()))) {
            athletes = reader.readAthletes();
        } catch (IOException e) {
            System.err.println("File not found!");
            e.printStackTrace();
        }
        BiathlonCompetition biathlonCompetition = new BiathlonCompetition(athletes);
        System.out.println(biathlonCompetition.getWinners().toString());
    }
}
