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
public class NNestedBlockTest extends BaseTest {

	
private static CKReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new CK().calculate(fixturesDir() + "/nnestedblock");
	}

	@Test
	public void count_operators() {
		
		CKNumber a = report.getByClassName("nnestedblock.C1");
		Assert.assertEquals(10, a.getNNestedBlocks());
		
		CKNumber b = report.getByClassName("nnestedblock.C2");
		Assert.assertEquals(10, b.getNNestedBlocks());		
	}
	
	
}
