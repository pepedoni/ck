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
			double abd = 0.0; 
			try {
				abd = (double) (ck.getNom() + ck.getNoConstructors()) / ck.getNNestedBlocks();
			} catch (Exception e) {
				abd = 0.0; 
			}
			ck.setAverageBlockDepth(abd);
		}
	}

}
