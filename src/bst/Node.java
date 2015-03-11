package bst;

public class Node {
    public int value;
    public Node leftSubtree;
    public Node rightSubtree;
    public Node parent;

    public Node (){
        leftSubtree = null;
        rightSubtree = null;
        parent = null;
    }

    public Node (int val){
        value = val;
        leftSubtree = null;
        rightSubtree = null;
        parent = null;
    }
}
