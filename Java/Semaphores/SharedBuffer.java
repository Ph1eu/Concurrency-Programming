package Semaphores;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class SharedBuffer {
    private static int BufferSize =10;
    private LinkedBlockingQueue<Good> buffer = new LinkedBlockingQueue<>(BufferSize);
    private Semaphore mutex = new Semaphore(3);
    private Semaphore emptySlots = new Semaphore(BufferSize);
    private Semaphore fullSlots = new Semaphore(0);

    public void produce(){
        try {
            if (buffer.size() == BufferSize){
                System.out.println("Buffer is full, waiting for consumer");}

            emptySlots.acquire();
            mutex.acquire();

            Good newGood = new Good(new Random().nextInt(1000));
            buffer.put(newGood);
            System.out.println("Produced " + newGood.getValue());

            mutex.release();
            fullSlots.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Good consume(){
        Good consumedGood = null;

        try {
            if(buffer.size() == 0){
                System.out.println("Buffer is empty, waiting for producer");
            }
            fullSlots.acquire();
            mutex.acquire();

            consumedGood = buffer.take();
            System.out.println("Consumed " + consumedGood.getValue());

            mutex.release();
            emptySlots.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return consumedGood;
    }
}
