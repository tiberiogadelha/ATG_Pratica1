package factory;

import grafo.Graph;
import grafo.WeightedGraph;

public class GraphFactory {

	private int id;
	
	public GraphFactory() {
		id = 1;
	}

	/**
	 * Cria um novo grafo, recebendo como parametro o numero de vertices.
	 * @param numero de vertices
	 * @return Retorna o objeto Graph 
	 */
	public Graph newGraph(int numberOfVertex) {
		Graph graph = new Graph(id);
		
		for(int i = 1; i <= numberOfVertex; i++) {
			graph.addVertix(i);
		}
		
		id++;
		
		return graph;
	}
	
	public WeightedGraph newWeightedGraph(int numberOfVertex) {
		WeightedGraph graph = new WeightedGraph(id);
		
		for(int i = 1; i <= numberOfVertex; i++) {
			graph.addVertix(i);
		}
		
		id++;
		
		return graph;
	}
}
