package kruskal;

public class DisjoinSet {
	private int[] set;
	public int[] getSet() {
		return set;
	}
	public DisjoinSet(int numVertex) {
		set = new int[numVertex];
		for(int i=0;i<set.length; i++) {
			set[i] = -1;
		}
	}

	public void union(int root1, int root2) {
		if(set[root2] < set[root1]) {
			set[root1] = root2;
		}else {
			if(set[root1]==set[root2]) {
				set[root1]--;
			}
				set[root2] = root1;
		}
	}
	
	public int find(int x) {
		if(set[x] < 0) {
			return x;
		}
		int next = x;
		while(set[next] > 0 ) {
			next=set[next];
		}
		return next;
	}
}

