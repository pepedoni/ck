/**
 * 
 */
package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.BlockComment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Javadoc;
import org.eclipse.jdt.core.dom.LineComment;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class NComments extends ASTVisitor implements Metric {

	private int comments;
	
	@Override
	public boolean visit(BlockComment node) {
		comments++;	
		return super.visit(node);
	}
	
	@Override
	public boolean visit(LineComment node) {
		comments++;	
		return super.visit(node);
	}
	
	@Override
	public boolean visit(Javadoc node) {
		comments++;	
		return super.visit(node);
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber result, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setNComments(comments);

	}

}
