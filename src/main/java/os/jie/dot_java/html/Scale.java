package os.jie.dot_java.html;

public enum Scale {
    FALSE("FALSE"),
    TRUE("TRUE"),
    WIDTH("WIDTH"),
    HEIGHT("HEIGHT"),
    BOTH("BOTH");

	private final String str;

	private Scale(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
