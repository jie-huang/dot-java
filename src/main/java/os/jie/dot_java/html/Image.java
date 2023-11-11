package os.jie.dot_java.html;

import os.jie.dot_java.html.attrs.ScaleImpl;
import os.jie.dot_java.html.attrs.SourceImpl;

public class Image extends AbstractElemPack {
    // Attributes ==== begin
    final ScaleImpl scale;
    final SourceImpl src;
    // Attributes ==== end

    public Image(String src) {
        super("IMG", true);
        this.src = new SourceImpl(src);
        attrs.add(this.src);
        this.scale = null;
    }

    public Image(String src, Scale scale) {
        super("IMG", true);
        this.src = new SourceImpl(src);
        attrs.add(this.src);
        this.scale = new ScaleImpl(scale);
        attrs.add(this.scale);
    }
}
