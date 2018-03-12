/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 * pLevel = 1 / Difficult level
 * 
 */
public class ProgramLevel implements ComposedMetric {

	@Override
	public void update(CKReport report) {		
		//make sure difficult level was previously computed
		for (CKNumber ck : report.all()) {
			double pLevel = 0.0;
			try {
				pLevel = (double) 1 / ck.getDifficultLevel();
			} catch (Exception e) {
			}
			ck.setProgramLevel(pLevel);
		}
	}
}
