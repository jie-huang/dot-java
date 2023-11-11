package os.jie.dot_java.attrs;

import org.apache.commons.text.StringEscapeUtils;


import os.jie.dot_java.DotWriter;
import os.jie.dot_java.html.Table;
import os.jie.dot_java.html.text.Text;

public class LabelImpl extends AbstractAttr {
    final String s;
    final Text text;
    final Table table;

    /**
     * Construct simple string label.
     * @param s (in): simple string label
     */
    public LabelImpl(String s) {
        super("label");
        this.s = StringEscapeUtils.escapeJava(s);
        this.text = null;
        this.table = null;
    }

    /**
     * Construct Html String label
     * @param text (in): Text to show
     */
    public LabelImpl(Text text) {
        super("label");
        this.s = null;
        this.text = text;
        this.table = null;
    }

    /**
     * Construct Html Table label
     * @param table (in): html table
     */
    public LabelImpl(Table table) {
        super("label");
        this.s = null;
        this.text = null;
        this.table = table;
    }

    @Override
    public boolean isDefault() {
        return (this.s == null) && (this.text == null) && (this.table == null);
    }

    @Override
    public void valueToDot(DotWriter dw) {
        if (this.s != null) {
            dw.append("\"").append(s).append("\"");
        } else if (this.text != null) {
            dw.append("<");
            this.text.toHtml(dw);
            dw.append(">");
        } else if (this.table != null) {
            dw.append("<");
            this.table.toDot(dw);
            dw.append(">");
        } else {
            throw new RuntimeException("Impossible path");
        }
    }
}
