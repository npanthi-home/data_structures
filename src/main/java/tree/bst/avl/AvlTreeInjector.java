package tree.bst.avl;

import common.Injector;
import common.Mutator;
import tree.rotations.*;

public class AvlTreeInjector<T extends Comparable<? super T>> implements Injector<T, AvlTree<T>> {
    private TriangularRotation<T, AvlTree<T>> leftTriangularRotation = new LeftTriangularRotation<>();
    private TriangularRotation<T, AvlTree<T>> rightTriangularRotation = new RightTriangularRotation<>();
    private LinearRotation<T, AvlTree<T>> leftLinearRotation = new LeftLinearRotation<>();
    private LinearRotation<T, AvlTree<T>> rightLinearRotation = new RightLinearRotation<>();
    private Mutator<T, AvlTree<T>> balanceFactorFixer = new BalanceFactorFixer<>();

    @Override
    public AvlTree<T> inject(AvlTree<T> node, T injection) {
        return insert(node, injection);
    }

    private AvlTree<T> insert(AvlTree<T> root, T data) {
        return data.compareTo(root.getData()) < 0
                ? updateLeftSubtree(root, data)
                : updateRightSubtree(root, data);
    }

    private AvlTree<T> updateRightSubtree(AvlTree<T> root, T data) {
        root.getBalanceFactor().increment();
        if (root.getRight() != null) {
            root.setRight(insert(root.getRight(), data));
            return root.getBalanceFactor().isImbalanced()
                    ? balanceFactorFixer.mutate(performRightSubtreeRotations(root))
                    : root;
        } else {
            root.setRight(createNode(data));
            return root;
        }
    }

    private AvlTree<T> performRightSubtreeRotations(AvlTree<T> root) {
        return root.getRight().getBalanceFactor().isRightHeavy()
                ? rightLinearRotation.execute(root)
                : rightTriangularRotation.execute(root);
    }

    private AvlTree<T> createNode(T data) {
        return new AvlTree<>(data);
    }

    private AvlTree<T> updateLeftSubtree(AvlTree<T> root, T data) {
        root.getBalanceFactor().decrement();
        if (root.getLeft() != null) {
            root.setLeft(insert(root.getLeft(), data));
            return root.getBalanceFactor().isImbalanced()
                    ? balanceFactorFixer.mutate(performLeftSubtreeRotations(root))
                    : root;
        } else {
            root.setLeft(createNode(data));
            return root;
        }
    }

    private AvlTree<T> performLeftSubtreeRotations(AvlTree<T> root) {
        return root.getLeft().getBalanceFactor().isLeftHeavy()
                ? leftLinearRotation.execute(root)
                : leftTriangularRotation.execute(root);
    }
}
