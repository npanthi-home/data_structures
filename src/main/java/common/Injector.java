package common;

import common.node.Node;

public interface Injector<I, N extends Node<I>> {
    N inject(N node, I injection);
}
