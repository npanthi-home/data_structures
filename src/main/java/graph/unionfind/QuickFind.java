package graph.unionfind;

import java.util.HashMap;
import java.util.Map;

public class QuickFind<T> implements UnionFind<T>{
    private Map<T, T> groups = new HashMap<>();

    public void connect(T source, T target) {
        mergeGroups(source, target);
    }

    private T getGroup(T node) {
        return groups.get(node);
    }

    private void mergeGroups(T source, T target) {
        T sourceGroup = getGroup(source);
        if (sourceGroup != null) {
            groups.forEach((key, value) -> {
                if (sourceGroup.equals(value)) {
                    groups.put(key, target);
                }
            });
        }
        groups.put(target, target);
        groups.put(source, target);
    }

    public boolean isConnected(T source, T target) {
        return getGroup(source).equals(getGroup(target));
    }
}
