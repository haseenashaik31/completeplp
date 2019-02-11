
package com.cg.oiqgs.UserInterface;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.mainclass.Agent;
import com.cg.oiqgs.mainclass.Insured;
import com.cg.oiqgs.mainclass.UnderWriter;
import com.cg.oiqgs.model.UserRole;
import com.cg.oiqgs.service.InsuranceQuotesService;
import com.cg.oiqgs.serviceImpl.InsuranceQuotesServiceImpl;
import com.cg.oiqgs.supportingClass.Account;
import com.cg.oiqgs.supportingClass.PolicyCreation;
import com.cg.oiqgs.supportingClass.ViewPolicy;


public class UserInterface {

	static Logger logger = Logger.getLogger(UserInterface.class);

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
		PropertyConfigurator.configure("resource/log4j.properties");
		logger.info("INSIDE USER INTERFACE MAIN METHOD");
		Scanner scanner = new Scanner(System.in);
		String rolecode = null;
		boolean validateFlag = false;
		InsuranceQuotesService service = new InsuranceQuotesServiceImpl();
		do {
			System.out.println("****login page****");
			System.out.println("Enter Username");
			String userName = scanner.nextLine();
			System.out.println("Enter Password");
			String password = scanner.nextLine();
			Account account = new Account();
			ViewPolicy policy = new ViewPolicy();
			PolicyCreation creation=new PolicyCreation();

			try {
				logger.info("INSIDE TRY BLOCK OF USER INTERFACE MAIN METHOD");
				List<UserRole> role = service.getValidate(userName, password);
				logger.info("Got the rolecode for given username and password");
				if (!role.isEmpty()) {
					logger.info("Inside of IF block of user interface");
					account.getUserName(userName);//sending username to account class 

					policy.getUserName(userName);//sending username to policy class
					for (UserRole userRole : role) {
						logger.debug("getting value from rolecode");
						rolecode = userRole.getRoleCode();
					}
					account.getRoleCode(rolecode);// sending role code to account class
					policy.getRoleCode(rolecode);// sending role code to account class
					creation.getRoleCode(rolecode);// sending role code to account class
					if (rolecode.equalsIgnoreCase("Insured")) {
						logger.info("control passed to insured class");
						validateFlag = true;
						Insured insured = new Insured();
						insured.main(null);//calling insured class main method
						logger.info("insured class is called");
					} else if (rolecode.equalsIgnoreCase("Agent")) {
						logger.info("control passed to agent class");
						validateFlag = true;
						Agent agent = new Agent();
						agent.main(null);//calling agent class main method
						logger.info("agent class is called");
					} else if (rolecode.equalsIgnoreCase("admin")) {
						logger.info("control passed to admin class");
						validateFlag = true;
						UnderWriter underWriter = new UnderWriter();
						underWriter.main(null);//calling underwriter class main method
						logger.info("admin class is called");
					}
				} else {
					logger.info("Inside else part of user interface");
					System.err.println("username/password is mismatch");
				}
			} catch (OiqgsException e) {
				logger.error("ERROR occured while fetching rolecode from database");
				System.err.println("error occured in password validation");
			}
		} while (!validateFlag);

	}

}
