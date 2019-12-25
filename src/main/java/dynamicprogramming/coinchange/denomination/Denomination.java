package dynamicprogramming.coinchange.denomination;

import java.util.Objects;

public class Denomination {
    private Integer denomination;

    public Denomination(Integer denomination) {
        this.denomination = denomination;
    }

    public Integer value() {
        return denomination;
    }

    @Override
    public String toString() {
        return denomination.toString();
    }

    @Override
    public boolean equals(Object o) {
        return this.denomination.equals(((Denomination) o).denomination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination);
    }
}
