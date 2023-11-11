package os.jie.dot_java;

import org.junit.jupiter.api.Test;

public class TestStyle extends TestBase {
    @Test
    public void edgeStyle0() {
        Graph g = new Graph(true, true);
        g.addEdge(new Edge("a", "b").style(EdgeStyle.BOLD));
        g.addEdge(new Edge("b", "c").style(EdgeStyle.DASHED));

        generateDotAndSvg(g);
    }

    @Test
    public void edgeStyleArrow() {
        Graph g = new Graph(true, true);
        g.addEdge(new Edge("a", "b").style(EdgeStyle.TAPERED).arrowHead(ArrowType.EDIAMOND));
        g.addEdge(new Edge("b", "c").style(EdgeStyle.DASHED).arrowHead(ArrowType.INVDOT).arrowTail(ArrowType.OBOX));

        generateDotAndSvg(g);
    }

    /**
     * This seems a bug of dot. It generate two edges between "a" and "d".
     */
    @Test
    public void constraintCrossClusters() {
        Graph g = new Digraph(true);
        g.addCluster(new Cluster("cluster_1")
            .addEdge("a", "b")
            .addEdge(new Edge("a", "c").constraint(false)));
        g.addCluster(new Cluster("cluster_2")
            .addNode("d"));
        g.addEdge(new Edge("a", "d").constraint(false).label("WARN: double lines here"));
        generateDotAndSvg(g);
    }
}
