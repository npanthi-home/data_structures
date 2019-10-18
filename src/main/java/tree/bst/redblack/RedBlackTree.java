package tree.bst.redblack;

import common.Injector;
import tree.bst.BinarySearchTree;

public class RedBlackTree<T extends Comparable<? super T>> extends BinarySearchTree<T> {
    private Colour colour;

    private Injector<T, RedBlackTree<T>> injector = new RedBlackTreeInjector<>();

    public RedBlackTree(T data) {
        super(data);
        this.colour = Colour.RED;
    }

    public RedBlackTree<T> insert(T data) {
        return injector.inject(this, data);
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }


    public RedBlackTree<T> getRight() {
        return super.getRight();
    }

    public RedBlackTree<T>  getLeft() {
        return super.getLeft();
    }
}
