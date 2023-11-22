package CountDownLatch;
import java.util.concurrent.CountDownLatch;

public class MeetAndWorkSynchronization {
    public static void main(String[] args) {
        int employeeCount = 10;
        int taskCount = 5;
        CountDownLatch startSignal = new CountDownLatch(employeeCount);
        CountDownLatch doneSignal = new CountDownLatch(employeeCount * taskCount);
        for (int i = 0; i < employeeCount; i++) {
            new Thread(new Employee(startSignal, doneSignal, i, taskCount)).start();
        }
        try{

            doneSignal.await();
        }catch(InterruptedException e){
        ;   e.printStackTrace();
        }
        System.out.println("All tasks completed.");
    }


}
