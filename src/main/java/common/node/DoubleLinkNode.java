package common.node;

public class DoubleLinkNode<T> extends Node<T> {
    private DoubleLinkNode<T> left;
    private DoubleLinkNode<T> right;

    public DoubleLinkNode(T data) {
        super(data);
        this.left = this.right = null;
    }

    public DoubleLinkNode<T> getLeft() {
        return left;
    }

    public void setLeft(DoubleLinkNode<T> left) {
        this.left = left;
    }

    public DoubleLinkNode<T> getRight() {
        return right;
    }

    public void setRight(DoubleLinkNode<T> right) {
        this.right = right;
    }
}
