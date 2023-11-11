package os.jie.dot_java;

import org.junit.jupiter.api.Test;

import os.jie.dot_java.Utils.Layout;

public class TestNeato extends TestBase {
    @Test
    public void neatoCase1() {
        Graph g = new Graph(false, "ER");
        Node course = new Node("course").shape(Shape.BOX);
        g.addNode(course);
        g.addNode(new Node("institute").shape(Shape.BOX));
        Node student = new Node("student").shape(Shape.BOX);
        g.addNode(student);
        Node name0 = new Node("name0").shape(Shape.ELLIPSE).label("name");
        g.addNode(name0);
        g.addNode(new Node("name1").shape(Shape.ELLIPSE).label("name"));
        Node name2 = new Node("name2").shape(Shape.ELLIPSE).label("name");
        g.addNode(name2);
        Node code = new Node("code").shape(Shape.ELLIPSE);
        g.addNode(code);
        Node grade = new Node("grade").shape(Shape.ELLIPSE);
        g.addNode(grade);
        Node number = new Node("number").shape(Shape.ELLIPSE);
        g.addNode(number);
        g.addNode(new Node("C-I").shape(Shape.DIAMOND).style(NodeStyle.FILLED).color("lightgrey"));
        g.addNode(new Node("S-C").shape(Shape.DIAMOND).style(NodeStyle.FILLED).color("lightgrey"));
        g.addNode(new Node("S-I").shape(Shape.DIAMOND).style(NodeStyle.FILLED).color("lightgrey"));

        g.addEdge(name0, course);
        g.addEdge(code, course);
        g.addEdge(new Edge("course", "C-I").label("n").len(1.00));
        g.addEdge(new Edge("C-I", "institute").label("1").len(1.00));
        g.addEdge("institute", "name1");

        g.addEdge(new Edge("institute", "S-I").label("1").len(1.00));
        g.addEdge(new Edge("S-I", "student").label("n").len(1.00));
        g.addEdge(student, grade);
        g.addEdge(student, name2);
        g.addEdge(student, number);
        g.addEdge(new Edge("student", "S-C").label("m").len(1.00));
        g.addEdge(new Edge("S-C", "course").label("n").len(1.00));

        g.label("\n\nEntity Relation Diagram\ndrawn by NEATO");
        g.fontSize(20);

        generateDotAndSvg(Layout.neato, g);
    }

    @Test
    public void process() {
        Graph g = new Graph(false, "G")
            .addEdge("run", "intr")
            .addEdge("intr", "runbl")
            .addEdge("runbl", "run")
            .addEdge("run", "kernel")
            .addEdge("kernel", "zombie")
            .addEdge("kernel", "sleep")
            .addEdge("kernel", "runmem")
            .addEdge("sleep", "swap")
            .addEdge("swap", "runswap")
            .addEdge("runswap", "new")
            .addEdge("runswap", "runmem")
            .addEdge("new", "runmem")
            .addEdge("sleep", "runmem");
        generateDotAndSvg(Layout.neato, g);
    }

    @Test
    public void philoDilemma() {
        Digraph g = new Digraph(false, "PhiloDilemma");
        g.overlap(false).fontSize(12).label("PetriNet Model PhiloDilemma\nExtracted from ConceptBase and layed out by Graphviz ");
        g.addNodeAttrs().shape(Shape.BOX);
        g.addNode("bec3");
        g.addNode("rel3");
        g.addNode("bec2");
        g.addNode("rel2");
        g.addNode("acq2");
        g.addNode("acq3");
        g.addNode("bec1");
        g.addNode("rel1");
        g.addNode("acq1");
        g.addNodeAttrs().shape(Shape.CIRCLE).fixedSize(FixedSize.True).width(0.9);
        g.addNode("hu3");
        g.addNode("th3");
        g.addNode("ri3");
        g.addNode("ea3");
        g.addNode("hu2");
        g.addNode("th2");
        g.addNode("ri2");
        g.addNode("ea2");
        g.addNode("hu1");
        g.addNode("th1");
        g.addNode("ri1");
        g.addNode("ea1");
        g.addEdge("ri3", "acq2");
        g.addEdge("ri3", "acq3");
        g.addEdge("hu3", "acq3");
        g.addEdge("bec3", "hu3");
        g.addEdge("th3", "bec3");
        g.addEdge("rel3", "th3");
        g.addEdge("rel3", "ri3");
        g.addEdge("ea3", "rel3");
        g.addEdge("acq3", "ea3");
        g.addEdge("ri2", "acq1");
        g.addEdge("ri2", "acq2");
        g.addEdge("hu2", "acq2");
        g.addEdge("bec2", "hu2");
        g.addEdge("th2", "bec2");
        g.addEdge("rel2", "th2");
        g.addEdge("rel2", "ri2");
        g.addEdge("ea2", "rel2");
        g.addEdge("acq2", "ea2");
        g.addEdge("ri1", "acq3");
        g.addEdge("ri1", "acq1");
        g.addEdge("hu1", "acq1");
        g.addEdge("bec1", "hu1");
        g.addEdge("th1", "bec1");
        g.addEdge("rel1", "th1");
        g.addEdge("rel1", "ri1");
        g.addEdge("ea1", "rel1");
        g.addEdge("acq1", "ea1");

        generateDotAndSvg(Layout.neato, g);
    }

    @Test
    public void trafficLights() {
        Graph g = new Graph(false, true, "TrafficLights");
        Node gy2 = new Node("gy2").shape(Shape.BOX);
        g.addNode(gy2);
        Node yr2 = new Node("yr2").shape(Shape.BOX);
        g.addNode(yr2);
        Node rg2 = new Node("rg2").shape(Shape.BOX);
        g.addNode(rg2);
        Node gy1 = new Node("gy1").shape(Shape.BOX);
        g.addNode(gy1);
        Node yr1 = new Node("yr1").shape(Shape.BOX);
        g.addNode(yr1);
        Node rg1 = new Node("rg1").shape(Shape.BOX);
        g.addNode(rg1);

        Node green2 = new Node("green2").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(green2);
        Node yellow2 = new Node("yellow2").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(yellow2);
        Node red2 = new Node("red2").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(red2);
        Node safe2 = new Node("safe2").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(safe2);
        Node safe1 = new Node("safe1").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(safe1);
        Node green1 = new Node("green1").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(green1);
        Node yellow1 = new Node("yellow1").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(yellow1);
        Node red1 = new Node("red1").shape(Shape.CIRCLE).fixedSize(FixedSize.False).width(0.9);
        g.addNode(red1);

        g.addEdge(gy2, yellow2);
        g.addEdge(rg2, green2);
        g.addEdge(yr2, safe1);
        g.addEdge(yr2, red2);
        g.addEdge(safe2, rg2);
        g.addEdge(green2, gy2);
        g.addEdge(yellow2, yr2);
        g.addEdge(red2, rg2);
        g.addEdge(gy1, yellow1);
        g.addEdge(rg1, green1);
        g.addEdge(yr1, safe2);
        g.addEdge(yr1, red1);
        g.addEdge(safe1, rg1);
        g.addEdge(green1, gy1);
        g.addEdge(yellow1, yr1);
        g.addEdge(red1, rg1);

        g.overlap(false)
            .label("PetriNet Model TrafficLights\nExtracted from ConceptBase and layed out by Graphviz")
            .fontSize(12);

        generateDotAndSvg(Layout.neato, g);
    }
}
