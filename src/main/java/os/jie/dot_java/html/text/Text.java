package os.jie.dot_java.html.text;

import os.jie.dot_java.html.Align;
import os.jie.dot_java.html.HtmlNode;

/**
 * Main entry to construct html string easily.
 * @author jie_huang
 *
 */
public abstract class Text implements TextItem, HtmlNode {
    public static Text newText(String s) {
        return new HtmlString(s);
    }

    public Text add(String s) {
        return new ListText(this, new HtmlString(s));
    }

    public Text addLineBreak() {
        return new ListText(this, new Break());
    }

    public Text addLineBreak(Align align) {
        return new ListText(this, new Break(align));
    }

    public Text add(Text text) {
        return new ListText(this, text);
    }

    public Text bold() {
        return new Bold(this);
    }

    public Text font(String colorName) {
        return new Font(this).color(colorName);
    }

    public Text font(int fontSize) {
        return new Font(this).fontSize(fontSize);
    }

    public Text italic() {
        return new Italic(this);
    }

    public Text overline() {
        return new Overline(this);
    }

    public Text strike() {
        return new Strike(this);
    }

    public Text subscript() {
        return new Subscript(this);
    }

    public Text superscript() {
        return new Supscript(this);
    }

    public Text underline() {
        return new Underline(this);
    }
}
