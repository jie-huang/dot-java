package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.NodeAttrs;
import os.jie.dot_java.Statement;

public class NodeAttrsImpl extends NodeAttrs<NodeAttrsImpl> implements Statement {
    public final static String TYPE = "node";

    @Override
    public boolean toDot(DotWriter dw) {
        dw.indentLine().append(TYPE);
        attrsToDot(dw);
        return true;
    }
}
