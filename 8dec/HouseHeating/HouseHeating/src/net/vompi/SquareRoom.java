package net.vompi;

/**
 * SquareRoom class simulates a room that has a square shape.
 *
 */
public class SquareRoom extends Room {
    private double edgeLength;

    /**
     * Creates a new SquareRoom object
     * @param edgeLength the length of the edge of the room, given in meters
     */
    public SquareRoom(double edgeLength){
        this.edgeLength = edgeLength;
    }

    @Override
    public double getArea() {
        return edgeLength * edgeLength;
    }
}
