package tree.collectors;

import common.Collector;
import common.node.DoubleLinkNode;
import common.node.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InOrderCollector<T> implements Collector<T> {
    public Collection<T> collect(Node<T> node) {
        ArrayList<T> collection = new ArrayList<>();
        collect(node, collection);
        return collection;
    }

    private void collect(Node<T> node, List<T> collection) {
        if(node != null) {
            DoubleLinkNode<T> doubleLinkNode = (DoubleLinkNode<T>) node;
            collect(doubleLinkNode.getLeft(), collection);
            collection.add(node.getData());
            collect(doubleLinkNode.getRight(), collection);
        }
    }
}
