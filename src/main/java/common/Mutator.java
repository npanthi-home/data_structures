package common;

import common.node.Node;

import java.util.Collection;

public interface Mutator<T> {
    Node<T> mutate(Node<T> node);
}
