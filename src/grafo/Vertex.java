package grafo;

import java.util.ArrayList;
import java.util.Arrays;

import no.Node;

public class Vertex {
	
	private int id;
	private ArrayList<Node> edges;
	
	
	public Vertex(int id) {
		this.setId(id);
		
		edges = new ArrayList<>();
	
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Node> getEdges() {
		return edges;
	}


	public void addEdge(int id, Vertex vertex) {
		Node newEdge = new Node(id);
		newEdge.setEdge(vertex);
		newEdge.setFatherID(this.id);
		edges.add(newEdge);
		
	}
	
	@Override
	public String toString() {
		String saida = "Vertex's ID: " + id + " | Edges: " + edges.toString() + " ";
		
		return saida;
	}

}
