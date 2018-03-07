package com.github.mauricioaniche.ck.metric;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.ck.CK;
import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class McCabeTest extends BaseTest {

	private static CKReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new CK().calculate(fixturesDir() + "/mccabe");
	}

	@Test
	public void countAllBranchInstructions() {
		
		CKNumber a = report.getByClassName("mccabe.CC1");
		Assert.assertEquals(5, a.getMcCabe());
		CKNumber b = report.getByClassName("mccabe.CC2");
		Assert.assertEquals(5, b.getMcCabe());
	}
}
