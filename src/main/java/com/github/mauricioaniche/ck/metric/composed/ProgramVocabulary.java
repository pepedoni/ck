/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * pv = number of unique operands + number of unique operators
 */
public class ProgramVocabulary implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			int pv = ck.getNUniqueOperands() + ck.getNUniqueOperators();
			ck.setProgramVocabulary(pv);
		}
	}
}
