package os.jie.dot_java;

import os.jie.dot_java.attrs.ArrowHeadImpl;
import os.jie.dot_java.attrs.ArrowTailImpl;
import os.jie.dot_java.attrs.ColorImpl;
import os.jie.dot_java.attrs.ConstraintImpl;
import os.jie.dot_java.attrs.DirImpl;
import os.jie.dot_java.attrs.EdgeStyleImpl;
import os.jie.dot_java.attrs.FontColorImpl;
import os.jie.dot_java.attrs.FontSizeImpl;
import os.jie.dot_java.attrs.LabelImpl;
import os.jie.dot_java.attrs.LenImpl;
import os.jie.dot_java.attrs.PenWidthImpl;
import os.jie.dot_java.html.Table;
import os.jie.dot_java.html.text.Text;

@SuppressWarnings("unchecked")
public class EdgeAttrs<T extends EdgeAttrs<T>> extends AttrList {
    // attributes ==== begin
    public LabelImpl label;
    public ConstraintImpl constraint;
    public PenWidthImpl penWidth;
    public FontSizeImpl fontSize;
    public FontColorImpl fontColor;
    public LenImpl len;
    public DirImpl dir;
    public ColorImpl color;
    public EdgeStyleImpl style;
    public ArrowHeadImpl arrowHead;
    public ArrowTailImpl arrowTail;
    // attributes ==== end

    // operations ==== begin
    public T lable(Table table) {
        check(this.label);
        this.label = new LabelImpl(table);
        attrs.add(this.label);
        return (T) this;
    }

    public T label(String s) {
        check(this.label);
        this.label = new LabelImpl(s);
        attrs.add(this.label);
        return (T) this;
    }

    public T label(Text text) {
        check(this.label);
        this.label = new LabelImpl(text);
        attrs.add(this.label);
        return (T) this;
    }

    public T constraint(boolean constraint) {
        check(this.constraint);
        this.constraint = new ConstraintImpl(constraint);
        attrs.add(this.constraint);
        return (T) this;
    }

    public T penWidth(double penWidth) {
        check(this.penWidth);
        this.penWidth = new PenWidthImpl(penWidth);
        attrs.add(this.penWidth);
        return (T) this;
    }

    public T fontSize(double fontSize) {
        check(this.fontSize);
        this.fontSize = new FontSizeImpl(fontSize);
        attrs.add(this.fontSize);
        return (T) this;
    }

    public T fontColor(String color) {
        check(this.fontColor);
        this.fontColor = new FontColorImpl(new Color(color));
        attrs.add(this.fontColor);
        return (T) this;
    }

    public T len(double len) {
        check(this.len);
        this.len = new LenImpl(len);
        attrs.add(this.len);
        return (T) this;
    }

    public T dir(DirType dir) {
        check(this.dir);
        this.dir = new DirImpl(dir);
        attrs.add(this.dir);
        return (T) this;
    }

    public T color(String colorName, String... colorNames) {
        check(this.color);
        this.color = new ColorImpl(colorName, colorNames);
        attrs.add(this.color);
        return (T) this;
    }

    public T style(EdgeStyle style, EdgeStyle... styles) {
        check(this.style);
        this.style = new EdgeStyleImpl(style, styles);
        attrs.add(this.style);
        return (T) this;
    }

    public T arrowHead(ArrowType arrowType) {
        check(this.arrowHead);
        this.arrowHead = new ArrowHeadImpl(arrowType);
        attrs.add(this.arrowHead);
        return (T) this;
    }

    public T arrowTail(ArrowType arrowType) {
        check(this.arrowTail);
        this.arrowTail = new ArrowTailImpl(arrowType);
        attrs.add(this.arrowTail);
        return (T) this;
    }
    // operations ==== end
}
