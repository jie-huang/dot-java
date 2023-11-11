package os.jie.dot_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.regex.Pattern;

/**
 * Dot Utilities.
 * @author jie_huang
 *
 */
public class Utils {
    /**
     * dot command path. It can be changed in case it is different.
     * This is default for MacOS.
     */
    static String DOT = "/usr/local/bin/dot";
    static {
        String name = System.getProperty("os.name");
        if (name.startsWith("Linux")) {
            DOT = "/usr/bin/dot";
        } else if (name.startsWith("Mac")) {
            DOT = "/usr/local/bin/dot";
        }
    }

    /**
     * Layout commands. More can be added.
     * @author jie_huang
     */
    public static enum Layout {
        circo,
        dot,
        fdp,
        neato,
        osage,
        patchwork,
        sfdp,
        twopi
    }

    /**
     * compile dot file to image file with "dot" layout.
     * @param dotFile       (in): dot file path
     * @param type          (in): image type
     * @param outputFile    (in): output image file path
     * @return true if success
     */
    public static boolean compileDot(String dotFile, String type, String outputFile) {
        return compileDot(Layout.dot, dotFile, type, outputFile);
    }

    /**
     * compile dot file to image file.
     * @param layout        (in): layout type
     * @param dotFile       (in): dot file path
     * @param type          (in): image type
     * @param outputFile    (in): output image file path
     * @return true if success
     */
    public static boolean compileDot(Layout layout, String dotFile, String type, String outputFile) {
        try {
            Process p = new ProcessBuilder().inheritIO().command(DOT, "-K" + layout, "-T" + type, dotFile, "-o", outputFile).start();
            int n = p.waitFor();
            return (n == 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * compile graph into image file directly with "dot" layout.
     * @param g             (in): graph
     * @param type          (in): image type
     * @param outputFile    (in): output image file path
     * @return true if success
     */
    public static boolean compileGraph(Graph g, String type, String outputFile) {
        return compileGraph(g, Layout.dot, type, outputFile);
    }

    /**
     * compile graph into image file directly.
     * @param g             (in): graph
     * @param layout        (in): layout type
     * @param type          (in): image type
     * @param outputFile    (in): output file path
     * @return true if success
     */
    public static boolean compileGraph(Graph g, Layout layout, String type, String outputFile) {
        try {
            Process p = new ProcessBuilder().redirectInput(Redirect.PIPE)
                    .redirectError(Redirect.INHERIT)
                    .redirectOutput(Redirect.INHERIT)
                    .command(DOT, "-K" + layout, "-T" + type, "-o", outputFile).start();
            DotWriter writer = new DotWriter(p.getOutputStream());
            g.toDot(writer);
            writer.close();
            int n = p.waitFor();
            return (n == 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class StreamWrapper extends Thread {
        final InputStream is;
        public final String type;
        public String msg;

        public StreamWrapper(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer buffer = new StringBuffer();
                String line = null;
                while ((line = br.readLine()) != null) {
                    buffer.append(line);
                }
                msg = buffer.toString();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Compile a graph to svg string.
     * @param g         (in) : graph to be compiled
     * @param layout    (in) : Layout type
     * @param type      (in) : image type
     * @return svg string or error message
     */
    public static String compileGraph(Graph g, Layout layout, String type) {
        try {
            Process p = new ProcessBuilder().redirectInput(Redirect.PIPE)
                    .redirectError(Redirect.PIPE)
                    .redirectOutput(Redirect.PIPE)
                    .command(DOT, "-K" + layout, "-T" + type).start();
            StreamWrapper error = new StreamWrapper(p.getErrorStream(), "ERROR");
            StreamWrapper output = new StreamWrapper(p.getInputStream(), "OUTPUT");
            error.start();
            output.start();
            DotWriter writer = new DotWriter(p.getOutputStream());
            g.toDot(writer);
            writer.close();
            error.join();
            output.join();
            int n = p.waitFor();
            if (n == 0) {
                return output.msg;
            } else {
                return error.msg;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static final Pattern DOT_ID_PATTERN = Pattern.compile("^[_a-zA-Z\\0200-\\0377][_a-zA-Z0-9\\0200-\\0377]*$");

    /**
     * This is used to escape the id;
     * @param id    (in): id in dot language. It may need escape if it is keyword or contains special character.
     * @return escaped id
     */
    public static String escapeDotId(String id) {
        if (DOT_ID_PATTERN.matcher(id).matches()) {
            if (isKeyWord(id)) {
                return quoteId(id);
            } else {
                return id;
            }
        } else {
            return quoteId(id);
        }
    }

    static final String[] DOT_KEYWORDS = {
            "digraph",
            "edge",
            "graph",
            "node",
            "strict",
            "subgraph"
    };

    /**
     * check whether an id is a dot language keyword. It is case insensitive
     * @param id    (in): id
     * @return true if it is dot language keyword
     */
    public static boolean isKeyWord(String id) {
        String lowerCase = id.toLowerCase();
        for (int i = 0; i < DOT_KEYWORDS.length; ++i) {
            if (DOT_KEYWORDS[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    /**
     * quote an id. It only escape the double quote '"'.
     * It is better to check whether the id need quote first. Only the needed-quote id should use this method.
     * @param id    (in): dot language id
     * @return quoted id.
     */
    public static String quoteId(String id) {
        String newId = id;
        if (newId.contains("\"")) {
            newId = newId.replaceAll("\"", "\\\"");
        }
        return "\"" + newId + "\"";
    }
}
