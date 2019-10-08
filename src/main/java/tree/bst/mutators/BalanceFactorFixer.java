package tree.bst.mutators;

import common.Mutator;
import common.node.Node;
import tree.bst.avl.AvlTree;

public class BalanceFactorFixer<T extends Comparable<? super T>> implements Mutator<T> {
    @Override
    public Node<T> mutate(Node<T> node) {
        if (node != null) {
            AvlTree<T> avlTree = (AvlTree<T>) node;
            if (avlTree.getLeft() == null && avlTree.getRight() == null)
                avlTree.setBalanceFactor(0);

            avlTree.setLeft((AvlTree<T>) mutate(avlTree.getLeft()));
            avlTree.setRight((AvlTree<T>) mutate(avlTree.getRight()));
            avlTree.setBalanceFactor(getBalanceFactor(avlTree.getRight()) - getBalanceFactor(avlTree.getLeft()));

            return avlTree;
        }
        return null;
    }

    private int getBalanceFactor(AvlTree<T> root) {
        return root != null ? root.getBalanceFactor() : -1;
    }
}
