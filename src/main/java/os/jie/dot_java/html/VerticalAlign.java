package os.jie.dot_java.html;

import os.jie.dot_java.html.attrs.HtmlAttrValue;

public enum VerticalAlign implements HtmlAttrValue {
	BOTTOM("BOTTOM"),
    MIDDLE("MIDDLE"),
    TOP("TOP");

    @Override
    public String getValueString() {
        return this.str;
    }

	private final String str;

	private VerticalAlign(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return this.str;
	}
}
