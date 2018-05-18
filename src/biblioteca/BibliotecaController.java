package biblioteca;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import Dijkstra.Dijkstra;
import arquivo.ArquivoController;
import factory.GraphFactory;
import grafo.Edge;
import grafo.Graph;
import grafo.Vertex;
import grafo.WeightedEdge;
import grafo.WeightedGraph;
import kruskal.DisjoinSet;
import util.BFSandDFSUtil;

public class BibliotecaController {

	private final String LS = System.lineSeparator();
	private ArquivoController arq = new ArquivoController();
	private ArrayList<Graph> graphs;
	private GraphFactory factory = new GraphFactory();

	public BibliotecaController() {
		graphs = new ArrayList<>();
	}

	/**
	 * Le as informacoes necessarias, atraves de um arquivo, para criar um
	 * grafo. Apos a leitura, o metodo passa os dados para o metodo
	 * createGraph(graph)
	 * 
	 * @param path
	 *            do arquivo
	 * @throws Exception 
	 */
	public void readGraph(String path) throws Exception {
		ArrayList<String> newGraph = arq.readFile(path);

		createGraph(newGraph);

	}

	/**
	 * Cria um novo grafo, atraves das infomacoes lidas no metodo
	 * readGraph(path) e o adiciona a biblioteca
	 * 
	 * @param As informacoes para criar o grafo
	 * @throws Exception 
	 */
	private void createGraph(ArrayList<String> newGraph) throws Exception {
		int vertexNumber = Integer.parseInt(newGraph.get(0));
		Graph graph = factory.newGraph(vertexNumber);
		
		for(int i = 1; i < newGraph.size(); i++) {
			String edge = newGraph.get(i);
			String[] vertex = edge.split(" ");
			if(vertex.length == 2) {
				int vertex1Id = Integer.parseInt(String.valueOf(vertex[0]));
				int vertex2Id = Integer.parseInt(String.valueOf(vertex[1]));
			
				graph.addEdge(vertex1Id, vertex2Id);
				
			} else {
				throw new Exception("Try another graph! A graph's edge has to be between 2 vertices");
			}
		}
		

		graphs.add(graph);

	}

	/**
	 * Le as informacoes necessarias, atraves de um arquivo, para criar um
	 * grafo. Apos a leitura, o metodo passa os dados para o metodo
	 * createWeightGraph(graph)
	 * 
	 * @param path
	 *            do arquivo
	 * @throws Exception 
	 */
	public void readWeightGraph(String path) throws Exception {

		ArrayList<String> newGraph = arq.readFile(path);

		createWeightGraph(newGraph);

	}

	/**
	 * Cria um novo grafo, atraves das infomacoes lidas no metodo
	 * readWeightGraph(path) e o adiciona a biblioteca
	 * 
	 * @param As informacoes para criar o grafo
	 * @throws Exception 
	 */
	private void createWeightGraph(ArrayList<String> newGraph) throws Exception {

		int vertexNumber = Integer.parseInt(newGraph.get(0));
		WeightedGraph graph = factory.newWeightedGraph(vertexNumber);
		
		for(int i = 1; i < newGraph.size(); i++) {
			
			String edge = newGraph.get(i);
			String[] vertex = edge.split(" ");
			
			if(vertex.length == 3) {
				int vertex1Id = Integer.parseInt(String.valueOf(vertex[0]));
				int vertex2Id = Integer.parseInt(String.valueOf(vertex[1]));
				float weight = Float.parseFloat(String.valueOf(vertex[2]));
			
				graph.addEdge(weight, vertex1Id, vertex2Id);
			} else {
				throw new Exception("Try another graph! A weighted graph's edge has to be between 2 vertices and a weight");
			}
		}
		

		graphs.add(graph);



	}

	/**
	 * O metodo informa o numero de vertices que o grafo possui.
	 * 
	 * @param ID
	 *            do grafo
	 * @return O numero de vertices
	 * @throws Exception
	 */
	public int getVertexNumber(int graphId) throws Exception {
		Graph graph = getGraph(graphId);

		if (graph != null) {
			return graph.getVertexNumber();
		}

		throw new Exception("There's no graph with this ID");
	}

	/**
	 * O metodo informa o numero de arestas que o grafo possui.
	 * 
	 * @param O
	 *            ID do grafo
	 * @return O numero de arestas
	 * @throws Exception
	 */
	public int getEdgeNumber(int graphId) throws Exception {
		Graph graph = getGraph(graphId);

		if (graph != null) {
			return graph.getEdgeNumber();
		}

		throw new Exception("There's no graph with this ID");
	}

