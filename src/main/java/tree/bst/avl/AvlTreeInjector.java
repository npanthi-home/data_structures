package tree.bst.avl;

import common.Injector;
import common.Mutator;
import common.node.Node;
import tree.bst.mutators.BalanceFactorFixer;
import tree.bst.mutators.LeftSubtreeRotator;
import tree.bst.mutators.RightSubtreeRotator;

public class AvlTreeInjector<T extends Comparable<? super T>> implements Injector<T> {
    private Mutator<T> leftSubtreeRotator = new LeftSubtreeRotator<>();
    private Mutator<T> rightSubtreeRotator = new RightSubtreeRotator<>();
    private Mutator<T> balanceFactorFixer = new BalanceFactorFixer<>();

    public Node<T> inject(Node<T> node, T injection) {
        return insert((AvlTree<T>) node, injection);
    }

    private Node<T> insert(AvlTree<T> root, T data) {
        AvlTree<T> newRoot;
        if (data.compareTo(root.getData()) < 0)
            newRoot = updateLeftSubtree(root, data);
        else
            newRoot = updateRightSubtree(root, data);
        return newRoot;
    }

    private AvlTree<T> updateRightSubtree(AvlTree<T> root, T data) {
        root.setBalanceFactor(root.getBalanceFactor() + 1);
        if (root.getRight() != null) {
            root.setRight((AvlTree<T>) insert(root.getRight(), data));
            if (root.getBalanceFactor() == 2)
                return (AvlTree<T>) balanceFactorFixer.mutate(performRightSubtreeRotations(root));
            return root;
        } else {
            root.setRight(createNode(data));
            return root;
        }
    }

    private AvlTree<T> performRightSubtreeRotations(AvlTree<T> root) {
        AvlTree<T> newRoot;
        if (root.getRight().getBalanceFactor() == 1)
            newRoot = (AvlTree<T>) leftSubtreeRotator.mutate(root);
        else {
            root.setRight((AvlTree<T>) rightSubtreeRotator.mutate(root.getRight()));
            newRoot = (AvlTree<T>) leftSubtreeRotator.mutate(root);
        }
        return newRoot;
    }

    private AvlTree<T> createNode(T data) {
        return new AvlTree<>(data);
    }

    private AvlTree<T> updateLeftSubtree(AvlTree<T> root, T data) {
        root.setBalanceFactor(root.getBalanceFactor() - 1);
        if (root.getLeft() != null) {
            root.setLeft((AvlTree<T>) insert(root.getLeft(), data));
            if (root.getBalanceFactor() == -2)
                return (AvlTree<T>) balanceFactorFixer.mutate(performLeftSubtreeRotations(root));
            return root;
        } else {
            root.setLeft(createNode(data));
            return root;
        }
    }

    private AvlTree<T> performLeftSubtreeRotations(AvlTree<T> root) {
        AvlTree<T> newRoot;
        if (root.getLeft().getBalanceFactor() == -1)
            newRoot = (AvlTree<T>) rightSubtreeRotator.mutate(root);
        else {
            root.setLeft((AvlTree<T>) leftSubtreeRotator.mutate(root.getLeft()));
            newRoot = (AvlTree<T>) rightSubtreeRotator.mutate(root);
        }
        return newRoot;
    }
}
