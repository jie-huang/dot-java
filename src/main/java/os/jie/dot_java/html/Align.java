package os.jie.dot_java.html;

public enum Align {
    CENTER("CENTER"),
    LEFT("LEFT"),
    RIGHT("RIGHT");

	private final String str;

	private Align(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
