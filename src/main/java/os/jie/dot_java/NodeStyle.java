package os.jie.dot_java;

public enum NodeStyle {
    BOLD("bold"),
    DASHED("dashed"),
    DIAGONALS("diagonals"),
    DOTTED("dotted"),
    FILLED("filled"),
    INVIS("invis"),
    RADIAL("radial"),
    ROUNDED("rounded"),
    SOLID("solid"),
    STRIPED("striped"),
    WEDGED("wedged");

	private final String str;

	private NodeStyle(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
