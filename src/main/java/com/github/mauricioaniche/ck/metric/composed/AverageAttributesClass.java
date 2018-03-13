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
public class AverageAttributesClass implements ComposedMetric {

	private Map<String, Integer> packageToClassNumber = new HashMap<>();

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			packageToClassNumber.merge(ck.getPackageName(), 1, Integer::sum);
		}

		for (CKNumber ck : report.all()) {
			double aac = 0.0;
			try {
				aac = (double) ck.getNof() / packageToClassNumber.get(ck.getPackageName());
			} catch (Exception e) {
				aac = 0.0;
			}
			ck.setAverageAttributesClass(aac);
		}
	}

}
