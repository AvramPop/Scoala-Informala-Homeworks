package net.vompi;

import java.util.ArrayList;

/**
 * House simulates a real house, that has a modifiable set of rooms,
 * having a known total area.
 *
 */
public class House {
    private ArrayList<Room> rooms = new ArrayList<>();
    private double area = 0;

    /**
     * Adds the given newRoom to the house's set of rooms.
     * @param newRoom
     */

    public void addRoom(Room newRoom){
        rooms.add(newRoom);
        area += newRoom.getArea();
    }

    /**
     * Removes the roomToRemove from the house's set of rooms.
     * @param roomToRemove
     * @throws IllegalArgumentException when a room which is not part of the house has to be removed
     */

    public void removeRoom(Room roomToRemove) throws IllegalArgumentException{
        if(rooms.contains(roomToRemove)) {
            rooms.remove(roomToRemove);
            area -= roomToRemove.getArea();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Prints every room's in the house area to standard output.
     */

    public void displayAllRoomsAreas(){
        for(int i = 0; i < rooms.size(); i++){
            System.out.println("Room " + (i + 1) + " "  + rooms.get(i).getArea() + " square meters");
        }
    }

    public double getArea(){
        return area;
    }
}
