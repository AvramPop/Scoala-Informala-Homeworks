package com.greetings;

import java.util.ArrayList;

/**
 * The Deliverer object extends the Thread class and models some kind of currier, who receives a bunch of packages
 * and has to deliver them to the destination.
 *
 * When a thread is started it takes every package, sleeps a time equivalent to the distance, then computes the value and
 * profit, which will be printed when the delivery ends(aka the Thread dies).
 */
public class Deliverer extends Thread {

    ArrayList<Package> packages = new ArrayList<>();
    private int value = 0;
    private int profit = 0;

    public void addPackage(Package pack){
        packages.add(pack);
    }

    @Override
    public void run() {
        for (Package p : packages) {
            this.profit += p.profitPerKm * p.distanceToTarget;
            this.value += p.merchandiseValue;

            try {
                this.sleep(p.distanceToTarget * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The total value for deliverer in town " + packages.get(0).targetLocation + " is: " + value);
        System.out.println("The total profit for deliverer in town " + packages.get(0).targetLocation + " is: " + profit);
    }
}
