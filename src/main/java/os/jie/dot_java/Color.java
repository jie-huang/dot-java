package os.jie.dot_java;

import os.jie.dot_java.attrs.DotAttrValue;

/**
 * Do NOT want to support enum color definition because there are too many types.
 * @author jie_huang
 *
 */
public class Color implements DotAttrValue {
    java.awt.Color color;
    String colorName;

    public Color(java.awt.Color color) {
        this.color = color;
    }

    public Color(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public boolean isSimple() {
        return true;
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
