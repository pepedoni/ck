package com.github.mauricioaniche.ck;

import java.util.HashMap;
import java.util.Map;

public class CKNumber {

	private String file;
	private String packageName;
	private String className;
	private String type;

	private int dit;
	private int noc;
	private int mcCabe;
	private int cbo;
	private int lcom;
	private int rfc;
	private int nom;
	private int nopm;
	private int nosm;

	private int nof;
	private int nopf;
	private int nosf;

	private int nosi;
	private int loc;

	private int nOperands;
	private int nUniqueOperands;
	private int nOperators;
	private int nUniqueOperators;
	private int noConstructors;
	private int nNestedBlocks;
	private double averageBlockDepth;
	private int wmc;
	
	private Map<String, Integer> specific;
	private boolean error;
	
	public CKNumber(String file, String packageName, String className, String type) {
		this.file = file;
		this.packageName = packageName;
		this.className = className;
		this.type = type;

		this.specific = new HashMap<String, Integer>();
	}

	public String getFile() {
		return file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CKNumber other = (CKNumber) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		return true;
	}

	public int getDit() {
		return dit;
	}

	public void setDit(int dit) {
		this.dit = dit;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getPackageName() {
		return packageName;
	}
	
	public String getClassName() {
		return className;
	}

	public void incNoc() {
		incNoc(1);
	}

	public int getNoc() {
		return noc;
	}

	public void setMcCabe(int cc) {
		this.mcCabe = cc;
	}

	public int getMcCabe() {
		return mcCabe;
	}

	public int getCbo() {
		return cbo;
	}

	public void setCbo(int cbo) {
		this.cbo = cbo;
	}

	public void setLcom(int lcom) {
		this.lcom = lcom;
	}

	public int getLcom() {
		return lcom;
	}

	public void setRfc(int rfc) {
		this.rfc = rfc;
	}

	public int getRfc() {
		return rfc;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

	public int getNom() {
		return nom;
	}

	public int getSpecific(String key) {
		if (!specific.containsKey(key))
			return -1;
		return specific.get(key);
	}

	public void addSpecific(String key, int value) {
		specific.put(key, value);
	}

	public String getType() {
		return type;
	}

	public int getNopm() {
		return nopm;
	}

	public void setNopm(int nopm) {
		this.nopm = nopm;
	}

	public int getNosm() {
		return nosm;
	}

	public void setNosm(int nosm) {
		this.nosm = nosm;
	}

	public int getNof() {
		return nof;
	}

	public void setNof(int nof) {
		this.nof = nof;
	}

	public int getNopf() {
		return nopf;
	}

	public void setNopf(int nopf) {
		this.nopf = nopf;
	}

	public int getNosf() {
		return nosf;
	}

	public void setNosf(int nosf) {
		this.nosf = nosf;
	}

	public int getNosi() {
		return nosi;
	}

	public void setNosi(int nosi) {
		this.nosi = nosi;
	}

	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}

	public int getNOperands() {
		return nOperands;
	}

	public void setNOperands(int operands) {
		this.nOperands = operands;

	}

	public int getNUniqueOperands() {
		return nUniqueOperands;
	}

	public void setNUniqueOperands(int nUniqueOperands) {
		this.nUniqueOperands = nUniqueOperands;
	}

	public int getNOperators() {
		return nOperators;
	}

	public void setNOperators(int nOperators) {
		this.nOperators = nOperators;
	}

	public int getNUniqueOperators() {
		return nUniqueOperators;
	}

	public void setNUniqueOperators(int nUniqueOperators) {
		this.nUniqueOperators = nUniqueOperators;
	}

	public int getNoConstructors() {
		return noConstructors;
	}

	public void setNoConstructors(int constructors) {
		this.noConstructors = constructors;
	}

	/**
	 * @return the nBlocks
	 */
	public int getNNestedBlocks() {
		return nNestedBlocks;
	}

	/**
	 * @param nBlocks the nBlocks to set
	 */
	public void setNNestedBlocks(int nBlocks) {
		this.nNestedBlocks = nBlocks;
	}

	public boolean isError() {
		return error;
	}

	public void error() {
		this.error = true;
	}

	public void incNoc(int value) {
		this.noc += value;
	}
	
	public double getAverageBlockDepth() {
		return averageBlockDepth;		
	}
	
	public void setAverageBlockDepth(double abd) {
		averageBlockDepth = abd;		
	}

	/**
	 * @return the wmc
	 */
	public int getWMC() {
		return wmc;
	}

	/**
	 * @param wmc the wmc to set
	 */
	public void setWMC(int wmc) {
		this.wmc = wmc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CKNumber [file=" + file + ", packageName=" + packageName + ", className=" + className + ", type=" + type
				+ ", dit=" + dit + ", noc=" + noc + ", mcCabe=" + mcCabe + ", cbo=" + cbo + ", lcom=" + lcom + ", rfc="
				+ rfc + ", nom=" + nom + ", nopm=" + nopm + ", nosm=" + nosm + ", nof=" + nof + ", nopf=" + nopf
				+ ", nosf=" + nosf + ", nosi=" + nosi + ", loc=" + loc + ", nOperands=" + nOperands
				+ ", nUniqueOperands=" + nUniqueOperands + ", nOperators=" + nOperators + ", nUniqueOperators="
				+ nUniqueOperators + ", noConstructors=" + noConstructors + ", nNestedBlocks=" + nNestedBlocks
				+ ", averageBlockDepth=" + averageBlockDepth + ", wmc=" + wmc + ", specific=" + specific + ", error="
				+ error + "]";
	}
	
}
