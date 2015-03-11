package bst;

public class BSTTester {
    public static void main (String arguments[]){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert (5);
        bst.insert (7);
        bst.insert(21);
        bst.dumptree();
        bst.delete(20);
        bst.delete(21);
        bst.dumptree();
        bst.delete(35);
    }
}
