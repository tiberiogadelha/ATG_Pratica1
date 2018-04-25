package no;

import grafo.Vertex;

public class Node {
	
	private int id;
	private int fatherID;
	private Vertex edge;
	private float weight;
	
	public Node(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vertex getEdge() {
		return edge;
	}

	public void setEdge(Vertex edge) {
		this.edge = edge;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public int getFatherID() {
		return this.fatherID;
	}
	
	public void setFatherID(int id) {
		this.fatherID = id;
	}

	
	@Override
	public String toString() {
		String saida = "Edge's ID: " + id + " | " + fatherID + " --- " + edge.getId() + " ";
		
		return saida;
	}

}
