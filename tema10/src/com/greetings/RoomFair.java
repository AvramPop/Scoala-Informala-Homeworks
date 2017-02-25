package com.greetings;

/**
 * The RoomFair class is a POJO which models the cost of a season for a room.
 */
public class RoomFair {
    private long id;
    private float value;
    private String season;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
