package tree.rotations;

import common.node.DoubleLinkNode;

public interface TriangularRotation<T, D extends DoubleLinkNode<T>> {
    D execute(D root);
}
