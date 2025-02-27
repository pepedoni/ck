package com.github.mauricioaniche.ck.metric;

import java.util.HashSet;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class RFC extends ASTVisitor implements Metric {

	private HashSet<String> methodInvocations = new HashSet<>();

	@Override
	public boolean visit(MethodInvocation node) {
		IMethodBinding binding = node.resolveMethodBinding();
		count(node.getName()  + "/" + arguments(node.arguments()), binding);
		
		return super.visit(node);
	}

	private String arguments(List<?> arguments) {
		if(arguments==null || arguments.isEmpty()) return "0";
		return "" + arguments.size();
	}

	private void count(String methodName, IMethodBinding binding) {
		if(binding!=null) {
			String method = getMethodName(binding);
			methodInvocations.add(method);
		} else {
			methodInvocations.add(methodName);
		}
	}
	
	@Override
	public boolean visit(SuperMethodInvocation node) {
		IMethodBinding binding = node.resolveMethodBinding();
		count(node.getName()  + "/" + arguments(node.arguments()), binding);
		
		return super.visit(node);
	}

	private String getMethodName(IMethodBinding binding) {
		
		ITypeBinding[] args = binding.getParameterTypes();
		StringBuilder argumentList = new StringBuilder();

		for(ITypeBinding arg : args) {
			argumentList.append(arg.getName());
		}

		StringBuilder methodStringBuilder = new StringBuilder();
		methodStringBuilder.append(binding.getDeclaringClass().getQualifiedName());
		methodStringBuilder.append(".");
		methodStringBuilder.append(binding.getName());
		methodStringBuilder.append("/");
		methodStringBuilder.append(binding.getParameterTypes().length);
		methodStringBuilder.append("[");
		methodStringBuilder.append(argumentList.toString());
		methodStringBuilder.append("]");

		return methodStringBuilder.toString();
		
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber number, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {
		result.setRfc(methodInvocations.size());
		
	}
	
}
