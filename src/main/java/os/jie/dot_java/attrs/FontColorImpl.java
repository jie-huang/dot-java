package os.jie.dot_java.attrs;

import os.jie.dot_java.Color;

public class FontColorImpl extends ValueAttr<Color> {
    public FontColorImpl(Color value) {
        super("fontcolor", null, value);
    }
    public FontColorImpl(String value) {
        super("fontcolor", null, new Color(value));
    }
}
