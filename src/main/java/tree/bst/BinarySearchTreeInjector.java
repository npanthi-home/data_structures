package tree.bst;

import common.Injector;

public class BinarySearchTreeInjector<T extends Comparable<? super T>> implements Injector<T, BinarySearchTree<T>> {
    public BinarySearchTree<T> inject(BinarySearchTree<T> root, T injection) {
        return insert(root, injection);
    }

    private BinarySearchTree<T> insert(BinarySearchTree<T> tree, T data) {
        return data.compareTo(tree.getData()) < 0
                ? insertInLeftSubtree(tree, data)
                : insertInRightSubtree(tree, data);
    }

    private BinarySearchTree<T> insertInRightSubtree(BinarySearchTree<T> root, T data) {
        if (root.getRight() != null)
            return insert(root.getRight(), data);
        else {
            root.setRight(createNode(data));
            return root;
        }
    }

    private BinarySearchTree<T> createNode(T data) {
        return new BinarySearchTree<>(data);
    }

    private BinarySearchTree<T> insertInLeftSubtree(BinarySearchTree<T> root, T data) {
        if (root.getLeft() != null)
            return insert(root.getLeft(), data);
        else {
            root.setLeft(createNode(data));
            return root;
        }
    }
}
