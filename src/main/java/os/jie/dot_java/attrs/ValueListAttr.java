package os.jie.dot_java.attrs;

import java.util.ArrayList;
import java.util.List;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Utils;

public class ValueListAttr<V extends DotAttrValue> extends AbstractAttr {
    private final V defaultValue;
    protected final List<V> values;
    private final String delimeter;

    @SuppressWarnings("unchecked")
    ValueListAttr(String key, String delimeter, V defaultValue, V value, V...values) {
        super(key);
        this.delimeter = delimeter;
        this.defaultValue = defaultValue;
        this.values = new ArrayList<V>();
        this.values.add(value);
        for (int i = 0; i < values.length; ++i) {
            this.values.add(values[i]);
        }
    }

    @Override
    public boolean isDefault() {
        return ((defaultValue == null) && (values == null)) ||
            ((defaultValue != null) && (values.size() == 1) && defaultValue.equals(values.get(0)));
    }

    @Override
    public void valueToDot(DotWriter dw) {
        if (values.size() == 1) {
            dw.append(Utils.escapeDotId(values.get(0).getValueString()));
        } else {
            StringBuilder sb = new StringBuilder();
            boolean isFirst = true;
            for (V v : values) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    sb.append(delimeter);
                }
                sb.append(v.getValueString());
            }
            dw.append(Utils.escapeDotId(sb.toString()));
        }
    }
}
