package com.greetings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * The FestivalGate class models a gate where every attendee has to validate
 * his/hers ticket, holding the data of every one.
 */
public class FestivalGate {
    private Queue<TicketType> ticketsQueue = new LinkedList<>();
    private Map<TicketType, Integer> ticketsBought = new HashMap<>();

    public FestivalGate() {
        for(TicketType t : TicketType.values()){
            ticketsBought.put(t, 0);
        }
    }

    public void addTicket(TicketType ticket){
        ticketsQueue.add(ticket);
        int ticketsOfKind = ticketsBought.get(ticket);
        ticketsBought.put(ticket, ticketsOfKind + 1);
    }

    public Map<TicketType, Integer> getTicketsBought() {
        return ticketsBought;
    }

    public void clearData(){
        ticketsQueue.clear();
        ticketsBought.clear();
    }
}
