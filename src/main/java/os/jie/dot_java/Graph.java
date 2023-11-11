package os.jie.dot_java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

import os.jie.dot_java.attrs.AbstractGraph;
import os.jie.dot_java.attrs.AbstractGraphImpl;

/**
 * Ref: <a href="http://graphviz.org/content/dot-language">http://graphviz.org/content/dot-language</a>
 * This is the main entry to construct a graph.
 * @author jie_huang
 *
 */
public class Graph extends GraphAttrs<Graph> implements AbstractGraph<Graph> {
    final AbstractGraphImpl delegate;

    public final boolean strict;

    public final boolean directional;

    public Graph(String id) {
        this(false, false, id);
    }

    public Graph(boolean strict) {
        this(strict, false, null);
    }

    public Graph(boolean strict, String id) {
        this(strict, false, id);
    }

    public Graph(boolean strict, boolean directional) {
        this(strict, directional, null);
    }

    public Graph(boolean strict, boolean directional, String id) {
        this.strict = strict;
        this.directional = directional;
        delegate = new AbstractGraphImpl(id);
    }

    public String toDot() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024 * 1024);
        DotWriter dw = new DotWriter(baos);
        toDot(dw);
        dw.close();
        return baos.toString();
    }

    public void toDot(String fileName) throws FileNotFoundException {
        DotWriter dw = new DotWriter(new File(fileName));
        toDot(dw);
        dw.close();
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
    public Graph addEdge(Edge edge) {
        delegate.addEdge(edge);
        return this;
    }

    public Graph addEdge(String fromNodeId, String toNodeId, String...toNodeIds) {
        delegate.addEdge(new Edge(fromNodeId, toNodeId, toNodeIds));
        return this;
    }

    public Graph addEdge(NodeId fromNode, NodeId toNode, NodeId...toNodes) {
        delegate.addEdge(new Edge(fromNode, toNode, toNodes));
        return this;
    }

    public Graph addEdge(Node fromNode, Node toNode, Node...toNodes) {
        String[] ids = new String[toNodes.length];
        for (int i = 0; i < toNodes.length; ++i) {
            ids[i] = toNodes[i].id;
        }
        delegate.addEdge(new Edge(fromNode.id, toNode.id, ids));
        return this;
    }

    @Override
    public Graph addNode(Node node) {
        delegate.addNode(node);
        return this;
    }

    public Graph addNode(String nodeId, String... nodeIds) {
        delegate.addNode(new Node(nodeId));
        for (int i = 0; i < nodeIds.length; ++i) {
            delegate.addNode(new Node(nodeIds[i]));
        }
        return this;
    }

    @Override
    public Graph addSubgraph(Subgraph subgraph) {
        delegate.addSubgraph(subgraph);
        return this;
    }

    @Override
    public Graph addCluster(Cluster cluster) {
        delegate.addCluster(cluster);
        return this;
    }

    public void toDot(DotWriter dw) {
        dw.directional = directional;
        String type = strict ? (directional ? "strict digraph" : "strict graph") : (directional ? "digraph" : "graph");
        delegate.headToDot(dw, type);
        dw.indent();
        boolean written = attrsToDotStatement(dw);
        delegate.bodyToDot(dw, written);
        dw.unindent();
        dw.indentLine().append('}').println(); // cannot have ';' at the end of 'graph'.
    }
}
