package com.cg.oiqgs.dao;

public interface QueryMapper {
	public static final String userCheck = "SELECT rolecode FROM User_role WHERE username=? AND password=?";
	public static final String validUser = "SELECT username FROM User_role WHERE username=?";
	public static final String insertUser = "INSERT INTO user_role values(?,?,?)";
	public static final String insertAccount = "INSERT INTO accounts values(account_number_seq.nextval,?,?,?,?,?,?)";
	public static final String AccountNumber = "SELECT account_number_seq.currval FROM dual";
	public static final String validAccount = "SELECT account_Number FROM accounts WHERE account_Number=?";
	public static final String businessSegment = "SELECT * FROM businessSegment";
	public static final String questions = "SELECT * FROM policyQuestions WHERE bus_seg_id=?";
	public static final String policyInsert = "INSERT INTO policy values(policy_number.nextval,?,?,?)";
	public static final String policyNumber = "SELECT policy_number.currval FROM dual";
	public static final String policyDetails = "INSERT INTO policydetails values(?,?,?)";
	public static final String getPolicyDetails = "SELECT p.policy_number,p.business_segment,p.policy_premium,p.account_number FROM user_role u,accounts a,policy p WHERE u.username=a.username AND a.account_number=p.account_number AND u.username=?";
	public static final String checkAccount = "SELECT INSURED_NAME FROM accounts WHERE USERNAME=?";
	public static final String getReport = "select a.insured_name,a.insured_street,a.insured_city,a.insured_state,a.insured_zip,p.business_segment, pq.POL_QUES_DESC,d.answer,p.policy_premium from accounts a,policy p,policydetails d,policyquestions pq  where a.account_number=p.account_number and p.policy_number=d.policy_number and pq.POL_QUES_ID=d.QUESTION_ID and a.account_number=?";
	public static final String getAllPolicyDetails = "SELECT p.policy_number,p.business_segment,p.policy_premium,p.account_number FROM policy p ";
}
