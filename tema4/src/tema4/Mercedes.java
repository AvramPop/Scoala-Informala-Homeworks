package tema4;

public abstract class Mercedes extends Car {
	protected Mercedes(int availableFuel, String chassisNumber, int tankSize, String fuelType, int gears,
			double consumptionPer100Kms) {
		super(availableFuel, chassisNumber, tankSize, fuelType, gears, consumptionPer100Kms);
	}
}
