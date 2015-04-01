package DijkstrasAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GraphHelper {
    protected ArrayList<Node> nodes = new ArrayList<Node>();

    private Node getNode (String name){
        Node temp = null;
        for (int i = 0; i < nodes.size(); i++){
            if (nodes.get(i).name.equals(name)){
                temp = nodes.get(i);
                break;
            }
        }
        return temp;
    }
    protected void initialize (String filePath) throws IOException {
        BufferedReader buf = new BufferedReader(new FileReader(new File(filePath)));
        while (buf.ready()){
            StringTokenizer tokenizer = new StringTokenizer(buf.readLine(), "\t: ");
            String nodeName = tokenizer.nextToken();
            Node temp = getNode(nodeName);
            if (temp == null){
                temp = new Node (nodeName,Integer.MAX_VALUE );
                nodes.add(temp);
            }
            while (tokenizer.hasMoreTokens()){
                String name = tokenizer.nextToken();
                int weight = Integer.valueOf(tokenizer.nextToken());
                Node neighbor = getNode(name);
                if (neighbor == null){
                    neighbor = new Node (name,Integer.MAX_VALUE );
                    nodes.add(neighbor);
                }
                temp.addNeighbor(neighbor, weight);
            }
        }
    }
    protected void printNodes (){
        for (int i = 0; i < nodes.size(); i++){
            System.out.printf("Name: %s\nValue: %d\n", nodes.get(i).name, nodes.get(i).getValue());
            ArrayList<Neighbor> n = nodes.get(i).getNeighbors();
            for (int j = 0; j < n.size(); j++){
                System.out.printf("Neighbor: %s\nWeight: %d\n", n.get(j).node.name, n.get(j).weight);
            }
            System.out.println();
        }
    }

    protected ArrayList<Node> getNodes (){
        return nodes;
    }
}
