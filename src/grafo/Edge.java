package grafo;

public class Edge implements Comparable<Edge>{
	
	private int id;
	private int fatherID;
	private Vertex edge;
	
	public Edge(int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vertex getEdge() {
		return edge;
	}

	public void setEdge(Vertex edge) {
		this.edge = edge;
	}

	
	public int getFatherID() {
		return this.fatherID;
	}
	
	public void setFatherID(int id) {
		this.fatherID = id;
	}

	
	@Override
	public String toString() {
		String saida = "Edge's ID: " + id + " | " + fatherID + " --- " + edge.getId() + " ";
		
		return saida;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} if (obj == null) {
			return false;
		} if (getClass() != obj.getClass()) {
			return false;
		}
		
		Edge other = (Edge) obj;
		if (id != other.id) {
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(Edge o) {
		if (o.getEdge().getId() < this.edge.getId()) {
			return 1;
		} else if (o.getEdge().getId() > this.edge.getId()){
			return -1;
		} else {
			return 0;
		}
	}

}
