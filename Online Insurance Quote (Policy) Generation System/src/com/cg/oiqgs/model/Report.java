package com.cg.oiqgs.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Report implements Serializable {
	private long policyNumber;
	private double policyPremium;
	private Long accountNumber;
	private String bussinessSegment;
	private String questAns;
	private long policyDetails;
	private String policyQuestions;
	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private int insuredZip;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(long policyNumber, double policyPremium, Long accountNumber, String bussinessSegment, String questAns,
			long policyDetails, String policyQuestions, String insuredName, String insuredStreet, String insuredCity,
			String insuredState, int insuredZip) {
		super();
		this.policyNumber = policyNumber;
		this.policyPremium = policyPremium;
		this.accountNumber = accountNumber;
		this.bussinessSegment = bussinessSegment;
		this.questAns = questAns;
		this.policyDetails = policyDetails;
		this.policyQuestions = policyQuestions;
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
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

	public String getQuestAns() {
		return questAns;
	}

	public void setQuestAns(String questAns) {
		this.questAns = questAns;
	}

	public long getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(long policyDetails) {
		this.policyDetails = policyDetails;
	}

	public String getPolicyQuestions() {
		return policyQuestions;
	}

	public void setPolicyQuestions(String policyQuestions) {
		this.policyQuestions = policyQuestions;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getInsuredStreet() {
		return insuredStreet;
	}

	public void setInsuredStreet(String insuredStreet) {
		this.insuredStreet = insuredStreet;
	}

	public String getInsuredCity() {
		return insuredCity;
	}

	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}

	public String getInsuredState() {
		return insuredState;
	}

	public void setInsuredState(String insuredState) {
		this.insuredState = insuredState;
	}

	public int getInsuredZip() {
		return insuredZip;
	}

	public void setInsuredZip(int insuredZip) {
		this.insuredZip = insuredZip;
	}

	@Override
	public String toString() {
		return "ReportGeneration [policyNumber=" + policyNumber + ", policyPremium=" + policyPremium
				+ ", accountNumber=" + accountNumber + ", bussinessSegment=" + bussinessSegment + ", questAns="
				+ questAns + ", policyDetails=" + policyDetails + ", policyQuestions=" + policyQuestions
				+ ", insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity=" + insuredCity
				+ ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + "]";
	}

}
