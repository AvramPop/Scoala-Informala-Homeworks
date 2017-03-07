package com.greetings;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The DeliverySystem takes a bunch of packages and sends them by deliverers, one for every location
 */
public class DeliverSystem {
    HashMap<Date, HashMap<String, ArrayList<Package>>> packages = new HashMap<>();

    public void addPackage(Package pack){

        if(packages.get(pack.deliveryDate) != null){
            //if there is at least one package with the same date
            ArrayList<Package> tempArr;
            if(packages.get(pack.deliveryDate).get(pack.targetLocation) != null) {
                //if there is at least one package with the same location
                tempArr = packages.get(pack.deliveryDate).get(pack.targetLocation);
            } else {
                //if there is no package with the same location
                tempArr = new ArrayList<>();
            }
            tempArr.add(pack);
            HashMap<String, ArrayList<Package>> tempMap = packages.get(pack.deliveryDate);
            tempMap.put(pack.targetLocation, tempArr);
            packages.put(pack.deliveryDate, tempMap);
        } else {
            //if there is no package with the same date
            ArrayList<Package> tempArr = new ArrayList<>();
            tempArr.add(pack);
            HashMap<String, ArrayList<Package>> tempMap = new HashMap<>();
            tempMap.put(pack.targetLocation, tempArr);
            packages.put(pack.deliveryDate, tempMap);
        }

    }


    /**
     * The packages having the delivery date will be delivered, following their location.
     * A Deliverer thread will be created for every unique location
     *
     * @param date the delivery date to send packages in
     */
    public void deliverPackagesForDate(Date date){
        int count = 0;
        Deliverer deliverers[] = new Deliverer[1000];
        for(Map.Entry<Date, HashMap<String, ArrayList<Package>>> entry : packages.entrySet()) {
            if(entry.getKey().equals(date)) {
                HashMap<String, ArrayList<Package>> value = entry.getValue();
                for (Map.Entry<String, ArrayList<Package>> entry1 : value.entrySet()) {
                    deliverers[count] = new Deliverer();
                    for (Package p : entry1.getValue()) {
                        deliverers[count].addPackage(p);
                    }
                    deliverers[count].start();
                    count++;
                }
            }
        }
    }

    /**
     * This method will produce the delivery of every single package, no matter the date.
     * A separate thread will be created for every location.
     */
    public void deliverAllPackages(){
        int count = 0;
        Deliverer deliverers[] = new Deliverer[1000];
        for(Map.Entry<Date, HashMap<String, ArrayList<Package>>> entry : packages.entrySet()) {
            HashMap<String, ArrayList<Package>> value = entry.getValue();
            for(Map.Entry<String, ArrayList<Package>> entry1 : value.entrySet()){
                deliverers[count] = new Deliverer();
                for(Package p : entry1.getValue()){
                    deliverers[count].addPackage(p);
                }
                deliverers[count].start();
                count++;
            }
        }
    }
}
