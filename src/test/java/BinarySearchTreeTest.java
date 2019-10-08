import org.junit.Test;
import tree.bst.BinarySearchTree;

public class BinarySearchTreeTest {
    @Test
    public void printInOrder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(10);
        tree.insert(12);
        tree.insert(8);
        tree.insert(11);
        System.out.println(tree.fetchInOrder());
    }

    @Test
    public void printInOrderString() {
        BinarySearchTree<String> tree = new BinarySearchTree<>("Hello")
                .insert("World")
                .insert("Not")
                .insert("Great");
        System.out.println(tree.fetchInOrder());
        System.out.println(tree.fetchLevelOrder());
    }

    @Test
    public void printLevelOrder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(11)
                .insert(7)
                .insert(1)
                .insert(3)
                .insert(4)
                .insert(6)
                .insert(5);
        System.out.println(tree.fetchLevelOrder());
    }
}