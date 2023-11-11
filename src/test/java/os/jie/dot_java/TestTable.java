package os.jie.dot_java;

import org.junit.jupiter.api.Test;

import os.jie.dot_java.html.Table;
import os.jie.dot_java.html.TableDataCell;
import os.jie.dot_java.html.TableDataAlign;
import os.jie.dot_java.html.TableRow;
import os.jie.dot_java.html.text.Text;

public class TestTable extends TestBase {
    @Test
    public void tableCase0() {
        Digraph g = new Digraph(false, "g");
        g.addGraphAttrs().fontSize(30).labelLoc(LabelLoc.TOP).splines(Splines.spline).overlap(false).rankDir(RankDir.LEFT_RIGHT);
        g.ratio(Ratio.Constants.AUTO);

        g.addNode(new Node("state0").style(NodeStyle.FILLED, NodeStyle.BOLD).penWidth(5).fillColor("white").fontName("Courier New").shape(Shape.MRECORD)
            .label(new Table().border(0).cellBorder(0).cellPadding(3).bgColor("white")
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #0").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(0) s -> •e $")).align(TableDataAlign.LEFT).port("r0")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(1) e -> •l '=' r")).align(TableDataAlign.LEFT).port("r1")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(2) e -> •r")).align(TableDataAlign.LEFT).port("r2")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(3) l -> •'*' r")).align(TableDataAlign.LEFT).port("r3")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(4) l -> •'n'")).align(TableDataAlign.LEFT).port("r4")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(5) r -> •l")).align(TableDataAlign.LEFT).port("r5")))
            ));

        g.addNode(new Node("state1").style(NodeStyle.FILLED).penWidth(1).fillColor("white").fontName("Courier New").shape(Shape.MRECORD)
            .label(new Table().border(0).cellBorder(0).cellPadding(3).bgColor("white")
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #1").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(3) l -> •'*' r")).align(TableDataAlign.LEFT).port("r3")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(3) l -> '*' •r")).align(TableDataAlign.LEFT).port("r3")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(4) l -> •'n'")).align(TableDataAlign.LEFT).port("r4")))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(5) r -> •l")).align(TableDataAlign.LEFT).port("r5")))
            ));

        g.addNode(new Node("state2")
            .style(NodeStyle.FILLED)
            .penWidth(1)
            .fillColor("white")
            .fontName("Courier New")
            .shape(Shape.MRECORD)
            .label(
                new Table()
                    .border(0)
                    .cellBorder(0)
                    .cellPadding(3)
                    .bgColor("white")
                    .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #2").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                    .addRow(
                        new TableRow().addCell(new TableDataCell(Text.newText("(4) l -> 'n' •")).align(TableDataAlign.LEFT).port("r4")).addCell(
                            new TableDataCell("=$").bgColor("grey").align(TableDataAlign.RIGHT)))
            ));

        g.addNode(new Node("state3").style(NodeStyle.FILLED).penWidth(1).fillColor("white").fontName("Courier New").shape(Shape.MRECORD).label(
            new Table()
                .border(0).cellBorder(0).cellPadding(3).bgColor("white")
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #3").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell("(5) r -> l •").align(TableDataAlign.LEFT).port("r5")).addCell(new TableDataCell("=$").bgColor("grey").align(TableDataAlign.RIGHT)))
            ));

        g.addNode(new Node("state4").style(NodeStyle.FILLED).penWidth(1).fillColor("white").fontName("Courier New").shape(Shape.MRECORD).label(
            new Table()
                .border(0).cellBorder(0).cellPadding(3).bgColor("white")
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #4").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell("(3) l -> '*' r •").align(TableDataAlign.LEFT).port("r3")).addCell(new TableDataCell("=$").bgColor("grey").align(TableDataAlign.RIGHT)))
            ));

        g.addNode(new Node("state5").style(NodeStyle.FILLED).penWidth(1).fillColor("black").fontName("Courier New").shape(Shape.MRECORD).label(
            new Table()
                .border(0).cellBorder(0).cellPadding(3).bgColor("black")
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #5").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("(0) s -> e •$").font("white")).align(TableDataAlign.LEFT).port("r0")))
            ));

        g.addNode(new Node("state6").style(NodeStyle.FILLED).penWidth(1).fillColor("white").fontName("Courier New").shape(Shape.MRECORD).label(
            new Table()
                .border(0).cellBorder(0).cellPadding(3).bgColor("white")
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #6").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell("(1) e -> l •'=' r").align(TableDataAlign.LEFT).port("r1")))
                .addRow(new TableRow().addCell(new TableDataCell("(5) r -> l •").align(TableDataAlign.LEFT).port("r5")).addCell(new TableDataCell("$").bgColor("grey").align(TableDataAlign.RIGHT)))
            ));

