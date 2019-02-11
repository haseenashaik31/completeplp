package com.cg.oiqgs.dao;

import java.util.List;

import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.model.AccountCreation;
import com.cg.oiqgs.model.Policy;
import com.cg.oiqgs.model.PolicyDetails;
import com.cg.oiqgs.model.Report;
import com.cg.oiqgs.model.UserRole;

public interface InsuranceQuotesDao {

	List<UserRole> getValidate(String userName, String password) throws OiqgsException;

	boolean userValidation(String userName) throws OiqgsException;

	int insertProfile(UserRole role) throws OiqgsException;

	long insertAccount(AccountCreation accountCreation) throws OiqgsException;

	boolean accountValidation(long accountNumber) throws OiqgsException;

	List<Policy> getBusinessSegment() throws OiqgsException;

	List<Policy> getPolicyQuestions(String segId) throws OiqgsException;

	long insertPolicy(Policy policy) throws OiqgsException;

	int insertPolicyDetails(PolicyDetails details) throws OiqgsException;

	List<Policy> getPolicyDetails(String userName) throws OiqgsException;

	List<Report> getReport(long accountNumber) throws OiqgsException;

	List<Policy> getPolicyDetails() throws OiqgsException;

	boolean checkInsured(String userName) throws OiqgsException;

}
