package os.jie.dot_java.html.attrs;

import java.util.ArrayList;
import java.util.List;

public class ValueListAttr<V extends HtmlAttrValue> extends AbstractAttr {
    private final V defaultValue;
    private final String delimeter;
    protected List<V> values;

    @SuppressWarnings("unchecked")
    ValueListAttr(String key, String delimeter, V defaultValue, V value, V... values) {
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
    public String getValue() {
        if (values.size() == 1) {
            return values.get(0).getValueString();
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
            return sb.toString();
        }
    }
}
