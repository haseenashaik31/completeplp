package com.cg.oiqgs.serviceImpl;

import java.util.List;

import com.cg.oiqgs.dao.InsuranceQuotesDao;
import com.cg.oiqgs.daoimpl.InsuranceQuotesDaoImpl;
import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.model.AccountCreation;
import com.cg.oiqgs.model.Policy;
import com.cg.oiqgs.model.PolicyDetails;
import com.cg.oiqgs.model.Report;
import com.cg.oiqgs.model.UserRole;
import com.cg.oiqgs.service.InsuranceQuotesService;

public class InsuranceQuotesServiceImpl implements InsuranceQuotesService {

	InsuranceQuotesDao quotesDao = new InsuranceQuotesDaoImpl();
	/***
	 * method		:getValidate
	 * argument		:It's take Username and password as argument from Account class
	 * return type	:list contain rolecode of the user to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:05-feb-2019
	 */
	@Override
	public List<UserRole> getValidate(String userName, String password) throws OiqgsException {
		return quotesDao.getValidate(userName, password);
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
		return quotesDao.userValidation(userName);
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
		return quotesDao.insertProfile(role);
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
		return quotesDao.insertAccount(accountCreation);
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
	
		return quotesDao.accountValidation(accountNumber);
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
		return quotesDao.getBusinessSegment();
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
		return quotesDao.getPolicyQuestions(segId);
	}
	/***
	 * method		:insertPolicy
	 * argument		:It's take model argument as an argument from policy class
	 * return type	:Generated policy number to InsuranceQuotesServiceImpl
	 * Author		:Capgemini
	 * Date			:06-feb-2019
	 */
	@Override
	public long insertPolicy(Policy policy) throws OiqgsException {
		return quotesDao.insertPolicy(policy);
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
		return quotesDao.insertPolicyDetails(details);
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
		return quotesDao.getPolicyDetails(userName);
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
		return quotesDao.getReport(accountNumber);
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
		return quotesDao.getPolicyDetails();
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
		return quotesDao.checkInsured(userName);
	}

}
