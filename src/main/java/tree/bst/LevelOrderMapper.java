package tree.bst;

import common.Mapper;
import common.node.DoubleLinkNode;
import common.node.Node;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOrderMapper<T> implements Mapper<Integer, T> {
    public Map<Integer, Collection<T>> map(Node<T> root) {
        Map<Integer, Collection<DoubleLinkNode<T>>> levelOrderMap = initMap((DoubleLinkNode<T>) root);
        map(levelOrderMap, 0);
        return levelOrderMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> getMappedValue(entry.getValue())));
    }

    private Map<Integer, Collection<DoubleLinkNode<T>>> initMap(DoubleLinkNode<T> root) {
        Map<Integer, Collection<DoubleLinkNode<T>>> levelOrderMap = new HashMap<>();
        levelOrderMap.put(0, Collections.singletonList(root));
        return levelOrderMap;
    }

    private void map(Map<Integer, Collection<DoubleLinkNode<T>>> levelOrderMap, int currentLevel) {
        if (levelOrderMap.get(currentLevel) == null)
            return;
        for (DoubleLinkNode<T> node : levelOrderMap.get(currentLevel)) {
            updateMap(levelOrderMap, node.getLeft(), currentLevel + 1);
            updateMap(levelOrderMap, node.getRight(), currentLevel + 1);
        }
        map(levelOrderMap, currentLevel + 1);
    }

    private void updateMap(Map<Integer, Collection<DoubleLinkNode<T>>> levelOrderMap, DoubleLinkNode<T> node, int newLevel) {
        if (node != null) {
            levelOrderMap.computeIfAbsent(newLevel, value -> new ArrayList<>());
            levelOrderMap.get(newLevel).add(node);
        }
    }

    private Collection<T> getMappedValue(Collection<DoubleLinkNode<T>> collection) {
        return collection.stream()
                .map(DoubleLinkNode::getData)
                .collect(Collectors.toList());
    }
}
