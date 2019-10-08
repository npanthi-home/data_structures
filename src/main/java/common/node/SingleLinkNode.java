package common.node;

public class SingleLinkNode<T> extends Node<T> {
    private Node link;

    public SingleLinkNode(T data) {
        super(data);
        this.link = null;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
