package com.greetings;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dani on 2/8/17.
 */
public class FestivalStatisticsThreadTest {
    FestivalGate gate = new FestivalGate();

    @Test
    public void statsThreadCorrectlyReadsInfoFromGate(){
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.ONE_DAY);
        FestivalStatisticsThread stats = new FestivalStatisticsThread(gate);
        Assert.assertEquals(stats.gate.getTicketsBought().equals(gate.getTicketsBought()), true);
        Assert.assertEquals(Integer.valueOf(stats.gate.getTicketsBought().get(TicketType.FREE_PASS)), Integer.valueOf(3));
        gate.clearData();
    }

    @Test(expected = IllegalArgumentException.class)
    public void statsThreadThrowsErrorIfGateIsEmpty(){
        gate.clearData();
        FestivalStatisticsThread stats = new FestivalStatisticsThread(gate);
        stats.run();
    }
}