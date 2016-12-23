package net.vompi;

/**
 * The HeatingWattageCalculator does calculations about a house's consumption of energy.
 *
 */
public class HeatingWattageCalculator {
    /**
     * Returns the consumption in watts of houseToComputeWattageFor house
     * @param houseToComputeWattageFor
     * @return the house's wattage
     */

    public int calculateWattageForHouse(House houseToComputeWattageFor){
        return 33 * (int)houseToComputeWattageFor.getArea();
    }
}
