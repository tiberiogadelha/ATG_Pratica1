package grafo;

public class WeightEdge extends Edge {
	
	private float weight;

	public WeightEdge(int id, float weight) {
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
		String saida = "Edge's ID: " + super.getId() + " | Weight: " + weight + "| " +  + super.getFatherID() + " --- " + super.getEdge().getId() + " ";
		
		return saida;
	}

}
