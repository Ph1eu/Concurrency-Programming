package Semaphores;

import java.util.UUID;
import java.util.concurrent.*;

public class EquilibriumMarket {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();
        CopyOnWriteArrayList<Good> totalConsumed = new CopyOnWriteArrayList<>();
        Thread producer = new Thread(new Producer(sharedBuffer,totalConsumed));
        Thread consumer = new Thread(new Consumer(sharedBuffer,totalConsumed));
        producer.start();
        consumer.start();

    }
}
