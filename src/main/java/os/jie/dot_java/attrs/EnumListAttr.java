package os.jie.dot_java.attrs;

import java.util.ArrayList;
import java.util.List;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Utils;

public class EnumListAttr<E extends Enum<E>> extends AbstractAttr {
    private final E defaultValue;
    private final String delimeter;
    List<E> values;

    @SuppressWarnings("unchecked")
    protected EnumListAttr(String key, String delimeter, E defaultValue, E value, E... values) {
        super(key);
        this.delimeter = delimeter;
        this.defaultValue = defaultValue;
        this.values = new ArrayList<E>();
        this.values.add(value);
        for (int i = 0; i < values.length; ++i) {
            this.values.add(values[i]);
        }
    }

    @Override
    public boolean isDefault() {
        return ((null == defaultValue) && (null == values)) ||
            ((null != defaultValue) && (values.size() == 1) && (defaultValue == values.get(0)));
    }

    @Override
    public void valueToDot(DotWriter dw) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (E value : values) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append(delimeter);
            }
            sb.append(value.toString());
        }
        dw.append(Utils.escapeDotId(sb.toString()));
    }
}
