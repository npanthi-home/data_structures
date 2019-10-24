package graph.unionfind;

public interface UnionFind<T> {
    void connect(T source, T target);
    boolean isConnected(T source, T target);
}
