package com.github.mauricioaniche.ck;

import java.math.RoundingMode;
import java.text.DecimalFormat;
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
	private int efferentCoupling;
	private int afferentCoupling;
	private int lcom1;
	private int lcom2;
	private double lcom3;
	private int rfc;
	private int nom;
	private int nopm;
	private int nosm;
	private int nof;
	private int nopf;
	private int nosf;
	private int nosi;
	private int loc;
	private int noLines;
	private int nParameter;
	private int nComments;

	private int nOperands;
	private int nUniqueOperands;
	private int nOperators;
	private int nUniqueOperators;
	private int noConstructors;
	private int nNestedBlocks;
	private int wmc;
	private int programLength;
	private int programVocabulary;
	private int programVolume;
	private int noTypesPackage;
	private int nImport;
	private int noInteface;
	
	private double averageBlockDepth;
	private double averageAttributesClass;
	private double averageConstructorsClass;
	private double averageLOCMethod;
	private double averageNOM;
	private double averageNParameter;
	
	private double abstractness;
	private double instability;
	private double normalizedDistance;
	private double difficultLevel;
	private double effort;
	private double timeToImplement;
	private double programLevel;
	private double commentsRatio;
	private double nDeliveredBugs;
	private double averageComments;
	private double maintainability;
	
	private Map<String, Integer> specific;
	private boolean error;
	private DecimalFormat df;
	
	public CKNumber(String file, String packageName, String className, String type) {
		this.file = file;
		this.packageName = packageName;
		this.className = className;
		this.type = type;

		this.specific = new HashMap<String, Integer>();
		
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
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

	private double sanityzer(double value) {
		if(Double.isNaN(value) || Double.isInfinite(value))
			value = 0.0;
			
		return Double.valueOf(df.format(value));
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

	/**
	 * @return the lcom1
	 */
	public int getLcom1() {
		return lcom1;
	}

	/**
	 * @param lcom1 the lcom1 to set
	 */
	public void setLcom1(int lcom1) {
		this.lcom1 = lcom1;
	}

	public void setLcom2(int lcom) {
		this.lcom2 = lcom;
	}

	public int getLcom2() {
		return lcom2;
	}

	/**
	 * @return the lcom3
	 */
	public double getLcom3() {
		return lcom3;
	}

	/**
	 * @param lcom3 the lcom3 to set
	 */
	public void setLcom3(double lcom3) {
		this.lcom3 = sanityzer(lcom3);
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
		averageBlockDepth = sanityzer(abd);		
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

	/**
	 * @return the averageAttributesClass
	 */
	public double getAverageAttributesClass() {
		return averageAttributesClass;
	}

	/**
	 * @param averageAttributesClass the averageAttributesClass to set
	 */
	public void setAverageAttributesClass(double averageAttributesClass) {
		this.averageAttributesClass = sanityzer(averageAttributesClass);
	}
	
	/**
	 * @return the averageConstructorsClass
	 */
	public double getAverageConstructorsClass() {
		return averageConstructorsClass;
	}

	/**
	 * @param averageConstructorsClass the averageConstructorsClass to set
	 */
	public void setAverageConstructorsClass(double averageConstructorsClass) {
		this.averageConstructorsClass = sanityzer(averageConstructorsClass);
	}

	/**
	 * @return the abstractness
	 */
	public double getAbstractness() {
		return abstractness;
	}

	/**
	 * @param abstractness the abstractness to set
	 */
	public void setAbstractness(double abstractness) {
		this.abstractness = sanityzer(abstractness);
	}

	/**
	 * @return the efferentCoupling
	 */
	public int getEfferentCoupling() {
		return efferentCoupling;
	}

	/**
	 * @param efferentCoupling the efferentCoupling to set
	 */
	public void setEfferentCoupling(int efferentCoupling) {
		this.efferentCoupling = efferentCoupling;
	}

	/**
	 * @return the afferentCoupling
	 */
	public int getAfferentCoupling() {
		return afferentCoupling;
	}

	/**
	 * @param afferentCoupling the afferentCoupling to set
	 */
	public void setAfferentCoupling(int afferentCoupling) {
		this.afferentCoupling = afferentCoupling;
	}

	/**
	 * @return the instability
	 */
	public double getInstability() {
		return instability;
	}

	/**
	 * @param instability the instability to set
	 */
	public void setInstability(double instability) {
		this.instability = sanityzer(instability);
	}

	/**
	 * @return the normalizedDistance
	 */
	public double getNormalizedDistance() {
		return normalizedDistance;
	}

	/**
	 * @param normalizedDistance the normalizedDistance to set
	 */
	public void setNormalizedDistance(double normalizedDistance) {
		this.normalizedDistance = sanityzer(normalizedDistance);
	}

	/**
	 * @return the difficultLevel
	 */
	public double getDifficultLevel() {
		return difficultLevel;
	}

	/**
	 * @param difficultLevel the difficultLevel to set
	 */
	public void setDifficultLevel(double difficultLevel) {
		this.difficultLevel = sanityzer(difficultLevel);
	}

	/**
	 * @return the programLength
	 */
	public int getProgramLength() {
		return programLength;
	}

	/**
	 * @param programLength the programLength to set
	 */
	public void setProgramLength(int programLength) {
		this.programLength = programLength;
	}

	/**
	 * @return the programVocabulary
	 */
	public int getProgramVocabulary() {
		return programVocabulary;
	}

	/**
	 * @param programVocabulary the programVocabulary to set
	 */
	public void setProgramVocabulary(int programVocabulary) {
		this.programVocabulary = programVocabulary;
	}

	/**
	 * @return the programVolume
	 */
	public int getProgramVolume() {
		return programVolume;
	}

	/**
	 * @param programVolume the programVolume to set
	 */
	public void setProgramVolume(int programVolume) {
		this.programVolume = programVolume;
	}

	/**
	 * @return the effort
	 */
	public double getEffort() {
		return effort;
	}

	/**
	 * @param effort the effort to set
	 */
	public void setEffort(double effort) {
		this.effort = sanityzer(effort);
	}

	/**
	 * @return the timeToImplement
	 */
	public double getTimeToImplement() {
		return timeToImplement;
	}

	/**
	 * @param timeToImplement the timeToImplement to set
	 */
	public void setTimeToImplement(double timeToImplement) {
		this.timeToImplement = sanityzer(timeToImplement);
	}

	/**
	 * @return the programLevel
	 */
	public double getProgramLevel() {
		return programLevel;
	}

	/**
	 * @param programLevel the programLevel to set
	 */
	public void setProgramLevel(double programLevel) {
		this.programLevel = sanityzer(programLevel);
	}

	/**
	 * @return the averageLOCMethod
	 */
	public double getAverageLOCMethod() {
		return averageLOCMethod;
	}

	/**
	 * @param averageLOCMethod the averageLOCMethod to set
	 */
	public void setAverageLOCMethod(double averageLOCMethod) {
		this.averageLOCMethod = sanityzer(averageLOCMethod);
	}

	/**
	 * @return the averageNOM
	 */
	public double getAverageNOM() {
		return averageNOM;
	}

	/**
	 * @param averageNOM the averageNOM to set
	 */
	public void setAverageNOM(double averageNOM) {
		this.averageNOM = sanityzer(averageNOM);
	}

	/**
	 * @return the nParameter
	 */
	public int getNParameter() {
		return nParameter;
	}

	/**
	 * @param nParameter the nParameter to set
	 */
	public void setNParameter(int nParameter) {
		this.nParameter = nParameter;
	}

	/**
	 * @return the averageNParameter
	 */
	public double getAverageNParameter() {
		return averageNParameter;
	}

	/**
	 * @param averageNParameter the averageNParameter to set
	 */
	public void setAverageNParameter(double averageNParameter) {
		this.averageNParameter = sanityzer(averageNParameter);
	}

	/**
	 * @return the noTypesPackage
	 */
	public int getNOTypesPackage() {
		return noTypesPackage;
	}

	/**
	 * @param noTypesPackage the noTypesPackage to set
	 */
	public void setNOTypesPackage(int noTypesPackage) {
		this.noTypesPackage = noTypesPackage;
	}

	/**
	 * @return the nComments
	 */
	public int getNComments() {
		return nComments;
	}

	/**
	 * @param nComments the nComments to set
	 */
	public void setNComments(int nComments) {
		this.nComments = nComments;
	}

	/**
	 * @return the commentsRatio
	 */
	public double getCommentsRatio() {
		return commentsRatio;
	}

	/**
	 * @param commentsRatio the commentsRatio to set
	 */
	public void setCommentsRatio(double commentsRatio) {
		this.commentsRatio = sanityzer(commentsRatio);
	}

	/**
	 * @return the nDeliveredBugs
	 */
	public double getNDeliveredBugs() {
		return nDeliveredBugs;
	}

	/**
	 * @param nDeliveredBugs the nDeliveredBugs to set
	 */
	public void setNDeliveredBugs(double nDeliveredBugs) {
		this.nDeliveredBugs = sanityzer(nDeliveredBugs);
	}

	/**
	 * @return the averageComments
	 */
	public double getAverageComments() {
		return averageComments;
	}

	/**
	 * @param averageComments the averageComments to set
	 */
	public void setAverageComments(double averageComments) {
		this.averageComments = sanityzer(averageComments);
	}

	/**
	 * @return the nImport
	 */
	public int getNImport() {
		return nImport;
	}

	/**
	 * @param nImport the nImport to set
	 */
	public void setNImport(int nImport) {
		this.nImport = nImport;
	}

	/**
	 * @return the noInteface
	 */
	public int getNOInteface() {
		return noInteface;
	}

	/**
	 * @param noInteface the noInteface to set
	 */
	public void setNOInteface(int noInteface) {
		this.noInteface = noInteface;
	}

	/**
	 * @return the noLines
	 */
	public int getNoLines() {
		return noLines;
	}

	/**
	 * @param noLines the noLines to set
	 */
	public void setNoLines(int noLines) {
		this.noLines = noLines;
	}

	/**
	 * @return the maintainability
	 */
	public double getMaintainability() {
		return maintainability;
	}

	/**
	 * @param maintainability the maintainability to set
	 */
	public void setMaintainability(double maintainability) {
		this.maintainability = sanityzer(maintainability);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CKNumber [file=" + file + ", packageName=" + packageName + ", className=" + className + ", type=" + type
				+ ", dit=" + dit + ", noc=" + noc + ", mcCabe=" + mcCabe + ", cbo=" + cbo + ", efferentCoupling="
				+ efferentCoupling + ", afferentCoupling=" + afferentCoupling + ", lcom1=" + lcom1 + ", lcom2=" + lcom2
				+ ", lcom3=" + lcom3 + ", rfc=" + rfc + ", nom=" + nom + ", nopm=" + nopm + ", nosm=" + nosm + ", nof="
				+ nof + ", nopf=" + nopf + ", nosf=" + nosf + ", nosi=" + nosi + ", loc=" + loc + ", noLines=" + noLines
				+ ", nParameter=" + nParameter + ", nComments=" + nComments + ", nOperands=" + nOperands
				+ ", nUniqueOperands=" + nUniqueOperands + ", nOperators=" + nOperators + ", nUniqueOperators="
				+ nUniqueOperators + ", noConstructors=" + noConstructors + ", nNestedBlocks=" + nNestedBlocks
				+ ", wmc=" + wmc + ", programLength=" + programLength + ", programVocabulary=" + programVocabulary
				+ ", programVolume=" + programVolume + ", noTypesPackage=" + noTypesPackage + ", nImport=" + nImport
				+ ", noInteface=" + noInteface + ", averageBlockDepth=" + averageBlockDepth
				+ ", averageAttributesClass=" + averageAttributesClass + ", averageConstructorsClass="
				+ averageConstructorsClass + ", averageLOCMethod=" + averageLOCMethod + ", averageNOM=" + averageNOM
				+ ", averageNParameter=" + averageNParameter + ", abstractness=" + abstractness + ", instability="
				+ instability + ", normalizedDistance=" + normalizedDistance + ", difficultLevel=" + difficultLevel
				+ ", effort=" + effort + ", timeToImplement=" + timeToImplement + ", programLevel=" + programLevel
				+ ", commentsRatio=" + commentsRatio + ", nDeliveredBugs=" + nDeliveredBugs + ", averageComments="
				+ averageComments + ", maintainability=" + maintainability + ", specific=" + specific + ", error="
				+ error + "]";
	}

}
