package com.cg.oiqgs.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Policy implements Serializable {
	private long policyNumber;
	private double policyPremium;
	private Long accountNumber;
	private String bussinessSegment;
	private String busSegId;
	private int busSegSeq;
	private String busSegName;
	private String polQuesId;
	private int polQuesSeq;
	private String polQuesDesc;
	private String polQuesAns1;
	private int polQuesAns1Weightage;
	private String polQuesAns2;
	private int polQuesAns2Weightage;
	private String PolQuesAns3;
	private int polQuesAns3Weightage;

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(long policyNumber, double policyPremium, Long accountNumber, String bussinessSegment, String busSegId,
			int busSegSeq, String busSegName, String polQuesId, int polQuesSeq, String polQuesDesc, String polQuesAns1,
			int polQuesAns1Weightage, String polQuesAns2, int polQuesAns2Weightage, String polQuesAns3,
			int polQuesAns3Weightage, String polQuesAns4) {
		super();
		this.policyNumber = policyNumber;
		this.policyPremium = policyPremium;
		this.accountNumber = accountNumber;
		this.bussinessSegment = bussinessSegment;
		this.busSegId = busSegId;
		this.busSegSeq = busSegSeq;
		this.busSegName = busSegName;
		this.polQuesId = polQuesId;
		this.polQuesSeq = polQuesSeq;
		this.polQuesDesc = polQuesDesc;
		this.polQuesAns1 = polQuesAns1;
		this.polQuesAns1Weightage = polQuesAns1Weightage;
		this.polQuesAns2 = polQuesAns2;
		this.polQuesAns2Weightage = polQuesAns2Weightage;
		this.PolQuesAns3 = polQuesAns3;
		this.polQuesAns3Weightage = polQuesAns3Weightage;

	}

	@Override
	public String toString() {
		return "policy [policyNumber=" + policyNumber + ", policyPremium=" + policyPremium + ", accountNumber="
				+ accountNumber + ", bussinessSegment=" + bussinessSegment + ", busSegId=" + busSegId + ", busSegSeq="
				+ busSegSeq + ", busSegName=" + busSegName + ", polQuesId=" + polQuesId + ", polQuesSeq=" + polQuesSeq
				+ ", polQuesDesc=" + polQuesDesc + ", polQuesAns1=" + polQuesAns1 + ", polQuesAns1Weightage="
				+ polQuesAns1Weightage + ", polQuesAns2=" + polQuesAns2 + ", polQuesAns2Weightage="
				+ polQuesAns2Weightage + ", Pol_Ques_Ans3=" + PolQuesAns3 + ", polQuesAns3Weightage="
				+ polQuesAns3Weightage + "]";
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public double getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBussinessSegment() {
		return bussinessSegment;
	}

	public void setBussinessSegment(String bussinessSegment) {
		this.bussinessSegment = bussinessSegment;
	}

	public String getBusSegId() {
		return busSegId;
	}

	public void setBusSegId(String busSegId) {
		this.busSegId = busSegId;
	}

	public int getBusSegSeq() {
		return busSegSeq;
	}

	public void setBusSegSeq(int busSegSeq) {
		this.busSegSeq = busSegSeq;
	}

	public String getBusSegName() {
		return busSegName;
	}

	public void setBusSegName(String busSegName) {
		this.busSegName = busSegName;
	}

	public String getPolQuesId() {
		return polQuesId;
	}

	public void setPolQuesId(String polQuesId) {
		this.polQuesId = polQuesId;
	}

	public int getPolQuesSeq() {
		return polQuesSeq;
	}

	public void setPolQuesSeq(int polQuesSeq) {
		this.polQuesSeq = polQuesSeq;
	}

	public String getPolQuesDesc() {
		return polQuesDesc;
	}

	public void setPolQuesDesc(String polQuesDesc) {
		this.polQuesDesc = polQuesDesc;
	}

	public String getPolQuesAns1() {
		return polQuesAns1;
	}

	public void setPolQuesAns1(String polQuesAns1) {
		this.polQuesAns1 = polQuesAns1;
	}

	public int getPolQuesAns1Weightage() {
		return polQuesAns1Weightage;
	}

	public void setPolQuesAns1Weightage(int polQuesAns1Weightage) {
		this.polQuesAns1Weightage = polQuesAns1Weightage;
	}

	public String getPolQuesAns2() {
		return polQuesAns2;
	}

	public void setPolQuesAns2(String polQuesAns2) {
		this.polQuesAns2 = polQuesAns2;
	}

	public int getPolQuesAns2Weightage() {
		return polQuesAns2Weightage;
	}

	public void setPolQuesAns2Weightage(int polQuesAns2Weightage) {
		this.polQuesAns2Weightage = polQuesAns2Weightage;
	}

	public String getPolQuesAns3() {
		return PolQuesAns3;
	}

	public void setPolQuesAns3(String polQuesAns3) {
		PolQuesAns3 = polQuesAns3;
	}

	public int getPolQuesAns3Weightage() {
		return polQuesAns3Weightage;
	}

	public void setPolQuesAns3Weightage(int polQuesAns3Weightage) {
		this.polQuesAns3Weightage = polQuesAns3Weightage;
	}

}
