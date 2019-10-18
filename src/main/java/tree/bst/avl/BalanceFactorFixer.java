package tree.bst.avl;

import common.Mutator;

public class BalanceFactorFixer<T extends Comparable<? super T>> implements Mutator<T, AvlTree<T>> {
    @Override
    public AvlTree<T> mutate(AvlTree<T> root) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null)
                root.getBalanceFactor().reset();

            root.setLeft(mutate(root.getLeft()));
            root.setRight(mutate(root.getRight()));
            root.setBalanceFactor(new BalanceFactor(calculateBalanceFactor(root)));

            return root;
        }
        return null;
    }

    private int calculateBalanceFactor(AvlTree<T> root) {
        return getBalanceFactor(root.getRight()) - getBalanceFactor(root.getLeft());
    }

    private int getBalanceFactor(AvlTree<T> root) {
        return root != null ? root.getBalanceFactor().getValue() : -1;
    }
}
