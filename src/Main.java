

import biblioteca.BibliotecaController;

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
		
	}
}
