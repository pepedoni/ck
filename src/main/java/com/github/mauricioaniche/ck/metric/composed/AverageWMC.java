/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *	WMC/(Number of methods + n of constructors)
 */
public class AverageWMC implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for(CKNumber ck : report.all()) {
			double average = 0.0;
			try {
				average = (double)ck.getWMC() / (ck.getNom() + ck.getNoConstructors());
			} catch (Exception e) {
				average = 0.0;
			}
			ck.setAverageWMC(average);
		}
	}
}
