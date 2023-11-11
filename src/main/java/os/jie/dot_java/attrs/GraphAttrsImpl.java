package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.GraphAttrs;
import os.jie.dot_java.Statement;

public class GraphAttrsImpl extends GraphAttrs<GraphAttrsImpl> implements Statement {
    public final static String TYPE = "graph";

    public GraphAttrsImpl() {
    }

    @Override
    public boolean toDot(DotWriter dw) {
        dw.indentLine().append(TYPE);
        attrsToDotAttribute(dw);
        return true;
    }
}
