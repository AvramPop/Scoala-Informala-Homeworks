package net.vompi;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dani on 1/26/17.
 */
public class TimeTest {
    @Test
    public void timeAddsSecondsCorrectly(){
        Time t = new Time(30, 2);
        t.increaseSecondsWith(60);
        Time expected = new Time(31, 2);
        Assert.assertEquals(t, expected);
    }

    @Test
    public void timeAddsMinutesCorrectly(){
        Time t = new Time(30, 2);
        t.increaseMinutesWith(60);
        Time expected = new Time(90, 2);
        Assert.assertEquals(t, expected);
    }

    @Test
    public void timeAddsTimeCorrectly(){
        Time t = new Time(30, 2);
        Time t2 = new Time(20, 59);
        t.addTime(t2);
        Time expected = new Time(51, 1);
        Assert.assertEquals(t, expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void timeAddingNullTimeThrowsError(){
        Time t = new Time(30, 2);
        Time t2 = null;
        t.addTime(t2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void timeWithSecondsAbove60ThrowsExceptionAtConstructor(){
        Time t = new Time(30, 85);
    }

    @Test
    public void timesCompareCorrectly(){
        Time t = new Time(30, 2);
        Time t2 = new Time(20, 59);
        Assert.assertEquals(t.compareTo(t2), 1);
    }
}