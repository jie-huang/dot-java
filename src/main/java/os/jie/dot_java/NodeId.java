package os.jie.dot_java;

import os.jie.dot_java.attrs.DotAttrValue;

public class NodeId implements DotAttrValue {
    public final String nodeId;
    public final Port port;

    public NodeId(String nodeId) {
        this.nodeId = nodeId;
        this.port = null;
    }

    public NodeId(String nodeId, String portId) {
        this.nodeId = nodeId;
        this.port = new Port(portId);
    }

    public NodeId(String nodeId, String portId, CompassPoint compassPoint) {
        this.nodeId = nodeId;
        this.port = new Port(portId, compassPoint);
    }

    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public String getValueString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.escapeDotId(nodeId));
        String s = null;
        if (null != port) {
            s = port.getValueString();
        }
        if (null != s) {
            sb.append(":").append(s);
        }
        return sb.toString();
    }
}
