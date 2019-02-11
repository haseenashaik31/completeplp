package com.cg.oiqgs.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.oiqgs.dao.InsuranceQuotesDao;
import com.cg.oiqgs.dao.QueryMapper;
import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.model.AccountCreation;
import com.cg.oiqgs.model.Policy;
import com.cg.oiqgs.model.PolicyDetails;
import com.cg.oiqgs.model.Report;
import com.cg.oiqgs.model.UserRole;
import com.cg.oiqgs.utility.JdbcUtility;

public class InsuranceQuotesDaoImpl implements InsuranceQuotesDao {
	PreparedStatement statement = null;
	Connection connection = null;
	long accountNum;
	/***
	 * method		:getValidate
	 * argument		:It's take Username and password as argument from Account class
	 * return type	:list contain rolecode of the user to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:05-feb-2019
	 */
	@Override
	public List<UserRole> getValidate(String userName, String password) throws OiqgsException {
		ResultSet resultSet = null;
		String roleCode;
		connection = JdbcUtility.getConnection();
		List<UserRole> getValidateList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(QueryMapper.userCheck);
			statement.setString(1, userName);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				roleCode = resultSet.getString(1);//getting value based on column index number from the table
				UserRole role = new UserRole();
				role.setRoleCode(roleCode);
				getValidateList.add(role);
			}

		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return getValidateList;
	}
	/***
	 * method		:userValidation
	 * argument		:It's take username as an argument from UserInterFace
	 * return type	:Boolean result for authenticating user to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:05-feb-2019
	 */
	@Override
	public boolean userValidation(String userName) throws OiqgsException {
		ResultSet resultSet = null;
		List<UserRole> userValidationList = new ArrayList<>();
		boolean validFlag = false;
		connection = JdbcUtility.getConnection();

		try {
			statement = connection.prepareStatement(QueryMapper.validUser);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String user = resultSet.getString(1);
				UserRole role = new UserRole();
				role.setUserName(user);
				userValidationList.add(role);
			}

			if (userValidationList.isEmpty()) {
				validFlag = true;
			}
		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return validFlag;
	}
	/***
	 * method		:insertProfile
	 * argument		:It's take model argument from profile creation class
	 * return type	:integer containing how many rows inserted to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:05-feb-2019
	 */
	@Override
	public int insertProfile(UserRole role) throws OiqgsException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertUser);
			statement.setString(1, role.getUserName());
			statement.setString(2, role.getPassword());
			statement.setString(3, role.getRoleCode());
			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return result;
	}
	/***
	 * method		:insertAccount
	 * argument		:It's take model argument from Accounts class
	 * return type	:Generated Account number to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:05-feb-2019
	 */
	@Override
	public long insertAccount(AccountCreation accountCreation) throws OiqgsException {
		connection = JdbcUtility.getConnection();

		long accountNumber = 0;
		ResultSet resultSet = null;
		try {

			statement = connection.prepareStatement(QueryMapper.insertAccount);
			statement.setString(1, accountCreation.getInsuredName());
			statement.setString(2, accountCreation.getInsuredStreet());
			statement.setString(3, accountCreation.getInsuredCity());
			statement.setString(4, accountCreation.getInsuredState());
			statement.setInt(5, accountCreation.getInsuredZip());
			statement.setString(6, accountCreation.getUserName());
			statement.executeUpdate();
			statement = connection.prepareStatement(QueryMapper.AccountNumber);
			resultSet = statement.executeQuery();
			while (resultSet.next())
				accountNumber = resultSet.getLong(1);

		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return accountNumber;
	}
	/***
	 * method		:accountValidation
	 * argument		:It's take accountNumber as an argument
	 * return type	:Boolean result for authenticating the account number present in database to InsuranceQuotesServiceImpl 
	 * Author		:Capgemini
	 * Date			:06-feb-2019
	 */
	@Override
	public boolean accountValidation(long accountNumber) throws OiqgsException {
		ResultSet resultSet = null;
		List<Policy> accountValidationList = new ArrayList<>();
		boolean validFlag = false;
		connection = JdbcUtility.getConnection();

		try {
			statement = connection.prepareStatement(QueryMapper.validAccount);
			statement.setLong(1, accountNumber);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				long accountNumber1 = resultSet.getLong(1);//getting value based on column index number from the table
				Policy policy = new Policy();
				policy.setAccountNumber(accountNumber1);
				accountValidationList.add(policy);
			}

			if (!(accountValidationList.isEmpty())) {
				validFlag = true;
			}
		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return validFlag;
	}
	/***
	 * method		:getBusinessSegment
	 * argument		:no argument
	 * return type	:list containing business segment present in the business segment table to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:06-feb-2019
	 */
	@Override
	public List<Policy> getBusinessSegment() throws OiqgsException {
		List<Policy> getBusinessSegmentList = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.businessSegment);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String busId = resultSet.getString(1);//getting value based on column index number from the table

				String busName = resultSet.getString(3);//getting value based on column index number from the table
				Policy policy = new Policy();
				policy.setBusSegId(busId);
				policy.setBusSegName(busName);
				getBusinessSegmentList.add(policy);
			}
		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}

		return getBusinessSegmentList;
	}
	/***
	 * method		:getPolicyQuestions
	 * argument		:It's take business segment id as an argument
	 * return type	:list containing policy questions present in the policy questions table to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:06-feb-2019
	 */
	@Override
	public List<Policy> getPolicyQuestions(String segId) throws OiqgsException {
		List<Policy> getPolicyQuestionsList = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.questions);
			statement.setString(1, segId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String polQuesId = resultSet.getString(1);//getting value based on column index number from the table
				int polQuesSeq = resultSet.getInt(2);//getting value based on column index number from the table
				String polQuesDesc = resultSet.getString(4);//getting value based on column index number from the table
				String polQuesAns1 = resultSet.getString(5);//getting value based on column index number from the table
				int polQuesAns1Weightage = resultSet.getInt(6);//getting value based on column index number from the table
				String polQuesAns2 = resultSet.getString(7);//getting value based on column index number from the table
				int polQuesAns2Weightage = resultSet.getInt(8);//getting value based on column index number from the table
				String polQuesAns3 = resultSet.getString(9);//getting value based on column index number from the table
				int polQuesAns3Weightage = resultSet.getInt(10);//getting value based on column index number from the table
				Policy policy = new Policy();
				policy.setPolQuesId(polQuesId);
				policy.setPolQuesSeq(polQuesSeq);
				policy.setPolQuesDesc(polQuesDesc);
				policy.setPolQuesAns1(polQuesAns1);
				policy.setPolQuesAns1Weightage(polQuesAns1Weightage);
				policy.setPolQuesAns2(polQuesAns2);
				policy.setPolQuesAns2Weightage(polQuesAns2Weightage);
				policy.setPolQuesAns3(polQuesAns3);
				policy.setPolQuesAns3Weightage(polQuesAns3Weightage);
				getPolicyQuestionsList.add(policy);
			}
		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return getPolicyQuestionsList;
	}
	/***
	 * method		:insertPolicy
	 * argument		:It's take model argument as an argument from policy class
	 * return type	:Generated policy number to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:06-feb-2019
	 */
	static long policyNumber = 0;
	@SuppressWarnings("unused")
	@Override
	public long insertPolicy(Policy policy) throws OiqgsException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		boolean valid = false;
		try {
			statement = connection.prepareStatement(QueryMapper.policyInsert);
			statement.setString(1, policy.getBussinessSegment());
			statement.setDouble(2, policy.getPolicyPremium());
			statement.setLong(3, policy.getAccountNumber());
			result = statement.executeUpdate();
			statement = connection.prepareStatement(QueryMapper.policyNumber);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next())
				policyNumber = resultSet.getLong(1);
		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return policyNumber;
	}
	/***
	 * method		:insertPolicyDetails
	 * argument		:It's take model argument from policy creation class
	 * return type	:integer containing how many rows inserted to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:06-feb-2019
	 */
	@Override
	public int insertPolicyDetails(PolicyDetails details) throws OiqgsException {
		connection = JdbcUtility.getConnection();
		int result = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.policyDetails);
			statement.setLong(1, policyNumber);
			statement.setString(2, details.getQuestId());
			statement.setString(3, details.getQuestAns());
		
			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println("SQL STATEMENT DOESNT EXECUTED");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new OiqgsException("proble in closing the statement");
			}
			try {
				connection.close();
			} catch (Exception e2) {
				throw new OiqgsException("connection is not closed");
			}
		}
		return result;
	}
	/***
	 * method		:getPolicyDetails
	 * argument		:It's take username as an argument from view policy class
	 * return type	:list containing policy details present in the policy details table to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:07-feb-2019
	 */
	@Override
	public List<Policy> getPolicyDetails(String userName) throws OiqgsException {
		List<Policy> getPolicyDetailsList = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.getPolicyDetails);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				long policyNumber = resultSet.getLong(1);
				String businessSegment = resultSet.getString(2);
				double policyPremium = resultSet.getDouble(3);
				long accountNumber = resultSet.getLong(4);
				Policy policy = new Policy();
				policy.setPolicyNumber(policyNumber);
				policy.setBussinessSegment(businessSegment);
				policy.setAccountNumber(accountNumber);
				policy.setPolicyPremium(policyPremium);
				getPolicyDetailsList.add(policy);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getPolicyDetailsList;
	}
	/***
	 * method		:getReport
	 * argument		:It's take accountNumber as an argument from report generation class
	 * return type	:list containing  details present in the policy details,accounts table to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:07-feb-2019
	 */
	@Override
	public List<Report> getReport(long accountNumber) throws OiqgsException {
		List<Report> getReportlist = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.getReport);
			statement.setLong(1, accountNumber);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String insuredName = resultSet.getString(1);
				String insuredStreet = resultSet.getString(2);
				String insuredCity = resultSet.getString(3);
				String insuredState = resultSet.getString(4);
				int insuredZip = resultSet.getInt(5);
				String bussinessSegment = resultSet.getString(6);
				String policyQuestion = resultSet.getString(7);
				String questAns = resultSet.getString(8);
				double policyPremium = resultSet.getDouble(9);
