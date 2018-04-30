package grafo;

import java.util.ArrayList;

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
	
	public void addWeightEdge(float weight, int vertex1Id, int vertex2Id) {
		Vertex vertex1 = getVertex(vertex1Id);
		Vertex vertex2 = getVertex(vertex2Id);
		
		vertex1.addWeightEdge(idForEdges, vertex2, weight);
		vertex2.addWeightEdge(idForEdges, vertex1, weight);
		
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
		
		Graph other = (Graph) obj;
		if (id != other.id) {
			return false;
		}
		
		return true;
	}
	
	


	public int getEdgeNumber() {
		
		return idForEdges - 1;
	}


	public String amRepresentation() {
		String saida = "  ";
		
		for(int i = 0; i < verteces.size(); i++) {
			if(i < verteces.size()) {
				saida += (i+1) + " ";
			} else {
				saida += i+1;
			}
		}
		
		saida += LS;
		String[] frequency = bla();
		
		for(int i = 0; i < verteces.size(); i++) {
			saida += (i+1) + " " + frequency[i] + LS;
			
		}
		
		
		
		return saida;
	}
	
	private String[] bla() {
		String[] saida = new String[verteces.size()];
		String help = "";
		
		for(int i = 0; i < saida.length; i++) {
			Vertex vertex = verteces.get(i);
			
			for(int j = 1; j <= saida.length; j++) {
				if(vertex.hasEdge(j)) {
					if(j < saida.length) {
						help += "1 ";
					} else {
						help += "1";
					}
				} else {
					if(j < saida.length) {
						help += "0 ";
					} else {
						help += "0";
					}
				}
			}
			
			saida[i] = help;
			help = "";
		}
		
		return saida;
	}


	public String alRepresentation() {
		String saida = "";
		
		sortVertices();
		
		for(Vertex vertex: verteces) {
			saida += vertex.getId() + " - ";
			for(Edge edge: vertex.getEdges()) {
				saida += edge.getEdge().getId() + " ";
			}
			saida += LS;
		}
		
		return saida;
	}
	
	public float getMeanEdge() {
		return (2*idForEdges)/verteces.size();
	}
	
	private void sortVertices() {
		for(Vertex vertex: verteces) {
			vertex.getEdges().sort(null);
		}
		
	}

}
