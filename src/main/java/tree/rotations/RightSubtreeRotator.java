package tree.rotations;

import common.Mutator;
import common.node.DoubleLinkNode;

public class RightSubtreeRotator<T, D extends DoubleLinkNode<T>> implements Mutator<T, D> {
    @Override
    public D mutate(D currentRoot) {
        if(currentRoot != null) {
            D newRoot = currentRoot.getLeft();
            currentRoot.setLeft(newRoot.getRight());
            newRoot.setRight(currentRoot);
            return newRoot;
        }
        return null;
    }
}
