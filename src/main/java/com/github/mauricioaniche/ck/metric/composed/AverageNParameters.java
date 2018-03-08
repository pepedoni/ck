/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * Number of parameters / NOM 
 */
public class AverageNParameters implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			double a = ck.getNParameter() / ck.getNom(); 
			ck.setAverageNParameter(a);
		}
	}

}
