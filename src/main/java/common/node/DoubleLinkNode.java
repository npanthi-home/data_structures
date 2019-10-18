package common.node;

public class DoubleLinkNode<T> extends Node<T> {
    private DoubleLinkNode<T> left;
    private DoubleLinkNode<T> right;

    public DoubleLinkNode(T data) {
        super(data);
        this.left = this.right = null;
    }

    public <D extends DoubleLinkNode<T>> D getLeft() {
        return (D) left;
    }

    public <D extends DoubleLinkNode<T>> void setLeft(D left) {
        this.left = left;
    }

    public <D extends DoubleLinkNode<T>> D getRight() {
        return (D) right;
    }

    public <D extends DoubleLinkNode<T>> void setRight(D right) {
        this.right = right;
    }
}
