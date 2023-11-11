package os.jie.dot_java.html.text;

import java.util.ArrayList;
import java.util.List;

import os.jie.dot_java.DotWriter;
import os.jie.dot_java.html.Align;

public class ListText extends Text {
    final List<Text> items = new ArrayList<Text>();

    ListText(Text first, Text second) {
        items.add(first);
        items.add(second);
    }

    @Override
    public Text add(Text text) {
        items.add(text);
        return this;
    }

    @Override
    public Text addLineBreak() {
        items.add(new Break());
        return this;
    }

    @Override
    public Text addLineBreak(Align align) {
        items.add(new Break(align));
        return this;
    }


    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        for (Text text: items) {
            sb.append(text.toHtml());
        }
        return sb.toString();
    }

    @Override
    public void toHtml(DotWriter dw) {
        for (Text text: items) {
            text.toHtml(dw);
        }
    }
}
