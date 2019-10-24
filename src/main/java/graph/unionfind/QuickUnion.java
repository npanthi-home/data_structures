package graph.unionfind;

import java.util.HashMap;
import java.util.Map;

public class QuickUnion<T> implements UnionFind<T>{
    private Map<T, T> parents = new HashMap<>();

    public void connect(T source, T target) {
        parents.put(source, getRoot(target));
    }

    private T getRoot(T node) {
        if(getParent(node) == null) {
            return node;
        }
        return getRoot(getParent(node));
    }

    private T getParent(T node) {
        return parents.get(node);
    }

    public boolean isConnected(T source, T target) {
        return getRoot(source).equals(getRoot(target));
    }
}
