/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 *         V = Halstead Volume G = Cyclomatic Complexity LOC = count of source
 * 
 *         MI = 171 - 5.2 * ln(V) - 0.23 * (G) - 16.2 * ln(LOC)
 *
 */
public class Maintainability implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			double mi = 0.0;
			try {
				mi = 171 - 5.2 * Math.log(ck.getProgramVolume()) - 0.23 * ck.getWMC()
						- 16.2 * Math.log(ck.getLoc());
			} catch (Exception e) {
				mi = 0.0;
			}
			ck.setMaintainability(mi);
		}
	}
}
