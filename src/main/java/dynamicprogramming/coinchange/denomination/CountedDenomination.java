package dynamicprogramming.coinchange.denomination;

import java.util.Map;

public class CountedDenomination implements Map.Entry<Integer, Integer> {
    private Integer denomination;
    private Integer count;

    public CountedDenomination(Integer denomination, Integer count) {
        this.denomination = denomination;
        this.count = count;
    }

    public Integer value() {
        return denomination;
    }

    public Integer count() {
        return count;
    }

    @Override
    public Integer getKey() {
        return denomination;
    }

    @Override
    public Integer getValue() {
        return count;
    }

    @Override
    public Integer setValue(Integer count) {
        this.count = count;
        return this.count;
    }
}
