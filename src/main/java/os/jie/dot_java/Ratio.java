package os.jie.dot_java;

import os.jie.dot_java.attrs.DotAttrValue;

public class Ratio implements DotAttrValue {
    public static enum Constants {
        AUTO("auto"),
        COMPRESS("compress"),
        FILL("fill"),
        EXPAND("expand");

        private final String str;
    	private Constants(String str) {
    		this.str = str;
    	}
    	
    	@Override
    	public String toString() {
    		return this.str;
    	}
    }

    final String value;

    public Ratio(double size) {
        value = String.valueOf(size);
    }

    public Ratio(Constants type) {
        value = type.toString();
    }

    @Override
    public boolean isSimple() {
        return true;
    }

    @Override
    public String getValueString() {
        return value;
    }
}
