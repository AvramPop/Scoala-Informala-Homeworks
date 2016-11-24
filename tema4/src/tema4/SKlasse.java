package tema4;

public class SKlasse extends Mercedes {

	/**
	 * Creates a SKlasse with a unique chassis number and a specified quantity
	 * of fuel in the tank. The other members of the object are class specific.
	 * 
	 * @param availableFuel
	 *            the fuel available in the tank of the car (in liters)
	 * @param chassisNumber
	 *            an unique code, describing the car's vital info
	 *
	 */

	public SKlasse(int availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber, 65, "Diesel", 5, 13.9);
	}
}
