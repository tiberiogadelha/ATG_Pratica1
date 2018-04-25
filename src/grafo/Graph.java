package grafo;

import java.util.ArrayList;

import no.Node;

public class Graph {
	
	private final String LS = System.lineSeparator();
	
	private int idForEdges = 1;
	private int id;
	private ArrayList<Vertex> verteces;
	
	
	public Graph(int id) {
		this.setId(id);
		this.verteces = new ArrayList<>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Vertex> getAllVertix() {
		return verteces;
	}


	public void setVertex(ArrayList<Vertex> vertix) {
		this.verteces = vertix;
	}


	public void addVertix(int i) {
		Vertex newVertex = new Vertex(i);
		this.verteces.add(newVertex);
	}


	public void addEdge(int vertex1Id, int vertex2Id) {
		Vertex vertex1 = getVertex(vertex1Id);
		Vertex vertex2 = getVertex(vertex2Id);
		
		vertex1.addEdge(idForEdges, vertex2);
		vertex2.addEdge(idForEdges, vertex1);
		
		idForEdges++;
		
	}
	
	private Vertex getVertex(int id) {
		Vertex foundVertex = null;
		
		for(Vertex vertex: verteces) {
			if(vertex.getId() == id) {
				return vertex;
			}
		}
		
		return foundVertex;
	}
	
	public int getVertexNumber() {
		return this.verteces.size();
	}
	
	@Override
	public String toString() {
		String saida = "Graph's ID: " + id + " | Verteces: " + verteces.toString() + " ";
		return saida;
	}


	public int getEdgeNumber() {
		
		return idForEdges - 1;
	}


	public String amRepresentation() {
		String saida = "";
		
		return saida;
	}


	public String alRepresentation() {
		String saida = "";
		
		for(Vertex vertex: verteces) {
			saida += vertex.getId() + " - ";
			for(Node edge: vertex.getEdges()) {
				saida += edge.getEdge().getId() + " ";
			}
			saida += LS;
		}
		
		return saida;
	}

}
