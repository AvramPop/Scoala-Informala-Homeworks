package net.vompi;

/**
 * Created by dani on 1/21/17.
 */
public final class Time implements Comparable<Time> {
    private int minutes;
    private int seconds;

    public Time() {
        minutes = 0;
        seconds = 0;
    }

    public Time(int minutes, int seconds) throws IllegalArgumentException{
        this.minutes = minutes;
        if(seconds < 60) {
            this.seconds = seconds;
        } else if(seconds == 60){
            this.minutes++;
        } else {
            throw new IllegalArgumentException("Seconds must be below 60");
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void increaseMinutesWith(int minutes){
        this.minutes += minutes;
    }

    public void increaseSecondsWith(int seconds){
        this.minutes += seconds % 60;
        this.seconds += seconds - (seconds % 60);
        if(seconds >= 60){
            this.minutes += seconds % 60;
            this.seconds += seconds - (seconds % 60);
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void addTime(Time time) {
        this.minutes += time.getSeconds() % 60;
        this.seconds += time.getSeconds() - (time.getSeconds() % 60);
    }

    @Override
    public int compareTo(Time o) {
        if(this.minutes > o.minutes){
            return 1;
        } else if(this.minutes < o.minutes){
            return -1;
        } else if(this.seconds > o.seconds){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Time{" +
                "minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }
}
