package DijkstrasAlgorithm;

import java.util.ArrayList;

public class Node {
    public String name;
    private int value;
    private ArrayList<Neighbor> neighbors;

    public Node(String name, int value) {
        this.name = name;
        this.value = value;
        neighbors = new ArrayList<Neighbor>();
    }

    public ArrayList<Neighbor> getNeighbors (){
        return neighbors;
    }

    public void setValue (int v){
        value = v;
    }
    public int getValue(){
        return value;
    }

    public void addNeighbor (Node name, int weight){
        neighbors.add(new Neighbor(name, weight));
    }
}
