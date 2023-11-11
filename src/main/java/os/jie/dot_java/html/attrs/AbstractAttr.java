package os.jie.dot_java.html.attrs;

import org.apache.commons.text.StringEscapeUtils;

public abstract class AbstractAttr implements HtmlAttr {
    protected final String key;

    protected AbstractAttr(String key) {
        this.key = key;
    }

    /**
     * Always output the result, even for default value.
     */
    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append("=\"");
        sb.append(StringEscapeUtils.escapeHtml4(getValue()));
        sb.append("\"");
        return sb.toString();
    }

    @Override
    public String getKey() {
        return key;
    }
}
