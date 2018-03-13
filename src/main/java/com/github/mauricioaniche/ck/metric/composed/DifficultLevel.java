/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 * dl = (n1/2) * (N2/n2)
 * n1 = number of unique operators
 * n2 = number of unique operands
 * N2 = total number of operands
 */
public class DifficultLevel implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			double dl = 0.0; 
			try {
				dl = (double) (ck.getNUniqueOperators() / 2) * (ck.getNOperands() / ck.getNUniqueOperands());
			} catch (Exception e) {
				dl = 0.0;
			}
			ck.setDifficultLevel(dl);
		}
	}
}
