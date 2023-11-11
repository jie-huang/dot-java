package os.jie.dot_java.attrs;

import os.jie.dot_java.Statement;

/**
 * The corresponding of Dot IdStatement.
 * @author jie_huang
 *
 */
public interface DotAttr extends Statement {
    public boolean isDefault();

    public String getKey();
}
