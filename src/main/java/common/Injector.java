package common;

import common.node.Node;

public interface Injector<T> {
    Node<T> inject(Node<T> node, T injection);
}
