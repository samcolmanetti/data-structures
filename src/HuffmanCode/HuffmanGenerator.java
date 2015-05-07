package HuffmanCode;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import scranton.tree.BinarySearchTree;

public class HuffmanGenerator {

    private String text;
    private Hashtable<String,Integer> table;
    private HuffmanTree tree;

    public HuffmanGenerator (String text){
        this.text = text.toLowerCase();
        table = new Hashtable<String, Integer>();
        genFreq ();
    }
    private void genFreq (){
        for (int i = 0; i < text.length(); i++){
            if (table.get(Character.toString(text.charAt(i))) == null)
                table.put(Character.toString(text.charAt(i)), 1);
            else
                table.put (Character.toString(text.charAt(i)), table.get(Character.toString(text.charAt(i))) + 1);
        }
        buildTree();
    }
    private void buildTree (){
        ArrayList<HuffmanTree> nodes = new ArrayList<HuffmanTree>();
        Enumeration<String> keys = table.keys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            nodes.add(new HuffmanTree(new Node (key, table.get(key))));
        }
        TreeComparator treeComp = new TreeComparator();
        while (nodes.size() > 1){
            nodes.sort(treeComp);
            Node n1 = nodes.get(0).getRoot();
            Node n2 = nodes.get(1).getRoot();

            nodes.add(new HuffmanTree (new Node(n1.letters + n2.letters, n1.value + n2.value)));
            nodes.get(nodes.size()-1).insertLeft(n1);
            nodes.get(nodes.size()-1).insertRight(n2);
            nodes.remove(0);
            nodes.remove(0);
        }
        tree = nodes.get(0);

    }
    public String encode (){
        HuffmanTree temp = tree;
        for (int i = 0; i < text.length(); i++){

        }
        return "";
    }

    public String decode (){
        return "";
    }
    private String getSymbol (char c){
        String results = "";
        HuffmanTree temp = tree;
        while (temp != null){
            if (temp.left().equals(Character.toString(c)))
                temp = temp ;//temp.left();
            else if (temp.right().letters.equals(Character.toString(c)))
                results += "1";
            else if (temp.left().letters.contains(Character.toString(c)){

            }
        }
        return "";
    }
}