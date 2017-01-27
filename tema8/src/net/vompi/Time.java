package net.vompi;

/**
 * The Time class models a minutes-and-seconds stopwatch.
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
        this.minutes += seconds / 60;
        this.seconds += seconds % 60;
        if(this.seconds > 60){
            this.minutes += this.seconds / 60;
            this.seconds = this.seconds % 60;
        } else if(this.seconds == 60){
            this.minutes++;
            this.seconds = 0;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    /**
     * The addTime method adds a Time object to another one, that is, increases one's seconds
     * with the anther one's, making the same with the minutes.
     * @param time the time to add to the current object
     */

    public void addTime(Time time) throws IllegalArgumentException{
        if(time == null){
            throw new IllegalArgumentException();
        }
        else {
            this.minutes += time.getMinutes();
            this.minutes += time.getSeconds() / 60;
            this.seconds += time.getSeconds() % 60;
            if (this.seconds > 60) {
                this.minutes += this.seconds / 60;
                this.seconds = this.seconds % 60;
            } else if (this.seconds == 60) {
                this.minutes++;
                this.seconds = 0;
            }
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (minutes != time.minutes) return false;
        return seconds == time.seconds;
    }

    @Override
    public int hashCode() {
        int result = minutes;
        result = 31 * result + seconds;
        return result;
    }
}
