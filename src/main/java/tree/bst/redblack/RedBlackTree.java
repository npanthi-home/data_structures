package tree.bst.redblack;

import common.Injector;
import tree.bst.BinarySearchTree;

public class RedBlackTree<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    private Injector<T> injector = new RedBlackTreeInjector<>();

    public RedBlackTree(T data) {
        super(data);
    }

    public RedBlackTree<T> insert(T data) {
        return (RedBlackTree<T>) injector.inject(this, data);
    }
}
