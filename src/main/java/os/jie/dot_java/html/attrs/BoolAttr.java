package os.jie.dot_java.html.attrs;

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
    public String getValue() {
        return String.valueOf(value);
    }
}
