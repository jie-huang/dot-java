package os.jie.dot_java;

import os.jie.dot_java.html.attrs.HtmlAttrValue;

public class Port implements HtmlAttrValue {
    public final String portId;
    public final CompassPoint compassPoint;

    public Port(String portId) {
        this.portId = portId;
        this.compassPoint = null;
    }

    public Port(String portId, CompassPoint compassPoint) {
        this.portId = portId;
        this.compassPoint = compassPoint;
    }

    @Override
    public String getValueString() {
        if (compassPoint == null) {
            return portId;
        } else {
            return portId + ":" + compassPoint;
        }
    }
}
