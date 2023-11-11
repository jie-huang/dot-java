package os.jie.dot_java;

import org.junit.jupiter.api.Test;

import os.jie.dot_java.Utils.Layout;

public class TestCluster extends TestBase {
    @Test
    public void clusterCase0() {
        Graph g = new Graph(false, true, "G");

        g.addNode(new Node("start").shape(Shape.MDIAMOND));
        g.addNode(new Node("end").shape(Shape.MSQUARE));
        g.addEdge(new Edge("start", "a0"));
        g.addEdge(new Edge("start", "b0"));
        g.addEdge(new Edge("a1", "b3"));
        g.addEdge(new Edge("b2", "a3"));
        g.addEdge(new Edge("a3", "a0"));
        g.addEdge(new Edge("a3", "end"));
        g.addEdge(new Edge("b3", "end"));

        Cluster cluster_0 = new Cluster("cluster_0").style(ClusterStyle.FILLED).color("lightgrey").label("process #1");
        cluster_0.addEdge(new Edge("a0", "a1", "a2", "a3"));
        cluster_0.addNodeAttrs().style(NodeStyle.FILLED).color("white");
        g.addCluster(cluster_0);

        Cluster cluster_1 = new Cluster("cluster_1").color("blue").label("process #2");
        cluster_1.addEdge(new Edge("b0", "b1", "b2", "b3"));
        cluster_1.addNodeAttrs().style(NodeStyle.FILLED);
        g.addCluster(cluster_1);

        generateDotAndSvg(g);
    }

    @Test
    public void clusterCase1() {
        Graph g = new Graph(false, "G");
        g.addNode("e");
        g.addCluster(new Cluster("clusterA").addEdge("a", "b").addCluster(new Cluster("clusterC").addEdge("C", "D")));
        g.addCluster(new Cluster("clusterB").addEdge("d", "f"));
//        g.addEdge(new Edge("d", "D"));
        g.addEdge("d", "D");
        g.addEdge("e", "clusterB");
        g.addEdge("clusterC", "clusterB");

        generateDotAndSvg(Layout.fdp, g);
    }
}
