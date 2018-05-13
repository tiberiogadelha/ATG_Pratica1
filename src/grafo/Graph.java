package grafo;

import java.util.ArrayList;

public class Graph {
	
	private final String LS = System.lineSeparator();
	
	private int idForEdges = 1;
	private int id;
	private ArrayList<Vertex> vertices;
	
	
	public Graph(int id) {
		this.setId(id);
		this.vertices = new ArrayList<>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Vertex> getAllVertix() {
		return vertices;
	}


	public void setVertex(ArrayList<Vertex> vertix) {
		this.vertices = vertix;
	}

	
	/**
	 * O metodo adiciona um novo vertice ao grafo
	 *  recebendo como parametro a sua identificacao
	 * @param o ID do novo vertice
	 */
	public void addVertix(int id) {
		Vertex newVertex = new Vertex(id);
		this.vertices.add(newVertex);
	}
	

	/**
	 * O metodo adiciona uma nova aresta entre dois vertices
	 * @param ID do vertice 1
	 * @param ID do vertice 2
	 */
	public void addEdge(int vertex1Id, int vertex2Id) {
		Vertex vertex1 = getVertex(vertex1Id);
		Vertex vertex2 = getVertex(vertex2Id);
		
		vertex1.addEdge(idForEdges, vertex2);
		vertex2.addEdge(idForEdges, vertex1);
		
		idForEdges++;
		
	}
	
	/**
	 * O metodo adiciona uma nova aresta, com peso, entre dois vertices
	 * @param O peso da aresta
	 * @param ID do vertice 1
	 * @param ID do vertice 2
	 */
	public void addWeightEdge(float weight, int vertex1Id, int vertex2Id) {
		Vertex vertex1 = getVertex(vertex1Id);
		Vertex vertex2 = getVertex(vertex2Id);
		
		vertex1.addWeightEdge(idForEdges, vertex2, weight);
		vertex2.addWeightEdge(idForEdges, vertex1, weight);
		
		idForEdges++;
	}
	
	/**
	 * O metodo procura no grafo o vertice que possui a id do parametro
	 * @param ID do vertice procurado
	 * @return O vertice que possui o ID passado por parametro
	 */
	public Vertex getVertex(int id) {
		Vertex foundVertex = null;
		
		for(Vertex vertex: vertices) {
			if(vertex.getId() == id) {
				return vertex;
			}
		}
		
		return foundVertex;
	}
	
	/**
	 * O metodo retorna o numero de vertices do grafo.
	 * @return O numero de vertices
	 */
	public int getVertexNumber() {
		return this.vertices.size();
	}
	
	@Override
	public String toString() {
		String saida = "Graph's ID: " + id + " | Verteces: " + vertices.toString() + " ";
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
	
	

	/**
	 * O metodo retorna o numero de arestas do grafo.
	 * @return O numero de arestas.
	 */
	public int getEdgeNumber() {
		
		return idForEdges - 1;
	}

	/**
	 * O metodo cria a representacao "AM" do grafo
	 * @return A string que representa o grafo.
	 */
	public String amRepresentation() {
		String saida = "  ";
		
		for(int i = 0; i < vertices.size(); i++) {
			if(i < vertices.size()) {
				saida += (i+1) + " ";
			} else {
				saida += i+1;
			}
		}
		
		saida += LS;
		String[] frequency = checkConnectionBetweenVertices();
		
		for(int i = 0; i < vertices.size(); i++) {
			saida += (i+1) + " " + frequency[i] + LS;
			
		}
		
		
		
		return saida;
	}
	
	/**
	 * O metodo como o vertice esta conectado com os demais vertices do grafo.
	 * Se determinado vertice X tiver conexao com o vertice Y, 1 eh colocado no aux.
	 * Se não, 0 eh colocado no aux.
	 * @return Um array de String que representa como os vertices estao conectados entre si.
	 */
	private String[] checkConnectionBetweenVertices() {
		String[] saida = new String[vertices.size()];
		
		String aux = "";
		
		for(int i = 0; i < saida.length; i++) {
			Vertex vertex = vertices.get(i);
			
			for(int j = 1; j <= saida.length; j++) {
				
				if(vertex.hasEdge(j)) {
					if(j < saida.length) {
						aux += "1 ";
					} else {
						aux += "1";
					}
				} else {
					if(j < saida.length) {
						aux += "0 ";
					} else {
						aux += "0";
					}
				}
			}
			
			saida[i] = aux;
			aux = "";
		}
		
		return saida;
	}

	/**
	 * O metodo cria a representacao do tipo AL do grafo
	 * @return Retorna uma String que representa o grafo.
	 */
	public String alRepresentation() {
		String saida = "";
		
		sortVertices();
		
		for(Vertex vertex: vertices) {
			saida += vertex.getId() + " - ";
			for(Edge edge: vertex.getEdges()) {
				saida += edge.getEdge().getId() + " ";
			}
			saida += LS;
		}
		
		return saida;
	}
	
	/**
	 * O metodo calcula o grau medio do grafo.
	 * @return O grau medio do grafo.
	 */
	public float getMeanEdge() {
		return (2*idForEdges)/vertices.size();
	}
	
	/**
	 * O metodo ordena as arestas de cada vertice, por ID.
	 */
	private void sortVertices() {
		for(Vertex vertex: vertices) {
			vertex.getEdges().sort(null);
		}
		
	}

}
