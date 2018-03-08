/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 * Volume = Program Length * log{Program Vocabulary}
 * 
 * pl = number of operands + number of operators
 * pv = number of unique operands + number of unique operators
 * 
 */
public class ProgramVolume implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		
		//TODO use pl and pv, but make sure they were previously computed
		for (CKNumber ck : report.all()) {
			int pl = ck.getNOperands() + ck.getNOperators();
			int pv = ck.getNUniqueOperands() + ck.getNUniqueOperators();
			int v = pl * pv;
			ck.setProgramVolume(v);
		}
	}
}
