package os.jie.dot_java;

public enum NodeLabelLoc {
    BOTTOM("b"),
    CENTER("c"),
    TOP("t");

	private final String str;

	private NodeLabelLoc(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
