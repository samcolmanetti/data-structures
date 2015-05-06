package HuffmanCode;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class HuffmanGenerator {
    private String text;
    private Hashtable<String,Integer> table;
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
        ArrayList<Node> nodes = new ArrayList<Node>();
        Enumeration<String> keys = table.keys();

        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            nodes.add(new Node (key, table.get(key)));
        }
        NodeComparator c = new NodeComparator();
        for (int i = table.size(); i < 2 * table.size() - 1; i++){
            nodes.sort(c);
            nodes.add(new Node (nodes.get(0).letters + nodes.get(1).letters, nodes.get(0).value + nodes.get(1).value));
        }

    }
}