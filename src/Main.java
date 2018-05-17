import java.io.IOException;
import java.util.Scanner;

import biblioteca.BibliotecaFacade;
import grafo.Graph;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	private static BibliotecaFacade biblioteca = new BibliotecaFacade();
	
	public static void main(String[] args) throws Exception {
		
		
		
		int option = -1;
		
		while(option != 0) {
			showMenu();
			System.out.println("Choose a option: ");
			option = sc.nextInt();
			sc.nextLine();
			
			
			switch(option) {
			
			case 0:
				
				break;
				
			case 1:
				readGraph();
				
				break;
				
			case 2:
				readWeightedGraph();
				
				break;
			case 3:
				getGraph();
				break;
				
			case 4:
				int vertexNumber = getVertexNumber();
				
				if(vertexNumber != -1) {
					System.out.println("Vertex's number: " + vertexNumber);
				} else {
					System.out.println("A problem occurred");
				}
				
				break;
				
			case 5:
				int edgeNumber = getEdgeNumber();
				
				if(edgeNumber != -1) {
					System.out.println("Edge's number: " + edgeNumber);
				} else {
					System.out.println("A problem occurred");
				}
				
				break;
				
			case 6:
				float meanEdge = getMeanEdge();
				
				if(meanEdge != -1) {
					System.out.println("Mean edge: " + meanEdge);
				} else {
					System.out.println("A problem occurred");
				}
				
				break;
				
			case 7:
				System.out.println(getAMRepresentation());
				
				break;
				
			case 8:
				System.out.println(getALRepresentation());
				
				break;
				
			case 9:
				doBFS();
				
				break;
				
			case 10:
				doDFS();
				
				break;
				
			case 11:
				connected();
				
				break;
				
			case 12:
				shortestPath();
				
				break;
				
			case 13:
				MST();
				
				break;
				
			case 14:
				getAllGraphs();
				
				break;
			}
			
		}
		
	
	}
	
	

	public static void showMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("|--------- Welcome! Choose an option: ---------|");
		System.out.println("|----------------------------------------------|");
		System.out.println("|------- 0) Get out ---------------------------|");
		System.out.println("|------- 1) Read a graph ----------------------|");
		System.out.println("|------- 2) Read a weighted graph -------------|");
		System.out.println("|------- 3) Get a graph -----------------------|");
		System.out.println("|------- 4) Get Vertex's number of a graph ----|");
		System.out.println("|------- 5) Get Edge's number of a graph ------|");
		System.out.println("|------- 6) Get mean edge of a graph ----------|");
		System.out.println("|------- 7) Get AM representation of a graph --|");
		System.out.println("|------- 8) Get AL representation of a graph --|");
		System.out.println("|------- 9) Do a BFS in a graph ---------------|");
		System.out.println("|------- 10) Do a DFS in a graph --------------|");
		System.out.println("|------- 11) Verify if the graph is connected -|");
		System.out.println("|------- 12) Find the shortest path -----------|");
		System.out.println("|------- 13) Get Minimum Spanning Tree --------|");
		System.out.println("|------- 14) Get all graphs -------------------|");
		System.out.println("------------------------------------------------");
		
		
	}
	
	private static void readGraph() {
		System.out.println("Type a path to the txt: ");
		String path = sc.nextLine();
		
		try {
			biblioteca.readGraph(path);
			System.out.println("New graph was created");
		} catch (IOException e) {
			System.out.println("There's a problem with this path! Try again, please.");
		}
	}
	
	private static void readWeightedGraph() {
		System.out.println("Type a path to the txt: ");
		String path = sc.nextLine();
		
		try {
			biblioteca.readWeightGraph(path);
			System.out.println("New weighted graph was created");
		} catch (IOException e) {
			System.out.println("There's a problem with this path! Try another path, please.");
		}
	}
	
	private static int getVertexNumber() {
		int vertexNumber = -1;
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			vertexNumber = biblioteca.getVertexNumber(id);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return vertexNumber;
		
	}
	
	private static int getEdgeNumber() {
		int edgeNumber = -1;
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			edgeNumber = biblioteca.getEdgeNumber(id);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return edgeNumber;
		
	}
	
	private static float getMeanEdge() {
		float meanEdge = -1;
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			meanEdge = biblioteca.getMeanEdge(id);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return meanEdge;
		
	}
	
	private static String getAMRepresentation() {
		String out = "";
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			out = biblioteca.graphRepresentation(id, "AM");
		} catch (Exception e) {
			out = e.getMessage();
		}
		
		return out;
	}
	
	private static String getALRepresentation() {
		String out = "";
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			out = biblioteca.graphRepresentation(id, "AL");
		} catch (Exception e) {
			out = e.getMessage();
		}
		
		return out;
	}
	
	private static void doBFS() {
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Type the vertex's ID: "); 
		int vertexId = sc.nextInt();
		sc.nextLine();
		
		System.out.println(biblioteca.BFS(id, vertexId));
	}
	
	private static void doDFS() {
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Type the vertex's ID: "); 
		int vertexId = sc.nextInt();
		sc.nextLine();
		
		biblioteca.DFS(id, vertexId);
	}
	
	private static void connected() {
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			boolean isConnected = biblioteca.connected(id);
			System.out.println("Is this a connected graph? " + isConnected );
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void getGraph() {
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		Graph graph = biblioteca.getGraph(id);
		if(graph != null) {
			System.out.println(graph.toString());
		} else {
			System.out.println("There's no graph is this ID!");
		}
		
	}
	
	private static void shortestPath() {
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Type the vertex1's ID: "); 
		int vertex1Id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Type the vertex2's ID: "); 
		int vertex2Id = sc.nextInt();
		sc.nextLine();
		
		try {
			System.out.println(biblioteca.shortestPath(id, vertex1Id, vertex2Id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void MST() {
		System.out.println("Type the graph's ID: "); 
		int id = sc.nextInt();
		sc.nextLine();
		
		biblioteca.MST(id);
	}
	
	public static void getAllGraphs() {
		System.out.println(biblioteca.getAllGraphs());
	}
}
