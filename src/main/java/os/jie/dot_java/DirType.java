package os.jie.dot_java;

public enum DirType {
    BACK("back"),
    BOTH("both"),
    FORWARD("forward"),
    NONE("none");

	private final String str;
	private DirType(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return this.str;
	}
}
