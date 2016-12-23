package net.vompi;

/**
 * RightAngleTriangleRoom class simulates a room that has a right-angle triangle shape.
 *
 */
public class RightAngleTriangleRoom extends Room {
    private double side1, side2;

    /**
     * Creates a new RightAngleTriangleRoom object
     * @param side1 the first side's length of the room, given in meters
     * @param side2 the second side's length of the room, given in meters
     */
    public RightAngleTriangleRoom(double side1, double side2){
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1 * side2 / 2;
    }
}
