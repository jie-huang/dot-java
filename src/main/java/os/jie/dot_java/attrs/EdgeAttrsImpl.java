package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.EdgeAttrs;
import os.jie.dot_java.Statement;

public class EdgeAttrsImpl extends EdgeAttrs<EdgeAttrsImpl> implements Statement {
    public final static String TYPE = "edge";

    @Override
    public boolean toDot(DotWriter dw) {
        dw.indentLine().append(TYPE);
        attrsToDot(dw);
        return true;
    }
}