        g.addNode(new Node("state7").style(NodeStyle.FILLED).penWidth(1).fillColor("white").fontName("Courier New").shape(Shape.MRECORD).label(
            new Table()
                .border(0).cellBorder(0).cellPadding(3).bgColor("white")
                .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #7").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell("(1) e -> l '=' •r").align(TableDataAlign.LEFT).port("r1")))
                .addRow(new TableRow().addCell(new TableDataCell("(3) l -> •'*' r").align(TableDataAlign.LEFT).port("r3")))
                .addRow(new TableRow().addCell(new TableDataCell("(4) l -> •'n'").align(TableDataAlign.LEFT).port("r4")))
                .addRow(new TableRow().addCell(new TableDataCell("(5) r -> •l").align(TableDataAlign.LEFT).port("r5")))
            ));

        g.addNode(new Node("state8")
            .style(NodeStyle.FILLED)
            .penWidth(1)
            .fillColor("white")
            .fontName("Courier New")
            .shape(Shape.MRECORD)
            .label(
                new Table()
                    .border(0)
                    .cellBorder(0)
                    .cellPadding(3)
                    .bgColor("white")
                    .addRow(new TableRow().addCell(new TableDataCell(Text.newText("State #8").font("white")).bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                    .addRow(
                        new TableRow().addCell(new TableDataCell("(1) e -> l '=' r •").align(TableDataAlign.LEFT).port("r1")).addCell(new TableDataCell("$").bgColor("grey").align(TableDataAlign.RIGHT)))
            ));

        g.addNode(new Node("state9").style(NodeStyle.FILLED).penWidth(1).fillColor("white").fontName("Courier New").shape(Shape.MRECORD).label(
            new Table()
                .border(0).cellBorder(0).cellPadding(3).bgColor("white")
                .addRow(new TableRow().addCell(new TableDataCell("State #9").bgColor("black").align(TableDataAlign.CENTER).colSpan(2)))
                .addRow(new TableRow().addCell(new TableDataCell("(2) e -> r •").align(TableDataAlign.LEFT).port("r2")).addCell(new TableDataCell("$").bgColor("grey").align(TableDataAlign.RIGHT)))
            ));

        g.addEdge(new Edge("state0", "state5").penWidth(5).fontSize(28).fontColor("black").label("e"));
        g.addEdge(new Edge("state0", "state6").penWidth(5).fontSize(28).fontColor("black").label("l"));
        g.addEdge(new Edge("state0", "state9").penWidth(5).fontSize(28).fontColor("black").label("r"));
        g.addEdge(new Edge("state0", "state1").penWidth(1).fontSize(14).fontColor("grey28").label("'*'"));
        g.addEdge(new Edge("state0", "state2").penWidth(1).fontSize(14).fontColor("grey28").label("'n'"));
        g.addEdge(new Edge("state1", "state1").penWidth(1).fontSize(14).fontColor("grey28").label("'*'"));
        g.addEdge(new Edge("state1", "state4").penWidth(5).fontSize(28).fontColor("black").label("r"));
        g.addEdge(new Edge("state1", "state2").penWidth(1).fontSize(14).fontColor("grey28").label("'n'"));
        g.addEdge(new Edge("state1", "state3").penWidth(5).fontSize(28).fontColor("black").label("l"));
        g.addEdge(new Edge("state6", "state7").penWidth(1).fontSize(14).fontColor("grey28").label("'='"));
        g.addEdge(new Edge("state7", "state8").penWidth(5).fontSize(28).fontColor("black").label("r"));
        g.addEdge(new Edge("state7", "state1").penWidth(1).fontSize(14).fontColor("grey28").label("'*'"));
        g.addEdge(new Edge("state7", "state2").penWidth(1).fontSize(14).fontColor("grey28").label("'n'"));
        g.addEdge(new Edge("state7", "state3").penWidth(5).fontSize(28).fontColor("black").label("l"));
        generateDotAndSvg(g);
    }

    @Test
    public void tableHref() {
        Digraph g = new Digraph(false, "g");
        g.addNode(new Node("node_1").shape(Shape.NONE).label(
            new Table().border(0).cellBorder(1).cellPadding(2).cellSpacing(0)
            .addRow(new TableRow().addCell(new TableDataCell(Text.newText("www.apple.com").underline()).href("http://www.apple.com")))
            .addRow(new TableRow().addCell(new TableDataCell("tableCase0.svg").href("./tableCase0.svg")))));
        generateDotAndSvg(g);
    }
}
