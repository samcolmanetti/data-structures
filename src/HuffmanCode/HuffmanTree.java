package HuffmanCode;


import scranton.tree.Heap;

import java.util.Comparator;

public class HuffmanTree implements Comparable{
    private HuffmanNode node;

    public HuffmanTree (Node n){
        this.node = new HuffmanNode(n);
    }
    public void insertLeft (Node n){
        node.left = new HuffmanNode(n);
}
    public void insertRight (Node n){
        node.right = new HuffmanNode(n);
    }
    public HuffmanNode right (){
        return node.right;
    }
    public HuffmanNode left (){
        return node.left;
    }
    public HuffmanNode getRoot (){
        return node;
    }

    @Override
    public int compareTo(Object o) {
        HuffmanTree t = (HuffmanTree) o;
        return this.node.root.compareTo(t.getRoot());
    }

    private class HuffmanNode {
        public Node root;
        public HuffmanNode left;
        public HuffmanNode right;

        public HuffmanNode (Node node) {
            this.root = node;
            this.left = null;
            this.right = null;
        }
    }
}