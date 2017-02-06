package com.greetings;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * Created by dani on 2/6/17.
 */
public class FestivalGateTest {
    @Test
    public void gateCorrectlyIncrementsTicketsValidated(){
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FREE_PASS);
        int ticketsOfKind = gate.getTicketsBought().get(TicketType.FREE_PASS);
        Assert.assertEquals(ticketsOfKind, 1);
    }

    @Test
    public void gateCorrectlyPrintsZeroWhenTicketsOfKindIsEmpty(){
        FestivalGate gate = new FestivalGate();
        int ticketsOfKind = gate.getTicketsBought().get(TicketType.FREE_PASS);
        Assert.assertEquals(ticketsOfKind, 0);
    }
}