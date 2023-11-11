package os.jie.dot_java;

public enum RankDir {
    TOP_BOTTOM("TB"),
    LEFT_RIGHT("LR"),
    BOTTOM_TOP("BT"),
    RIGHT_LEFT("RL");

	private final String str;

	private RankDir(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
