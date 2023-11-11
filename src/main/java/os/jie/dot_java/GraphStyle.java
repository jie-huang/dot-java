package os.jie.dot_java;

public enum GraphStyle {
    FILLED("filled"),
    RADIAL("radial"),
    ROUNDED("rounded"),
    STRIPED("striped");

	private final String str;

	private GraphStyle(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
