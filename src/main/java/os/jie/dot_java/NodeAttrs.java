package os.jie.dot_java;

import os.jie.dot_java.attrs.ColorImpl;
import os.jie.dot_java.attrs.FillColorImpl;
import os.jie.dot_java.attrs.FixedSizeImpl;
import os.jie.dot_java.attrs.FontColorImpl;
import os.jie.dot_java.attrs.FontNameImpl;
import os.jie.dot_java.attrs.FontSizeImpl;
import os.jie.dot_java.attrs.GradientAngleImpl;
import os.jie.dot_java.attrs.HeightImpl;
import os.jie.dot_java.attrs.LabelImpl;
import os.jie.dot_java.attrs.MarginImpl;
import os.jie.dot_java.attrs.NodeStyleImpl;
import os.jie.dot_java.attrs.PenWidthImpl;
import os.jie.dot_java.attrs.ShapeImpl;
import os.jie.dot_java.attrs.UrlImpl;
import os.jie.dot_java.attrs.WidthImpl;
import os.jie.dot_java.html.Table;
import os.jie.dot_java.html.text.Text;

@SuppressWarnings("unchecked")
public abstract class NodeAttrs<T extends NodeAttrs<T>> extends AttrList {
    // attributes ==== begin
    public LabelImpl label;
    public ShapeImpl shape;
    public NodeStyleImpl style;
    public ColorImpl color;
    public PenWidthImpl penWidth;
    public FillColorImpl fillColor;
    public FontNameImpl fontName;
    public FixedSizeImpl fixedSize;
    public WidthImpl width;
    public HeightImpl height;
    public GradientAngleImpl gradientAngle;
    public FontColorImpl fontColor;
    public FontSizeImpl fontSize;
    public MarginImpl margin;
    public UrlImpl url;
    // attributes ==== end

    // operation ==== begin
    public T label(Table table) {
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

    public T shape(Shape shape) {
        check(this.shape);
        this.shape = new ShapeImpl(shape);
        attrs.add(this.shape);
        return (T) this;
    }

    public T style(NodeStyle style, NodeStyle... styles) {
        check(this.style);
        this.style = new NodeStyleImpl(style, styles);
        attrs.add(this.style);
        return (T) this;
    }

    public T color(String colorName) {
        check(this.color);
        this.color = new ColorImpl(colorName);
        attrs.add(this.color);
        return (T) this;
    }

    public T penWidth(double penWidth) {
        check(this.penWidth);
        this.penWidth = new PenWidthImpl(penWidth);
        attrs.add(this.penWidth);
        return (T) this;
    }

    public T fillColor(String colorName, String... colorNames) {
        check(this.fillColor);
        this.fillColor = new FillColorImpl(colorName, colorNames);
        attrs.add(this.fillColor);
        return (T) this;
    }

    public T fontName(String fontName) {
        check(this.fontName);
        this.fontName = new FontNameImpl(fontName);
        attrs.add(this.fontName);
        return (T) this;
    }

    public T fixedSize(FixedSize fixedSize) {
        check(this.fixedSize);
        this.fixedSize = new FixedSizeImpl(fixedSize);
        attrs.add(this.fixedSize);
        return (T) this;
    }

    public T fixedSize(boolean fixedSize) {
        check(this.fixedSize);
        this.fixedSize = new FixedSizeImpl(fixedSize ? FixedSize.True : FixedSize.False);
        attrs.add(this.fixedSize);
        return (T) this;
    }

    public T width(double width) {
        check(this.width);
        this.width = new WidthImpl(width);
        attrs.add(this.width);
        return (T) this;
    }

    public T height(double height) {
        check(this.height);
        this.height = new HeightImpl(height);
        attrs.add(this.height);
        return (T) this;
    }

    public T gradientAngle(int gradientAngle) {
        check(this.gradientAngle);
        this.gradientAngle = new GradientAngleImpl(gradientAngle);
        attrs.add(this.gradientAngle);
        return (T) this;
    }

    public T fontColor(String colorName) {
        check(this.fontColor);
        this.fontColor = new FontColorImpl(colorName);
        attrs.add(this.fontColor);
        return (T) this;
    }

    public T fontSize(double fontSize) {
        check(this.fontSize);
        this.fontSize = new FontSizeImpl(fontSize);
        attrs.add(this.fontSize);
        return (T) this;
    }

    public T margin(double x) {
        check(this.margin);
        this.margin = new MarginImpl(x);
        attrs.add(this.margin);
        return (T) this;
    }

    public T margin(double x, double y) {
        check(this.margin);
        this.margin = new MarginImpl(x, y);
        attrs.add(this.margin);
        return (T) this;
    }

    public T url(String u) {
        check(this.url);
        this.url = new UrlImpl(u);
        attrs.add(this.url);
        return (T) this;
    }

    // operation ==== end
}
