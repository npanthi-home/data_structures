package tree.rotations;

import common.node.DoubleLinkNode;

public interface LinearRotation<T, D extends DoubleLinkNode<T>> {
    D execute(D root);
}
