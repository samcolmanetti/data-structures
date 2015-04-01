package DijkstrasAlgorithm;

public class Neighbor {
    public Node node;
    public int weight;

    public Neighbor(Node node){
        this.node = node;
    }

    public Neighbor(Node node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
