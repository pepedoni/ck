package com.github.mauricioaniche.ck.metric;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.ck.CK;
import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class WMCTest extends BaseTest {

	private static CKReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new CK().calculate(fixturesDir() + "/wmc");
	}

	@Test
	public void countMethodInvocations() {
		CKNumber a = report.getByClassName("wmc.GO");
		Assert.assertEquals(3, a.getRfc());
	}

	@Test
	public void countSuperInvocations() {
		CKNumber a = report.getByClassName("wmc.GO3");
		Assert.assertEquals(2, a.getRfc());
	}

}
