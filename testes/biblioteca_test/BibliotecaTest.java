package biblioteca_test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import biblioteca.BibliotecaController;
import grafo.Graph;
import grafo.WeightedGraph;

class BibliotecaTest {
	
	public BibliotecaController biblioteca;
	
	@Before
	void setUp() {
		 biblioteca = new BibliotecaController();
	}
	
	@Test
	void testReadGraph() throws IOException {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo3.txt"); // Le um grafo com 8 vertices e 7 Arestas
		Graph graph = biblioteca.getGraph(1);
		assertEquals(8, graph.getVertexNumber());
		assertEquals(7, graph.getEdgeNumber());
	}
	
	@Test
	void testReadWeightGraph() throws IOException {
		biblioteca = new BibliotecaController();
		biblioteca.readWeightGraph("grafo4.txt");
		Graph graph = biblioteca.getGraph(1);
		assertEquals(6, graph.getVertexNumber());
		assertEquals(8, graph.getEdgeNumber());
		
		assertTrue(graph.getClass() == WeightedGraph.class);
		
	}
	
	@Test
	void testMeanEdge() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readGraph("grafo3.txt");
		biblioteca.readGraph("grafo1.txt");
		
		assertEquals(1.75, biblioteca.getMeanEdge(1), 0.00001); // grau medio do grafo3.txt
		assertEquals(2.0, biblioteca.getMeanEdge(2), 0.00001); // Grau medio do grafo1.txt
		
	}
	
	@Test
	void testGraphRepresentation() throws Exception {
		biblioteca = new BibliotecaController();
		biblioteca.readWeightGraph("grafo2.txt"); // Weighted Graph
		biblioteca.readGraph("grafo1.txt"); 
		
		System.out.println(biblioteca.graphRepresentation(1, "AM"));
		System.out.println(biblioteca.graphRepresentation(1, "AL"));
		
		System.out.println(biblioteca.graphRepresentation(2, "AM"));
		System.out.println(biblioteca.graphRepresentation(2, "AL"));
	}
	
	
	/*
	@Test
	void testGetVertexNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEdgeNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testGraphRepresentation() {
		fail("Not yet implemented");
	}

	@Test
	void testBFS() {
		fail("Not yet implemented");
	}

	@Test
	void testDFS() {
		fail("Not yet implemented");
	}
	*/
}
