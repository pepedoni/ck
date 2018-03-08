/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 * T = Effort/18
 * 
 */
public class TimeToImplement implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		
		//make sure effort was previously computed
		for (CKNumber ck : report.all()) {
			double t = ck.getEffort() / 18;
			ck.setTimeToImplement(t);
		}
	}
}
