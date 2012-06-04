package be.ac.fundp.precise.uiwsc.webClient.model.processManagment;

import com.google.common.collect.AbstractIterator;

/**
 * The Class ProcessPrefix creates a prefix for processes in alphabetic order.
 */
public class ProcessPrefix extends AbstractIterator<String> {
	    
    	/** The now. */
    	private int now;
	    
    	/** The vs. */
    	private static char[] vs;
	    static {
	        vs = new char['Z' - 'A' + 1];
	        for(char i='A'; i<='Z';i++) vs[i - 'A'] = i;
	    }

	    /**
    	 * Alpha.
    	 *
    	 * @param i the i
    	 * @return the string builder
    	 */
    	private StringBuilder alpha(int i){
	        assert i > 0;
	        char r = vs[--i % vs.length];
	        int n = i / vs.length;
	        return n == 0 ? new StringBuilder().append(r) : alpha(n).append(r);
	    }

	    /* (non-Javadoc)
    	 * @see com.google.common.collect.AbstractIterator#computeNext()
    	 */
    	@Override protected String computeNext() {
	        return alpha(++now).toString();
	    }
	}