package os.jie.dot_java.html.text;

import os.jie.dot_java.DotWriter;

public class AbstractTextPack extends Text {
    final String packKey;
    final Text inner;

    AbstractTextPack(String packKey, Text text) {
        this.packKey = packKey;
        this.inner = text;
    }

    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        sb.append('<').append(packKey).append('>');
        sb.append(inner.toHtml());
        sb.append("</").append(packKey).append('>');
        return sb.toString();
    }

    @Override
    public void toHtml(DotWriter dw) {
        dw.append('<').append(packKey).append('>');
        dw.append(inner.toHtml());
        dw.append("</").append(packKey).append('>');
    }
}
