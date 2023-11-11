package os.jie.dot_java;

import org.junit.jupiter.api.Test;

import os.jie.dot_java.html.text.Text;

public class TestSimpleCase extends TestBase {
    @Test
    public void case1() {
        Graph g = new Graph(true, true);
        g.addEdge(new Edge("a", "b").addNodeId("c"));

        generateDotAndSvg(g);
    }

    @Test
    public void case2() {
        Graph g = new Graph(true, true);
        g.addEdge(new Edge("a", "b"));
        g.addEdge(new Edge("a", "c"));
        g.addEdge(new Edge("b", "c").constraint(false));

        generateDotAndSvg(g);
    }

    @Test
    public void case3() {
        Graph g = new Graph(true, true);
        g.addNode(new Node("a").label(Text.newText("label a")));
        Text t = Text.newText("E=mc").add(Text.newText("2").superscript());
        g.addNode(new Node("b").label(t));
        g.addNode(new Node("c").label(Text.newText("strike").strike()));
        g.addEdge(new Edge("a", "b", "c"));
        generateDotAndSvg(g);
    }

    @Test
    public void nodeUrl() {
        Graph g = new Graph(true, true);
        g.addNode(new Node("apple").label("apple").url("http://www.apple.com"));
        g.addNode(new Node("google").label("google").url("http://www.google.com"));
        g.addNode(new Node("relative").label("relative").url("./fake_url"));
        g.addNode(new Node("escape").label("escape").url("./escape?q=abc\\N\\G"));
        g.addEdge(new Edge("apple", "google", "relative", "escape"));
        generateDotAndSvg(g);
    }

    /**
     * Test generate svg without dot file directly.
     */
    @Test
    public void helloWorld() {
        Digraph g = new Digraph(false);
        g.addEdge(new Edge("hello", "world"));
        generateSvg(g);
    }

    @Test
    public void stateMachine() {
        Graph g = new Graph(false, true, "finite_state_machine")
            .rankDir(RankDir.LEFT_RIGHT)
            .size(8, 5);
        g.addNodeAttrs().shape(Shape.DOUBLE_CIRCLE);
        g.addNode("LR_0", "LR_3", "LR_4", "LR_8");
        g.addNodeAttrs().shape(Shape.CIRCLE);

        g.addEdge(new Edge("LR_0", "LR_2").label("SS(B)"));
        g.addEdge(new Edge("LR_0", "LR_1").label("SS(S)"));
        g.addEdge(new Edge("LR_1", "LR_3").label("S($end)"));
        g.addEdge(new Edge("LR_2", "LR_6").label("SS(b)"));
        g.addEdge(new Edge("LR_2", "LR_5").label("SS(a)"));
        g.addEdge(new Edge("LR_2", "LR_4").label("S(A)"));
        g.addEdge(new Edge("LR_5", "LR_7").label("S(b)"));
        g.addEdge(new Edge("LR_5", "LR_5").label("S(a)"));
        g.addEdge(new Edge("LR_6", "LR_6").label("S(b)"));
        g.addEdge(new Edge("LR_6", "LR_5").label("S(a)"));
        g.addEdge(new Edge("LR_7", "LR_8").label("S(b)"));
        g.addEdge(new Edge("LR_7", "LR_5").label("S(a)"));
        g.addEdge(new Edge("LR_8", "LR_6").label("S(b)"));
        g.addEdge(new Edge("LR_8", "LR_5").label("S(a)"));
        generateDotAndSvg(g);
    }
}
