package tema4;

public class Main {

	public static void main(String[] args) {
		Car car = new VWPassat(300, "sadasddas");
		car.start();

		car.shiftGear(1);

		car.drive(500);

		car.shiftGear(5);

		car.changeTyres(13);

		car.drive(100);

		car.shiftGear(4);

		car.drive(230);

		car.shiftGear(5);

		car.drive(120);

		car.shiftGear(4);

		car.drive(800);

		car.shiftGear(5);

		car.drive(1000);

		car.shiftGear(4);

		car.drive(200);

		car.shiftGear(5);

		car.drive(90);

		car.stop();

	}

}
