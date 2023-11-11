package os.jie.dot_java.attrs;

import os.jie.dot_java.RankDir;

public class RankDirImpl extends EnumAttr<RankDir> {
    public RankDirImpl(RankDir value) {
        super("rankdir", RankDir.TOP_BOTTOM, value);
    }
}
