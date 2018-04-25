package biblioteca;

import java.io.IOException;
import java.util.ArrayList;

import arquivo.ArquivoController;
import factory.GraphFactory;
import grafo.Graph;


public class BibliotecaController {
	
	private ArquivoController arq = new ArquivoController();
	private ArrayList<Graph> graphs; 
	private GraphFactory factory = new GraphFactory();
	
	public BibliotecaController() {
		graphs = new ArrayList<>();
	}
	
	public void readGraph(String path) throws IOException {
		ArrayList<String> newGraph = arq.readFile(path);
		
		createGraph(newGraph);
		
		
	}
	
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
	
	public int getVertexNumber(int graphId) throws Exception {
		Graph graph = getGraph(graphId);
		
		if(graph != null) {
			return graph.getVertexNumber();
		}
		
		throw new Exception("There's no graph with this ID");
	}
	
	public int getEdgeNumber(int graphId) throws Exception {
		Graph graph = getGraph(graphId);
		
		if(graph != null) {
			return graph.getEdgeNumber();
		}
		
		throw new Exception("There's no graph with this ID");
	}
	
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
	
	private Graph getGraph(int id) {
		Graph foundGraph = null;
		
		for(Graph graph: graphs) {
			if(graph.getId() == id) {
				return graph;
			}
		}
		
		return foundGraph;
	}
	
	public ArrayList<Graph> getGraphs() {
		return this.graphs;
	}
	

}
