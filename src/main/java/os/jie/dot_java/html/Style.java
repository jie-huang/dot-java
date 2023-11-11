package os.jie.dot_java.html;

public enum Style {
    ROUNDED("ROUNDED"),
    RADIAL("RADIAL");

    private final String str;

	private Style(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
