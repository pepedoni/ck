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
public class NBlock extends ASTVisitor implements Metric {

	private int nestedBlocks = 1;
	
	@Override
	public boolean visit(Block node) {
		List<Statement> list = node.statements();
		for(Statement st : list) {
			if(st.getNodeType() == ASTNode.BLOCK)
				nestedBlocks++;
		}
		return super.visit(node);
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber number, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setRfc(nestedBlocks);
		
	}
}
