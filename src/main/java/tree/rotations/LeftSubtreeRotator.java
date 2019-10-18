package tree.rotations;

import common.Mutator;
import common.node.DoubleLinkNode;

public class LeftSubtreeRotator<T, D extends DoubleLinkNode<T>> implements Mutator<T, D> {
    @Override
    public D mutate(D currentRoot) {
        if(currentRoot != null) {
            D newRoot = currentRoot.getRight();
            currentRoot.setRight(newRoot.getLeft());
            newRoot.setLeft(currentRoot);
            return newRoot;
        }

        return null;
    }
}
