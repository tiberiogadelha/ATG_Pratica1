

import biblioteca.BibliotecaController;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BibliotecaController bb = new BibliotecaController();
		bb.readGraph("grafo1.txt");
		bb.getGraphs();
		System.out.println(bb.getVertexNumber(1));
		System.out.println(bb.getEdgeNumber(1));
		System.out.println(bb.graphRepresentation(1, "AL"));
	}
}
