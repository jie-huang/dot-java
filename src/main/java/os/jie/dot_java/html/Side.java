package os.jie.dot_java.html;

public enum Side {
    LEFT("L"),
    RIGHT("R"),
    TOP("T"),
    BOTTOM("B");

	private final String str;

	private Side(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
