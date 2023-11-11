package os.jie.dot_java;

public enum ArrowType {
    BOX("box"),
    CIRCLE("circle"),
    CROW("crow"),
    DIAMOND("diamond"),
    DOT("dot"),
    EDIAMOND("ediamond"),
    EMPTY("empty"),
    HALFOPEN("halfopen"),
    INV("inv"),
    INVDOT("invdot"),
    INVEMPTY("invempty"),
    INVODOT("invodot"),
    NONE("none"),
    NORMAL("normal"),
    OBOX("obox"),
    ODIAMOND("odiamond"),
    ODOT("odot"),
    OPEN("open"),
    TEE("tee"),
    VEE("vee");
	
	private final String str;

	private ArrowType(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return this.str;
	}
}
