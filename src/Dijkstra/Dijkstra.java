package Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import grafo.Edge;
import grafo.Graph;
import grafo.Vertex;
import grafo.WeightedEdge;

public class Dijkstra {
	private final List<Vertex> vertex;
	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettleNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Float> distance;
	
	public Dijkstra(Graph graph) {
		this.vertex = new ArrayList<Vertex>(graph.getAllVertix());
		this.edges = new ArrayList<Edge>();
		for(Vertex vertex : this.vertex) {
			for(Edge edge : vertex.getEdges()) {
				this.edges.add(edge);
			}
		}
	}
	
	public void execute(Vertex source) throws Exception {
		settledNodes = new HashSet<Vertex>();
		unSettleNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Float>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source, (float) 0.0);
		unSettleNodes.add(source);
		while(unSettleNodes.size() > 0) {
			Vertex node = getMinimum(unSettleNodes);
			settledNodes.add(node);
			unSettleNodes.remove(node);
			findMinimalDistances(node);
		}
	}
	
	private void findMinimalDistances(Vertex node) throws Exception {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for(Vertex target : adjacentNodes) {
			if(getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, (getShortestDistance(node) + getDistance(node, target)));
				predecessors.put(target, node);
				unSettleNodes.add(target);
			}
		}
	}
	
	private float getDistance(Vertex node, Vertex target) throws Exception {
		for(Edge edge : this.edges) {
			if(edge.getFatherID() == node.getId() && edge.getConnectedTo().getId() == target.getId()) {
				WeightedEdge aux = (WeightedEdge) edge;
				return aux.getWeight();
			}
		}
			throw new Exception("Shout not happen!");
	}
	
	private List<Vertex> getNeighbors(Vertex node){
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for(Edge edge: this.edges) {
			if(edge.getFatherID() == node.getId() && !isSettled(edge.getConnectedTo())) {
				neighbors.add(edge.getConnectedTo());
			}
		}
		return neighbors;
	}
	
	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for(Vertex vertex : vertexes) {
			if(minimum == null) {
				minimum = vertex;
			}else {
				if(getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
			return minimum;
	}
	
	private boolean isSettled(Vertex vertex) {
		return settledNodes.contains(vertex);
	}
	
	private float getShortestDistance(Vertex destination) {
		Float d = distance.get(destination);
		if(d==null) {
			return Integer.MAX_VALUE;
		}else {
			return d;
		}
	}
	
	public LinkedList<Vertex> getPath(Vertex target){
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		if(predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while(predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		
		Collections.reverse(path);
		return path;
	}
}
