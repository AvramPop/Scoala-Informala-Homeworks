package tema4;

/**
 * The Car object implements the Vehicle interface, being able to start, stop,
 * and drive for an amount of kms.
 * 
 * It can shift gears and change tires, changing the consumption accordingly,
 * and also return it's average consumption and available fuel at any moment.
 * 
 * Every Car has a class specific tank size, fuel type, number of gears and
 * medium consumption per 100 kms. The unique characteristic. of every single
 * Car is their chassis number. Every Car is created with a specific amount of
 * fuel in the tank.
 * 
 *
 */

public abstract class Car implements Vehicle {

	protected final int tankSize;
	protected final String fuelType;
	protected final int gears;
	protected final double consumptionPer100Kms;

	protected double availableFuel;
	protected int tyreSize = 16;
	protected int actualGear = 0;
	protected String chassisNumber;

	private double distanceTraveled = 0;
	private double actualConsumption;
	private boolean isMoving = false;
	private double averageConsumption;
	private double totalConsumption = 0;

	protected Car(int availableFuel, String chassisNumber, int tankSize, String fuelType, int gears,
			double consumptionPer100Kms) {
		this.availableFuel = availableFuel;
		this.chassisNumber = chassisNumber;
		this.fuelType = fuelType;
		this.gears = gears;
		this.tankSize = tankSize;
		this.consumptionPer100Kms = consumptionPer100Kms;
		actualConsumption = consumptionPer100Kms;
	}

	/**
	 * Changes to gear of the car to the one given, changing the consumption if
	 * needed
	 *
	 * @param newGear
	 *            the gear to shift to
	 */

	public void shiftGear(int newGear) {
		if (newGear == actualGear) {
			System.out.println("Can't shift to same gear!");
		} else {
			if (actualGear < newGear) {
				actualConsumption = 9 * actualConsumption / 10;
			} else
				actualConsumption = 11 * actualConsumption / 10;
			this.actualGear = newGear;
		}
	}

	/**
	 * Changes the tyreSize of the car, changing the consumption if needed
	 *
	 * @param newTyreSize
	 *            the number up to which the sum has to be computed
	 */

	public void changeTyres(int newTyreSize) {
		this.tyreSize = newTyreSize;
		if (newTyreSize > tyreSize) {
			actualConsumption = 12 * actualConsumption / 10;
		} else if (newTyreSize < tyreSize) {
			actualConsumption = 8 * actualConsumption / 10;
		}
	}

	/**
	 * Returns the average quantity of fuel consumed in a drive, per 100 kms in
	 * liters.
	 *
	 * @return the average consumption
	 */

	public double getAverageFuelConsumption() {
		return averageConsumption;
	}

	/**
	 * Returns the consumption of the car at the moment of asking, in liters /
	 * 100kms
	 *
	 * @return the consumption at the moment
	 */

	public double getActualConsumption() {
		return actualConsumption;
	}

	/**
	 * Returns the quantity of fuel in the car's tank
	 *
	 * @return the available fuel in tank
	 */

	public double getAvailableFuel() {
		return availableFuel;
	}

	/**
	 * Changes the state of the car, making it "moving". More, it resets the
	 * counter of kilometers driven.
	 *
	 */

	public void start() {
		distanceTraveled = 0;
		isMoving = true;
		actualConsumption = consumptionPer100Kms;
	}

	/**
	 * Changes the state of the car, making it "not moving". It calculates the
	 * average consumption, printing all the information to standard output.
	 *
	 */

	public void stop() {
		System.out.println("distance = " + distanceTraveled);
		System.out.println("liters = " + totalConsumption);
		isMoving = false;
		averageConsumption();
		printCarInfo();
	}

	private void averageConsumption() {
		averageConsumption = totalConsumption / distanceTraveled * 100;
	}

	private void printCarInfo() {
		System.out.println("Your car has stopped :)");
		System.out.println("Available fuel: " + availableFuel + "l");
		System.out.println("Average consumption: " + averageConsumption + " l/100km");
	}

	/**
	 * Does the logic of driving a specified distance in kilometers, if the car
	 * is started and there is enough fuel in the tank.
	 * 
	 * 
	 * @param distance
	 *            the distance to be traveled
	 */

	public void drive(double distance) {

		if (isMoving) {
			double litersConsumed = distance * actualConsumption / 100;
			if (availableFuel >= litersConsumed) {
				distanceTraveled += distance;
				totalConsumption += litersConsumed;
				availableFuel -= litersConsumed;
			} else
				System.out.println("You do not have enought fuel for this drive!");

		} else
			System.out.println("Can't move while the car is stopped!");

	}

}
