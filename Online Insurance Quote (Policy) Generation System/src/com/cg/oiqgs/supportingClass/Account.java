package com.cg.oiqgs.supportingClass;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.oiqgs.UserInterface.UserInterface;
import com.cg.oiqgs.exception.OiqgsException;
import com.cg.oiqgs.mainclass.Agent;
import com.cg.oiqgs.mainclass.Insured;
import com.cg.oiqgs.mainclass.UnderWriter;
import com.cg.oiqgs.model.AccountCreation;
import com.cg.oiqgs.service.InsuranceQuotesService;
import com.cg.oiqgs.serviceImpl.InsuranceQuotesServiceImpl;

public class Account {
	static String userName;
	static String roleCode;

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
		boolean doFlag = false;
		Scanner scanner = new Scanner(System.in);
		String insuredName;
		if (roleCode.equalsIgnoreCase("Agent") || roleCode.equalsIgnoreCase("Admin")) {
			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter InsuredName:");
				insuredName = scanner.nextLine();
				String regexname = "[a-zA-Z0-9]*";
				boolean valid = Pattern.matches(regexname, insuredName);
				if (valid == true)
					doFlag = true;
				else
					System.err.println("ENTER VALID NAME");
			} while (!doFlag);
			doFlag = false;
			String insuredStreet;
			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter insuredStreet:");
				insuredStreet = scanner.nextLine();
				String regexname = "[a-zA-Z0-9]*";
				boolean valid = Pattern.matches(regexname, insuredStreet);
				if (valid == true)
					doFlag = true;
				else
					System.err.println("ENTER VALID Street");
			} while (!doFlag);
			doFlag = false;
			String insuredCity;
			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter insuredCity:");
				insuredCity = scanner.nextLine();
				String regexname = "[a-zA-Z0-9]*";
				boolean valid = Pattern.matches(regexname, insuredCity);
				if (valid == true)
					doFlag = true;
				else
					System.err.println("ENTER VALID City");
			} while (!doFlag);
			doFlag = false;
			String insuredState;
			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter insuredState:");
				insuredState = scanner.nextLine();
				String regexname = "[a-zA-Z0-9]*";
				boolean valid = Pattern.matches(regexname, insuredState);
				if (valid == true)
					doFlag = true;
				else
					System.err.println("ENTER VALID State");
			} while (!doFlag);
			doFlag = false;
			String zip;
			int insuredZip = 0;
			do {
				scanner = new Scanner(System.in);
				System.out.println("Enter insuredZip:");
				try {
				zip = scanner.nextLine();
				
				String regexname = "[0-9]{5}";
				insuredZip = Integer.parseInt(zip);
				boolean valid = Pattern.matches(regexname, zip);
				if (valid == true)
					doFlag = true;
				else
					System.err.println("ENTER VALID Zip");
				}catch (Exception e) {
				System.err.println("ONLY INTEGER");	
				}
			} while (!doFlag);
			AccountCreation accountCreation = new AccountCreation();
			accountCreation.setInsuredName(insuredName);
			accountCreation.setInsuredStreet(insuredStreet);
			accountCreation.setInsuredCity(insuredCity);
			accountCreation.setInsuredState(insuredState);
			accountCreation.setInsuredZip(insuredZip);
			accountCreation.setUserName(userName);
			InsuranceQuotesService service = new InsuranceQuotesServiceImpl();
			try {
				long accountNumber = service.insertAccount(accountCreation);
				System.out.println("YOUR ACCOUNT NO:" + accountNumber);
			} catch (OiqgsException e) {
				e.printStackTrace();
			}finally {
				doFlag=false;
				do {
				System.out.println("Do you want to continue.....(y/n)");
				String choice = scanner.nextLine();
				String regex="[A-Za-z]{1}";
				boolean val=Pattern.matches(regex, choice);
				if(val==true)
					doFlag=true;
				else
					System.err.println("give proper input");

				if (roleCode.equalsIgnoreCase("Agent")) {
					if (choice.equalsIgnoreCase("y")) {
						Agent agent = new Agent();
						agent.main(null);
					} else {
						UserInterface userInterface=new UserInterface();
						userInterface.main(null);
					}
				}
				if (roleCode.equalsIgnoreCase("Admin")) {
					if (choice.equalsIgnoreCase("y")) {
						UnderWriter underWriter = new UnderWriter();
						underWriter.main(null);
					}else {
						UserInterface userInterface=new UserInterface();
						userInterface.main(null);
					}
				}
			}while(!doFlag);
				}
		} else {
			InsuranceQuotesService service = new InsuranceQuotesServiceImpl();
			boolean validInsured = false;
			try {
				validInsured = service.checkInsured(userName);// check wheather this user already has account
			} catch (OiqgsException e1) {
				e1.printStackTrace();
			}
			if (validInsured == true) {
				do {
					scanner = new Scanner(System.in);
					System.out.println("Enter InsuredName:");
					insuredName = scanner.nextLine();
					String regexname = "[a-zA-Z0-9]*";
					boolean valid = Pattern.matches(regexname, insuredName);
					if (valid == true)
						doFlag = true;
					else
						System.err.println("ENTER VALID NAME");
				} while (!doFlag);
				doFlag = false;
				String insuredStreet;
				do {
					scanner = new Scanner(System.in);
					System.out.println("Enter insuredStreet:");
					insuredStreet = scanner.nextLine();
					String regexname = "[a-zA-Z0-9]*";
					boolean valid = Pattern.matches(regexname, insuredStreet);
					if (valid == true)
						doFlag = true;
					else
						System.err.println("ENTER VALID Street");
				} while (!doFlag);
				doFlag = false;
				String insuredCity;
				do {
					scanner = new Scanner(System.in);
					System.out.println("Enter insuredCity:");
					insuredCity = scanner.nextLine();
					String regexname = "[a-zA-Z0-9]*";
					boolean valid = Pattern.matches(regexname, insuredCity);
					if (valid == true)
						doFlag = true;
					else
						System.err.println("ENTER VALID City");
				} while (!doFlag);
				doFlag = false;
				String insuredState;
				do {
					scanner = new Scanner(System.in);
					System.out.println("Enter insuredState:");
					insuredState = scanner.nextLine();
					String regexname = "[a-zA-Z0-9]*";
					boolean valid = Pattern.matches(regexname, insuredState);
					if (valid == true)
						doFlag = true;
					else
						System.err.println("ENTER VALID State");
				} while (!doFlag);
				doFlag = false;
				String zip;
				int insuredZip;
				do {
					scanner = new Scanner(System.in);
					System.out.println("Enter insuredZip:");
					zip = scanner.nextLine();
					String regexname = "[0-9]{5}";
					insuredZip = Integer.parseInt(zip);
					boolean valid = Pattern.matches(regexname, zip);
					if (valid == true)
						doFlag = true;
					else
						System.err.println("ENTER VALID Zip");
				} while (!doFlag);

				AccountCreation accountCreation = new AccountCreation();
				accountCreation.setInsuredName(insuredName);
				accountCreation.setInsuredStreet(insuredStreet);
				accountCreation.setInsuredCity(insuredCity);
				accountCreation.setInsuredState(insuredState);
				accountCreation.setInsuredZip(insuredZip);
				accountCreation.setUserName(userName);

				try {
					long accountNumber = service.insertAccount(accountCreation);
					System.out.println("YOUR ACCOUNT NO:" + accountNumber);
				} catch (OiqgsException e) {
					e.printStackTrace();
				}
			} else {
				System.err.println("YOUR ALLOWED CREATE ONLY ONE ACCOUNT");
			}
			doFlag=false;
			do {
			System.out.println("Do you want to continue.....(y/n)");
			String choice = scanner.nextLine();
			String regex="[A-Za-z]{1}";
			boolean val=Pattern.matches(regex, choice);
			if(val==true)
				doFlag=true;
			else
				System.err.println("give proper input");
			if (choice.equalsIgnoreCase("y")) {
				Insured insured = new Insured();
				insured.main(null);
			} else {
				UserInterface userInterface=new UserInterface();
				userInterface.main(null);
			}
			}while(!doFlag);
			}
	}

	public void getUserName(String user) {
		userName = user;// getting username from user interface based on the login credential and initialize in static variable userName 

	}

	public void getRoleCode(String rolecode) {
		roleCode = rolecode;// getting rolecode from user interface based on the login credential and initialize in static variable rolecode

	}
}
