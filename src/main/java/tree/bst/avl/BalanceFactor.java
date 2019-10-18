package tree.bst.avl;

public class BalanceFactor {
    private int value;

    public BalanceFactor() {
        this.value = 0;
    }

    public BalanceFactor(int value) {
        this.value = value;
    }

    public void reset() {
        this.value = 0;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public boolean isImbalanced() {
        return Math.abs(value) == 2;
    }

    public boolean isLeftHeavy() {
        return value < 0;
    }

    public boolean isRightHeavy() {
        return value > 0;
    }

    public int getValue() {
        return value;
    }
}
