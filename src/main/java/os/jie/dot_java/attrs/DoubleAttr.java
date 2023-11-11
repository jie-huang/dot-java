package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;

public class DoubleAttr extends AbstractAttr {
    private final double defaultValue;
    private final double minValue;
    private final double maxValue;
    private final double tolerance;
    private double value;

    public DoubleAttr(String key, double defaultValue, double minValue, double maxValue, double value) {
        super(key);
        this.defaultValue = defaultValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.tolerance = 0.000001;
        if ((value >= this.minValue) && (value <= this.maxValue)) {
            this.value = value;
        } else {
            throw new RuntimeException("value must be in range of [" + minValue + ", " + maxValue + "]: " + value);
        }
    }

    @Override
    public boolean isDefault() {
        return Math.abs(value - defaultValue) <= tolerance;
    }

    @Override
    public void valueToDot(DotWriter dw) {
        dw.append(String.valueOf(value));
    }
}
