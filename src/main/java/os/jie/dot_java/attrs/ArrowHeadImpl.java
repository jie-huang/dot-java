package os.jie.dot_java.attrs;

import os.jie.dot_java.ArrowType;

public class ArrowHeadImpl extends EnumAttr<ArrowType> {
    public ArrowHeadImpl(ArrowType value) {
        super("arrowhead", ArrowType.NORMAL, value);
    }
}
