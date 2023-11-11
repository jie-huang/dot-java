package os.jie.dot_java;

import java.util.ArrayList;
import java.util.List;

public class Edge extends EdgeAttrs<Edge> implements Statement {
    public final EdgeNode fromId; // It can be node Id or subgraph id.

    /**
     * Since the direction of edge ("--" / "-&gt;") must match to graph, it is redundant information.
     * So, there is no need for EdgeRhs.
     */
    public final List<EdgeNode> links = new ArrayList<EdgeNode>();

    // operations ==== begin
    public Edge addNodeId(EdgeNode toId) {
        this.links.add(toId);
        return this;
    }

    public Edge addNodeId(String nodeId) {
        this.links.add(new EdgeNode(new NodeId(nodeId)));
        return this;
    }

    public Edge addSubgraph(Subgraph subgraph) {
        this.links.add(new EdgeNode(subgraph));
        return this;
    }

    // operations ==== end
    public Edge(EdgeNode fromId, EdgeNode toId) {
        this.fromId = fromId;
        this.links.add(toId);
    }

    public Edge(NodeId fromId, NodeId toId, NodeId... toIds) {
        this.fromId = new EdgeNode(fromId);
        this.links.add(new EdgeNode(toId));
        for (int n = 0; n < toIds.length; ++n) {
            this.links.add(new EdgeNode(toIds[n]));
        }
    }

    public Edge(String fromId, String toId, String... toIds) {
        this.fromId = new EdgeNode(new NodeId(fromId));
        this.links.add(new EdgeNode(new NodeId(toId)));
        for (int n = 0; n < toIds.length; ++n) {
            this.links.add(new EdgeNode(new NodeId(toIds[n])));
        }
    }

    @Override
    public boolean toDot(DotWriter dw) {
        dw.indentLine();
        fromId.toDot(dw);
        for (EdgeNode link : links) {
            dw.append(dw.directional ? " -> " : " -- ");
            link.toDot(dw);
        }
        attrsToDotAttribute(dw);
        dw.append(';');
        return true;
    }
}
