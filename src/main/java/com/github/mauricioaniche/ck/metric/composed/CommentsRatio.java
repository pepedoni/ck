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
			double ratio = (ck.getNComments() / ck.getLoc()) * 100; 
			ck.setCommentsRatio(ratio);
		}
	}
}
