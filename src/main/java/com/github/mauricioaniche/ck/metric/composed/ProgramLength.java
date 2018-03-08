/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * pl = number of operands + number of operators
 */
public class ProgramLength implements ComposedMetric {
	
	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			int pl = ck.getNOperands() + ck.getNOperators();
			ck.setProgramLength(pl);
		}
	}
}