	/**
	 * Cria uma representacao para o grafo, de acordo com o tipo desejado.
	 * 
	 * @param O
	 *            ID do grafo
	 * @param O
	 *            Tipo de representacao desejado
	 * @return A representacao do grafo atraves de String
	 * @throws Exception
	 */
	public String graphRepresentation(int graphId, String type) throws Exception {
		Graph graph = getGraph(graphId);

		if (graph != null) {
			if (type.equalsIgnoreCase("AM")) {
				return graph.amRepresentation();
				
			} else {
				return graph.alRepresentation();
			}
		}

		throw new Exception("There's no graph with this ID");
	}

	/**
	 * Procura no sistema o grafo que possui o ID passado por parametro.
	 * 
	 * @param ID
	 *            do grafo
	 * @return O Grafo desejado
	 */
	public Graph getGraph(int id) {
		Graph foundGraph = null;

		for (Graph graph : graphs) {
			if (graph.getId() == id) {
				return graph;
			}
		}

		return foundGraph;
	}

	/**
	 * O metodo calcula o grau medio de um grafo recebendo como parametro o ID
	 * do grafo desejado.
	 * 
	 * @param ID
	 *            do grafo
	 * @return O grau medio do grafo
	 * @throws Exception
	 */

	public Float getMeanEdge(int graphID) throws Exception {
		Graph foundGraph = getGraph(graphID);

		if (foundGraph != null) {
			return foundGraph.getMeanEdge();
		}

		throw new Exception("There's no graph with this ID");
	}

	public ArrayList<Graph> getGraphs() {
		return this.graphs;
	}
	
	/**
	 * Realiza e imprime o resultado de uma BFS num determinando grafo, a partir de um certo vertice
	 * @param graphID O ID do grafo
	 * @param vert O vertice pelo qual a BFS vai comecar.
	 */
	public String BFS(int graphID, int vert) {
		String bfs = "";
		
		Graph graph = getGraph(graphID);
		Vertex vertex = graph.getVertex(vert);
		boolean visited[] = new boolean[graph.getVertexNumber() + 1];
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		visited[vert] = true;
		queue.add(vertex);
		int level = 0;
		List<BFSandDFSUtil> orderVertex = new ArrayList<BFSandDFSUtil>();
				
		bfs += vertex.getId() + " " + level + " -" + LS;	
		while (queue.size() != 0) {
			Vertex newVert = queue.poll();
			
			if (queue.isEmpty()) {
				level++;
			}
			ArrayList<Edge> vertexAdj = newVert.getEdges();
			
			for (int i = 0; i < vertexAdj.size(); i++) {
				Edge n = vertexAdj.get(i);
				
				if (!visited[n.getConnectedTo().getId()]) {
					visited[n.getConnectedTo().getId()] = true;
					orderVertex.add(new BFSandDFSUtil(n.getConnectedTo().getId(), level, n.getFatherID()));
					queue.add(n.getConnectedTo());
				}
			}
		}
		Collections.sort(orderVertex);
		for(int i=0; i<orderVertex.size(); i++) {
			BFSandDFSUtil aux = orderVertex.get(i);
			bfs+=aux.getId() + " " + aux.getLevel() + " " + aux.getFatherID() + LS;
		}
		
		return bfs;
	}
	
	/**
	 * Metodo auxiliar da funcao DFS.
	 * @param vertex O vertice
	 * @param visited Um array de vertices visitados
	 * @param newLevel O nivel
	 */
	private void DFSUtil(Vertex vertex, boolean[] visited, int newLevel, List<BFSandDFSUtil> orderVertex) {
		visited[vertex.getId()] = true;
		ArrayList<Edge> vertexAdj = vertex.getEdges();

		for (int i = 0; i < vertexAdj.size(); i++) {
			Edge n = vertexAdj.get(i);
			
			if (!visited[n.getConnectedTo().getId()]) {
				orderVertex.add(new BFSandDFSUtil(n.getConnectedTo().getId(), newLevel, n.getFatherID()));
				DFSUtil(n.getConnectedTo(), visited, newLevel + 1, orderVertex);
			}
		}
	}
	
	/**
	 * Realiza e imprime o resultado de uma DFS num grafo, a partir de um certo vertice
	 * @param graphID O id do grafo
	 * @param vert O vertice pela qual a DFS vai comecar
	 */
	public String DFS(int graphID, int vert) {
		Graph graph = getGraph(graphID);
		Vertex vertex = graph.getVertex(vert);
		boolean visited[] = new boolean[graph.getVertexNumber() + 1];
		visited[0] = true;
		String dfs = "";
		List<BFSandDFSUtil> orderVertex = new ArrayList<BFSandDFSUtil>();

		System.out.println(vertex.getId() + " 0 "+ "-");
		
		DFSUtil(vertex, visited, 1, orderVertex);
		Collections.sort(orderVertex);
		
		for(int i=0; i<orderVertex.size(); i++) {
			BFSandDFSUtil aux = orderVertex.get(i);
			dfs += aux.getId() + " " + aux.getLevel() + " " + aux.getFatherID() + LS;
		}
		
		return dfs;

	}

