package com.greetings;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        Random random = new Random();

        FestivalStatisticsThread festivalStatisticsThread = new FestivalStatisticsThread(gate);
        try{
            festivalStatisticsThread.start();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        int attendees = random.nextInt(1000) + 100;

        for (int i = 0; i < attendees; i++) {
            TicketType ticketType = TicketType.values()[random.nextInt(TicketType.values().length)];
            FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(gate, ticketType);
            festivalAttendee.validateTicket();
        }
    }
}
