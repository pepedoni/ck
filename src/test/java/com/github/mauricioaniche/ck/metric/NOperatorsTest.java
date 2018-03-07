/**
 * 
 */
package com.github.mauricioaniche.ck.metric;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.ck.CK;
import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class NOperatorsTest extends BaseTest {

	private static CKReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new CK().calculate(fixturesDir() + "/noperators");
	}

	@Test
	public void count_operators() {
		
		CKNumber a = report.getByClassName("noperators.C1");
		Assert.assertEquals(10, a.getNOperators());		
	}
	
}
