/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 * effort ^ (2/3)/3000
 * 
 */
public class NDeliveredBugs implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			double ndb = 0.0;
			try {
				ndb = (double) (Math.pow(ck.getEffort(),(2/3))) / 3000;
			} catch (Exception e) {
			}
			ck.setNDeliveredBugs(ndb);
		}
	}
}
