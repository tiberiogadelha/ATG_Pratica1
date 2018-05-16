

import java.util.LinkedList;

import Dijkstra.Dijkstra;
import biblioteca.BibliotecaController;
import grafo.Graph;
import grafo.Vertex;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BibliotecaController bb = new BibliotecaController();
		bb.readGraph("grafo1.txt");
		bb.getGraphs();
		
		
		bb.readWeightGraph("grafo2.txt");
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
