package Future;

import java.util.Random;
import java.util.concurrent.Callable;

public class Employee implements Callable<Integer> {

    private Company company;

    public Employee(Company company) {
        this.company = company;
    }

    @Override
    public Integer call() {
        synchronized (this.company) {
            int value = this.company.getValue();
            Random random = new Random();
            value += random.nextInt(10000);
            this.company.setValue(value);
            return value;
        }
    }

}
