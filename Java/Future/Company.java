package Future;

public class Company {
    private int value;
    private int debt = 1000000;
    public synchronized int getValue() {
        return value;
    }
    public synchronized void setValue(int value) {
        this.value = value;
    }
    public synchronized int getDebt() {
        return debt;
    }
}
