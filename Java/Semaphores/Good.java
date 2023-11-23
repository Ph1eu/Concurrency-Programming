package Semaphores;

import java.util.Objects;
import java.util.UUID;

public class Good implements Comparable<Good> {
    private UUID id;
    private int value;
    public Good(int value) {
        this.value = value;
        this.id = UUID.randomUUID();
    }
    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return value == good.value && Objects.equals(id, good.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    @Override
    public int compareTo(Good o) {

        return 0;
    }
}
