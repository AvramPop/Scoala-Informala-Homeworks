package tema4;

public abstract class VW extends Car {
	protected VW(int availableFuel, String chassisNumber, int tankSize, String fuelType, int gears,
			double consumptionPer100Kms) {
		super(availableFuel, chassisNumber, tankSize, fuelType, gears, consumptionPer100Kms);
	}
}
