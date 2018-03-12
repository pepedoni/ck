package com.github.mauricioaniche.ck.metric.composed;

import java.util.HashMap;
import java.util.Map;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class Abstractness implements ComposedMetric {

	private Map<String, Integer> packageToClassNumber = new HashMap<>();
	private Map<String, Integer> packageToAbstractClassNumber = new HashMap<>();

	@Override
	public void update(CKReport report) {

		for (CKNumber ck : report.all()) {
			packageToClassNumber.merge(ck.getPackageName(), 1, Integer::sum);
			if (ck.getType().equals("abstract")) {
				packageToAbstractClassNumber.merge(ck.getPackageName(), 1, Integer::sum);
			}
		}

		for (CKNumber ck : report.all()) {
			double abstractness = 0.0;
			try {
				abstractness = (double) packageToAbstractClassNumber.get(ck.getPackageName())
						/ packageToClassNumber.get(ck.getPackageName());
			} catch (Exception e) {

			}
			ck.setAbstractness(abstractness);
		}

	}
}