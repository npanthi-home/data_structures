package tree.bst;

import common.Collector;
import common.Injector;
import common.Mapper;
import common.node.DoubleLinkNode;
import tree.collectors.InOrderCollector;
import tree.collectors.LevelOrderCollector;
import tree.collectors.PostOrderCollector;
import tree.collectors.PreOrderCollector;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BinarySearchTree<T extends Comparable<? super T>> extends DoubleLinkNode<T> {
    private Injector<T, BinarySearchTree<T>> injector = new BinarySearchTreeInjector<>();
    private Collector<T> inOrderCollector = new InOrderCollector<>();
    private Collector<T> preOrderCollector = new PreOrderCollector<>();
    private Collector<T> postOrderCollector = new PostOrderCollector<>();
    private Mapper<Integer, T> levelOrderMapper = new LevelOrderCollector<>();

    public BinarySearchTree(T data) {
        super(data);
    }

    public BinarySearchTree<T> insert(T data) {
        return injector.inject(this, data);
    }

    public List fetchInOrder() {
        return (List) inOrderCollector.collect(this);
    }

    public List fetchPreOrder() {
        return (List) preOrderCollector.collect(this);
    }

    public List fetchPostOrder() {
        return (List) postOrderCollector.collect(this);
    }

    public Map<Integer, Collection<T>> fetchLevelOrder() {
        return levelOrderMapper.map(this);
    }
}
