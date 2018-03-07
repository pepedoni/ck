/**
 * 
 */
package com.github.mauricioaniche.ck.metric;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Statement;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class NNestedBlock extends ASTVisitor implements Metric {

	private int nestedBlocks = 0;
	
	@Override
	public boolean visit(Block node) {
		
		@SuppressWarnings("unchecked")
		List<Statement> stList = node.statements();
		for(Statement st : stList) {
			switch (st.getNodeType()) {
			case ASTNode.BLOCK:
			case ASTNode.IF_STATEMENT:
			case ASTNode.FOR_STATEMENT:
			case ASTNode.ENHANCED_FOR_STATEMENT:
			case ASTNode.DO_STATEMENT:
			case ASTNode.SWITCH_CASE:
			case ASTNode.WHILE_STATEMENT:
			case ASTNode.TRY_STATEMENT:
				nestedBlocks++;
				break;
			default:
				break;
			}
		}
		return super.visit(node);
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber number, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		if(nestedBlocks == 0)
			nestedBlocks++;
		
		result.setNNestedBlocks(nestedBlocks);
		
	}
}
