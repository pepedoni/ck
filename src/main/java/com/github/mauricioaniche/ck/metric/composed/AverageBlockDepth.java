/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class AverageBlockDepth implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for(CKNumber ck : report.all()) {
			double abd = (ck.getNom() + ck.getNoConstructors()) / ck.getNNestedBlocks();
			ck.setAverageBlockDepth(abd);
		}
	}

}
