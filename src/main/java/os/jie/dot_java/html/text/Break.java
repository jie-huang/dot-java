package os.jie.dot_java.html.text;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.html.Align;
import os.jie.dot_java.html.HtmlNode;
import os.jie.dot_java.html.attrs.AlignImpl;

public class Break extends Text implements TextItem, HtmlNode {
    // Attributes ==== begin
    AlignImpl align;
    // Attributes ==== end

    // operation ==== begin
    // operation ==== end
    public Break() {
    }

    public Break(Align align) {
        this.align = new AlignImpl(align);
    }

    @Override
    public String toHtml() {
        String s = null;
        if (null != align) {
            s = align.toHtml();
        }

        if (null == s) {
            return "<BR/>";
        } else {
            return "<BR " + s + " />";
        }
    }

    @Override
    public void toHtml(DotWriter dw) {
        if (dw.prettyPrint) {
            dw.indentLine();
        }
        dw.append(toHtml());
    }
}
