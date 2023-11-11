package os.jie.dot_java;


/**
 * Ref: <a href="http://graphviz.org/content/dot-language">http://graphviz.org/content/dot-language</a>
 * This is the main entry to construct a graph.
 * @author jie_huang
 *
 */
public class Digraph extends Graph {
    public Digraph(boolean strict) {
        super(strict, true);
    }

    public Digraph(boolean strict, String id) {
        super(strict, true, id);
    }
}
