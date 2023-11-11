package os.jie.dot_java;

import org.junit.jupiter.api.Test;

import os.jie.dot_java.html.Style;
import os.jie.dot_java.html.Table;
import os.jie.dot_java.html.TableDataCell;
import os.jie.dot_java.html.TableRow;

public class TestColor extends TestBase {
    @Test
    public void colorCase0() {
        Digraph g = new Digraph(false, "G");
        g.bgColor("purple", "pink").label("agraph").fontColor("white");
        Cluster cluster1 = new Cluster("cluster1").fillColor("blue", "cyan").label("acluster").fontColor("white").style(ClusterStyle.FILLED).gradientAngle(270);
        cluster1.addNodeAttrs().shape(Shape.BOX).fillColor("red", "yellow").style(NodeStyle.FILLED).gradientAngle(90);
        cluster1.addNode("anode");
        g.addCluster(cluster1);

        generateDotAndSvg(g);
    }

    @Test
    public void colorCase1() {
        Digraph g = new Digraph(false, "G");
        g.bgColor("purple", "pink").style(GraphStyle.FILLED);

        Cluster cluster1 = new Cluster("cluster1").fillColor("blue", "green").style(ClusterStyle.FILLED);
        cluster1.addNodeAttrs().shape(Shape.CIRCLE).fillColor("gold", "brown").style(NodeStyle.RADIAL).gradientAngle(180);
        g.addCluster(cluster1);

        Node a0 = new Node("a0");
        cluster1.addNode(a0);

        Table table = new Table();
        table.border(10).cellSpacing(10).cellPadding(10).style(Style.ROUNDED).bgColor("yellow", "violet").gradientAngle(315);
        String[] colorList1 = { "yellow", "gold", "orange", "red", "brown" };
        String[] colorList2 = { "yellow", "green", "blue", "purple", "violet" };
        int k = 0;
        TableRow trHead = new TableRow();
        trHead.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(colorList2[0]).gradientAngle(315));
        for (int i = 0; i < colorList2.length - 1; ++i) {
            trHead.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(colorList2[i], colorList2[i + 1]).gradientAngle(315));
            trHead.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(colorList2[i + 1]).gradientAngle(315));
        }
        k = (k / 10 + 1) * 10;
        table.addRow(trHead);
        for (int i = 0; i < colorList1.length - 1; ++i) {
            String color1 = colorList1[i + 1];
            TableRow tr1 = new TableRow();
            tr1.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(colorList1[i], color1).gradientAngle(315));
            for (int j = 1; j < colorList2.length; ++j) {
                String color2 = colorList2[j];
                tr1.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(color1, color2).gradientAngle(315));
                tr1.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(color1, color2).gradientAngle(315));
            }
            k = (k / 10 + 1) * 10;
            table.addRow(tr1);

            TableRow tr2 = new TableRow();
            tr2.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(color1).gradientAngle(315));
            for (int j = 1; j < colorList2.length; ++j) {
                String color2 = colorList2[j];
                tr2.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(color1, color2).gradientAngle(315));
                tr2.addCell(new TableDataCell(String.format("%02d", k++)).border(3).bgColor(color1, color2).gradientAngle(315));
            }
            k = (k / 10 + 1) * 10;
            table.addRow(tr2);
        }
        a0.label(table);

        generateDotAndSvg(g);
    }

    @Test
    public void colorCase2() {
        Digraph g = new Digraph(false, "G");
        g.bgColor("blue");

        Cluster cluster_1 = new Cluster("cluster_1").fontColor("white");
        cluster_1.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.BOX).fillColor("antiquewhite", "aquamarine");
        cluster_1.addNode("n5");
        cluster_1.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.ELLIPSE).fillColor("bisque4", "blue2");
        cluster_1.addNode("n4");
        cluster_1.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.CIRCLE).fillColor("cadetblue1", "chocolate1");
        cluster_1.addNode("n3");
        cluster_1.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.DIAMOND).fillColor("crimson", "cyan4");
        cluster_1.addNode("n2");
        cluster_1.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.TRIANGLE).fillColor("deepskyblue2", "firebrick");
        cluster_1.addNode("n1");
        cluster_1.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.PENTAGON).fillColor("gray24", "gray88");
        cluster_1.addNode("n0");
        cluster_1.label("X11 Colors");
        g.addCluster(cluster_1);

        Cluster cluster_2 = new Cluster("cluster_2").fillColor("white");
        cluster_2.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.BOX).fillColor("bisque", "brown");
        cluster_2.addNode("n11");
        cluster_2.addNodeAttrs().shape(Shape.ELLIPSE).fillColor("green", "darkorchid");
        cluster_2.addNode("n10");
        cluster_2.addNodeAttrs().shape(Shape.CIRCLE).fillColor("deepskyblue", "gold");
        cluster_2.addNode("n9");
        cluster_2.addNodeAttrs().shape(Shape.DIAMOND).fillColor("lightseagreen", "orangered");
        cluster_2.addNode("n8");
        cluster_2.addNodeAttrs().shape(Shape.TRIANGLE).fillColor("turquoise", "salmon");
        cluster_2.addNode("n7");
        cluster_2.addNodeAttrs().shape(Shape.PENTAGON).fillColor("snow", "black");
        cluster_2.addNode("n6");
        cluster_2.label("SVG Colors");
        g.addCluster(cluster_2);

        Cluster cluster_3 = new Cluster("cluster_3").fontColor("white");
        cluster_3.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.BOX).fillColor("/accent3/1", "/accent3/3");
        cluster_3.addNode("n17");
        cluster_3.addNodeAttrs().shape(Shape.ELLIPSE).fillColor("/accent4/1", "/accent4/4");
        cluster_3.addNode("n16");
        cluster_3.addNodeAttrs().shape(Shape.CIRCLE).fillColor("/accent5/1", "/accent5/5");
        cluster_3.addNode("n15");
        cluster_3.addNodeAttrs().shape(Shape.DIAMOND).fillColor("/accent6/1", "/accent6/6");
        cluster_3.addNode("n14");
        cluster_3.addNodeAttrs().shape(Shape.TRIANGLE).fillColor("/accent7/1", "/accent7/7");
        cluster_3.addNode("n13");
        cluster_3.addNodeAttrs().shape(Shape.PENTAGON).fillColor("/accent8/1", "/accent8/8");
        cluster_3.addNode("n12");
        cluster_3.label("Brewer - accent");
        g.addCluster(cluster_3);

        Cluster cluster_4 = new Cluster("cluster_4").fontColor("white");
        cluster_4.addNodeAttrs().style(NodeStyle.FILLED).shape(Shape.BOX).fillColor("/blues3/1", "/blues3/2");
        cluster_4.addNode("n23");
        cluster_4.addNodeAttrs().shape(Shape.ELLIPSE).fillColor("/blues4/1", "/blues4/3");
        cluster_4.addNode("n22");
        cluster_4.addNodeAttrs().shape(Shape.CIRCLE).fillColor("/blues5/1", "/blues5/4");
        cluster_4.addNode("n21");
        cluster_4.addNodeAttrs().shape(Shape.DIAMOND).fillColor("/blues6/1", "/blues6/5");
        cluster_4.addNode("n20");
        cluster_4.addNodeAttrs().shape(Shape.TRIANGLE).fillColor("/blues7/1", "/blues7/6");
        cluster_4.addNode("n19");
        cluster_4.addNodeAttrs().shape(Shape.PENTAGON).fillColor("/blues8/1", "/blues8/7");
        cluster_4.addNode("n18");
        cluster_4.label("Brewer - blues");
        cluster_4.addEdge("n3", "n9", "n15", "n21");
        g.addCluster(cluster_4);

        generateDotAndSvg(g);
    }

    @Test
    public void switchNetwork() {
        Graph g = new Graph(false, true, "G");
        g.addGraphAttrs().center(true).rankDir(RankDir.LEFT_RIGHT).bgColor("#808080");
        g.addEdgeAttrs().dir(DirType.NONE);
        g.addNodeAttrs().width(0.3).height(0.3).label("");

        Subgraph sg1 = new Subgraph();
        sg1.addNodeAttrs().shape(Shape.CIRCLE).style(NodeStyle.INVIS);
        sg1.addNode("1", "2", "3", "4", "5", "6", "7", "8", "10", "20", "30", "40", "50", "60", "70", "80");
        g.addSubgraph(sg1);

        Subgraph sg2 = new Subgraph();
        sg2.addNodeAttrs().shape(Shape.CIRCLE);
        sg2.addNode("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x");
        g.addSubgraph(sg2);

        Subgraph sg3 = new Subgraph();
        sg3.addNodeAttrs().shape(Shape.DIAMOND);
        sg3.addNode("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X");
        g.addSubgraph(sg3);

        g.addEdge(new Edge("1", "a").addSubgraph(new Subgraph().addNode("A", "B")).color("#0000ff"));
        g.addEdge(new Edge("2", "b").addSubgraph(new Subgraph().addNode("B", "A")).color("#ff0000"));
        g.addEdge(new Edge("3", "c").addSubgraph(new Subgraph().addNode("C", "D")).color("#ffff00"));
        g.addEdge(new Edge("4", "d").addSubgraph(new Subgraph().addNode("D", "C")).color("#00ff00"));
        g.addEdge(new Edge("5", "e").addSubgraph(new Subgraph().addNode("E", "F")).color("#000000"));
        g.addEdge(new Edge("6", "f").addSubgraph(new Subgraph().addNode("F", "E")).color("#00ffff"));
        g.addEdge(new Edge("7", "g").addSubgraph(new Subgraph().addNode("G", "H")).color("#ffffff"));
        g.addEdge(new Edge("8", "h").addSubgraph(new Subgraph().addNode("H", "G")).color("#ff00ff"));

        Subgraph sg4 = new Subgraph();
        sg4.addEdgeAttrs().color("#ff0000", "#0000ff");
        sg4.addEdge(new Edge("A", "i").addSubgraph(new Subgraph().addNode("I", "K")));
        sg4.addEdge(new Edge("B", "j").addSubgraph(new Subgraph().addNode("J", "L")));
        g.addSubgraph(sg4);

        Subgraph sg5 = new Subgraph();
        sg5.addEdgeAttrs().color("#00ff00", "#ffff00");
        sg5.addEdge(new Edge("C", "k").addSubgraph(new Subgraph().addNode("K", "I")));
        sg5.addEdge(new Edge("D", "l").addSubgraph(new Subgraph().addNode("L", "J")));
        g.addSubgraph(sg5);

        Subgraph sg6 = new Subgraph();
        sg6.addEdgeAttrs().color("#00ffff", "#000000");
        sg6.addEdge(new Edge("E", "m").addSubgraph(new Subgraph().addNode("M", "O")));
        sg6.addEdge(new Edge("F", "n").addSubgraph(new Subgraph().addNode("N", "P")));
        g.addSubgraph(sg6);

        Subgraph sg7 = new Subgraph();
        sg7.addEdgeAttrs().color("#ff00ff", "#ffffff");
        sg7.addEdge(new Edge("G", "o").addSubgraph(new Subgraph().addNode("O", "M")));
        sg7.addEdge(new Edge("H", "p").addSubgraph(new Subgraph().addNode("P", "N")));
        g.addSubgraph(sg7);

        Subgraph sg8 = new Subgraph();
        sg8.addEdgeAttrs().color("#00ff00", "#ffff00", "#ff0000", "#0000ff");
        sg8.addEdge(new Edge("I", "q").addSubgraph(new Subgraph().addNode("Q", "U")));
        sg8.addEdge(new Edge("J", "r").addSubgraph(new Subgraph().addNode("R", "V")));
        sg8.addEdge(new Edge("K", "s").addSubgraph(new Subgraph().addNode("S", "W")));
        sg8.addEdge(new Edge("L", "t").addSubgraph(new Subgraph().addNode("T", "X")));
        g.addSubgraph(sg8);

        Subgraph sg9 = new Subgraph();
        sg9.addEdgeAttrs().color("#ff00ff", "#ffffff", "#00ffff", "#000000");
        sg9.addEdge(new Edge("M", "u").addSubgraph(new Subgraph().addNode("U", "Q")));
        sg9.addEdge(new Edge("N", "v").addSubgraph(new Subgraph().addNode("V", "R")));
        sg9.addEdge(new Edge("O", "w").addSubgraph(new Subgraph().addNode("W", "S")));
        sg9.addEdge(new Edge("P", "x").addSubgraph(new Subgraph().addNode("X", "T")));
        g.addSubgraph(sg9);

        Subgraph sg10 = new Subgraph();
        sg10.addEdgeAttrs().color("#ff00ff", "#ffffff", "#00ffff", "#000000", "#00ff00", "#ffff00", "#ff0000", "#0000ff");
        sg10.addEdge("Q", "10");
        sg10.addEdge("R", "20");
        sg10.addEdge("S", "30");
        sg10.addEdge("T", "40");
        sg10.addEdge("U", "50");
        sg10.addEdge("V", "60");
        sg10.addEdge("W", "70");
        sg10.addEdge("X", "80");
        g.addSubgraph(sg10);

        generateDotAndSvg(g);
    }

    @Test
    public void clusterColor() {
        Graph g = new Graph(false, true, "G").bgColor("red", "cyan").gradientAngle(0)
            .addCluster(new Cluster("cluster_0").style(ClusterStyle.FILLED).color("lightgrey").fillColor("blue", "yellow").gradientAngle(90)
                .addNode(new Node("a0").fillColor("yellow", "green").style(NodeStyle.FILLED).gradientAngle(270))
                .addNode(new Node("a1").fillColor("green", "red").style(NodeStyle.FILLED).gradientAngle(270))
                .addNode(new Node("a2").fillColor("red", "cyan").style(NodeStyle.FILLED).gradientAngle(270))
                .addNode(new Node("a2").fillColor("cyan", "blue").style(NodeStyle.FILLED).gradientAngle(270))
                .addEdge("a0", "a1", "a2", "a3")
                .label("process #1"))
            .addCluster(new Cluster("cluster_1")
                .addNode(new Node("b0").fillColor("yellow", "magenta").style(NodeStyle.FILLED).gradientAngle(270))
                .addNode(new Node("b1").fillColor("magenta", "cyan").style(NodeStyle.FILLED).gradientAngle(270))
                .addNode(new Node("b2").fillColor("cyan", "red").style(NodeStyle.FILLED).gradientAngle(270))
                .addNode(new Node("b3").fillColor("red", "blue").style(NodeStyle.FILLED).gradientAngle(270))
                .addEdge("b0", "b1", "b2", "b3")
                .label("process #2")
                .color("blue")
                .fillColor("blue", "yellow")
                .style(ClusterStyle.FILLED)
                .gradientAngle(90))
            .addEdge("start", "a0")
            .addEdge("start", "b0")
            .addEdge("a1", "b3")
            .addEdge("b2", "a3")
            .addEdge("a3", "a0")
            .addEdge("a3", "end")
            .addEdge("b3", "end")
            .addNode(new Node("start").shape(Shape.MDIAMOND).fillColor("yellow", "brown").gradientAngle(90).style(NodeStyle.RADIAL))
            .addNode(new Node("end").shape(Shape.MSQUARE).fillColor("orange", "blue").gradientAngle(90).style(NodeStyle.RADIAL));

        generateDotAndSvg(g);
    }

    @Test
    public void gradientAngle() {
        Cluster cluster_1 = new Cluster("cluster_1").fontColor("white").label("Linear Angle Variations (white to black gradient)");
        for (int n = 9; n > 0; --n) {
            String nodeId = "n" + n;
            int angle = 360 - (9 - n) * 45;
            String label = String.format("%s:% 3d", nodeId, angle);
            Node node = new Node(nodeId).shape(Shape.CIRCLE).style(NodeStyle.FILLED).fillColor("white", "black").gradientAngle(angle).label(label)
                .fontColor("black");
            cluster_1.addNode(node);
        }

        Cluster cluster_2 = new Cluster("cluster_2").fontColor("white").label("Radial Angle Variations (white to black gradient)");
        for (int n = 9; n > 0; --n) {
            String nodeId = "n" + (n + 9);
            int angle = 360 - (9 - n) * 45;
            String label = String.format("%s:% 3d", nodeId, angle);
            Node node = new Node(nodeId).shape(Shape.CIRCLE).style(NodeStyle.RADIAL).fillColor("white", "black").gradientAngle(angle).label(label)
                .fontColor("black");
            cluster_2.addNode(node);
        }

        Graph g = new Graph(false, true, "G").bgColor("blue")
            .addCluster(cluster_1)
            .addCluster(cluster_2)
            .addEdge("n5", "n14");

        generateDotAndSvg(g);
    }
}
