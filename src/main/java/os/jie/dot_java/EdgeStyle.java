package os.jie.dot_java;

public enum EdgeStyle {
	DASHED("dashed"),
	DOTTED("dotted"),
	SOLID("solid"),
	INVIS("invis"),
	BOLD("bold"),
	TAPERED("tapered");

	private final String str;

	private EdgeStyle(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
