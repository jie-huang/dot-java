package os.jie.dot_java.attrs;

import os.jie.dot_java.DirType;

public class DirImpl extends EnumAttr<DirType> {
    public DirImpl(DirType value) {
        // digraph default is forward, graph default is none.
        super("dir", null, value);
    }
}
