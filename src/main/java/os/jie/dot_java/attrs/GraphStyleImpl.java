package os.jie.dot_java.attrs;

import os.jie.dot_java.GraphStyle;

public class GraphStyleImpl extends EnumListAttr<GraphStyle> {
    public GraphStyleImpl(GraphStyle value, GraphStyle...values) {
        super("style", ",", null, value, values);
    }
}
