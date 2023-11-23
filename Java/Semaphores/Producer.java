package Semaphores;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;

public class Producer implements Runnable{
    private  SharedBuffer sharedBuffer;
    private CopyOnWriteArrayList<Good> totalConsumed ;
    public Producer(SharedBuffer sharedBuffer,CopyOnWriteArrayList<Good> totalConsumed) {
        this.sharedBuffer = sharedBuffer;
        this.totalConsumed = totalConsumed;
    }

    @Override
    public void run() {
         while (true){
                int totalConsumption = 0;
                for(Good good : totalConsumed){
                    totalConsumption += good.getValue();
                }
                if(totalConsumption > 10000000){
                    System.out.println("Total consumption is " + totalConsumption + ".It's surplus, stop producing");
                    break;
                }
                sharedBuffer.produce();
          }

    }
}
