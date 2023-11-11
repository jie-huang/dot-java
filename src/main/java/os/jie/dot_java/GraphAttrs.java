package os.jie.dot_java;

import os.jie.dot_java.attrs.BgColorImpl;
import os.jie.dot_java.attrs.CenterImpl;
import os.jie.dot_java.attrs.FontColorImpl;
import os.jie.dot_java.attrs.FontNameImpl;
import os.jie.dot_java.attrs.FontSizeImpl;
import os.jie.dot_java.attrs.GradientAngleImpl;
import os.jie.dot_java.attrs.GraphStyleImpl;
import os.jie.dot_java.attrs.LabelImpl;
import os.jie.dot_java.attrs.LabelLocImpl;
import os.jie.dot_java.attrs.OverlapImpl;
import os.jie.dot_java.attrs.RankDirImpl;
import os.jie.dot_java.attrs.RatioImpl;
import os.jie.dot_java.attrs.SizeImpl;
import os.jie.dot_java.attrs.SplinesImpl;
import os.jie.dot_java.html.Table;
import os.jie.dot_java.html.text.Text;

@SuppressWarnings("unchecked")
public class GraphAttrs<T extends GraphAttrs<T>> extends AttrList {
    // attributes ==== begin
    public LabelImpl label;
    public FontSizeImpl fontSize;
    public LabelLocImpl labelLoc;
    public SplinesImpl splines;
    public OverlapImpl overlap;
    public RankDirImpl rankdir;
    public RatioImpl ratio;
    public BgColorImpl bgColor;
    public FontColorImpl fontColor;
    public GraphStyleImpl style;
    public CenterImpl center;
    public SizeImpl size;
    public GradientAngleImpl gradientAngle;
    public FontNameImpl fontName;
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

    public T fontSize(double fontSize) {
        check(this.fontSize);
        this.fontSize = new FontSizeImpl(fontSize);
        attrs.add(this.fontSize);
        return (T) this;
    }

    public T labelLoc(LabelLoc labelLoc) {
        check(this.labelLoc);
        this.labelLoc = new LabelLocImpl(labelLoc);
        attrs.add(this.labelLoc);
        return (T) this;
    }

    public T splines(Splines splines) {
        check(this.splines);
        this.splines = new SplinesImpl(splines);
        attrs.add(this.splines);
        return (T) this;
    }

    public T overlap(Overlap overlap) {
        check(this.overlap);
        this.overlap = new OverlapImpl(overlap);
        attrs.add(this.overlap);
        return (T) this;
    }

    public T overlap(boolean overlap) {
        check(this.overlap);
        this.overlap = new OverlapImpl(new Overlap(overlap));
        attrs.add(this.overlap);
        return (T) this;
    }

    public T rankDir(RankDir rankdir) {
        check(this.rankdir);
        this.rankdir = new RankDirImpl(rankdir);
        attrs.add(this.rankdir);
        return (T) this;
    }

    public T ratio(double ratio) {
        check(this.ratio);
        this.ratio = new RatioImpl(new Ratio(ratio));
        attrs.add(this.ratio);
        return (T) this;
    }

    public T ratio(Ratio.Constants type) {
        check(this.ratio);
        this.ratio = new RatioImpl(new Ratio(type));
        attrs.add(this.ratio);
        return (T) this;
    }

    public T bgColor(String colorName, String...colorNames) {
        check(this.bgColor);
        this.bgColor = new BgColorImpl(colorName, colorNames);
        attrs.add(this.bgColor);
        return (T) this;
    }

    public T fontColor(String colorName) {
        check(this.fontColor);
        this.fontColor = new FontColorImpl(colorName);
        attrs.add(this.fontColor);
        return (T) this;
    }

    public T style(GraphStyle style, GraphStyle...styles) {
        check(this.style);
        this.style = new GraphStyleImpl(style, styles);
        attrs.add(this.style);
        return (T) this;
    }

    public T center(boolean center) {
        check(this.center);
        this.center = new CenterImpl(center);
        attrs.add(this.center);
        return (T) this;
    }

    public T size(double size) {
        check(this.size);
        this.size = new SizeImpl(false, size);
        attrs.add(this.size);
        return (T) this;
    }

    public T size(double width, double height) {
        check(this.size);
        this.size = new SizeImpl(false, width, height);
        attrs.add(this.size);
        return (T) this;
    }

    public T size(double width, double height, boolean fixed) {
        check(this.size);
        this.size = new SizeImpl(fixed, width, height);
        attrs.add(this.size);
        return (T) this;
    }

    public T gradientAngle(int gradientAngle) {
        check(this.gradientAngle);
        this.gradientAngle = new GradientAngleImpl(gradientAngle);
        attrs.add(this.gradientAngle);
        return (T) this;
    }

    public T fontName(String fontName) {
        check(this.fontName);
        this.fontName = new FontNameImpl(fontName);
        attrs.add(this.fontName);
        return (T) this;
    }
    // operations ==== end
}
