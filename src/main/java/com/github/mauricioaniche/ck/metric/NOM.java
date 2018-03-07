package com.github.mauricioaniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class NOM extends ASTVisitor implements Metric {

	private int methods;
	private int constructors;
	
	@Override
	public boolean visit(MethodDeclaration node) {
		methods++;
		if(node.isConstructor())
			constructors++;

		return false;
	}

	@Override
	public void execute(CompilationUnit cu, CKNumber number, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setNom(methods);
		result.setNoConstructors(constructors);
	}
}