	/**
	 * O metodo diz se o grafo eh conexo recebendo como parametro o ID do grafo
	 * desejado.
	 * 
	 * @param ID
	 *            do grafo
	 * @return Boolean dizendo se o grafo eh conexo
	 * @throws Exception
	 */

	public boolean connected(int graphID) throws Exception {
		Graph graph = getGraph(graphID);
		boolean isConnected = true;
		boolean[] allVertex = new boolean[graph.getVertexNumber()+1];
		allVertex[0] = true;
		connectedUtil(graph.getAllVertix().get(0), allVertex);
		
		for(int i=0; i<graph.getVertexNumber()+1; i++) {
			if(!allVertex[i]) {
				isConnected = false;
			}
		}
		
		return isConnected;
	}
	
	/**
	 * Metodo auxiliar da BFS
	 * @param vertex O Vertice
	 * @param visited O array de vertices visitados
	 */
	private void connectedUtil(Vertex vertex, boolean[] visited) {
		visited[vertex.getId()] = true;
		ArrayList<Edge> vertexAdj = vertex.getEdges();
		
		for (int i = 0; i < vertexAdj.size(); i++) {
			Edge n = vertexAdj.get(i);
			
			if (!visited[n.getConnectedTo().getId()]) {
				connectedUtil(n.getConnectedTo(), visited);
			}
		}
	}
	
	/**
	 * O metodo gera e imprime a MST de um grafo
	 * @param graphID O id do grafo
	 * @throws Exception 
	 */
	public void MST(int graphID) throws Exception {
		Graph graph = getGraph(graphID);
		
		if(graph instanceof WeightedGraph) {
			ArrayList<WeightedEdge> weightEdges = new ArrayList<WeightedEdge>();
			WeightedEdge[] wes = new WeightedEdge[graph.getVertexNumber()+1];
			int j = 0;
		
			for(Edge edge : graph.getEdges()) {
				WeightedEdge we = (WeightedEdge) edge;
				weightEdges.add(we);
				wes[j] = we;
				j++;
			}
		
		
			int count = graph.getVertexNumber();
			Arrays.sort(wes, new Comparator<WeightedEdge>() {
				public int compare(WeightedEdge a1, WeightedEdge a2) {
				
					if(a1.compareTo(a2) > 0) {
						return 1;
					
					}else if(a1.compareTo(a2) == 0) {
						return 0;
					
					}else {
						return -1;
					}
				}
			
			});
		
			ArrayList<WeightedEdge> mstEdges = new ArrayList<WeightedEdge>();
			DisjoinSet vertexSet = new DisjoinSet(count+1);
		
			for(int i=0; i < graph.getVertexNumber() && mstEdges.size() < (count-1); i++) {
				WeightedEdge currentEdge = wes[i];
				int root1 = vertexSet.find(currentEdge.getFatherID());
				int root2 = vertexSet.find(currentEdge.getConnectedTo().getId());
			
				if(root1 != root2) {
					mstEdges.add(currentEdge);
					vertexSet.union(root1, root2);
					System.out.println(currentEdge.getFatherID() + " " +currentEdge.getConnectedTo().getId());;
				}
			}
		} else {
			throw new Exception("Try a weighted graph to get MST");
		}
	}
	
	/**
	 * Calcula e imprime o menor caminho entre 2 vertices de um grafo.
	 * @param graphID O id do grafo
	 * @param vertex1ID ID do primeiro vertice
	 * @param vertex2ID ID do segundo vertice
	 * @throws Exception 
	 */
	public String shortestPath(int graphID, int vertex1ID, int vertex2ID) throws Exception {
		String shortestPath = "";
		Graph graph = getGraph(graphID);
		
		if(graph instanceof WeightedGraph) {
			Dijkstra dij = new Dijkstra(graph);
			Vertex ver = graph.getVertex(vertex1ID);
			Vertex ver2 = graph.getVertex(vertex2ID);
			dij.execute(ver);
			LinkedList<Vertex> path = dij.getPath(ver2);
				
			for(int i=0;i<path.size();i++) {
				if(i+1<path.size()) {
					shortestPath += path.get(i).getId()+" ";
				}else {
					shortestPath += path.get(i).getId();
				}
			}
		
			return shortestPath;
		} else {
			throw new Exception("Try a weighted graph to get the shortest path");
		}
		
			
	}
}
