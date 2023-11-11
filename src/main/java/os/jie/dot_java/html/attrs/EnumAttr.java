package os.jie.dot_java.html.attrs;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class EnumAttr<E extends Enum<E>> extends AbstractAttr {
    private final E defaultValue;
    E value;

    protected EnumAttr(String key, E defaultValue, E value) {
        super(key);
        this.defaultValue = defaultValue;
        this.value = value;
        if (this.value == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            Type param = type.getActualTypeArguments()[0];
            throw new RuntimeException("value cannot be null for enum: " + param.toString());
        }
    }

    @Override
    public boolean isDefault() {
        return (value == null) || (value == defaultValue);
    }

    /**
     * Use {@link #toString()} as value string because the name may not contain '-'.
     */
    @Override
    public String getValue() {
        return value.toString();
    }
}
