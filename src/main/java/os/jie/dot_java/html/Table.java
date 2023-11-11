package os.jie.dot_java.html;

import java.util.ArrayList;
import java.util.List;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.html.attrs.AlignImpl;
import os.jie.dot_java.html.attrs.BgColorImpl;
import os.jie.dot_java.html.attrs.BorderImpl;
import os.jie.dot_java.html.attrs.CellBorderImpl;
import os.jie.dot_java.html.attrs.CellPaddingImpl;
import os.jie.dot_java.html.attrs.CellSpacingImpl;
import os.jie.dot_java.html.attrs.ColorImpl;
import os.jie.dot_java.html.attrs.ColumnsImpl;
import os.jie.dot_java.html.attrs.FixedSizeImpl;
import os.jie.dot_java.html.attrs.GradientAngleImpl;
import os.jie.dot_java.html.attrs.HeightImpl;
import os.jie.dot_java.html.attrs.HrefImpl;
import os.jie.dot_java.html.attrs.IdImpl;
import os.jie.dot_java.html.attrs.PortImpl;
import os.jie.dot_java.html.attrs.RowsImpl;
import os.jie.dot_java.html.attrs.SidesImpl;
import os.jie.dot_java.html.attrs.StyleImpl;
import os.jie.dot_java.html.attrs.TargetImpl;
import os.jie.dot_java.html.attrs.TitleImpl;
import os.jie.dot_java.html.attrs.ToolTipImpl;
import os.jie.dot_java.html.attrs.VerticalAlignImpl;
import os.jie.dot_java.html.attrs.WidthImpl;
import os.jie.dot_java.html.text.Font;

public class Table extends AbstractElemPack {
    public Table() {
        super("TABLE", false);
    }

    // Attributes ==== begin
    AlignImpl align;
    BgColorImpl bgColor;
    BorderImpl border;
    CellBorderImpl cellBorder;
    CellPaddingImpl cellPadding;
    CellSpacingImpl cellSpacing;
    ColorImpl color;
    ColumnsImpl columns;
    FixedSizeImpl fixedSize;
    GradientAngleImpl gradientAngle;
    HeightImpl height;
    HrefImpl href;
    IdImpl id;
    PortImpl port;
    RowsImpl rows;
    SidesImpl sides;
    StyleImpl style;
    TargetImpl target;
    TitleImpl title;
    ToolTipImpl toolTip;
    VerticalAlignImpl valign;
    WidthImpl width;
    // Attributes ==== end

    public Font font;

    // children ==== begin
    public List<TableRow> trRows;

    // children ==== end

    // Operation ==== begin
    public Table addRow(TableRow row) {
        if (null == trRows) {
            trRows = new ArrayList<TableRow>();
        }
        trRows.add(row);
        return this;
    }

    public Table addRow(TableDataCell cell0, TableDataCell... cells) {
        return addRow(new TableRow(cell0, cells));
    }

    public Table align(Align align) {
        check(this.align);
        this.align = new AlignImpl(align);
        attrs.add(this.align);
        return this;
    }

    public Table bgColor(Color color) {
        check(this.bgColor);
        this.bgColor = new BgColorImpl(color);
        attrs.add(this.bgColor);
        return this;
    }

    public Table bgColor(String colorName, String... colorNames) {
        check(this.bgColor);
        this.bgColor = new BgColorImpl(colorName, colorNames);
        attrs.add(this.bgColor);
        return this;
    }

    public Table border(int border) {
        check(this.border);
        this.border = new BorderImpl(border);
        attrs.add(this.border);
        return this;
    }

    public Table cellBorder(int cellBorder) {
        check(this.cellBorder);
        this.cellBorder = new CellBorderImpl(cellBorder);
        attrs.add(this.cellBorder);
        return this;
    }

    public Table cellPadding(int cellPadding) {
        check(this.cellPadding);
        this.cellPadding = new CellPaddingImpl(cellPadding);
        attrs.add(this.cellPadding);
        return this;
    }

    public Table cellSpacing(int cellSpacing) {
        check(this.cellSpacing);
        this.cellSpacing = new CellSpacingImpl(cellSpacing);
        attrs.add(this.cellSpacing);
        return this;
    }

    public Table style(Style style) {
        check(this.style);
        this.style = new StyleImpl(style);
        attrs.add(this.style);
        return this;
    }

    public Table gradientAngle(double gradientAngle) {
        check(this.gradientAngle);
        this.gradientAngle = new GradientAngleImpl(gradientAngle);
        attrs.add(this.gradientAngle);
        return this;
    }
    // Operation ==== end

    @Override
    public boolean toDot(DotWriter dw) {
        if (font != null) {
            font.headToHtml(dw);
        }
        super.toDot(dw);
        if (font != null) {
            font.tailToHtml(dw);
        }
        return true;
    }

    @Override
    public void innerToDot(DotWriter dw) {
        dw.indent();
        for (TableRow row : trRows) {
            if (row.hr) {
                dw.indentLine().append("<HR/>");
            }
            row.toDot(dw);
        }
        dw.unindent();
        dw.indentLine();
    }
}
