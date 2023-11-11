package os.jie.dot_java;

public interface Statement {
	/**
	 * Write the content to dot text.
     * @param dw    (in): dot writer to write the attribute
     * @return true if really write something.
	 */
    public boolean toDot(DotWriter dw);
}
