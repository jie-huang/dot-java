package os.jie.dot_java.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Statement;
import os.jie.dot_java.html.attrs.HtmlAttr;

public abstract class AbstractElemPack implements Statement {
    final String key;
    final boolean noChild;

    protected AbstractElemPack(String key, boolean noChild) {
        this.key = key;
        this.noChild = noChild;
    }

    protected List<HtmlAttr> attrs = new ArrayList<HtmlAttr>();

    protected static void check(HtmlAttr attr) {
        if (null != attr) {
            throw new RuntimeException(attr.getKey() + " is set already!");
        }
    }

    protected List<HtmlAttr> getAttrsToShow(boolean showDefault) {
        List<HtmlAttr> attrsToShow = new ArrayList<HtmlAttr>();
        for (HtmlAttr attr: attrs) {
            if (! showDefault && attr.isDefault()) {
                continue;
            }
            attrsToShow.add(attr);
        }
        Collections.sort(attrsToShow, new Comparator<HtmlAttr>() {
            @Override
            public int compare(HtmlAttr o1, HtmlAttr o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return attrsToShow;
    }

    @Override
    public boolean toDot(DotWriter dw) {
        List<HtmlAttr> attrsToShow = getAttrsToShow(dw.showDefaultHtmlAttr);
        dw.indentLine().append('<').append(key);
        if (!attrsToShow.isEmpty()) {
            for (HtmlAttr attr : attrs) {
                dw.append(' ').append(attr.toHtml());
            }
        }
        if (noChild) {
            dw.append("/>");
        } else {
            dw.append('>');
            innerToDot(dw);
            dw.append("</").append(key).append('>');
        }
        return true;
    }

    /**
     * default for {@link AbstractElemPack#noChild}, do nothing.
     * @param dw    (in): dot writer
     */
    protected void innerToDot(DotWriter dw) {
        // do nothing.
    }
}
