package tree.bst.avl;

import tree.bst.BinarySearchTree;

public class AvlTree<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    private int balanceFactor;

    private AvlTreeInjector<T> injector = new AvlTreeInjector<T>();

    public AvlTree(T data) {
        super(data);
        this.balanceFactor = 0;
    }

    /*
    * Once you use insert on a AvlTree reference, the root might have changed and reference might become stale.
    * In order to prevent that, always re-initialize your reference with the value returned from here. It always returns
    * the current root of the AvlTree.
    */
    public AvlTree<T> insert(T data) {
        return (AvlTree<T>) injector.inject(this, data);
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public AvlTree<T> getRight() {
        return (AvlTree<T>) super.getRight();
    }

    public AvlTree<T>  getLeft() {
        return (AvlTree<T>) super.getLeft();
    }
}
