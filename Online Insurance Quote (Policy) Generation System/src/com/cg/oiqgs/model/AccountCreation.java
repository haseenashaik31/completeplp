package com.cg.oiqgs.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AccountCreation implements Serializable {
	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private int insuredZip;
	private long accountNumber;
	private String userName;

	public AccountCreation() {
		super();
	}

	public AccountCreation(String insuredName, String insuredStreet, String insuredCity, String insuredState,
			int insuredZip, long accountNumber, String userName) {
		super();
		this.insuredName = insuredName;
		this.insuredStreet = insuredStreet;
		this.insuredCity = insuredCity;
		this.insuredState = insuredState;
		this.insuredZip = insuredZip;
		this.accountNumber = accountNumber;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "AccountCreation [insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity="
				+ insuredCity + ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + ", accountNumber="
				+ accountNumber + ", userName=" + userName + "]";
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

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
