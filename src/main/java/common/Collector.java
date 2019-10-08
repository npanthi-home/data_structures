package common;

import common.node.Node;

import java.util.Collection;

public interface Collector<T> {
    Collection<T> collect(Node<T> node);
}
