package tree.bst.redblack;

import common.Injector;
import common.node.DoubleLinkNode;
import common.node.Node;

public class RedBlackTreeInjector<T extends Comparable<? super T>> implements Injector<T> {
    public Node<T> inject(Node<T> node, T injection) {
        DoubleLinkNode<T> tree = (DoubleLinkNode<T>) node;
        insert(tree, injection);
        return tree;
    }

    private void insert(DoubleLinkNode<T> tree, T data) {
        if (data.compareTo(tree.getData()) < 0)
            insertInLeftSubtree(tree, data);
        else
            insertInRightSubtree(tree, data);
    }

    private void insertInRightSubtree(DoubleLinkNode<T> tree, T data) {
        if (tree.getRight() != null)
            insert(tree.getRight(), data);
        else
            tree.setRight(createNode(data));

    }

    private DoubleLinkNode<T> createNode(T data) {
        return new DoubleLinkNode<T>(data);
    }

    private void insertInLeftSubtree(DoubleLinkNode<T> tree, T data) {
        if (tree.getLeft() != null)
            insert(tree.getLeft(), data);
        else
            tree.setLeft(createNode(data));
    }
}
