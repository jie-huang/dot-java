package os.jie.dot_java.attrs;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Utils;

public class SizeImpl extends AbstractAttr {
    final boolean fixed;
    final double width;
    final double height;

    public SizeImpl(boolean fixed, double width) {
        this(fixed, width, Double.MIN_VALUE);
    }

    public SizeImpl(boolean fixed, double width, double height) {
        super("size");
        this.fixed = fixed;
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isDefault() {
        return false;
    }

    @Override
    protected void valueToDot(DotWriter dw) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(width));
        if (height > 0) {
            sb.append(',').append(String.valueOf(height));
        }
        if (fixed) {
            sb.append('!');
        }
        dw.append(Utils.escapeDotId(sb.toString()));
    }
}
