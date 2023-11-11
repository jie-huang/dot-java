package os.jie.dot_java.html;

import os.jie.dot_java.html.attrs.HtmlAttrValue;

public class Color implements HtmlAttrValue {
    java.awt.Color color;
    String colorName;

    public Color(java.awt.Color color) {
        this.color = color;
    }

    public Color(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public String getValueString() {
        if (null != colorName) {
            return colorName;
        } else if (null != color) {
            return color.toString();
        } else {
        return null;
        }
    }
}
