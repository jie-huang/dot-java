package os.jie.dot_java.attrs;

public class LenImpl extends DoubleAttr {
    public LenImpl(double value) {
        // neato default 1.0 inch, fdp default 0.3 inch. Put -1.0 so there is no default.
        super("len", -1.0, 0.0, Double.MAX_VALUE, value);
    }
}
