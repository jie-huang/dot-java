package os.jie.dot_java.html;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Port;
import os.jie.dot_java.html.attrs.BreakAlignImpl;
import os.jie.dot_java.html.attrs.BgColorImpl;
import os.jie.dot_java.html.attrs.BorderImpl;
import os.jie.dot_java.html.attrs.CellPaddingImpl;
import os.jie.dot_java.html.attrs.CellSpacingImpl;
import os.jie.dot_java.html.attrs.ColumnSpanImpl;
import os.jie.dot_java.html.attrs.ColorImpl;
import os.jie.dot_java.html.attrs.FixedSizeImpl;
import os.jie.dot_java.html.attrs.GradientAngleImpl;
import os.jie.dot_java.html.attrs.HeightImpl;
import os.jie.dot_java.html.attrs.HrefImpl;
import os.jie.dot_java.html.attrs.IdImpl;
import os.jie.dot_java.html.attrs.PortImpl;
import os.jie.dot_java.html.attrs.RowSpanImpl;
import os.jie.dot_java.html.attrs.SidesImpl;
import os.jie.dot_java.html.attrs.StyleImpl;
import os.jie.dot_java.html.attrs.TargetImpl;
import os.jie.dot_java.html.attrs.TableDataAlignImpl;
import os.jie.dot_java.html.attrs.TitleImpl;
import os.jie.dot_java.html.attrs.ToolTipImpl;
import os.jie.dot_java.html.attrs.VerticalAlignImpl;
import os.jie.dot_java.html.attrs.WidthImpl;
import os.jie.dot_java.html.text.Text;
import os.jie.dot_java.html.text.TextItem;

public class TableDataCell extends AbstractElemPack {
    // Attributes ==== begin
    TableDataAlignImpl align;
    BreakAlignImpl balign;
    BgColorImpl bgColor;
    BorderImpl border;
    CellPaddingImpl cellPadding;
    CellSpacingImpl cellSpacing;
    ColorImpl color;
    ColumnSpanImpl colSpan;
    FixedSizeImpl fixedSize;
    GradientAngleImpl gradientAngle;
    HeightImpl height;
    HrefImpl href;
    IdImpl id;
    PortImpl port;
    RowSpanImpl rowSpan;
    SidesImpl sides;
    StyleImpl style;
    TargetImpl target;
    TitleImpl title;
    ToolTipImpl toolTip;
    VerticalAlignImpl valign;
    WidthImpl width;
    // Attributes ==== end

    // children ==== begin
    public TextItem label;
    public Image image;

    // children ==== end

    // operations ==== begin
    public TableDataCell bgColor(String colorName, String... colorNames) {
        check(this.bgColor);
        this.bgColor = new BgColorImpl(colorName, colorNames);
        attrs.add(this.bgColor);
        return this;
    }

    public TableDataCell align(TableDataAlign align) {
        check(this.align);
        this.align = new TableDataAlignImpl(align);
        attrs.add(this.align);
        return this;
    }

    public TableDataCell colSpan(int colSpan) {
        check(this.colSpan);
        this.colSpan = new ColumnSpanImpl(colSpan);
        attrs.add(this.colSpan);
        return this;
    }

    public TableDataCell rowSpan(int rowSpan) {
        check(this.rowSpan);
        this.rowSpan = new RowSpanImpl(rowSpan);
        attrs.add(this.rowSpan);
        return this;
    }

    public TableDataCell port(String port) {
        check(this.port);
        this.port = new PortImpl(new Port(port));
        attrs.add(this.port);
        return this;
    }

    public TableDataCell border(int border) {
        check(this.border);
        this.border = new BorderImpl(border);
        attrs.add(this.border);
        return this;
    }

    public TableDataCell gradientAngle(double gradientAngle) {
        check(this.gradientAngle);
        this.gradientAngle = new GradientAngleImpl(gradientAngle);
        attrs.add(this.gradientAngle);
        return this;
    }

    public TableDataCell href(String href) {
        check(this.href);
        this.href = new HrefImpl(href);
        attrs.add(this.href);
        return this;
    }
    // operations ==== end

    /**
     * For &lt;VR/&gt;. For first TD, it must be false.
     */
    public boolean vr = false;

    /**
     * By force the constructor, there can only be two types of Td. Text or Img.
     * @param label (in): TextItem label
     */
    public TableDataCell(TextItem label) {
        super("TD", false);
        this.label = label;
    }

    public TableDataCell(Image image) {
        super("TD", false);
        this.image = image;
    }

    public TableDataCell(String label) {
        super("TD", false);
        this.label = Text.newText(label);
    }

    /**
     * Since the inner space is kept, we should NOT indent &lt;TD&gt; inner part.
     */
    @Override
    protected void innerToDot(DotWriter dw) {
        if (this.label != null) {
            dw.append(label.toHtml());
        } else if (this.image != null) {
            image.toDot(dw);
        } else {
            // do nothing
        }
    }
}
