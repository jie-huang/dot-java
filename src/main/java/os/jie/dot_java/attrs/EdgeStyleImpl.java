package os.jie.dot_java.attrs;

import os.jie.dot_java.EdgeStyle;

public class EdgeStyleImpl extends EnumListAttr<EdgeStyle> {
    public EdgeStyleImpl(EdgeStyle value, EdgeStyle... values) {
        super("style", ",", null, value, values);
    }
}
