package os.jie.dot_java;

/**
 * It can be NodeId or Subgraph.
 * @author jie_huang
 *
 */
public class EdgeNode implements Statement {
    final NodeId nodeId;
    final Subgraph subgraph;

    public EdgeNode(NodeId id) {
        this.nodeId = id;
        this.subgraph = null;
    }

    public EdgeNode(Subgraph subgraph) {
        this.nodeId = null;
        this.subgraph = subgraph;
    }

    @Override
    public boolean toDot(DotWriter dw) {
        if (null != nodeId) {
            dw.append(nodeId.getValueString());
        } else {
            subgraph.toDot(dw);
        }
        return true;
    }
}
