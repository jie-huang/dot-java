package os.jie.dot_java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import os.jie.dot_java.Utils.Layout;

public class TestUtils {
    @Test
    public void escape0() {
        assertEquals("abc", Utils.escapeDotId("abc"));
        assertEquals("\"9abc\"", Utils.escapeDotId("9abc"));
        assertEquals("\"E-I\"", Utils.escapeDotId("E-I"));
        assertEquals("\"Node\"", Utils.escapeDotId("Node"));
    }

    @Test
    public void clusterId() {
        assertEquals("\"cluster_ticket-123\"", Utils.escapeDotId("cluster_ticket-123"));
    }

    @Test
    public void testStream() {
        Digraph g = new Digraph(true, "testStream");
        g.addEdge(new Edge("a", "b").addNodeId("c"));
        String svg = Utils.compileGraph(g, Layout.dot, "svg");
        assertTrue(svg.contains("<svg "));
        assertTrue(svg.contains("</svg>"));
        System.out.println(svg);
    }
}
