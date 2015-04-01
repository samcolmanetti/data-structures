package DijkstrasAlgorithm;

import java.io.IOException;
import java.util.ArrayList;

public class Graph extends GraphHelper{
    protected ArrayList<Node> nodes;

    public Graph (String filePath) throws IOException {
        super.initialize(filePath);
        nodes = super.nodes;
    }

    public String execute (){
        nodes.get(0).setValue(0);
        ArrayList<Node> visited = new ArrayList<Node>();

        return "";
    }
}