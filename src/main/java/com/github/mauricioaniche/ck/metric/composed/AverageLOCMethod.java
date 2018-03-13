package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 * AverageLOCMethod = (LoC / MoM)/10
 * 
 */
public class AverageLOCMethod implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			double aLocMethod = 0.0;
			try {
				aLocMethod = ((double) ck.getLoc() / ck.getNom())/10;
			} catch(ArithmeticException ae) {
				aLocMethod = 0.0;
			}
			ck.setAverageLOCMethod(aLocMethod);
		}
	}

}
