/**
 * 
 */
package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;
import com.github.mauricioaniche.ck.metric.dependent.NUniqueOperators;

/**
 * @author klerisson
 *
 */
public class NOperators extends ASTVisitor implements Metric {

	private int operators;
	private NUniqueOperators uniqueOperators;

	/**
	 * 
	 */
	public NOperators() {
		uniqueOperators = new NUniqueOperators();
	}

	/*@Override
	public boolean visit(Assignment node) {
		Assignment.Operator operator = node.getOperator();
		compute(operator.toString());
		
		return super.visit(node);
	}*/
	
	@Override
	public boolean visit(PrefixExpression node) {
		PrefixExpression.Operator operator = node.getOperator();
		compute(operator.toString());
		
		return super.visit(node);
	}
	
	@Override
	public boolean visit(InfixExpression node) {
		InfixExpression.Operator operator = node.getOperator();
		compute(operator.toString());
		
		return super.visit(node);
	}
	
	@Override
	public boolean visit(PostfixExpression node) {
		PostfixExpression.Operator operator = node.getOperator();
		compute(operator.toString());
		
		return super.visit(node);
	}

	private void compute(String operand) {
		operators++;
		uniqueOperators.plusOne(operand);
	}

	@Override
	public void execute(CompilationUnit cu, CKNumber result, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setNOperators(operators);
		result.setNUniqueOperators(uniqueOperators.computeUniqueOperators());
	}
}
