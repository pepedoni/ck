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
public class NOperandsTest extends BaseTest {

	private static CKReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new CK().calculate(fixturesDir() + "/noperands");
	}

	/* 
	@Test
	public void count_operands() {
		
		CKNumber a = report.getByClassName("noperands.C1");
		Assert.assertEquals(10, a.getNOperands());
		
		//CKNumber b = report.getByClassName("noperands.C2");
		//Assert.assertEquals(1, b.getNOperands());
	}
	*/
	
}
