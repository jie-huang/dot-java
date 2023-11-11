package os.jie.dot_java.attrs;

import os.jie.dot_java.Cluster;
import os.jie.dot_java.Edge;
import os.jie.dot_java.EdgeAttrs;
import os.jie.dot_java.GraphAttrs;
import os.jie.dot_java.Node;
import os.jie.dot_java.NodeAttrs;
import os.jie.dot_java.Subgraph;

public interface AbstractGraph<T extends AbstractGraph<T>> {
    public GraphAttrs<?> addGraphAttrs();

    public NodeAttrs<?> addNodeAttrs();

    public EdgeAttrs<?> addEdgeAttrs();

    public T addEdge(Edge edge);

    public T addNode(Node node);

    public T addSubgraph(Subgraph subgraph);

    public T addCluster(Cluster cluster);
}
