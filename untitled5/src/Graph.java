import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Models.Feature;

public class Graph {
    private Map<Node, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(Node node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node source, Node destination, double weight) {
        Edge edge = new Edge(destination, weight);
        adjacencyList.get(source).add(edge);
    }

    public List<Edge> getNeighbors(Node node) {
        return adjacencyList.get(node);
    }

	 
	
	public void printGraph() {
		// TODO Auto-generated method stub
		 for (Node node : adjacencyList.keySet()) {
		        System.out.print( " distance between two nodes ");
		        for (Edge edge : adjacencyList.get(node)) {
		            System.out.print( "(" + edge.getWeight() + ") ");
		        }
		        System.out.println();
		    }
		
	}

	

    //public List<Node> getShortestPath(Node source, Node destination) {
        // implement Dijkstra algorithm here
   // }
}

class Node {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public Node(Feature obj) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }
}

class Edge {
    private Node destination;
    private double weight;

    public Edge(Node destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
    

}

