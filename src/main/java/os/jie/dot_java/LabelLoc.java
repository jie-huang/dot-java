package os.jie.dot_java;

public enum LabelLoc {
    BOTTOM("b"),
    TOP("t");

	private final String str;

	private LabelLoc(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
