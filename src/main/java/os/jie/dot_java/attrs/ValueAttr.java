package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Utils;

public class ValueAttr<V extends DotAttrValue> extends AbstractAttr {
    private final V defaultValue;
    private V value;

    ValueAttr(String key, V defaultValue, V value) {
        super(key);
        this.defaultValue = defaultValue;
        this.value = value;
    }

    @Override
    public boolean isDefault() {
        return ((defaultValue == null) && (value == null)) ||
            ((defaultValue != null) && defaultValue.equals(value));
    }

    @Override
    public void valueToDot(DotWriter dw) {
        dw.append(Utils.escapeDotId(value.getValueString()));
    }
}
