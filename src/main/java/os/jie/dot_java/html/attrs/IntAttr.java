package os.jie.dot_java.html.attrs;

public class IntAttr extends AbstractAttr {
    private final int defaultValue;
    private final int minValue;
    private final int maxValue;
    private int value;

    public IntAttr(String key, int defaultValue, int minValue, int maxValue, int value) {
        super(key);
        this.defaultValue = defaultValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        if ((value >= this.minValue) && (value <= this.maxValue)) {
            this.value = value;
        } else {
            throw new RuntimeException("value must be in range of [" + minValue + ", " + maxValue + "]: " + value);
        }
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
