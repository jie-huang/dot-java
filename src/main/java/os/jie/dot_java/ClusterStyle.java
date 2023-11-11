package os.jie.dot_java;

public enum ClusterStyle {
    BOLD("bold"),
    DASHED("dashed"),
    DOTTED("dotted"),
    FILLED("filled"),
    ROUNDED("rounded"),
    SOLID("solid"),
    STRIPPED("stripped");
	
	private final String str;
	private ClusterStyle(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return this.str;
	}
}
