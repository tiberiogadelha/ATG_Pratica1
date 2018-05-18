package biblioteca;


import grafo.Graph;

public class BibliotecaFacade {
	
	private BibliotecaController biblioteca;
	
	public BibliotecaFacade() {
		biblioteca = new BibliotecaController();
	}
	
	public void readGraph(String path) throws Exception {
		biblioteca.readGraph(path);
	}
	
	public void readWeightGraph(String path) throws Exception {
		biblioteca.readWeightGraph(path);
	}
	
	public int getVertexNumber(int graphID) throws Exception {
		return biblioteca.getVertexNumber(graphID);
	}
	
	public int getEdgeNumber(int graphID) throws Exception {
		return biblioteca.getEdgeNumber(graphID);
	}
	
	public float getMeanEdge(int graphID) throws Exception {
		return biblioteca.getMeanEdge(graphID);
	}
	
	public String graphRepresentation(int graphID, String type) throws Exception {
		return biblioteca.graphRepresentation(graphID, type);
	}
	
	public String BFS(int graphID, int vertID) {
		return biblioteca.BFS(graphID, vertID);
	}
	
	public void DFS(int graphID, int vertexID) {
		biblioteca.DFS(graphID, vertexID);
	}
	
	public boolean connected(int graphID) throws Exception {
		return biblioteca.connected(graphID);
	}
	
	public String shortestPath(int graphID, int vertex1ID, int vertex2ID) throws Exception {
		return biblioteca.shortestPath(graphID, vertex1ID, vertex2ID);
	}
	
	public void MST(int graphID) throws Exception {
		biblioteca.MST(graphID);
	}
	
	public Graph getGraph(int graphID) {
		return biblioteca.getGraph(graphID);
	}

	public String getAllGraphs() {
		return biblioteca.getGraphs().toString();
	}

}
