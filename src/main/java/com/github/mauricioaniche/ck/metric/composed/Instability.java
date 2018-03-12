/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * i = efferent /(afferent + efferent)
 */
public class Instability implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for(CKNumber ck : report.all()) {
			double i = 0.0;
			try {
				i = (double) ck.getEfferentCoupling() / (ck.getAfferentCoupling() + ck.getEfferentCoupling());
			} catch (Exception e) {
			}
			ck.setInstability(i);
		}
	}
}
