/**
 * 
 */
package com.github.mauricioaniche.ck.metric.aggregated;

import java.util.HashSet;
import java.util.Set;

/**
 * @author klerisson
 *
 */
public class NUniqueOperators {

	private Set<String> operators;

    public NUniqueOperators() {
        operators = new HashSet<>();
    }

    public void plusOne(String operator) {
        operators.add(operator);
    }
    
    public int computeUniqueOperators() {
    	return operators.size();
    }
	
}
