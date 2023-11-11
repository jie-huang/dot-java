package os.jie.dot_java;

import os.jie.dot_java.attrs.AbstractGraph;
import os.jie.dot_java.attrs.AbstractGraphImpl;

public class Cluster extends ClusterAttrs<Cluster> implements AbstractGraph<Cluster>, Statement {
    final AbstractGraphImpl delegate;

    public static final String CLUSTER_PREFIX = "cluster";

    public Cluster(String id) {
        delegate = new AbstractGraphImpl(id);
        if ((id.length() > CLUSTER_PREFIX.length()) && id.startsWith(CLUSTER_PREFIX)) {
            // do nothing
        } else {
            throw new RuntimeException("Cluster id must begin with '" + CLUSTER_PREFIX + "'");
        }
    }

    @Override
    public GraphAttrs<?> addGraphAttrs() {
        return delegate.addGraphAttrs();
    }

    @Override
    public NodeAttrs<?> addNodeAttrs() {
        return delegate.addNodeAttrs();
    }

    @Override
    public EdgeAttrs<?> addEdgeAttrs() {
        return delegate.addEdgeAttrs();
    }

    @Override
    public Cluster addEdge(Edge edge) {
        delegate.addEdge(edge);
        return this;
    }

    public Cluster addEdge(String fromNodeId, String toNodeId, String...toNodeIds) {
        delegate.addEdge(new Edge(fromNodeId, toNodeId, toNodeIds));
        return this;
    }

    @Override
    public Cluster addNode(Node node) {
        delegate.addNode(node);
        return this;
    }

    public Cluster addNode(String nodeId) {
        delegate.addNode(new Node(nodeId));
        return this;
    }

    @Override
    public Cluster addSubgraph(Subgraph subgraph) {
        delegate.addSubgraph(subgraph);
        return this;
    }

    @Override
    public Cluster addCluster(Cluster cluster) {
        delegate.addCluster(cluster);
        return this;
    }

    @Override
    public boolean toDot(DotWriter dw) {
        delegate.headToDot(dw, "subgraph");
        dw.indent();
        boolean written = attrsToDotStatement(dw);
        delegate.bodyToDot(dw, written);
        dw.unindent();
        dw.indentLine().append('}'); // no ';' at end of cluster.
        return true;
    }
}
