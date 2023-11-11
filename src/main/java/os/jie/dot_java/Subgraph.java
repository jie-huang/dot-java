package os.jie.dot_java;

import os.jie.dot_java.attrs.AbstractGraph;
import os.jie.dot_java.attrs.AbstractGraphImpl;

public class Subgraph extends SubgraphAttrs<Subgraph> implements AbstractGraph<Subgraph>, Statement {
    final AbstractGraphImpl delegate;

	public Subgraph() {
	    delegate = new AbstractGraphImpl(null);
	}

	public Subgraph(String id) {
        delegate = new AbstractGraphImpl(id);
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
    public Subgraph addEdge(Edge edge) {
        delegate.addEdge(edge);
        return this;
    }

    public Subgraph addEdge(String fromNodeId, String toNodeId, String...toNodeIds) {
        delegate.addEdge(new Edge(fromNodeId, toNodeId, toNodeIds));
        return this;
    }

    @Override
    public Subgraph addNode(Node node) {
        delegate.addNode(node);
        return this;
    }

    public Subgraph addNode(String nodeId, String... nodeIds) {
        delegate.addNode(new Node(nodeId));
        for (int i = 0; i < nodeIds.length; ++i) {
            delegate.addNode(new Node(nodeIds[i]));
        }
        return this;
    }

    @Override
    public Subgraph addSubgraph(Subgraph subgraph) {
        delegate.addSubgraph(subgraph);
        return this;
    }

    @Override
    public Subgraph addCluster(Cluster cluster) {
        delegate.addCluster(cluster);
        return this;
    }

    @Override
    public boolean toDot(DotWriter dw) {
        if (delegate.id == null) {
            // anonymous subgraph
            delegate.headToDot(dw, null);
        } else {
            delegate.headToDot(dw, "subgraph");
        }
        dw.indent();
        boolean written = attrsToDotStatement(dw);
        delegate.bodyToDot(dw, written);
        dw.unindent();
        dw.indentLine().append('}'); // no ';' at end of subgraph
        return true;
    }
}
