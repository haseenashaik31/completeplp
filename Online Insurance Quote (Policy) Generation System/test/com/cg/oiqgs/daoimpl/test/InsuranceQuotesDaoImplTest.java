package com.cg.oiqgs.daoimpl.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.oiqgs.dao.InsuranceQuotesDao;
import com.cg.oiqgs.daoimpl.InsuranceQuotesDaoImpl;
import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.model.AccountCreation;
import com.cg.oiqgs.model.Policy;
import com.cg.oiqgs.model.UserRole;

public class InsuranceQuotesDaoImplTest {
InsuranceQuotesDao quotesDao; 
	@Before
	public void setUp() throws Exception {
		quotesDao=new InsuranceQuotesDaoImpl();
	}
	@Test
	public void testInsertProfile() {
		UserRole role = new UserRole();
		role.setUserName("kathir1996");
		role.setPassword("kathir1996");
		role.setRoleCode("ADMIN");
		try {
			int result = quotesDao.insertProfile(role);
			if(result>0)
				result=1;
			assertEquals(1, result);
		} catch (OiqgsException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInsertAccount() {
		AccountCreation accountCreation = new AccountCreation();
		accountCreation.setInsuredName("kathir");
		accountCreation.setInsuredStreet("mambadi");
		accountCreation.setInsuredCity("harur");
		accountCreation.setInsuredState("tamilnadu");
		accountCreation.setInsuredZip(12345);
		accountCreation.setUserName("insured");
		try {
			long result = quotesDao.insertAccount(accountCreation);
			if(result>0)
				result=1;
			assertEquals(1, result);
		} catch (OiqgsException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInsertPolicy() {
		Policy policy = new Policy();
		policy.setBussinessSegment("Business Auto");
		policy.setAccountNumber(1000000000l);
		policy.setPolicyPremium(1200.00);
		try {
			long result = quotesDao.insertPolicy(policy);
			if(result>0)
				result=1;
			assertEquals(1, result);
		} catch (OiqgsException e) {
			e.printStackTrace();
		}
	}
	@After
	public void tearDown() throws Exception {
		quotesDao=null;
	}

}
