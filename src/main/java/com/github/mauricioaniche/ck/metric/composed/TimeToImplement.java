/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 *         T = Effort/18
 * 
 */
public class TimeToImplement implements ComposedMetric {

	@Override
	public void update(CKReport report) {

		// make sure effort was previously computed
		for (CKNumber ck : report.all()) {

			double t = 0.0;
			try {
				t = (double) ck.getEffort() / 18;
			} catch (Exception e) {
				t = 0.0;
			}
			ck.setTimeToImplement(t);
		}
	}
}
