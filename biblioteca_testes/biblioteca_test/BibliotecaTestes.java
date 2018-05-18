package biblioteca_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import biblioteca.BibliotecaController;
import grafo.Graph;


class BibliotecaTestes {
	
	public BibliotecaController biblioteca;
	
	/*@Before
	public void setup() throws IOException {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		biblioteca.readWeightGraph("grafo2.txt");
		
	}
	*/
	

	@Test
	public void testReadGraph() throws IOException {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo3.txt");
		Graph graph = biblioteca.getGraph(1);
		assertEquals(8, graph.getVertexNumber());
		assertEquals(7, graph.getEdgeNumber());
	}

	@Test
	public void testReadWeightGraph() throws IOException {
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
	public void testBFS() throws IOException {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		
		System.out.println("BFS no grafo1.txt, comecando no nivel 1");
		System.out.println(biblioteca.BFS(1, 1));
	}

	@Test
	void testDFS() throws IOException {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo1.txt");
		
		System.out.println("DFS no grafo1.txt, comecando no nivel 1");
		System.out.println(biblioteca.BFS(1, 1));
	}

	/*@Test
	void testConnected() {
		fail("Not yet implemented");
	} */

	@Test
	void testShortestPath() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readWeightGraph("grafo2.txt");
		
		System.out.println("Menor caminho no grafo2.txt entre os vertices 1 e 5");
		System.out.println(biblioteca.shortestPath(1, 1, 5));
	}

	@Test
	void testMST() throws IOException {
		biblioteca = new BibliotecaController();
		biblioteca.readWeightGraph("grafo2.txt");
		
		System.out.println("MST do grafo2.txt");
		biblioteca.MST(1);
	}

	
	
}
