package biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import arquivo.ArquivoController;
import factory.GraphFactory;
import grafo.Edge;
import grafo.Graph;
import grafo.Vertex;
import grafo.WeightedGraph;


public class BibliotecaController {
	
	private ArquivoController arq = new ArquivoController();
	private ArrayList<Graph> graphs; 
	private GraphFactory factory = new GraphFactory();
	
	public BibliotecaController() {
		graphs = new ArrayList<>();
	}
	
	/**
	 * Le as informacoes necessarias, atraves de um arquivo, para criar um grafo.
	 * Apos a leitura, o metodo passa os dados para o metodo createGraph(graph)
	 * @param path do arquivo
	 * @throws IOException
	 */
	public void readGraph(String path) throws IOException {
		ArrayList<String> newGraph = arq.readFile(path);
		
		createGraph(newGraph);
		
		
	}
	
	/**
	 * Cria um novo grafo, atraves das infomacoes lidas no metodo readWeightGraph(path)
	 *  e o adiciona a biblioteca
	 * @param As informacoes para criar o grafo
	 */
	private void createGraph(ArrayList<String> newGraph) {
		Graph graph = null;
		boolean graphWasCreated = false;
		
		for(String data: newGraph) {
			
			if(graphWasCreated == false) {
				graph = factory.newGraph(Integer.parseInt(data));
				graphWasCreated = true;
				
			} else {
				int vertex1Id = Integer.parseInt(String.valueOf(data.charAt(0)));
				int vertex2Id = Integer.parseInt(String.valueOf(data.charAt(2)));
				graph.addEdge(vertex1Id, vertex2Id);
				
			}
		}
		
		graphs.add(graph);
		
	}
	
	/**
	 * Le as informacoes necessarias, atraves de um arquivo, para criar um grafo.
	 * Apos a leitura, o metodo passa os dados para o metodo createWeightGraph(graph)
	 * @param path do arquivo
	 * @throws IOException
	 */
	public void readWeightGraph(String path) throws IOException {
		
		ArrayList<String> newGraph = arq.readFile(path);
		
		createWeightGraph(newGraph);
		
	}
	
	
	/**
	 * Cria um novo grafo, atraves das infomacoes lidas no metodo readWeightGraph(path)
	 *  e o adiciona a biblioteca
	 * @param As informacoes para criar o grafo
	 */
	private void createWeightGraph(ArrayList<String> newGraph) {
		
		WeightedGraph graph = null;
		boolean graphWasCreated = false;
		
		for(String data: newGraph) {
			
			if(graphWasCreated == false) {
				graph = factory.newWeightedGraph(Integer.parseInt(data));
				graphWasCreated = true;
				
			} else {
				
				
				int vertex1Id = Integer.parseInt(String.valueOf(data.charAt(0)));
				int vertex2Id = Integer.parseInt(String.valueOf(data.charAt(2)));
				float weight = Float.parseFloat(String.valueOf(data.substring(3)));
				graph.addEdge(weight, vertex1Id, vertex2Id);
				
			}
		}
		
		graphs.add(graph);
		
	}
	
	/**
	 * O metodo informa o numero de vertices que o grafo possui.
	 * @param ID do grafo
	 * @return O numero de vertices
	 * @throws Exception
	 */
	public int getVertexNumber(int graphId) throws Exception {
		Graph graph = getGraph(graphId);
		
		if(graph != null) {
			return graph.getVertexNumber();
		}
		
		throw new Exception("There's no graph with this ID");
	}
	
	/**
	 * O metodo informa o numero de arestas que o grafo possui.
	 * @param O ID do grafo
	 * @return O numero de arestas
	 * @throws Exception
	 */
	public int getEdgeNumber(int graphId) throws Exception {
		Graph graph = getGraph(graphId);
		
		if(graph != null) {
			return graph.getEdgeNumber();
		}
		
		throw new Exception("There's no graph with this ID");
	}
	
	
	/**
	 * Cria uma representacao para o grafo, de acordo com o tipo desejado.
	 * @param O ID do grafo
	 * @param O Tipo de representacao desejado
	 * @return A representacao do grafo atraves de String
	 * @throws Exception
	 */
	public String graphRepresentation(int graphId, String type) throws Exception {
		Graph graph = getGraph(graphId);
		
		if(graph != null) {
			if(type.equalsIgnoreCase("AM")) {
				return graph.amRepresentation();
			} else {
				return graph.alRepresentation();
			}
		}
		
		throw new Exception("There's no graph with this ID");
	}
	
	/**
	 * Procura no sistema o grafo que possui o ID passado por parametro.
	 * @param ID do grafo
	 * @return O Grafo desejado
	 */
	// aqui alterado para teste
	public Graph getGraph(int id) {
		Graph foundGraph = null;
		
		for(Graph graph: graphs) {
			if(graph.getId() == id) {
				return graph;
			}
		}
		
		return foundGraph;
	}
	
	/**
	 * O metodo calcula o grau medio de um grafo
	 * recebendo como parametro o ID do grafo desejado.
	 * @param ID do grafo
	 * @return O grau medio do grafo
	 * @throws Exception
	 */
	
	public double getMeanEdge(int graphID) throws Exception {
		Graph foundGraph = getGraph(graphID);
		
		if(foundGraph != null) {
			return foundGraph.getMeanEdge();
		}
		
		throw new Exception("There's no graph with this ID");
	}
	
	public ArrayList<Graph> getGraphs() {
		return this.graphs;
	}
	
	public void BFS(int graphID, int vert) {
		Graph graph = getGraph(graphID);
		Vertex vertex = graph.getVertex(vert);
		boolean visited[] = new boolean[graph.getVertexNumber()+1];
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		visited[vert] = true;
		queue.add(vertex);
		int level = 0;
		System.out.println(vertex.getId() + " - "+ level);
		while(queue.size() != 0) {
			Vertex newVert = queue.poll();
			if(queue.isEmpty())
				level++;
			ArrayList<Edge> vertexAdj = newVert.getEdges();		
			for(int i=0; i<vertexAdj.size(); i++) {
				Edge n = vertexAdj.get(i);
				if(!visited[n.getConnectedTo().getId()]) {
					visited[n.getConnectedTo().getId()] = true;
					queue.add(n.getConnectedTo());
					System.out.println(n.getConnectedTo().getId() + " " + n.getFatherID() + " " + level);
				}
			}
		}
	}
	
	private void DFSUtil(Vertex vertex, boolean[] visited, int newLevel) {
		visited[vertex.getId()] = true;
		ArrayList<Edge> vertexAdj = vertex.getEdges();
		for(int i=0; i<vertexAdj.size(); i++) {
			Edge n = vertexAdj.get(i);
			if(!visited[n.getConnectedTo().getId()]) {
				System.out.println(n.getConnectedTo().getId() + " " + n.getFatherID() + " " + newLevel);
				DFSUtil(n.getConnectedTo(), visited, newLevel+1);
			}
		}
	}
	
	public void DFS(int graphID, int vert) {
		Graph graph = getGraph(graphID);
		Vertex vertex = graph.getVertex(vert);
		boolean visited[] = new boolean[graph.getVertexNumber()+1];
		visited[0] = true;
		System.out.println(vertex.getId()+" - "+"0");
		DFSUtil(vertex, visited, 1);

	}
}
