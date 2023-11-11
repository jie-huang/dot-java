package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Utils;

public class MarginImpl extends AbstractAttr {
    final double x;
    final double y;

    public MarginImpl(double x) {
        this(x, Double.MIN_VALUE);
    }

    public MarginImpl(double x, double y) {
        super("margin");
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isDefault() {
        return false;
    }

    @Override
    protected void valueToDot(DotWriter dw) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(x));
        if (y != Double.MIN_VALUE) {
            sb.append(',').append(String.valueOf(y));
        }
        dw.append(Utils.escapeDotId(sb.toString()));
    }
}
