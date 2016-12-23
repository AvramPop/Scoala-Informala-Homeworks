package net.vompi;

public class Main {

    public static void main(String[] args) {
        House myHouse = new House();

        Room r1 = new CircleRoom(10, 355);
        Room r2 = new RectangleRoom(10, 20);
        Room r3 = new RightAngleTriangleRoom(10, 20);
        Room r4 = new SquareRoom(10);
        Room r5 = new TrapezoidRoom(10, 5, 10);

        myHouse.addRoom(r1);
        myHouse.addRoom(r2);
        myHouse.addRoom(r3);
        myHouse.addRoom(r4);
        myHouse.addRoom(r5);

        myHouse.displayAllRoomsAreas();

        myHouse.removeRoom(r3);

        myHouse.displayAllRoomsAreas();

        HeatingWattageCalculator calculator = new HeatingWattageCalculator();
        int neededWattage = calculator.calculateWattageForHouse(myHouse);

        System.out.println("Consumption: " + neededWattage + " W");
    }
}
