package bst;
import queue.QueueAsLinkedList;

public class BinarySearchTree implements BST {
    private Node root;
    private int size;

    public BinarySearchTree (){
        root = null;
        size = 0;
    }

    public void insert(int val) {
        if (size == 0){
            root = new Node (val);
        } else {
            insert (this.root, val);
        }
        size++;
    }
    public void insert (Node curr, int val){
        if (val  >= curr.value) {
            if (curr.rightSubtree == null) {
                curr.rightSubtree = new Node(val);
                curr.rightSubtree.parent = curr;
            }
            else
                insert(curr.rightSubtree, val);
        }else {
            if (curr.leftSubtree == null) {
                curr.leftSubtree = new Node(val);
                curr.leftSubtree.parent = curr;
            }
            else
                insert(curr.leftSubtree, val);
        }
    }

    @Override
    public void delete(int val) {
            delete (root, val);
            size--;
    }
    public void delete (Node curr, int val){
        if (curr.value > val && curr.leftSubtree != null){
            delete (curr.leftSubtree, val);
        }else if (curr.value < val && curr.rightSubtree != null){
            delete (curr.rightSubtree, val);
        } else if (curr.value == val){
            if (curr.leftSubtree != null){
                Node temp = curr.leftSubtree;
                if (curr.value == root.value)
                    root = temp;
                while (temp.rightSubtree != null)
                    temp = temp.rightSubtree;
                temp.rightSubtree = curr.rightSubtree;
                if (curr.rightSubtree != null)
                    curr.rightSubtree.parent = temp;
                if (curr.parent != null)
                    curr.parent.leftSubtree = curr.leftSubtree;
            } else if (curr.rightSubtree != null){
                Node temp = curr.rightSubtree;
                if (curr.value == root.value)
                    root = temp;
                while (temp.leftSubtree != null)
                    temp = temp.leftSubtree;
                temp.leftSubtree = curr.leftSubtree;
                if (curr.leftSubtree != null)
                    curr.leftSubtree.parent = temp;
                if (curr.parent != null)
                    curr.parent.rightSubtree = curr.rightSubtree;
            } else {
                // leaf node
                if (size == 1)
                    root = null;
                else if (curr.parent.leftSubtree.value == curr.value)
                    curr.parent.leftSubtree = null;
                else
                    curr.parent.rightSubtree = null;
            }
        } else {
            size++; // I subtracted 1 beforehand so now I have to add 1 to even it out
            System.out.println ("Element not in tree");
        }
    }

    int[][] tree;
    public void dumptree () {
        System.out.println ("Dump tree:");
        int level = depth (root);
        int width = (int) Math.pow(2,level-1) + 1; // max number of nodes at lowest level + 1
        tree = new int[level][width];

        insertIntoTable(root, 0, width/2);

        for (int row = 0; row < level; row++) {
            for (int col = 0; col < width; col++) {
                if (tree[row][col] > 0)
                    System.out.print("\t" + tree[row][col] + "\t");
                else
                    System.out.print("\t");
            }
            System.out.println ();
        }
    }

    private int max (int v1, int v2){
        if (v1 > v2)
            return v1;
        else
            return v2;
    }

    private int depth (Node node){
        if (node == null)
            return 0;
        else if (node.leftSubtree == null && node.rightSubtree == null)
            return 1;
        else{
            return 1 + max (depth(node.leftSubtree), depth(node.rightSubtree));
        }
    }

    public void insertIntoTable (Node curr, int row, int col){

        tree[row][col] = curr.value;
        if (curr.leftSubtree != null)
            insertIntoTable(curr.leftSubtree, row + 1, col - 1);
        if (curr.rightSubtree != null){
            insertIntoTable(curr.rightSubtree, row+1, col+1);
        }

    }
}
