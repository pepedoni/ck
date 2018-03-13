/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import java.util.HashMap;
import java.util.Map;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class AverageConstructorsClass implements ComposedMetric {

	private Map<String, Integer> packageToClassNumber = new HashMap<>();
	
	@Override
	public void update(CKReport report) {	
		for (CKNumber ck : report.all()) {
			packageToClassNumber.merge(ck.getPackageName(), 1, Integer::sum);
		}

		for (CKNumber ck : report.all()) {
			double acc = 0.0;
			try {
				acc = (double) ck.getNoConstructors() / packageToClassNumber.get(ck.getPackageName());
			} catch (Exception e) {
				acc = 0.0;
			}
			ck.setAverageConstructorsClass(acc);
		}
	}
}
