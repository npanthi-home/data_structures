package tree.rotations;

import common.Mutator;
import common.node.DoubleLinkNode;

public class RightLinearRotation<T, D extends DoubleLinkNode<T>> implements LinearRotation<T, D> {
    private Mutator<T, D> leftSubtreeRotator = new LeftSubtreeRotator<>();

    @Override
    public D execute(D root) {
        return leftSubtreeRotator.mutate(root);
    }
}
