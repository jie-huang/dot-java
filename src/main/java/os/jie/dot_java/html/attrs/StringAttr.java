package os.jie.dot_java.html.attrs;

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
    public String getValue() {
        return value;
    }
}
