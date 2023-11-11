package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;

public class BoolAttr extends AbstractAttr {
    private final boolean defaultValue;
    private boolean value;

    public BoolAttr(String key, boolean defaultValue, boolean value) {
        super(key);
        this.defaultValue = defaultValue;
        this.value = value;
    }

    @Override
    public boolean isDefault() {
        return value == defaultValue;
    }

    @Override
    public void valueToDot(DotWriter dw) {
        dw.append(String.valueOf(value));
    }
}
