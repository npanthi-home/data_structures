package dynamicprogramming.coinchange;

import com.google.common.collect.Maps;
import dynamicprogramming.Cache;
import dynamicprogramming.coinchange.denomination.Denomination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCoins {
    private List<Denomination> denominations = new ArrayList<>();
    public Cache<Integer, Map<Denomination, Integer>> cache = new Cache<>();

    public Map<Denomination, Integer> execute(Integer sum) {
        if (cache.exists(sum)) {
            return cache.fetch(sum);
        }

        List<Map<Denomination, Integer>> results = new ArrayList<>();
        for (Denomination denomination : denominations) {
            if (sum.equals(denomination.value())) {
                Map<Denomination, Integer> singleValue = new HashMap<>();
                singleValue.put(denomination, 1);
                cache.memoize(sum, singleValue);
                return singleValue;
            }

            if (sum > denomination.value())
                results.add(getTransformedResult(denomination, this.execute(sum - denomination.value())));
        }

        Map<Denomination, Integer> minimum = getMinimumResult(results);
        cache.memoize(sum, minimum);
        return minimum;
    }

    private Map<Denomination, Integer> getTransformedResult(Denomination denomination, Map<Denomination, Integer> result) {
        if (result == null)
            return null;

        HashMap<Denomination, Integer> transformedResult = Maps.newHashMap(result);
        transformedResult.merge(denomination, 1, (a, b) -> a + b);
        return transformedResult;
    }

    private Map<Denomination, Integer> getMinimumResult(List<Map<Denomination, Integer>> results) {
        Map<Denomination, Integer> minimum = null;
        for (Map<Denomination, Integer> result : results) {
            if (result == null)
                continue;
            if (minimum == null || getTotalCoins(result) < getTotalCoins(minimum))
                minimum = result;
        }

        return minimum;
    }

    private Integer getTotalCoins(Map<Denomination, Integer> denominations) {
        return denominations.values().stream()
                .mapToInt(value -> value)
                .sum();
    }

    public List<Denomination> denominations() {
        return denominations;
    }
}
