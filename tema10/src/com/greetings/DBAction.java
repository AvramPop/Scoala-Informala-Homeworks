package com.greetings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dani on 2/25/17.
 */
public class DBAction {
    public void addRoom(Accomodation room, ArrayList<RoomFair> fares){
        AccomodationDAO accomodationDAO = new AccomodationDAO();
        RoomFairDAO roomFairDAO = new RoomFairDAO();
        AccomodationFairRelationDAO accomodationFairRelationDAO = new AccomodationFairRelationDAO();

        accomodationDAO.add(room);
        for(int i = 0; i < 4; i++){
            roomFairDAO.add(fares.get(i));
        }
        int roomFairSize = roomFairDAO.getAll().size();
        int lastElementOfRoomsIndex = accomodationDAO.getAll().size() - 1;

        AccomodationFairRelation arf1 = new AccomodationFairRelation();
        AccomodationFairRelation arf2 = new AccomodationFairRelation();
        AccomodationFairRelation arf3 = new AccomodationFairRelation();
        AccomodationFairRelation arf4 = new AccomodationFairRelation();

        arf1.setAccomodationId(accomodationDAO.getAll().get(lastElementOfRoomsIndex).getId());
        arf1.setRoomFairId(roomFairDAO.getAll().get(roomFairSize - 4).getId());
        arf2.setAccomodationId(accomodationDAO.getAll().get(lastElementOfRoomsIndex).getId());
        arf2.setRoomFairId(roomFairDAO.getAll().get(roomFairSize - 3).getId());
        arf3.setAccomodationId(accomodationDAO.getAll().get(lastElementOfRoomsIndex).getId());
        arf3.setRoomFairId(roomFairDAO.getAll().get(roomFairSize - 2).getId());
        arf4.setAccomodationId(accomodationDAO.getAll().get(lastElementOfRoomsIndex).getId());
        arf4.setRoomFairId(roomFairDAO.getAll().get(roomFairSize - 1).getId());

        accomodationFairRelationDAO.add(arf1);
        accomodationFairRelationDAO.add(arf2);
        accomodationFairRelationDAO.add(arf3);
        accomodationFairRelationDAO.add(arf4);
    }

    public void printRooms(){
        AccomodationFairRelationDAO accomodationFairRelationDAO = new AccomodationFairRelationDAO();
        accomodationFairRelationDAO.printWholeResultOfJoin();
    }
}
