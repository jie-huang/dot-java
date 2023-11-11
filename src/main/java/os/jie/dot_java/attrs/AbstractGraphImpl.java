package os.jie.dot_java.attrs;

import java.util.ArrayList;
import java.util.List;

import os.jie.dot_java.Cluster;
import os.jie.dot_java.DotWriter;
import os.jie.dot_java.Edge;
import os.jie.dot_java.EdgeAttrs;
import os.jie.dot_java.GraphAttrs;
import os.jie.dot_java.Node;
import os.jie.dot_java.NodeAttrs;
import os.jie.dot_java.Statement;
import os.jie.dot_java.Subgraph;
import os.jie.dot_java.Utils;

public class AbstractGraphImpl {
    /**
     * Since the order of the added Statement is meaningful and affected by the default attributes,
     * we cannot group them.
     */
    List<Statement> stmts = new ArrayList<Statement>();

    public final String id;

    // operation ==== begin
    public GraphAttrs<?> addGraphAttrs() {
        GraphAttrsImpl graphAttrs = new GraphAttrsImpl();
        stmts.add(graphAttrs);
        return graphAttrs;
    }

    public NodeAttrs<?> addNodeAttrs() {
        NodeAttrsImpl nodeAttrs = new NodeAttrsImpl();
        stmts.add(nodeAttrs);
        return nodeAttrs;
    }

    public EdgeAttrs<?> addEdgeAttrs() {
        EdgeAttrsImpl edgeAttrs = new EdgeAttrsImpl();
        stmts.add(edgeAttrs);
        return edgeAttrs;
    }

    public void addEdge(Edge edge) {
        stmts.add(edge);
    }

    public void addNode(Node node) {
        stmts.add(node);
    }

    public void addSubgraph(Subgraph subgraph) {
        stmts.add(subgraph);
    }

    public void addCluster(Cluster cluster) {
        stmts.add(cluster);
    }

    // operation ==== end

    public AbstractGraphImpl(String id) {
        this.id = id;
    }

    public void headToDot(DotWriter dw, String type) {
        dw.indentLine();
        if (null == type) {
            dw.append("{");
        } else {
            dw.append(type);
            if (id != null) {
                dw.append(' ').append(Utils.escapeDotId(id));
            }
            dw.append(" {");
        }
    }

    public void tailToDot(DotWriter dw) {
        dw.indentLine().append("};");
    }

    public void bodyToDot(DotWriter dw, boolean written) {
        boolean prevStmtIsGroup = written;
        for (Statement stmt : stmts) {
            boolean currentStmtIsGroup = ((stmt instanceof Subgraph) || (stmt instanceof Cluster));
            if ((prevStmtIsGroup || currentStmtIsGroup) && dw.newlineBetweenGroup) {
                dw.println();
            }
            stmt.toDot(dw);
            prevStmtIsGroup = currentStmtIsGroup;
        }
    }
}
