/**
 * 
 */
package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 * 
 * Weight of an entity as the number of method invocations in each method.
 */
public class WMC extends ASTVisitor implements Metric {
	
	private int weight;
		
	public boolean visit(MethodInvocation node) {
    	increaseWeight();
    	return super.visit(node);
    }
	
	public boolean visit(SuperMethodInvocation node) {
    	increaseWeight();
    	return super.visit(node);
    }
	
	private void increaseWeight() {
    	weight++;
    }
	
	@Override
	public void execute(CompilationUnit cu, CKNumber number, CKReport report) {
		cu.accept(this);	
	}

	@Override
	public void setResult(CKNumber result) {
		result.setWMC(weight);
	}
}
