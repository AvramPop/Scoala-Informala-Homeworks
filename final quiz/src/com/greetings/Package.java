package com.greetings;

import java.util.Date;

/**
 * Created by dani on 3/7/17.
 */
public class Package {
    public final String targetLocation;
    public final int distanceToTarget;
    public final int merchandiseValue;
    public final Date deliveryDate;
    public final int profitPerKm;

    public Package(String targetLocation, int distanceToTarget, int merchandiseValue,
                   Date deliveryDate, int profitPerKm) {
        this.targetLocation = targetLocation;
        this.distanceToTarget = distanceToTarget;
        this.merchandiseValue = merchandiseValue;
        this.deliveryDate = deliveryDate;
        this.profitPerKm = profitPerKm;
    }
}
