package com.cg.oiqgs.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PolicyDetails implements Serializable {
	private String questId;
	private String questAns;
	private long policyDetails;
	private String policyQuestions;

	public PolicyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PolicyDetails(String questId, String questAns, long policyDetails, String policyQuestions) {
		super();
		this.questId = questId;
		this.questAns = questAns;
		this.policyDetails = policyDetails;
		this.policyQuestions = policyQuestions;
	}

	public String getQuestId() {
		return questId;
	}

	public void setQuestId(String questId) {
		this.questId = questId;
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

	@Override
	public String toString() {
		return "PolicyDetails [questId=" + questId + ", questAns=" + questAns + ", policyDetails=" + policyDetails
				+ ", policyQuestions=" + policyQuestions + "]";
	}
}
