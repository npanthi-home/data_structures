package common;

import common.node.Node;

import java.util.Collection;

public interface Mutator<T, N extends Node<T>> {
    N mutate(N node);
}
