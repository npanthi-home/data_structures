package tree.rotations;

import common.Mutator;
import common.node.DoubleLinkNode;

public class LeftLinearRotation<T, D extends DoubleLinkNode<T>> implements LinearRotation<T, D> {
    private Mutator<T, D> rightSubtreeRotator = new RightSubtreeRotator<>();

    @Override
    public D execute(D root) {
        return rightSubtreeRotator.mutate(root);
    }
}
