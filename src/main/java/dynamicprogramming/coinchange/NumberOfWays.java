package dynamicprogramming.coinchange;

import com.google.common.collect.Maps;
import dynamicprogramming.Cache;
import dynamicprogramming.coinchange.denomination.Denomination;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfWays {
    private Set<Denomination> denominations = new HashSet<>();
    private Cache<Integer, Set<Map<Denomination, Integer>>> cache = new Cache<>();

    public Set<Map<Denomination, Integer>> execute(Integer sum) {
        if (cache.exists(sum)) {
            return cache.fetch(sum);
        }

        if (sum == 0) {
            return new HashSet<>();
        }

        Set<Map<Denomination, Integer>> existingWays = null;
        for (Denomination denomination : denominations) {
            if (sum >= denomination.value()) {
                Set<Map<Denomination, Integer>> newWays = getPossibleWays(denomination, sum);
                if(newWays != null)
                    existingWays = existingWays != null ? mergeWays(existingWays, newWays) : newWays;
            }
        }

        cache.memoize(sum, existingWays);
        return existingWays;
    }

    private Set<Map<Denomination, Integer>> mergeWays(Set<Map<Denomination, Integer>> existingWays, Set<Map<Denomination, Integer>> newWays) {
        Set<Map<Denomination, Integer>> allWays = new HashSet<>();
        allWays.addAll(existingWays);
        allWays.addAll(newWays);
        return allWays;
    }

    private Set<Map<Denomination, Integer>> getPossibleWays(Denomination denomination, Integer sum) {
        Set<Map<Denomination, Integer>> remainingSumWays = this.execute(sum - denomination.value());

        if (remainingSumWays == null)
            return null;

        if (remainingSumWays.isEmpty()) {
            Map<Denomination, Integer> singleEntry = new HashMap<>();
            singleEntry.put(denomination, 1);
            return Collections.singleton(singleEntry);
        }

        return remainingSumWays.stream()
                .map(Maps::newHashMap)
                .peek(way -> way.merge(denomination, 1, (a, b) -> a + b))
                .collect(Collectors.toSet());
    }

    public Set<Denomination> denominations() {
        return denominations;
    }
}
