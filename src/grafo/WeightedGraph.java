package grafo;

public class WeightedGraph extends Graph {

	public WeightedGraph(int id) {
		super(id);
		
	}
	
	public void addEdge(float weight, int vertex1Id, int vertex2Id) {
		Vertex vertex1 = getVertex(vertex1Id);
		Vertex vertex2 = getVertex(vertex2Id);
		
		vertex1.addWeightEdge(idForEdges, vertex2, weight);
		vertex2.addWeightEdge(idForEdges, vertex1, weight);
		
		edges.add(vertex1.getEdge(vertex2Id));
		
		idForEdges++;
	}
	
	@Override
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
	 * Se n�o, 0 eh colocado no aux.
	 * @return Um array de String que representa como os vertices estao conectados entre si.
	 */
	@Override
	protected String[] checkConnectionBetweenVertices() {
		String[] saida = new String[vertices.size()];
		
		String aux = "";
		WeightedEdge edge;
		
		for(int i = 0; i < saida.length; i++) {
			Vertex vertex = vertices.get(i);
			
			for(int j = 1; j <= saida.length; j++) {
				
				if(vertex.hasEdge(j)) {
					edge = (WeightedEdge) vertex.getEdge(j);
					if(j < saida.length) {
						aux += edge.getWeight() + " ";
					} else {
						aux += edge.getWeight();
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
	@Override
	public String alRepresentation() {
		String saida = "";
		
		sortVertices();
		
		for(Vertex vertex: vertices) {
			saida += vertex.getId() + " - ";
			for(Edge edge: vertex.getEdges()) {
				saida += edge.getConnectedTo().getId() +"(" + ((WeightedEdge) edge).getWeight() + ")" + " ";
			}
			saida += LS;
		}
		
		return saida;
	}
	
}
