package os.jie.dot_java.html;

import os.jie.dot_java.html.attrs.AlignImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestHtmlAttr {
    @Test
    public void testAlign() {
        AlignImpl align1 = new AlignImpl(Align.CENTER);
        assertEquals("CENTER", align1.getValue());

        AlignImpl align2 = new AlignImpl(Align.LEFT);
        assertEquals("LEFT", align2.getValue());
    }
}
