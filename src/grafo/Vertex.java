package grafo;

import java.util.ArrayList;

public class Vertex {
	
	private int id;
	private ArrayList<Edge> edges;
	
	
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


	public ArrayList<Edge> getEdges() {
		return edges;
	}


	public void addEdge(int id, Vertex vertex) {
		Edge newEdge = new Edge(id);
		newEdge.setEdge(vertex);
		newEdge.setFatherID(this.id);
		edges.add(newEdge);
		
	}
	
	public void addWeightEdge(int id, Vertex vertex, float weight) {
		Edge newEdge = new WeightEdge(id, weight);
		newEdge.setEdge(vertex);
		newEdge.setFatherID(this.id);
		edges.add(newEdge);
		
	}
	
	public void setEdges(ArrayList<Edge> newEdges) {
		this.edges = newEdges;
	}
	
	@Override
	public String toString() {
		String saida = "Vertex's ID: " + id + " | Edges: " + edges.toString() + " ";
		
		return saida;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} if (obj == null) {
			return false;
		} if (getClass() != obj.getClass()) {
			return false;
		}
		
		Vertex other = (Vertex) obj;
		if (id != other.id) {
			return false;
		}
		
		return true;
	}

	public boolean hasEdge(int id) {
		
		for(Edge edge: edges) {
			if(edge.getEdge().getId() == id) {
				return true;
			}
		}
		
		return false;
	}

	


	

}
