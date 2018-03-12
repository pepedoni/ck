package com.github.mauricioaniche.ck.metric.dependent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author klerisson
 *
 */
public class NUniqueOperands {

	private Set<String> operands;

    public NUniqueOperands() {
        operands = new HashSet<>();
    }

    public void plusOne(String operand) {
        operands.add(operand);
    }
    
    public int computeUniqueOperands() {
    	return operands.size();
    }
}
