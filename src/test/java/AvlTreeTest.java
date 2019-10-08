import org.junit.Test;
import tree.bst.BinarySearchTree;
import tree.bst.avl.AvlTree;

public class AvlTreeTest {
    @Test
    public void printInOrder() {
        AvlTree<Integer> tree = new AvlTree<Integer>(11)
                .insert(7)
                .insert(1)
                .insert(3)
                .insert(4)
                .insert(6)
                .insert(5);
        System.out.println(tree.fetchInOrder());
        System.out.println(tree.fetchLevelOrder());
    }
}