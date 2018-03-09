/**
 * 
 */
package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

/**
 * @author klerisson
 *
 */
public class NImports extends ASTVisitor implements Metric {

	private int importDeclaration;
	
	@Override
	public boolean visit(ImportDeclaration node) {
		importDeclaration++;
		return super.visit(node);
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber result, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setNImport(importDeclaration);
	}
}
