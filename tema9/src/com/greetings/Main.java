package com.greetings;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        Random random = new Random();
        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(gate);

        festivalStatisticsThread.start();
        int attendees = random.nextInt(1000) + 100;
        for (int i = 0; i < attendees; i++) {
            TicketType ticketType = TicketType.values()[random.nextInt(5)];
            FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(gate, ticketType);

            try {
                festivalAttendee.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            festivalAttendee.start();
        }
    }
}
