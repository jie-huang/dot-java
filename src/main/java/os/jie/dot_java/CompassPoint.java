package os.jie.dot_java;

public enum CompassPoint {
	NORTH("n"),
	NORTH_EAST("ne"),
	EAST("e"),
	SOUTH_EAST("se"),
	SOUTH("s"),
	SOUTH_WEST("sw"),
	WEST("w"),
	NORTH_WEST("nw"),
	CENTER("c"),
	NONE("_");
	
	private final String str;

	private CompassPoint(String str) {
		this.str = str;
	}
	
	public String toString() {
		return str;
	}
}
