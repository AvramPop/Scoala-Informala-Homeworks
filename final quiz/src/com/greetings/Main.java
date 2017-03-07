package com.greetings;

import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Date d1 = new Date(200);
        Date d2 = new Date(500);
        Date d3 = new Date(300);
        Date d4 = new Date(400);

        Package p1 = new Package("A", 7, 50, d1, 1);
        Package p2 = new Package("A", 1, 60, d4, 2);
        Package p3 = new Package("B", 2, 10, d4, 3);
        Package p4 = new Package("B", 3, 80, d3, 2);
        Package p5 = new Package("V", 2, 90, d4, 5);
        Package p6 = new Package("V", 4, 50, d4, 6);
        Package p7 = new Package("L", 3, 20, d2, 10);
        Package p8 = new Package("L", 1, 60, d4, 100);

        DeliverSystem deliverSystem = new DeliverSystem();

        deliverSystem.addPackage(p1);
        deliverSystem.addPackage(p2);
        deliverSystem.addPackage(p3);
        deliverSystem.addPackage(p4);
        deliverSystem.addPackage(p5);
        deliverSystem.addPackage(p6);
        deliverSystem.addPackage(p7);
        deliverSystem.addPackage(p8);

        deliverSystem.deliverPackagesForDate(d4);
        //deliverSystem.deliverAllPackages();
    }

}
