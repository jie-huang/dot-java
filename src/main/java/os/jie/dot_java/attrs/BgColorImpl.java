package os.jie.dot_java.attrs;

import os.jie.dot_java.Color;

public class BgColorImpl extends ValueListAttr<Color> {
    public BgColorImpl(Color value) {
        super("bgcolor", ":", null, value);
    }

    public BgColorImpl(String value, String... values) {
        super("bgcolor", ":", null, new Color(value));
        for (int i = 0; i < values.length; ++i) {
            super.values.add(new Color(values[i]));
        }
    }
}
