package dynamicprogramming.coinchange;

import dynamicprogramming.coinchange.denomination.Denomination;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MinimumCoinsTest {
    @Test
    public void shouldReturnDenominations() {
        MinimumCoins minimumCoins = new MinimumCoins();
        minimumCoins.denominations().add(new Denomination(1));
        minimumCoins.denominations().add(new Denomination(2));
        minimumCoins.denominations().add(new Denomination(3));
        Map<Denomination, Integer> result = minimumCoins.execute(5);
        System.out.println(result);
        assertEquals(new Integer(1), result.get(new Denomination(3)));
        assertEquals(new Integer(1), result.get(new Denomination(2)));
    }

    @Test
    public void shouldReturnEmptyDenominationsWhenChangeIsNotPossible() {
        MinimumCoins minimumCoins = new MinimumCoins();
        minimumCoins.denominations().add(new Denomination(7));
        minimumCoins.denominations().add(new Denomination(5));
        Map<Denomination, Integer> result = minimumCoins.execute(23);
        System.out.println(result);
        assertNull(result);
    }

    @Test
    public void shouldReturnDenominationsWhenBiggestCoinCannotBeUsedForChange() {
        MinimumCoins minimumCoins = new MinimumCoins();
        minimumCoins.denominations().add(new Denomination(3));
        minimumCoins.denominations().add(new Denomination(5));
        minimumCoins.denominations().add(new Denomination(2));
        Map<Denomination, Integer> result = minimumCoins.execute(11);
        System.out.println(result);
        assertEquals(new Integer(1), result.get(new Denomination(5)));
        assertEquals(new Integer(2), result.get(new Denomination(3)));
    }
}
