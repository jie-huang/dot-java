package os.jie.dot_java;

public enum FixedSize {
    False("false"),
    Shape("shape"),
    True("true");

    private final String value;

    private FixedSize(String s) {
        this.value = s;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
