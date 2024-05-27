package com.github.mauricioaniche.ck.metric;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class LCOM extends ASTVisitor implements Metric {

	ArrayList<TreeSet<String>> methods = new ArrayList<>();
	Set<String> declaredFields;
	private Map<String, Integer> fieldsNMethods;

	public LCOM() {
		this.declaredFields = new HashSet<>();
		this.fieldsNMethods = new HashMap<>();
	}

	@Override
	public boolean visit(FieldDeclaration node) {

		for (Object o : node.fragments()) {
			VariableDeclarationFragment vdf = (VariableDeclarationFragment) o;
			String name = vdf.getName().toString();
			declaredFields.add(name);
			fieldsNMethods.put(name, fieldsNMethods.getOrDefault(name, 0));
		}
		return super.visit(node);
	}

	@Override
	public boolean visit(SimpleName node) {
		String name = node.getFullyQualifiedName();
		if (declaredFields.contains(name)) {
			acessed(name);
			fieldsNMethods.merge(name, 1, Integer::sum);
		}
		return super.visit(node);
	}

	private void acessed(String name) {
		if (!methods.isEmpty()) {
			methods.get(methods.size() - 1).add(name);
		}
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		methods.add(new TreeSet<>());

		return super.visit(node);
	}

	@Override
	public void execute(CompilationUnit cu, CKNumber number, CKReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(CKNumber result) {

		/*
		 * LCOM1: Number method pairs that do not share instance variables.
		 * 
		 * LCOM2: |P| - |Q| if |P| - |Q| > 0 where P = set of all empty set
		 * intersections Q = set of all nonempty set intersections
		 * 
		 * LCOM3: M	be the set of methods defined by the class
		 *        F	be the set of fields defined by the class
		 *        p(f)	be the number of methods that access field f, where f is a member of F
		 *        <p>	be the mean of p(f) over F.
		 *        
		 *        then:
		 *        
		 *        lcom3 = (<p> - |M|) / (1-|M|)
		 */

		int lcom1 = 0;
		int lcom2 = 0;
		double lcom3 = 0;
		for (int i = 0; i < methods.size(); i++) {
			for (int j = i + 1; j < methods.size(); j++) {

				TreeSet<?> intersection = (TreeSet<?>) methods.get(i).clone();
				intersection.retainAll(methods.get(j));
				if (intersection.isEmpty()) {
					lcom1++;
					lcom2++;
				} else {
					lcom2--;
				}
			}
		}
		result.setLcom1(lcom1);
		result.setLcom2(lcom2 > 0 ? lcom2 : 0);
		
		double mean = (double)fieldsNMethods.values().stream().mapToInt(Integer::intValue).sum() / declaredFields.size();
		lcom3 = (mean - methods.size()) / (1 - methods.size());
		result.setLcom3(lcom3);
	}
}
