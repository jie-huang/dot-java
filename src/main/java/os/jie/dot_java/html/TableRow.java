package os.jie.dot_java.html;

import java.util.ArrayList;
import java.util.List;

import os.jie.dot_java.DotWriter;

public class TableRow extends AbstractElemPack {
    public TableRow() {
        super("TR", false);
    }

    public TableRow(TableDataCell cell0, TableDataCell... cells) {
        super("TR", false);
        addCell(cell0);
        for (int i = 0; i < cells.length; ++i) {
            addCell(cells[i]);
        }
    }

    /**
     * For &lt;HR/&gt;. For first Tr, it must be false.
     */
    public boolean hr = false;

    // operations ==== begin
    public TableRow addCell(TableDataCell cell) {
        if (cells.isEmpty()) {
            cell.vr = false;
        }
        cells.add(cell);
        return this;
    }
    // operations ==== end

    // children ==== begin
    public List<TableDataCell> cells = new ArrayList<TableDataCell>();
    // children ==== end

    @Override
    public void innerToDot(DotWriter dw) {
        dw.indent();
        for (TableDataCell cell: cells) {
            if (cell.vr) {
                dw.indentLine().append("<VR/>");
            }
            cell.toDot(dw);
        }
        dw.unindent();
        dw.indentLine();
    }
}
