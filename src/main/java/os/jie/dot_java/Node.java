package os.jie.dot_java;

public class Node extends NodeAttrs<Node> implements Statement {
    String id;

    public Node(String id) {
        this.id = id;
    }

    public NodeId getNodeId() {
        return new NodeId(this.id);
    }

    @Override
    public boolean toDot(DotWriter dw) {
        dw.indentLine().append(Utils.escapeDotId(id));
        attrsToDotAttribute(dw);
        return true;
    }
}
