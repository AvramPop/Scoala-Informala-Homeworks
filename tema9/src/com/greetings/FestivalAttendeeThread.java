package com.greetings;

/**
 * The FestivalAttendeeThread class extends the Thread class and models
 * a attendee who has a ticket and validates it at a certain gate.
 */
public class FestivalAttendeeThread extends Thread {
    private FestivalGate festivalGate;
    private TicketType ticket;

    public FestivalAttendeeThread(FestivalGate festivalGate, TicketType ticket) {
        this.festivalGate = festivalGate;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println(ticket);
            festivalGate.addTicket(ticket);
        }
    }
}
