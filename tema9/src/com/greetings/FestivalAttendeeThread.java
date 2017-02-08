package com.greetings;

import java.util.Random;

/**
 * The FestivalAttendeeThread class extends the Thread class and models
 * a attendee who has a ticket and validates it at a certain gate.
 */
public class FestivalAttendeeThread extends Thread {
    private FestivalGate festivalGate;
    private TicketType ticket;
    private Random random = new Random();

    public FestivalAttendeeThread(FestivalGate festivalGate, TicketType ticket) {
        this.festivalGate = festivalGate;
        this.ticket = ticket;
    }

    /**
     * The validateTicket method makes the thread sleep for a random below 1 seconds time wait,
     * then starts it, then joins it.
     */

    public void validateTicket(){
        try {
           sleep(random.nextInt(10) * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        start();

        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println(ticket);
            festivalGate.addTicket(ticket);
        }
    }
}
