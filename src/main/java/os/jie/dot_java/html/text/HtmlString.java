package os.jie.dot_java.html.text;

import org.apache.commons.text.StringEscapeUtils;

import os.jie.dot_java.DotWriter;

/**
 * Basic raw html string.
 * @author jie_huang
 *
 */
public class HtmlString extends Text {
    final String str;

    public HtmlString(String s) {
        this.str = s;
    }

    @Override
    public String toHtml() {
        return StringEscapeUtils.escapeHtml4(str);
    }

    @Override
    public void toHtml(DotWriter dw) {
        dw.append(StringEscapeUtils.escapeHtml4(str));
    }
}
