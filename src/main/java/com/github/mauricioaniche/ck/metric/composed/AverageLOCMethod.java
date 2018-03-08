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
			double aLocMethod = (ck.getLoc() / ck.getNom())/10;
			ck.setAverageLOCMethod(aLocMethod);
		}
	}

}
