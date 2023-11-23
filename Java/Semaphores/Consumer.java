package Semaphores;

import java.util.concurrent.*;

public class Consumer implements Runnable {
    private SharedBuffer sharedBuffer;
    private CopyOnWriteArrayList<Good> totalConsumed ;
    public Consumer(SharedBuffer sharedBuffer,CopyOnWriteArrayList<Good> totalConsumed) {
        this.sharedBuffer = sharedBuffer;
        this.totalConsumed = totalConsumed;
    }

    @Override
    public void run() {
        while (true) {
            int totalConsumption = 0;
            for(Good good : totalConsumed){
                totalConsumption += good.getValue();
            }

            if(totalConsumption > 10000000){
                System.out.println("Total consumption is " + totalConsumption + ".It's surplus, stop producing");
                break;
            }
            Good Good = sharedBuffer.consume();
            totalConsumed.add(Good);

        }
    }
}
