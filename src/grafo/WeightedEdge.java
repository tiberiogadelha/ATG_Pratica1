package grafo;

public class WeightedEdge extends Edge {
	
	private float weight;

	public WeightedEdge(int id, float weight) {
		super(id);
		this.weight = weight;
	}
	
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		String saida = "Edge's ID: " + super.getId() + " | Weight: " + weight + "| " +  + super.getFatherID() + " --- " + super.getConnectedTo().getId() + " ";
		
		return saida;
	}
	
	public float compareTo(WeightedEdge otherEdge) {
		return this.getWeight() - otherEdge.getWeight();
	}

}
