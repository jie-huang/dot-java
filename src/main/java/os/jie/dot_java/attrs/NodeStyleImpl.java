package os.jie.dot_java.attrs;

import os.jie.dot_java.NodeStyle;

public class NodeStyleImpl extends EnumListAttr<NodeStyle> {
    public NodeStyleImpl(NodeStyle value, NodeStyle...values) {
        super("style", ",", null, value, values);
    }
}
