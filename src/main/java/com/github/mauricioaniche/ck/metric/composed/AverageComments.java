/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import java.util.HashSet;

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
		report.all().forEach(ck -> ck.setAverageComments(ck.getNComments() / packages.size()));
	}
}
