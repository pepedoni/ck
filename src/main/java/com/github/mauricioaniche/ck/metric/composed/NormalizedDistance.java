/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * Normalized distance
 * nd = (instability + Abstractness) - 1
 */
public class NormalizedDistance implements ComposedMetric {
	
	@Override
	public void update(CKReport report) {	
		for (CKNumber ck : report.all()) {
			double nd = (ck.getInstability() + ck.getAbstractness()) - 1;
			ck.setNormalizedDistance(nd);
		}
	}
}
