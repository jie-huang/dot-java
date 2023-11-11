package os.jie.dot_java.html.attrs;

public class ValueAttr<V extends HtmlAttrValue> extends AbstractAttr {
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
    public String getValue() {
        return (null == value) ? null : value.getValueString();
    }
}
