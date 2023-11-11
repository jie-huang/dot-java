package os.jie.dot_java.html.attrs;

import java.util.HashSet;
import java.util.Set;

import os.jie.dot_java.html.Side;

public class SidesImpl extends AbstractAttr {
    Set<Side> sides = new HashSet<Side>();

    public SidesImpl(String key) {
        super(key);
    }

    @Override
    public boolean isDefault() {
        return (null == sides) || sides.isEmpty();
    }

    @Override
    public String getValue() {
        if (isDefault()) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            for (Side s : sides) {
                sb.append(s.toString());
            }
            return sb.toString();
        }
    }
}
