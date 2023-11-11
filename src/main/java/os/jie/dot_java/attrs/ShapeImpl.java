package os.jie.dot_java.attrs;

import os.jie.dot_java.Shape;

public class ShapeImpl extends EnumAttr<Shape> {
    public ShapeImpl(Shape value) {
        super("shape", Shape.ELLIPSE, value);
    }
}
