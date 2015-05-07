package HuffmanCode;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;


public class HuffmanCode {

    public String text;
    private Hashtable<String,Integer> table;
    private HuffmanTree tree;

    public HuffmanCode(String text){
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
            nodes.get(nodes.size()-1).insertLeft(nodes.get(0));
            nodes.get(nodes.size()-1).insertRight(nodes.get(1));
            nodes.remove(0);
            nodes.remove(0);
        }
        tree = nodes.get(0);
    }
    public String encode (){
        String result = "";
        for (int i = 0; i < text.length(); i++){
            result += toBinary(text.charAt(i)) + " ";
        }
        return result;
    }

    public String decode (String encoding){
        String result = "";
        StringTokenizer tokenizer = new StringTokenizer (encoding, " ");
        while (tokenizer.hasMoreTokens()){
            result += toLetter(tokenizer.nextToken());
        }
        return result;
    }
    private String toBinary (char c){
        String result = "";
        HuffmanTree temp = tree;
        while (temp != null){
            if (temp.right() != null && temp.right().getRoot().letters.contains(Character.toString(c))) {
                result += "1";
                temp = temp.right();
            }
            else if (temp.left() != null && temp.left().getRoot().letters.contains(Character.toString(c))){
                result += 0;
                temp = temp.left();
            } else {
                temp = null;
            }
        }
        return result;
    }
    private String toLetter (String bin){
        String result = "";
        HuffmanTree temp = tree;
        for (int i = 0; i < bin.length(); i++){
            if (bin.charAt(i) == '0')
                temp = temp.left();
            else if (bin.charAt(i) == '1')
                temp = temp.right();
        }
        return temp.getRoot().letters;
    }
}