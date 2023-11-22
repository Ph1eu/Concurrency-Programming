package CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Employee implements Runnable{
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final int employeeId;
    private final int taskCount;
    private final Random random = new Random();
    public Employee(CountDownLatch startSignal, CountDownLatch doneSignal, int employeeId, int taskCount) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.employeeId = employeeId;
        this.taskCount = taskCount;
    }
    @Override
    public void run() {
        try {
            waitForEnoughEmployee();

            System.out.println("everybody is here, let's start");
            for (int i = 0; i < taskCount; i++) {
                doWork();
                doneSignal.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void doWork() throws InterruptedException {
        System.out.println("Employee " + employeeId + " is doing task " + random.nextInt(1000));
        Thread.sleep(random.nextInt(1000));
    }
    private void waitForEnoughEmployee() throws InterruptedException {
        System.out.println("Employee " + employeeId + " is waiting for others");
        startSignal.countDown();
        startSignal.await();

    }
}

