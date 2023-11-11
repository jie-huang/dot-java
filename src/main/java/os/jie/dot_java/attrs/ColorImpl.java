package os.jie.dot_java.attrs;

import os.jie.dot_java.Color;

public class ColorImpl extends ValueListAttr<Color> {
    public ColorImpl(Color value) {
        super("color", ":", null, value);
    }

    public ColorImpl(String value, String... values) {
        super("color", ":", null, new Color(value));
        for (int i = 0; i < values.length; ++i) {
            super.values.add(new Color(values[i]));
        }
    }
}
