package CyclicBarrier;
import java.util.*;
import java.util.concurrent.*;

public class Capitalism {
    public static void main(String[] args) {
        int employeeCount = 10;
        CyclicBarrier startSignal = new CyclicBarrier(employeeCount);
        int validWorkValue = 1000000000;
        List<Employee> employeeList = new ArrayList<>();
        Thread[] threads = new Thread[employeeCount];

        for (int i = 0; i < employeeCount; i++) {
            // generate employee array
            employeeList.add(new Employee(startSignal, i));
        }

        int current_work_value = 0;
        int iteration = 0;
        while(true){
           //reuse the threads
            for(int i = 0; i < employeeCount; i++){
                threads[i] = new Thread(employeeList.get(i));
                threads[i].start();
            }

            for(int i = 0; i < employeeCount; i++){
                current_work_value += employeeList.get(i).getWorkValue();
            }
            if(current_work_value >= validWorkValue){
                System.out.println("All work has been done after " + iteration + " iteration");
                break;
            }
            else{
                iteration++;
                System.out.println("total work value is " + current_work_value + " after " + iteration + " iteration");
                System.out.println("work has not been done! Keep working");
            }

        }

    }
}
