package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;

public class StringAttr extends AbstractAttr {
    private String value;

    public StringAttr(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public boolean isDefault() {
        return value == null;
    }

    @Override
    public void valueToDot(DotWriter dw) {
        dw.append('"').append(value).append('"');
    }
}
