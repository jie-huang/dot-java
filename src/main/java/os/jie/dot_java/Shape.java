package os.jie.dot_java;

public enum Shape {
    MCIRCLE("Mcircle"),
    MDIAMOND("Mdiamond"),
    MRECORD("Mrecord"),
    MSQUARE("Msquare"),
    ASSEMBLY("assembly"),
    BOX("box"),
    BOX3D("box3d"),
    CDS("cds"),
    CIRCLE("circle"),
    COMPONENT("component"),
    DIAMOND("diamond"),
    DOUBLE_CIRCLE("doublecircle"),
    DOUBLE_OCTAGON("doubleoctagon"),
    EGG("egg"),
    ELLIPSE("ellipse"),
    FIVE_POVER_HANG("fivepoverhang"),
    FOLDER("folder"),
    HEXAGON("hexagon"),
    HOUSE("house"),
    INSULATOR("insulator"),
    INV_HOUSE("invhouse"),
    INV_TRAPEZIUM("invtrapezium"),
    INV_TRIANGLE("invtriangle"),
    LARROW("larrow"),
    LPROMOTER("lpromoter"),
    NONE("none"),
    NOTE("note"),
    NOVER_HANG("noverhang"),
    OCTAGON("octagon"),
    OVAL("oval"),
    PARALLELOGRAM("parallelogram"),
    PENTAGON("pentagon"),
    PLAIN("plain"),
    PLAIN_TEXT("plaintext"),
    POINT("point"),
    POLYGON("polygon"),
    PRIMER_SITE("primersite"),
    PROMOTER("promoter"),
    PROTEASE_SITE("proteasesite"),
    PROTEINSTAB("proteinstab"),
    RIGHT_ARROW("rarrow"),
    RECORD("record"), // Special shape by using label record
    RECT("rect"),
    RECTANGLE("rectangle"),
    RESTRICTION_SITE("restrictionsite"),
    RIBO_SITE("ribosite"),
    RNASTAB("rnastab"),
    RIGHT_PROMOTER("rpromoter"),
    SEPTAGON("septagon"),
    SIGNATURE("signature"),
    SQUARE("square"),
    STAR("star"),
    TAB("tab"),
    TERMINATOR("terminator"),
    THREE_POVER_HANG("threepoverhang"),
    TRAPEZIUM("trapezium"),
    TRIANGLE("triangle"),
    TRIPLE_OCTAGON("tripleoctagon"),
    UNDERLINE("underline"),
    UTR("utr");

	private final String str;

	private Shape(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return this.str;
	}
}
