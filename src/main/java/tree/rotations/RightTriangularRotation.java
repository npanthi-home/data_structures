package tree.rotations;

import common.Mutator;
import common.node.DoubleLinkNode;

public class RightTriangularRotation<T, D extends DoubleLinkNode<T>> implements TriangularRotation<T, D> {
    private Mutator<T, D> leftSubtreeRotator = new LeftSubtreeRotator<>();
    private Mutator<T, D> rightSubtreeRotator = new RightSubtreeRotator<>();

    @Override
    public D execute(D root) {
        root.setRight(rightSubtreeRotator.mutate(root.getRight()));
        return leftSubtreeRotator.mutate(root);
    }
}
