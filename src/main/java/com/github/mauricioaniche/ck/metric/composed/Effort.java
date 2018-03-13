/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 * effort = dl * V
 * dl is the difficult level and V is program volume
 * 
 */
public class Effort implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		
		//make sure dl and V were previously computed
		for (CKNumber ck : report.all()) {
			double e = 0.0;
			try {
				e = ck.getDifficultLevel() * ck.getProgramVolume();
			} catch (Exception e2) {
				e = 0.0;
			}
			ck.setEffort(e);
		}
	}
}
