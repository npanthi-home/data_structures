package tree.bst.mutators;

import common.Mutator;
import common.node.DoubleLinkNode;
import common.node.Node;

public class RightSubtreeRotator<T> implements Mutator<T> {
    public Node<T> mutate(Node<T> node) {
        if(node != null) {
            DoubleLinkNode<T> currentRoot = (DoubleLinkNode<T>) node;
            DoubleLinkNode<T> newRoot = currentRoot.getLeft();
            currentRoot.setLeft(newRoot.getRight());
            newRoot.setRight(currentRoot);
            return newRoot;
        }

        return null;
    }
}
