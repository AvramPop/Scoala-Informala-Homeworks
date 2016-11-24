package tema4;

public class VWPassat extends VW {

	/**
	 * Creates a VWPassat with a unique chassis number and a specified quantity
	 * of fuel in the tank. The other members of the object are class specific.
	 * 
	 * @param availableFuel
	 *            the fuel available in the tank of the car (in liters)
	 * @param chassisNumber
	 *            an unique code, describing the car's vital info
	 *
	 */

	public VWPassat(int availableFuel, String chassisNumber) {
		super(availableFuel, chassisNumber, 300, "Diesel", 6, 20);
	}
}
