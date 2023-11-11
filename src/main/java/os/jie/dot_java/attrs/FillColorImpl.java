package os.jie.dot_java.attrs;

import os.jie.dot_java.Color;

public class FillColorImpl extends ValueListAttr<Color> {
    public FillColorImpl(String value, String... values) {
        super("fillcolor", ":", null, new Color(value));
        for (int i = 0; i < values.length; ++i) {
            super.values.add(new Color(values[i]));
        }
    }
}
