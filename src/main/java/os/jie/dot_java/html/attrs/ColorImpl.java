package os.jie.dot_java.html.attrs;

import os.jie.dot_java.html.Color;

public class ColorImpl extends ValueAttr<Color> {
    public ColorImpl(Color value) {
        super("color", null, value);
    }
    public ColorImpl(String value) {
        super("color", null, new Color(value));
    }
}
