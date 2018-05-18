package util;

public class BFSandDFSUtil implements Comparable<BFSandDFSUtil>{
	int id;
	int level;
	int fatherID;
	
	public BFSandDFSUtil(int id, int level, int fatherID) {
		this.id = id;
		this.level = level;
		this.fatherID = fatherID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getFatherID() {
		return fatherID;
	}

	public void setFatherID(int fatherID) {
		this.fatherID = fatherID;
	}
	
	@Override
	public int compareTo(BFSandDFSUtil o) {
		if(this.id > o.getId()) {
			return 1;
		}else if(this.id == o.getId()) {
			return 0;
		}else {
			return -1;
		}
	}
	
}
