/**
 * 
 */
package com.github.mauricioaniche.ck.metric.composed;

import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class NOInterfaces implements ComposedMetric {

	private int nInterface;
	
	@Override
	public void update(CKReport report) {
		report.all().forEach(ck ->{ if(ck.getType().equals("interface")) nInterface++; });
		report.all().forEach(ck -> ck.setNOInteface(nInterface));
	}

}
