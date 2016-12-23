package net.vompi;

/**
 * TrapezoidRoom class simulates a room that has a trapezoid shape.
 *
 */
public class TrapezoidRoom extends Room {
    private double bigBase, smallBase, height;

    /**
     * Creates a new TrapezoidRoom object
     * @param bigBaseLength the length of the big base of the room, given in meters
     * @param smallBaseLength the length of the small base of the room, given in meters
     * @param height the height of the room, given in meters
     */
    public TrapezoidRoom(double bigBaseLength, double smallBaseLength, double height){
        this.bigBase = bigBaseLength;
        this.smallBase = smallBaseLength;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (bigBase + smallBase) * height / 2;
    }
}
