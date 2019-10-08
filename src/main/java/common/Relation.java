package common;

import common.node.Node;

public class Relation<T> {
    private Node<T> parent;
    private Node<T> child;

    public Relation(Node<T> parent, Node<T> child) {
        this.parent = parent;
        this.child = child;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getChild() {
        return child;
    }

    public void setChild(Node<T> child) {
        this.child = child;
    }
}
