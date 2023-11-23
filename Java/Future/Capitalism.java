package Future;

import java.util.Random;
import java.util.concurrent.*;

public class Capitalism {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Company company = new Company();
        Boss boss = new Boss(company);
        Employee employee = new Employee(company);
        try {
            for (int i = 0; i < 10; i++) {
                Future<Integer> futureResult = executorService.submit(employee);

                Integer result = futureResult.get();

                System.out.println("Employees produce " + result +" value in month " + (i+1));
            }
            if (company.getValue() < company.getDebt()) {
                int random = new Random().nextInt(2);
                if (random == 0){
                    System.out.println("Congrats! Your boss is Elon Musk");
                    boss.investForCompany();
                } else {
                    System.out.println("Congrats! Your boss is Sam bankman-Fried");
                    boss.stoleMoney();
                }
            }else{
                System.out.println("Congrats! Your boss is Jeff Bezos");
                boss.investForCompany();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }
}
