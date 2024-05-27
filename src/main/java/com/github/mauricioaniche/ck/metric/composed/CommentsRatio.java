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
public class CommentsRatio implements ComposedMetric {

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			double ratio = 0.0;
			try {
				ratio = ((double) ck.getNComments() / ck.getLoc()) * 100; 
			} catch (Exception e) {
				ratio = 0.0;
			}
			ck.setCommentsRatio(ratio);
		}
	}
}
