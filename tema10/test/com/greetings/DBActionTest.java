package com.greetings;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by dani on 2/25/17.
 */
public class DBActionTest {
    @Test
    public void addRoom(){
        Accomodation accomodation = new Accomodation();
        accomodation.setMaxGuests(5);
        accomodation.setType("Simple");
        accomodation.setBedType("Soft");
        accomodation.setDescription("Big windows");

        ArrayList<RoomFair> fares = new ArrayList<>();
        RoomFair rf1 = new RoomFair();
        RoomFair rf2 = new RoomFair();
        RoomFair rf3 = new RoomFair();
        RoomFair rf4 = new RoomFair();
        rf1.setSeason("Winter");
        rf1.setValue(5);
        fares.add(rf1);
        rf2.setSeason("Spring");
        rf2.setValue(50);
        fares.add(rf2);
        rf3.setSeason("Summer");
        rf3.setValue(65);
        fares.add(rf3);
        rf4.setSeason("Autumn");
        rf4.setValue(500);
        fares.add(rf4);

        DBAction dbAction = new DBAction();
        dbAction.addRoom(accomodation, fares);
    }

    @Test
    public void printRooms(){
        DBAction dbAction = new DBAction();
        dbAction.printRooms();
    }
}