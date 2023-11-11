package os.jie.dot_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import os.jie.dot_java.attrs.DotAttr;

public abstract class AttrList {
    public List<DotAttr> attrs = new ArrayList<DotAttr>();

    protected static void check(DotAttr attr) {
        if (null != attr) {
            throw new RuntimeException(attr.getKey() + " is set already!");
        }
    }

    public boolean isEmpty() {
        return (null == attrs) || attrs.isEmpty();
    }

    private List<DotAttr> getAttrsToShow(boolean showDefault) {
        List<DotAttr> attrsToShow = new ArrayList<DotAttr>();
        for (DotAttr attr : attrs) {
            if (!showDefault && attr.isDefault()) {
                continue;
            }
            attrsToShow.add(attr);
        }
        Collections.sort(attrsToShow, new Comparator<DotAttr>() {
            @Override
            public int compare(DotAttr o1, DotAttr o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return attrsToShow;
    }

    /**
     * @param dw    (in): dot writer to write the attribute
     * @return true if really write something.
     */
    public boolean attrsToDotStatement(DotWriter dw) {
        if ((null != attrs) && (!attrs.isEmpty())) {
            for (DotAttr attr : attrs) {
                dw.indentLine();
                attr.toDot(dw);
                dw.append(';'); // It must be ';'.
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean attrsToDotAttribute(DotWriter dw) {
        List<DotAttr> attrsToShow = getAttrsToShow(dw.showDefaultDotAttr);
        if ((null != attrsToShow) && (!attrsToShow.isEmpty())) {
            dw.append(" [");
            dw.indent();
            int n = 0;
            for (DotAttr attr : attrsToShow) {
                dw.indentLine();
                attr.toDot(dw);
                if ((++n) < attrsToShow.size()) {
                    dw.append(','); // It must be ','.
                }
            }
            dw.unindent();
            dw.indentLine().append("]");
        } else if (dw.showEmptyAttrBracket) {
            dw.append(" []");
        }
        return true;
    }

    public boolean attrsToDot(DotWriter dw) {
        if ((attrs != null) && (!attrs.isEmpty())) {
            dw.append(" [");
            boolean isFirst = true;
            for (DotAttr attr : attrs) {
                if (isFirst) {
                    isFirst = false;
                } else {
                    dw.append(", ");
                }

                attr.toDot(dw);
            }
            dw.append("]");
            return true;
        } else {
            return false;
        }
    }
}
