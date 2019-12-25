package dynamicprogramming.coinchange;

import dynamicprogramming.coinchange.denomination.Denomination;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class NumberOfWaysTest {
    @Test
    public void shouldReturnDenominations() {
        NumberOfWays numberOfWays = new NumberOfWays();
        numberOfWays.denominations().add(new Denomination(1));
        numberOfWays.denominations().add(new Denomination(2));
        numberOfWays.denominations().add(new Denomination(3));
        Set<Map<Denomination, Integer>> result = numberOfWays.execute(5);
        System.out.println(result);
        assertEquals(5, result.size());
    }

    @Test
    public void shouldReturnEmptyDenominationsWhenChangeIsNotPossible() {
        NumberOfWays minimumCoins = new NumberOfWays();
        minimumCoins.denominations().add(new Denomination(7));
        minimumCoins.denominations().add(new Denomination(5));
        Set<Map<Denomination, Integer>> result = minimumCoins.execute(23);
        System.out.println(result);
        assertNull(result);
    }

    @Test
    public void shouldReturnDenominationsWhenBiggestCoinCannotBeUsedForChange() {
        NumberOfWays minimumCoins = new NumberOfWays();
        minimumCoins.denominations().add(new Denomination(3));
        minimumCoins.denominations().add(new Denomination(5));
        minimumCoins.denominations().add(new Denomination(2));
        Set<Map<Denomination, Integer>> result = minimumCoins.execute(11);
        System.out.println(result);
        assertEquals(4, result.size());
    }
}