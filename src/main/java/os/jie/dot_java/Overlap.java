package os.jie.dot_java;

import os.jie.dot_java.attrs.DotAttrValue;

public class Overlap implements DotAttrValue {
    public static enum Constants {
        COMPRESS("compress"),
        IPSEP("ipsep"),
        ORTHO_XY("orthoxy"),
        ORTHO_YZ("orthoyz"),
        PRISM("prism"),
        SCALE_XY("scalexy"),
        VORONOI("voronoi"),
        VPSC("vpsc");

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

    public Overlap(boolean overlap) {
        value = String.valueOf(overlap);
    }

    public Overlap(int prism) {
        if (prism < 0) {
            throw new RuntimeException("prism must be non-negative number");
        }
        value = "prism" + String.valueOf(prism);
    }

    public Overlap(Constants type) {
        value = String.valueOf(type);
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
