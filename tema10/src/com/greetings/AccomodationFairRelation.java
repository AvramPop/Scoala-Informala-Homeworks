package com.greetings;

/**
 * The AccomodationFairRelation class is a POJO which models the db-layer mapping between a accomodation and a room-fair.
 */
public class AccomodationFairRelation {
    private long id;
    private long accomodationId;
    private long roomFairId;

    public long getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(long accomodationId) {
        this.accomodationId = accomodationId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoomFairId() {
        return roomFairId;
    }

    public void setRoomFairId(long roomFairId) {
        this.roomFairId = roomFairId;
    }
}
