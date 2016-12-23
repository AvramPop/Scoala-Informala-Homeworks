package net.vompi;

/**
 * CircleRoom class simulates a room that has a circle sector shape.
 *
 */
public class CircleRoom extends Room {
    private double radius, angle;

    /**
     * Creates a new CircleRoom object
     * @param radius the radius of the room, given in meters
     * @param angle the angle at center of the room, given in degrees
     * @throws IllegalArgumentException when an angle above 360 degrees is given
     */
    public CircleRoom(double radius, double angle) throws IllegalArgumentException {
        this.radius = radius;
        this.angle = angle;
        if(angle > 360) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getArea() {
        return angle * Math.PI * radius * radius / 360;
    }
}