System.out.println(policyQuestion);
				Report report = new Report();
				report.setInsuredName(insuredName);
				report.setInsuredStreet(insuredStreet);
				report.setInsuredCity(insuredCity);
				report.setInsuredState(insuredState);
				report.setInsuredZip(insuredZip);
				report.setBussinessSegment(bussinessSegment);
				report.setPolicyQuestions(policyQuestion);
				report.setQuestAns(questAns);
				report.setPolicyPremium(policyPremium);
				getReportlist.add(report);

			}
		} catch (SQLException e) {
			System.err.println("sql statement doesnt executed in ");
		}
		return getReportlist;
	}
	/***
	 * method		:getPolicyDetails
	 * argument		:It's take username as an argument from view policy class
	 * return type	:list containing policy details present in the policy details table to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:07-feb-2019
	 */
	@Override
	public List<Policy> getPolicyDetails() throws OiqgsException {
		List<Policy> getPolicyDetailslist = new ArrayList<>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.getAllPolicyDetails);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				long policyNumber = resultSet.getLong(1);
				String businessSegment = resultSet.getString(2);
				double policyPremium = resultSet.getDouble(3);
				long accountNumber = resultSet.getLong(4);
				Policy policy = new Policy();
				policy.setPolicyNumber(policyNumber);
				policy.setBussinessSegment(businessSegment);
				policy.setAccountNumber(accountNumber);
				policy.setPolicyPremium(policyPremium);
				getPolicyDetailslist.add(policy);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getPolicyDetailslist;
	}
	/***
	 * method		:checkInsured
	 * argument		:It's take username as an argument from Account class for checking insured person account creation
	 * return type	:Boolean result for authenticating the insured person to create account to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:07-feb-2019
	 */
	@Override
	public boolean checkInsured(String userName) throws OiqgsException {
		ResultSet resultSet = null;
		List<AccountCreation> checkinsuredList = new ArrayList<>();
		boolean validFlag = false;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.checkAccount);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String insuredName = resultSet.getString(1);
				AccountCreation accountCreation2 = new AccountCreation();
				accountCreation2.setInsuredName(insuredName);
				checkinsuredList.add(accountCreation2);
			}
			if (checkinsuredList.isEmpty()) {
				validFlag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return validFlag;
	}

}
