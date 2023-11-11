package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;

public class EnumAttr<E extends Enum<E>> extends AbstractAttr {
    private final E defaultValue;
    E value;

    protected EnumAttr(String key, E defaultValue, E value) {
        super(key);
        this.defaultValue = defaultValue;
        this.value = value;
    }

    @Override
    public boolean isDefault() {
        return (value == null) || (value == defaultValue);
    }

    @Override
    public void valueToDot(DotWriter dw) {
        dw.append(value.toString());
    }
}
