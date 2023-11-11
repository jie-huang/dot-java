package os.jie.dot_java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import os.jie.dot_java.Utils.Layout;

public class TestBase {
    static String TEST_TEMP_FOLDER_DOT = "test_temp/dot/";
    static String TEST_TEMP_FOLDER_SVG = "test_temp/svg/";

    public static String getMethodName(int nameStackIndex) {
      final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
      return ste[nameStackIndex].getMethodName();
    }

    void generateDotAndSvg(Graph g) {
        if (! generateDotAndSvg(Layout.dot, g, 4)) {
            throw new RuntimeException("failed to compile");
        }
    }

    void generateDotAndSvg(Layout layout, Graph g) {
        if (! generateDotAndSvg(layout, g, 4)) {
            throw new RuntimeException("failed to compile");
        }
    }

    private boolean generateDotAndSvg(Layout layout, Graph g, int nameStackIndex) {
        String caseName = getMethodName(nameStackIndex);
        try {
            FileUtils.forceMkdir(new File(TEST_TEMP_FOLDER_DOT));
            FileUtils.forceMkdir(new File(TEST_TEMP_FOLDER_SVG));
            String dotFile = TEST_TEMP_FOLDER_DOT + caseName + ".dot";
            g.toDot(dotFile);
            String type = "svg";
            String outputFile = TEST_TEMP_FOLDER_SVG + caseName + "." + type;
            return Utils.compileDot(layout, dotFile, type, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void generateSvg(Graph g) {
        if (! generateSvg(Layout.dot, g, 4)) {
            throw new RuntimeException("failed to compile");
        }
    }

    void generateSvg(Layout layout, Graph g) {
        if (! generateSvg(layout, g, 4)) {
            throw new RuntimeException("failed to compile");
        }
    }

    private boolean generateSvg(Layout layout, Graph g, int nameStackIndex) {
        String caseName = getMethodName(nameStackIndex);
        try {
            FileUtils.forceMkdir(new File(TEST_TEMP_FOLDER_SVG));
            String type = "svg";
            String outputFile = TEST_TEMP_FOLDER_SVG + caseName + "." + type;
            return Utils.compileGraph(g, layout, type, outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
