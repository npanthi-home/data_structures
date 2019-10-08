package common;

import common.node.Node;

import java.util.Collection;
import java.util.Map;

public interface Mapper<X, Y> {
    Map<X, Collection<Y>> map(Node<Y> node);
}
