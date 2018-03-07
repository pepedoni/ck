/**
 * 
 */
package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SimpleName;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * Number of operands
 * 
 * All identifiers that are not reserved words. Reserved words that specify
 * type.
 * 
 * Ex.: bool, double, char, numeric, or string constants
 * 
 * @author klerisson
 *
 */
public class NOperands extends ASTVisitor implements Metric {

	private int operands;
	private NUniqueOperands uniqueOperands;
	
	public NOperands() {
		this.uniqueOperands = new NUniqueOperands();
	}

	@Override
	public boolean visit(SimpleName node) {
		compute(node.getFullyQualifiedName());
		return super.visit(node);
	}
	
	@Override
	public boolean visit(PrimitiveType node) {
		compute(node.toString());
		return super.visit(node);
	}
	
	private void compute(String operand) {
		operands++;
		uniqueOperands.plusOne(operand);
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber result, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setNOperands(operands);
		result.setNUniqueOperands(uniqueOperands.computeUniqueOperands());
	}
}
