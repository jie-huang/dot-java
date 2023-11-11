package os.jie.dot_java.html.text;

import java.util.ArrayList;
import java.util.List;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.html.Color;
import os.jie.dot_java.html.attrs.ColorImpl;
import os.jie.dot_java.html.attrs.FaceImpl;
import os.jie.dot_java.html.attrs.HtmlAttr;
import os.jie.dot_java.html.attrs.PointSizeImpl;

/**
 * Font is used by outside of table and inside of table both.
 * @author jie_huang
 *
 */
public class Font extends AbstractTextPack {
    ColorImpl color;
    FaceImpl face;
    PointSizeImpl fontSize;

    private List<HtmlAttr> attrs = new ArrayList<HtmlAttr>();

    private static void check(HtmlAttr attr) {
        if (null != attr) {
            throw new RuntimeException(attr.getKey() + " is set already!");
        }
    }

    public Font(Text text) {
        super("font", text);
    }

    public Font fontSize(int fontSize) {
        check(this.fontSize);
        this.fontSize = new PointSizeImpl(fontSize);
        attrs.add(this.fontSize);
        return this;
    }

    public Font face(String fontName) {
        check(this.face);
        this.face = new FaceImpl(fontName);
        attrs.add(this.face);
        return this;
    }

    public Font color(Color color) {
        check(this.color);
        this.color = new ColorImpl(color);
        attrs.add(this.color);
        return this;
    }

    public Font color(String colorName) {
        check(this.color);
        this.color = new ColorImpl(colorName);
        attrs.add(this.color);
        return this;
    }

    public void headToHtml(DotWriter dw) {
        dw.indentLine().append('<').append(packKey);
        if (!attrs.isEmpty()) {
            dw.indent();
            boolean isFirst = true;
            for (HtmlAttr attr : attrs) {
                if (isFirst) {
                    isFirst = false;
                    dw.append(' ');
                } else {
                    dw.indentLine();
                }

                dw.append(attr.toHtml());
            }
            dw.unindent();
        }
        dw.append('>');
    }

    public void tailToHtml(DotWriter dw) {
        dw.indentLine().append('<').append(packKey).append('>');
    }

    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append('<').append(packKey);
        for (HtmlAttr attr: attrs) {
            sb.append(' ').append(attr.toHtml());
        }
        sb.append('>');
        sb.append(inner.toHtml());
        sb.append("</").append(packKey).append('>');
        return sb.toString();
    }

    @Override
    public void toHtml(DotWriter dw) {
        headToHtml(dw);
        dw.indentLine().append(inner.toHtml());
        tailToHtml(dw);
    }
}
