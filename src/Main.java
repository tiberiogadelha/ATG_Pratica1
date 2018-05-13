

import java.util.LinkedList;
import java.util.List;

import Dijkstra.Dijkstra;
import biblioteca.BibliotecaController;
import grafo.Graph;
import grafo.Vertex;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BibliotecaController bb = new BibliotecaController();
		bb.readGraph("grafo1.txt");
		bb.getGraphs();
		System.out.println(bb.graphRepresentation(1, "AM"));
		System.out.println(bb.graphRepresentation(1, "AL"));
		System.out.println(bb.getMeanEdge(1));
		bb.readWeightGraph("grafo2.txt");
		System.out.println(bb.graphRepresentation(2, "AM"));
		bb.BFS(1, 1);
		bb.DFS(1, 1);
		Graph graph = bb.getGraph(1);
		Dijkstra dij = new Dijkstra(graph);
		Vertex ver = graph.getVertex(3);
		Vertex ver2 = graph.getVertex(4);
		dij.execute(ver);
		LinkedList<Vertex> path = dij.getPath(ver2);
		System.out.println(path.size()-1);
	
	}
}
