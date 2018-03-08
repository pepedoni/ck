/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import java.util.HashSet;
import java.util.Set;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * NOM / packages
 */
public class AverageNOM implements ComposedMetric {

	private Set<String> pack = new HashSet<>();

	@Override
	public void update(CKReport report) {
		for (CKNumber ck : report.all()) {
			pack.add(ck.getPackageName());
		}

		for (CKNumber ck : report.all()) {
			double aNOM = ck.getNom() / pack.size();
			ck.setAverageNOM(aNOM);
		}
	}

}
