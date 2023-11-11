package os.jie.dot_java.html.attrs;


/**
 * Html Attribute.
 * @author jie_huang
 *
 */
public interface HtmlAttr {
    /**
     * @return true if it is default value. So, there is no need to output it.
     */
    public boolean isDefault();

    public String getKey();

    public String getValue();

    public String toHtml();
}
