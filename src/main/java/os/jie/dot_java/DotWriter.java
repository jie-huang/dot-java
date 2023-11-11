package os.jie.dot_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Format writer. It is NOT thread safe.
 * @author jie_huang
 *
 */
public class DotWriter extends PrintWriter {
    public DotWriter(OutputStream out) {
        super(out);
    }

    public DotWriter(File file) throws FileNotFoundException {
        super(file);
    }

    public void indent() {
        indent += indentSize;
    }

    public void unindent() {
        indent -= indentSize;
        if (indent < 0) {
            throw new RuntimeException("indent = " + indent);
        }
    }

    public DotWriter indentLine() {
        println();
        if (indent > 0) {
            for (int i = 0; i < indent; ++i) {
                append(' ');
            }
        }
        return this;
    }


    public boolean indentAttr = false;
    public boolean prettyPrint = true;

    /**
     * Put a new line between groups.
     */
    public boolean newlineBetweenGroup = true;

    public boolean showDefaultHtmlAttr = true;

    public boolean showDefaultDotAttr = true;

    public boolean showEmptyAttrBracket = false;

    /**
     * indent size.
     */
    public int indentSize = 4;

    /**
     * current indent
     */
    public int indent = 0;

    /**
     * This is not a best choice. But it will simplify the relationship between edge and (di)graph.
     */
    public boolean directional = true;
}
