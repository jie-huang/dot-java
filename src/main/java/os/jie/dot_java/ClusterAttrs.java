package os.jie.dot_java;

import os.jie.dot_java.attrs.ClusterStyleImpl;
import os.jie.dot_java.attrs.ColorImpl;
import os.jie.dot_java.attrs.FillColorImpl;
import os.jie.dot_java.attrs.FontColorImpl;
import os.jie.dot_java.attrs.GradientAngleImpl;
import os.jie.dot_java.attrs.LabelImpl;
import os.jie.dot_java.attrs.ShapeImpl;
import os.jie.dot_java.html.Table;
import os.jie.dot_java.html.text.Text;

@SuppressWarnings("unchecked")
public abstract class ClusterAttrs<T extends ClusterAttrs<T>> extends AttrList {
    // attributes ==== begin
    public LabelImpl label;
    public ShapeImpl shape;
    public ClusterStyleImpl style;
    public ColorImpl color;
    public FontColorImpl fontColor;
    public FillColorImpl fillColor;
    public GradientAngleImpl gradientAngle;

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

    public T style(ClusterStyle style) {
        check(this.style);
        this.style = new ClusterStyleImpl(style);
        attrs.add(this.style);
        return (T) this;
    }

    public T color(String color) {
        check(this.color);
        this.color = new ColorImpl(color);
        attrs.add(this.color);
        return (T) this;
    }

    public T fontColor(String colorName) {
        check(this.fontColor);
        this.fontColor = new FontColorImpl(colorName);
        attrs.add(this.fontColor);
        return (T) this;
    }

    public T fillColor(String colorName, String... colorNames) {
        check(this.fillColor);
        this.fillColor = new FillColorImpl(colorName, colorNames);
        attrs.add(this.fillColor);
        return (T) this;
    }

    public T gradientAngle(int gradientAngle) {
        check(this.gradientAngle);
        this.gradientAngle = new GradientAngleImpl(gradientAngle);
        attrs.add(this.gradientAngle);
        return (T) this;
    }
    // operation ==== end
}
