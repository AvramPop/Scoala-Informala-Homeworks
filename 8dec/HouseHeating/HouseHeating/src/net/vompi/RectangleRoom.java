package net.vompi;

/**
 * RectangleRoom class simulates a room that has a rectangle shape.
 *
 */
public class RectangleRoom extends Room {
    private double width, height;

    /**
     * Creates a new RectangleRoom object
     * @param width the width of the room, given in meters
     * @param height the height of the room, given in meters
     */
    public RectangleRoom(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
