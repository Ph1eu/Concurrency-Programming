package CyclicBarrier;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee implements Runnable{
    private final CyclicBarrier startSignal;
    private final int employeeId;
    private final Random random = new Random();
    private int workValue;

    public Employee(CyclicBarrier startSignal , int employeeId) {
        this.startSignal = startSignal;
        this.employeeId = employeeId;
    }
    @Override
    public void run() {
        try {
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void doWork() throws InterruptedException {
        this.workValue = random.nextInt(10000);
        System.out.println("Employee " + employeeId + " have done " + workValue+" value of work");
        try {
            startSignal.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public int getWorkValue(){
        return this.workValue;
    }
}

