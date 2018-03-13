/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import java.util.HashSet;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class AverageComments implements ComposedMetric {

	private HashSet<String> packages = new HashSet<>();

	@Override
	public void update(CKReport report) {
		report.all().forEach(ck -> packages.add(ck.getPackageName()));

		for (CKNumber ck : report.all()) {
			double average = 0.0;
			try {
				average = (double) ck.getNComments() / packages.size();
			} catch (Exception e) {
				average = 0.0;
			}
			ck.setAverageComments(average);
		}
	}
}
