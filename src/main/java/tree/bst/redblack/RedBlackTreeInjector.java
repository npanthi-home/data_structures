package tree.bst.redblack;

import common.Injector;
import common.Mutator;
import tree.rotations.*;

public class RedBlackTreeInjector<T extends Comparable<? super T>> implements Injector<T, RedBlackTree<T>> {
    private TriangularRotation<T, RedBlackTree<T>> leftTriangularRotation = new LeftTriangularRotation<>();
    private TriangularRotation<T, RedBlackTree<T>> rightTriangularRotation = new RightTriangularRotation<>();
    private LinearRotation<T, RedBlackTree<T>> leftLinearRotation = new LeftLinearRotation<>();
    private LinearRotation<T, RedBlackTree<T>> rightLinearRotation = new RightLinearRotation<>();
    private Mutator<T, RedBlackTree<T>> colourFixer = new ColourFixer<>();

    public RedBlackTree<T> inject(RedBlackTree<T> node, T injection) {
        return insert(node, injection);
    }

    private RedBlackTree<T> insert(RedBlackTree<T> root, T data) {
        return data.compareTo(root.getData()) < 0
                ? updateLeftSubtree(root, data)
                : updateRightSubtree(root, data);
    }

    private RedBlackTree<T> updateRightSubtree(RedBlackTree<T> root, T data) {
        root.setBalanceFactor(root.getBalanceFactor() + 1);
        if (root.getRight() != null) {
            root.setRight(insert(root.getRight(), data));
            return root.getBalanceFactor() == 2
                    ? colourFixer.mutate(performRightSubtreeRotations(root))
                    : root;
        } else {
            root.setRight(createNode(data));
            return root;
        }
    }

    private RedBlackTree<T> performRightSubtreeRotations(RedBlackTree<T> root) {
        return root.getRight().getBalanceFactor() == 1
                ? rightLinearRotation.execute(root)
                : rightTriangularRotation.execute(root);
    }

    private RedBlackTree<T> createNode(T data) {
        return new RedBlack Tree<>(data);
    }

    private RedBlackTree<T> updateLeftSubtree(RedBlackTree<T> root, T data) {
        root.setBalanceFactor(root.getBalanceFactor() - 1);
        if (root.getLeft() != null) {
            root.setLeft(insert(root.getLeft(), data));
            return root.getBalanceFactor() == -2
                    ? colourFixer.mutate(performLeftSubtreeRotations(root))
                    : root;
        } else {
            root.setLeft(createNode(data));
            return root;
        }
    }

    private RedBlackTree<T> performLeftSubtreeRotations(RedBlackTree<T> root) {
        return root.getLeft().getBalanceFactor() == -1
                ? leftLinearRotation.execute(root)
                : leftTriangularRotation.execute(root);
    }
}
