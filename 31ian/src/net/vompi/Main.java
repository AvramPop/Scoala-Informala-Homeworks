package net.vompi;

import java.util.Random;

public class Main {
    private long count;
    Random random = new Random();

    public void increment(){
        synchronized (this) {
            long original = count;
            count = original + 1;
        }
    }

    public long getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
	    Thread [] threads = new Thread[50000000];
	    Main main = new Main();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Worker(10, main));
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Count: " + main.getCount());
    }

    private static class Worker implements Runnable {
        int repeats;
        Main counter;

        public Worker(int repeats, Main counter) {
            this.repeats = repeats;
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < repeats; i++) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                counter.increment();
            }
        }
    }
}
