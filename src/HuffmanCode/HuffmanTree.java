package HuffmanCode;


import java.util.Comparator;

public class HuffmanTree implements Comparable{
    private Node node;
    private HuffmanTree left;
    private HuffmanTree right;

    public HuffmanTree (Node n){
        this.node = n;
    }
    public void insertLeft (HuffmanTree n){
        left = n;
}
    public void insertRight (HuffmanTree n){
        right = n;
    }
    public HuffmanTree right (){
        return right;
    }
    public HuffmanTree left (){
        return left;
    }
    public Node getRoot (){
        return node;
    }

    @Override
    public int compareTo(Object o) {
        HuffmanTree t = (HuffmanTree) o;
        return this.node.compareTo(t.getRoot());
    }
}