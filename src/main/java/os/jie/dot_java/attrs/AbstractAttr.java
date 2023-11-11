package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;

public abstract class AbstractAttr implements DotAttr {
    protected final String key;

    protected AbstractAttr(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    /**
     * Output everything, even the default value.
     */
    @Override
    public boolean toDot(DotWriter dw) {
        dw.append(key).append("=");
        valueToDot(dw);
        return true;
    }

    protected abstract void valueToDot(DotWriter dw);
}
