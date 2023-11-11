package os.jie.dot_java.html;


public enum TableDataAlign {
	CENTER("CENTER"),
	LEFT("LEFT"),
	RIGHT("RIGHT"),
	TEXT("TEXT");

	private final String str;

	private TableDataAlign(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
