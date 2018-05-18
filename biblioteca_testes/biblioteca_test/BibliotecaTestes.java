package biblioteca_test;

import static org.junit.Assert.*;

import org.junit.Test;

import biblioteca.BibliotecaController;
import grafo.Graph;


public class BibliotecaTestes {
	
	public BibliotecaController biblioteca;
	
	@Test
	public void testReadGraph() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo3.txt");
		Graph graph = biblioteca.getGraph(1);
		assertEquals(8, graph.getVertexNumber());
		assertEquals(7, graph.getEdgeNumber());
	}

	@Test
	public void testReadWeightGraph() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readWeightGraph("grafo4.txt");
		Graph graph = biblioteca.getGraph(1);
		assertEquals(6, graph.getVertexNumber());
		assertEquals(8, graph.getEdgeNumber());
	}

	

	@Test
	public void testGetMeanEdge() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		biblioteca.readGraph("grafo3.txt");
		
		assertEquals(1.75, biblioteca.getMeanEdge(2), 0.00001); // grau medio do grafo3.txt
		assertEquals(2.0, biblioteca.getMeanEdge(1), 0.00001); // Grau medio do grafo1.txt
	}

	@Test
	public void testGraphRepresentation() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		biblioteca.readWeightGraph("grafo2.txt");
		
		System.out.println("AM e AL representacao, respectivamente, do grafo1.txt");
		System.out.println(biblioteca.graphRepresentation(1, "AM"));
		System.out.println(biblioteca.graphRepresentation(1, "AL"));
		
		System.out.println("AM e AL representacao, respectivamente, do grafo2.txt");
		System.out.println(biblioteca.graphRepresentation(2, "AM"));
		System.out.println(biblioteca.graphRepresentation(2, "AL"));
	}

	
	@Test
	public void testBFS() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		
		System.out.println("BFS no grafo1.txt, comecando no nivel 0");
		System.out.println(biblioteca.BFS(1, 1));
	}

	@Test
	public void testDFS() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		
		System.out.println("DFS no grafo1.txt, comecando no nivel 0");
		System.out.println(biblioteca.BFS(1, 1));
	}

	@Test
	public void testConnected() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		assertTrue(biblioteca.connected(1));

	} 

	@Test
	public void testShortestPath() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readWeightGraph("grafo2.txt");
		
		System.out.println("Menor caminho no grafo2.txt entre os vertices 1 e 5");
		System.out.println(biblioteca.shortestPath(1, 1, 5));
	}

	@Test
	public void testMST() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readWeightGraph("grafo2.txt");
		
		System.out.println("MST do grafo2.txt");
		biblioteca.MST(1);
	}

	
	
}
